package com.coderme.Library.Domains;

import com.coderme.Library.Converters.UrlToBookConverter;
import com.coderme.Library.Services.DirectoryProp;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class WholeBookCatalogue {
    private final String searchString;
    private List<String> pathFound;

    public WholeBookCatalogue(String searchString) {
        this.searchString = searchString.toLowerCase();
    }

    public boolean hasBook() {
        AtomicBoolean matches = new AtomicBoolean(false);
        pathFound=new ArrayList<>();
        try (Stream<Path> walkStream = Files.walk(Paths.get(DirectoryProp.directory))) {
            walkStream.filter(p -> p.toFile().isFile()).forEach(f -> {
                if(f.getFileName().toString().contains(".pdf")) {
                    matches.set(f.getFileName().toString().toLowerCase().contains(searchString));
                    if (matches.get()) {
                         pathFound.add(f.toAbsolutePath().toString());
                    }
                }
                    }
            );
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("path found for searched book is : " + pathFound);

        return matches.get();
    }

    public List<Book> getBooks() {
        UrlToBookConverter urlToBookConverter = new UrlToBookConverter();
       return pathFound.stream().map(urlToBookConverter::transformToBook).collect(Collectors.toList());

    }

}
