package com.patzgn.geekcollection.web.admin;

import com.patzgn.geekcollection.domain.game.GameService;
import com.patzgn.geekcollection.domain.game.dto.GameDto;
import com.patzgn.geekcollection.domain.game.dto.GameSaveDto;
import com.patzgn.geekcollection.domain.genre.GenreService;
import com.patzgn.geekcollection.domain.genre.dto.GenreDto;
import com.patzgn.geekcollection.domain.platform.PlatformService;
import com.patzgn.geekcollection.domain.platform.dto.PlatformDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
                "message",
                "Game %s saved".formatted(game.getTitle())
        );
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit-game/{id}")
    public String editGame(@PathVariable long id, Model model) {
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("genres", allGenres);
        List<PlatformDto> allPlatforms = platformService.findAllPlatforms();
        model.addAttribute("platforms", allPlatforms);
        Optional<GameDto> game = gameService.findGameById(id);
        model.addAttribute("game", game);
        return "admin/game-form";
    }

    @GetMapping("/admin/delete-game/{id}")
    public String deleteGame(@PathVariable long id, RedirectAttributes redirectAttributes) {
        gameService.deleteGame(id);
        redirectAttributes.addFlashAttribute(
                "message",
                "Successfully deleted"
        );
        return "redirect:/games";
    }
}
