package com.khakiout.study.pdfgenerator;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.HtmlParser;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class PdfConverterService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void convert() {
        // step 1: creation of a document-object
        try (Document document = new Document()) {
            PdfWriter.getInstance(document, new FileOutputStream("parseHelloWorld.pdf"));
            // step 2: we open the document
            document.open();
            // step 3: parsing the HTML document to convert it in PDF
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("email.html");
            HtmlParser.parse(document, inputStream);
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
    }

}
