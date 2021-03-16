package com.coderme.Library.Domains;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable
{
    private String bookTitle;
    private float version;
    private String author;
    private int pages;

}
