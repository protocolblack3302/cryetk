package com.coderme.Library.Services;

import com.coderme.Library.Domains.Book;

public interface RecentBookUpdater {

    public void feedQueue(Book book);
    public void logRecentBooks();

}
