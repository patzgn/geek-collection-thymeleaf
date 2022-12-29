package com.patzgn.geekcollection.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/books")
    public String getBooksList() {
        return "book-listing";
    }

}
