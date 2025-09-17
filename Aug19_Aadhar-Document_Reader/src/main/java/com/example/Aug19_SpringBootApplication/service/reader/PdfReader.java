package com.example.Aug19_SpringBootApplication.service.reader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import technology.tabula.*;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;

import java.util.*;

@Component
public class PdfReader {
    public List<List<String>> readTables(MultipartFile file) throws Exception {
        List<List<String>> out = new ArrayList<>();
        try (PDDocument doc = PDDocument.load(file.getInputStream())) {
            var extractor = new ObjectExtractor(doc);
            var pages = extractor.extract();
            var algo = new SpreadsheetExtractionAlgorithm();

            while (pages.hasNext()) {
                Page p = pages.next();
                for (Table t : algo.extract(p)) {
                    for (List<RectangularTextContainer> row : t.getRows()) {
                        List<String> cells = new ArrayList<>();
                        for (RectangularTextContainer c : row) cells.add(c.getText().trim());
                        out.add(cells);
                    }
                }
            }
        }
        return out;
    }
}

