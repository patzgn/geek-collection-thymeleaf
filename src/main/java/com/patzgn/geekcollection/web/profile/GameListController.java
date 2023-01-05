package com.patzgn.geekcollection.web.profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/{username}")
public class GameListController {


    @GetMapping("/games")
    public String getGameList(@PathVariable String username,
                              Model model) {

        return ("/profile/games");
    }

}
