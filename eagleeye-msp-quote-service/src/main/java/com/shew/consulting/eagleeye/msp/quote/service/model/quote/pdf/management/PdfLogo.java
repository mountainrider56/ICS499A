package com.shew.consulting.eagleeye.msp.quote.service.model.quote.pdf.management;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PdfLogo {

    private final Document document;

    public PdfLogo(Document document) throws Exception {
        this.document = document;
        init();
    }

    private void init() throws Exception {
        Path path = Paths.get(ClassLoader.getSystemResource("pdf/images/logo.png").toURI());
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scaleAbsolute(184, 50);
        document.add(img);
    }

}
