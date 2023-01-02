package com.patzgn.geekcollection.web;

import com.patzgn.geekcollection.domain.game.dto.GameDto;
import com.patzgn.geekcollection.domain.game.GameService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class GameController {
    private static final int GAMES_PAGE_SIZE = 20;

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
        return "game/game";
    }

    @GetMapping("/games")
    public String getGamesList(@RequestParam(defaultValue = "1") int page,
                               Model model) {
        Page<GameDto> gamesPage = gameService.findAllGamesPage(page, GAMES_PAGE_SIZE);
        model.addAttribute("games", gamesPage.getContent());
        model.addAttribute("totalPages", gamesPage.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", GAMES_PAGE_SIZE);
        return "game/game-listing";
    }
}
