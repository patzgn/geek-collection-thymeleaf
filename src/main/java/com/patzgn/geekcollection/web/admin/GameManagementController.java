package com.patzgn.geekcollection.web.admin;

import com.patzgn.geekcollection.domain.game.GameService;
import com.patzgn.geekcollection.domain.game.dto.GameSaveDto;
import com.patzgn.geekcollection.domain.genre.GenreService;
import com.patzgn.geekcollection.domain.genre.dto.GenreDto;
import com.patzgn.geekcollection.domain.platform.PlatformService;
import com.patzgn.geekcollection.domain.platform.dto.PlatformDto;
import com.patzgn.geekcollection.web.GameController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GameManagementController {
    private final GameService gameService;
    private final GenreService genreService;
    private final PlatformService platformService;

    public GameManagementController(GameService gameService, GenreService genreService, PlatformService platformService) {
        this.gameService = gameService;
        this.genreService = genreService;
        this.platformService = platformService;
    }

    @GetMapping("/admin/add-game")
    public String addGameForm(Model model) {
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("genres", allGenres);
        List<PlatformDto> allPlatforms = platformService.findAllPlatforms();
        model.addAttribute("platforms", allPlatforms);
        GameSaveDto game = new GameSaveDto();
        model.addAttribute("game", game);
        return "admin/game-form";
    }

    @PostMapping("/admin/add-game")
    public String addGame(GameSaveDto game, RedirectAttributes redirectAttributes) {
        gameService.addGame(game);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Game %s saved".formatted(game.getTitle())
        );
        return "redirect:/admin";
    }
}
