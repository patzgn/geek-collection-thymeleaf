package com.patzgn.geekcollection.web.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/users/{name}")
class UserController {

    @GetMapping
    String getUserByName(@PathVariable String name) {
        return "profile/profile";
    }

}
