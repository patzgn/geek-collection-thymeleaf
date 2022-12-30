package com.patzgn.geekcollection.web.admin;

import com.patzgn.geekcollection.domain.game.GameService;
import com.patzgn.geekcollection.domain.game.dto.GameSaveDto;
import com.patzgn.geekcollection.web.GameController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GameManagementController {
    private final GameService gameService;

    public GameManagementController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/admin/add-game")
    public String addGameForm(Model model) {
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
