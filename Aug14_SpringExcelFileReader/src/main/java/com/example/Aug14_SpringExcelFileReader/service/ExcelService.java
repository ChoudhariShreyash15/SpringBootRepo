package com.example.Aug14_SpringExcelFileReader.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ExcelService {

    private BufferedImage preprocessImage(BufferedImage inputImage) {
        // Convert to grayscale
        BufferedImage grayscaleImage = new BufferedImage(
                inputImage.getWidth(), inputImage.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY
        );
        Graphics2D g2d = grayscaleImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, null);
        g2d.dispose();

        // Apply binary threshold
        BufferedImage binaryImage = new BufferedImage(
                grayscaleImage.getWidth(), grayscaleImage.getHeight(),
                BufferedImage.TYPE_BYTE_BINARY
        );
        Graphics2D g2dBin = binaryImage.createGraphics();
        g2dBin.drawImage(grayscaleImage, 0, 0, null);
        g2dBin.dispose();

        return binaryImage;
    }

    public void testOCR(MultipartFile multipartFile) throws IOException, TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        Path path = Paths.get("ocr.jpg");
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        BufferedImage image = ImageIO.read(path.toFile());
        image = preprocessImage(image);

        String s = tesseract.doOCR(image);
        System.out.println(s);
    }

    public void advwayOCR(MultipartFile multipartFile) throws IOException, TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        if (multipartFile.getContentType() != null) {
            if (multipartFile.getContentType().startsWith("image/")) {
                Path path = Paths.get("ocr-" + UUID.randomUUID().toString().substring(0, 3) + multipartFile.getOriginalFilename());
                Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                BufferedImage bufferedImage = ImageIO.read(path.toFile());
                bufferedImage = preprocessImage(bufferedImage);

                String s = tesseract.doOCR(bufferedImage);
                System.out.println(s);
            }
            if (multipartFile.getContentType().equals("application/pdf")) {
                Path path = Paths.get("pdf-" + UUID.randomUUID().toString().substring(0, 3) + multipartFile.getOriginalFilename());
                Files.copy(new ByteArrayInputStream(multipartFile.getBytes()), path, StandardCopyOption.REPLACE_EXISTING);

                PDDocument pdDocument = PDDocument.load(path.toFile());
                PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);

                for (int page = 0; page < pdDocument.getNumberOfPages(); page++) {
                    BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(page, 300);
                    bufferedImage = preprocessImage(bufferedImage);

                    String s = tesseract.doOCR(bufferedImage);
                    System.out.println(s);
                }
                pdDocument.close();
            }
            String filename = multipartFile.getOriginalFilename();
            if (filename != null && (filename.endsWith(".xlsx") || filename.endsWith(".xls"))) {
                System.out.println("in excel");
                readExcel(multipartFile);
            }
        }
    }

    private void readExcel(MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        Workbook workbook;

        if (filename != null && filename.endsWith(".xls")) {
            // Old Excel
            workbook = new HSSFWorkbook(multipartFile.getInputStream());
//            Workbook workbook1 = WorkbookFactory.create(multipartFile.getInputStream());
//            workbook1.get
        } else if (filename != null && filename.endsWith(".xlsx")) {
            // New Excel
            workbook = new XSSFWorkbook(multipartFile.getInputStream());
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + filename);
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {

                            System.out.print(cell.getDateCellValue() + "\t");
                        } else {
                            System.out.print(cell.getNumericCellValue() + "\t");
                        }
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default:
                        System.out.print("\t");
                }
            }
            System.out.println();
        }
        workbook.close();
    }

}

