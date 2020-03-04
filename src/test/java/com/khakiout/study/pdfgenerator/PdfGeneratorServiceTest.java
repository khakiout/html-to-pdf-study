package com.khakiout.study.pdfgenerator;

import org.junit.jupiter.api.Test;

public class PdfGeneratorServiceTest {

    @Test
    public void test() {
        PdfConverterService service = new PdfConverterService();

        service.convert();
    }
}
