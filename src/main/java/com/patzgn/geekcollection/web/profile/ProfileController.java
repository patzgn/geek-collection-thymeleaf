package com.patzgn.geekcollection.web.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ProfileController {

    @GetMapping("/{username}")
    String getMyProfile(@PathVariable String username) {
        return "profile/profile";
    }
}
