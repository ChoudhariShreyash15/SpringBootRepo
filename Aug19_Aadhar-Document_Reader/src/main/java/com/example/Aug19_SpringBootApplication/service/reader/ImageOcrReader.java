package com.example.Aug19_SpringBootApplication.service.reader;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@Component
public class ImageOcrReader {
    private final Tesseract tesseract;

    public ImageOcrReader() {
        this.tesseract = new Tesseract();
        this.tesseract.setDatapath("C:\\\\Program Files\\\\Tesseract-OCR\\\\tessdata");
        this.tesseract.setLanguage("eng+hin"); // English + Hindi
    }

    public String ocr(MultipartFile file) throws Exception {
        BufferedImage img = ImageIO.read(file.getInputStream());
        return tesseract.doOCR(img);
    }
}

