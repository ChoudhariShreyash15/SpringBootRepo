package com.example.Aug19_SpringBootApplication.service.util;

import java.util.*;
import java.util.regex.*;

public final class AadhaarParsers {
    private AadhaarParsers(){}

    // 12-digit Aadhaar (allow spaces)
    private static final Pattern AADHAAR = Pattern.compile("(\\d{4})[\\s-]?(\\d{4})[\\s-]?(\\d{4})");

    // English sample lines
    private static final Pattern NAME_EN = Pattern.compile("(?i)\\bname\\b[:\\-]?\\s*(.+)|^(?!DOB|MALE|FEMALE)([A-Z][A-Z\\s]+)$");
    private static final Pattern DOB_EN  = Pattern.compile("(?i)DOB\\s*[:\\-]?\\s*(\\d{2}[\\/-]\\d{2}[\\/-]\\d{4})");
    private static final Pattern GENDER_EN = Pattern.compile("(?i)\\b(MALE|FEMALE)\\b");
    private static final Pattern ADDRESS_LINE = Pattern.compile("(?i)([\\w\\-.,\\s]+),?\\s*India");

    // Hindi sample cues
    private static final Pattern DOB_HI = Pattern.compile("(?i)(जन्म\\s*तिथि|DOB)\\s*[:\\-]?\\s*(\\d{2}[\\/-]\\d{2}[\\/-]\\d{4})");
    private static final Pattern FEMALE_HI = Pattern.compile("(?i)(महिला|FEMALE)");
    private static final Pattern MALE_HI   = Pattern.compile("(?i)(पुरुष|MALE)");

    public static Map<String,String> parseFromOcr(String ocr) {
        Map<String,String> out = new HashMap<>();
        if (ocr == null) return out;

        Matcher m = AADHAAR.matcher(ocr.replaceAll("[^0-9\\s-]", ""));
        if (m.find()) out.put("aadhaarNumber", (m.group(1)+m.group(2)+m.group(3)));

        m = DOB_EN.matcher(ocr); if (!m.find()) m = DOB_HI.matcher(ocr);
        if (m.find()) out.put("dob", m.group(m.groupCount())); // last group

        if (FEMALE_HI.matcher(ocr).find()) out.put("gender","FEMALE");
        else if (MALE_HI.matcher(ocr).find()) out.put("gender","MALE");

        // try to guess name: take uppercase line not starting with keywords
        String name = Arrays.stream(ocr.split("\\R"))
                .map(String::trim)
                .filter(s -> s.matches("^[A-Z][A-Z\\s]{2,}$"))
                .filter(s -> !s.contains("GOVERNMENT") && !s.contains("AADHAAR") && !s.contains("INDIA"))
                .findFirst().orElse(null);
        if (name != null) out.put("name", name);

        Matcher addr = ADDRESS_LINE.matcher(ocr);
        if (addr.find()) out.put("address", addr.group(1).trim());

        return out;
    }
}

