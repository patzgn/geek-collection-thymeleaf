package com.patzgn.geekcollection.web.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    String getMyProfile() {
        return "profile/profile";
    }
}
