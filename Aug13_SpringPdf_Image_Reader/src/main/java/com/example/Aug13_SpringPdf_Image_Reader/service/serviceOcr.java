package com.example.Aug13_SpringPdf_Image_Reader.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class serviceOcr {

    public void readOcr(MultipartFile multipartFile) throws IOException, TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        Path path = Paths.get("ocr-" + UUID.randomUUID().toString().substring(0, 3) + extract(multipartFile.getOriginalFilename()));
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        BufferedImage bufferedImage = ImageIO.read(path.toFile());
        String s = tesseract.doOCR(bufferedImage);
        System.out.println(s);
    }

    public void processFile(MultipartFile multipartFile) throws IOException, TesseractException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        if (multipartFile.getContentType() != null) {
            if (multipartFile.getContentType().startsWith("image/")) {
                processImage(multipartFile, tesseract);
            } else if (multipartFile.getContentType().equals("application/pdf")) {
                processPdf(multipartFile, tesseract);
            }
        }
    }

    private void processImage(MultipartFile multipartFile, Tesseract tesseract) throws IOException, TesseractException {
        Path path = Paths.get("ocr-" + UUID.randomUUID().toString().substring(0, 3) + extract(multipartFile.getOriginalFilename()));
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        BufferedImage bufferedImage = ImageIO.read(path.toFile());
        String s = tesseract.doOCR(bufferedImage);
        System.out.println(s);
    }

    private void processPdf(MultipartFile multipartFile, Tesseract tesseract) throws IOException, TesseractException {
        Path path = Paths.get("pdf-" + UUID.randomUUID().toString().substring(0, 3) + extract(multipartFile.getOriginalFilename()));
        byte[] bytes = multipartFile.getBytes();
        Files.copy(new ByteArrayInputStream(bytes), path, StandardCopyOption.REPLACE_EXISTING);

        PDDocument pdDocument = PDDocument.load(path.toFile());
        PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);

        for (int page = 0; page < pdDocument.getNumberOfPages(); page++) {
            BufferedImage bufferedImage = pdfRenderer.renderImageWithDPI(page, 300);
            String s = tesseract.doOCR(bufferedImage);
            System.out.println(s);
        }

        pdDocument.close();
    }

    private String extract(String filename) {
        return filename.substring(filename.lastIndexOf('.'));
    }
}
