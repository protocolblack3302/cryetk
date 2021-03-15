package com.coderme.Library.Controllers;

import com.coderme.Library.Domains.Book;
import com.coderme.Library.Domains.WholeBookCatalogue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class SearchController {
    @PostMapping("/search")
    public String getBook(@RequestParam(value = "searchString") String searchString , Model model){

        WholeBookCatalogue bookCatalogue = new WholeBookCatalogue(searchString);
        if(bookCatalogue.hasBook()){
            Book foundBook = bookCatalogue.getBook();
            model.addAttribute("foundBook",foundBook);
            log.info(foundBook.toString());
        }else {
            model.addAttribute("foundBook", "oops! Book Not found int the database");
            log.error("Book not found !");
        }
        return "redirect:/search";
    }

}
