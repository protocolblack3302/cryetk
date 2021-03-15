package com.coderme.Library.Converters;
import com.coderme.Library.Domains.Book;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
public class UrlToBookConverter implements GenericTransformer<String,Book> {

public Book urlToBook (String sourceFile){

    PdfToImageConverter pdfToImageConverter = new PdfToImageConverter();
    pdfToImageConverter.OpenDocument(sourceFile);
    Book book = new Book();
    book.setBookTitle(pdfToImageConverter.getTitle());
    book.setAuthor(pdfToImageConverter.getAuthor());
    book.setThumbnail(pdfToImageConverter.convertToThumbnail());
    book.setVersion(pdfToImageConverter.getVersion());
    log.info(book.toString());
    log.info("Book is closed :  " + String.valueOf(pdfToImageConverter.closeDocument()));

    return book;
}
    @Override
    public Book transform(String s) {
        return urlToBook(s);
    }
}
