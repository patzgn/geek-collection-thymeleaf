package com.patzgn.geekcollection.web;

import com.patzgn.geekcollection.domain.game.GameDto;
import com.patzgn.geekcollection.domain.game.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game/{id}")
    public String getGame(@PathVariable Long id,
                          Model model) {
        GameDto game = gameService.findGameById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("game", game);
        return "game";
    }
}
