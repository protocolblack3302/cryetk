package com.coderme.Library.Domains;

import lombok.Data;

import java.awt.image.BufferedImage;

@Data
public class Book {

    private String bookTitle;
    private BufferedImage thumbnail;
    private float version;
    private String author;
    private int pages;

}
