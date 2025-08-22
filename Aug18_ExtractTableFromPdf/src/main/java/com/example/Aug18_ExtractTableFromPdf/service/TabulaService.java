package com.example.Aug18_ExtractTableFromPdf.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import technology.tabula.*;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TabulaService {

    // Method to read tables from a PDF using Tabula
    public void readPdf(MultipartFile multipartFile) {
        try (PDDocument pdDocument = PDDocument.load(multipartFile.getInputStream())) {
            ObjectExtractor objectExtractor = new ObjectExtractor(pdDocument);
            PageIterator extract = objectExtractor.extract();
            SpreadsheetExtractionAlgorithm bea = new SpreadsheetExtractionAlgorithm();

            while (extract.hasNext()) {
                Page next = extract.next();
                List<Table> tables = bea.extract(next);

                for (Table table : tables) {
                    List<List<RectangularTextContainer>> rows = table.getRows();
                    for (List<RectangularTextContainer> row : rows) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (RectangularTextContainer cell : row) {
                            String text = cell.getText();
                            if (text != null) {
                                stringBuilder.append(text.trim()).append(" | ");
                            }
                        }
                        System.out.println(stringBuilder.toString());
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading PDF with Tabula", e);
        }
    }

    // Method to read Excel files using Apache POI
    public void readExcel(MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream();
             Workbook workbook = WorkbookFactory.create(inputStream)) {   // ✅ works for xls & xlsx

            Sheet sheetAt = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();           // ✅ safe cell-to-string

            List<String> headers = new ArrayList<>();
            Iterator<Row> iterator = sheetAt.iterator();

            // Read headers
            if (iterator.hasNext()) {
                Row headerRow = iterator.next();
                headerRow.forEach(cell -> headers.add(dataFormatter.formatCellValue(cell)));
            }

            // Read rows
            while (iterator.hasNext()) {
                Row row = iterator.next();
                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + " | ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading Excel file", e);
        }
    }
}
