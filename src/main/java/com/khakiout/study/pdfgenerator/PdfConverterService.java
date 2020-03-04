package com.khakiout.study.pdfgenerator;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

@Service
public class PdfConverterService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void convert() throws Exception {
        try (OutputStream os = new FileOutputStream("openHtmlToPdf.pdf")) {
            ClassLoader classLoader = this.getClass().getClassLoader();
            URL inputUrl = classLoader.getResource("email.html");

            var builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withUri(inputUrl.toURI().toString());
            builder.toStream(os);
            builder.run();
        }
    }

}
