package com.patzgn.geekcollection.web;

import com.patzgn.geekcollection.domain.game.dto.GameDto;
import com.patzgn.geekcollection.domain.game.GameService;
import com.patzgn.geekcollection.domain.usergame.Status;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping("/games")
@AllArgsConstructor
class GameControllerOld {

    private final GameService gameService;

    @GetMapping
    public String getAllGames(@RequestParam(required = false) String keyword,
                              @PageableDefault(sort = "title") Pageable pageable,
                              Model model) {
        Page<GameDto> page;
        if (keyword == null) {
            page = gameService.findAllGames(pageable);
        } else {
            page = gameService.findByTitleContaining(keyword, pageable);
            model.addAttribute("keyword", keyword);
        }
        return addPaginationModel(page, model);
    }

    private String addPaginationModel(Page<GameDto> page, Model model) {
        model.addAttribute("games", page.getContent());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("currentPage", page.getNumber() + 1);
        return "game/game-listing";
    }

    //TODO
    @GetMapping("/{id}")
    public String getGame(@PathVariable Long id,
                          Authentication authentication,
                          Model model) {
        GameDto game = gameService.findGameById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("game", game);

        model.addAttribute("status", Status.values());

        return "game/game";
    }

    @GetMapping("/platform/{platform}")
    public String getAllGamesByGenre(@PathVariable String platform,
                                     @RequestParam(required = false) String keyword,
                                     @PageableDefault(sort = "title") Pageable pageable,
                                     Model model) {
        Page<GameDto> page;
        if (keyword == null) {
            page = gameService.findAllByPlatform(platform, pageable);
        } else {
            page = gameService.findByPlatformAndTitleContaining(platform, keyword, pageable);
            model.addAttribute("keyword", keyword);
        }
        return addPaginationModel(page, model);
    }

}
