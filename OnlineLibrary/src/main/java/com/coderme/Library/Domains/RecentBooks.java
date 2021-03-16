package com.coderme.Library.Domains;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Queue;

@Component
@Data
@Slf4j
@ConfigurationProperties("bookfetch")

public class RecentBooks implements Serializable {
   private int pagedBooks = 12;
   private Queue<Book> recentBooks;

   public void feedQueue(Book book) {
      if (recentBooks.size() == pagedBooks) {
         recentBooks.poll();
         recentBooks.add(book);
      }
   }
   public void logRecentBooks() {
      log.warn(getRecentBooks().toString());
   }
}