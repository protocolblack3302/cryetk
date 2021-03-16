package com.coderme.Library.Converters;
import com.coderme.Library.Domains.Book;
import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.IOException;


@Slf4j

public class UrlToBookConverter{

    public Book transformToBook (String sourceFile){
        File file = new File(sourceFile);
        PdfUtilities pdfUtilities = null;
        Book book = new Book();
        try {
            pdfUtilities = new PdfUtilities(file);
            book.setBookTitle(pdfUtilities.getTitle());
            book.setAuthor(pdfUtilities.getAuthor());
            book.setVersion(pdfUtilities.getVersion());
            log.info(book.toString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if(pdfUtilities!=null){
                pdfUtilities.closeDocument();
            }
        }
        return book;
        }

}
