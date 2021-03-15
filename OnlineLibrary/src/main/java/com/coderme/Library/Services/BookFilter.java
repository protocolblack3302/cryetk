package com.coderme.Library.Services;

import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Component;

@Component
public class BookFilter {
    @Filter
    public boolean isPdf(String s){
        return s.contains(".pdf");
    }

}
