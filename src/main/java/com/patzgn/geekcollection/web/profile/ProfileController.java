package com.patzgn.geekcollection.web.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    @GetMapping("/user/{username}")
    String getMyProfile(@PathVariable String username) {
        return "profile/profile";
    }
}
