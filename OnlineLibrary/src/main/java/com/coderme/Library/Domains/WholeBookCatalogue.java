package com.coderme.Library.Domains;

import com.coderme.Library.Converters.UrlToBookConverter;
import com.coderme.Library.Services.DirectoryProp;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class WholeBookCatalogue{
    private final String searchString;

    public WholeBookCatalogue(String searchString) {
        this.searchString=searchString;
    }

    public  boolean hasBook(){

        AtomicBoolean matches = new AtomicBoolean(false);
        try (Stream<Path> walkStream = Files.walk(Paths.get(DirectoryProp.directory))) {
            walkStream.filter(p -> p.toFile().isFile()).forEach(f -> {
              String[] splittedFileName = f.getFileName().toString().split(" ");
           matches.set(Arrays.stream(splittedFileName).anyMatch((split) -> split.contains(searchString)));
            }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches.get();
    }

    public Book getBook(){
        UrlToBookConverter urlToBookConverter = new UrlToBookConverter();
       return urlToBookConverter.transform(searchString);
    }

}
