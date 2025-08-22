package com.example.Aug19_SpringBootApplication.service.reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

@Component
public class ExcelReader {
    public List<List<String>> read(MultipartFile file) throws Exception {
        try (InputStream in = file.getInputStream();
             Workbook wb = WorkbookFactory.create(in)) {
            DataFormatter fmt = new DataFormatter();
            Sheet sheet = wb.getSheetAt(0);
            List<List<String>> table = new ArrayList<>();
            for (Row r : sheet) {
                List<String> row = new ArrayList<>();
                int last = r.getLastCellNum() == -1 ? 0 : r.getLastCellNum();
                for (int i = 0; i < last; i++) {
                    Cell c = r.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    row.add(fmt.formatCellValue(c));    // <-- avoids STRING/NUMERIC mismatch
                }
                table.add(row);
            }
            return table;
        }
    }
}
