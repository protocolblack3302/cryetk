package com.coderme.Library.Controllers;

import com.coderme.Library.Domains.SearchObject;
import com.coderme.Library.Domains.WholeBookCatalogue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
@Slf4j
public class SearchController {

    @GetMapping("/search")
    public String getSearchBox(Model model){
        model.addAttribute("searchObject",new SearchObject());
        return "search";
    }


    @PostMapping("/search")
    public String getBook(@Valid SearchObject searchString,Errors errors){
        if(errors.hasErrors()){
            return "search";
        }
        WholeBookCatalogue bookCatalogue = new WholeBookCatalogue(searchString.getSearchString());
        if(bookCatalogue.hasBook()){
            return "bookList";
        }else {
            log.error("Book not found !");
            return "search";
        }

    }

}
