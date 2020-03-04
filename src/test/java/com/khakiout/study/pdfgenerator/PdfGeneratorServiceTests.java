package com.khakiout.study.pdfgenerator;

import org.junit.jupiter.api.Test;

public class PdfGeneratorServiceTests {

    @Test
    public void test() throws Exception {
        PdfConverterService service = new PdfConverterService();

        service.convert();
    }
}
