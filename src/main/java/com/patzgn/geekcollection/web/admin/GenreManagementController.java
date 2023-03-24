package com.patzgn.geekcollection.web.admin;

import com.patzgn.geekcollection.domain.game.GameService;
import com.patzgn.geekcollection.domain.game.dto.GameSaveDto;
import com.patzgn.geekcollection.domain.genre.Genre;
import com.patzgn.geekcollection.domain.genre.GenreService;
import com.patzgn.geekcollection.domain.genre.dto.GenreDto;
import com.patzgn.geekcollection.domain.platform.PlatformService;
import com.patzgn.geekcollection.domain.platform.dto.PlatformDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GenreManagementController {
    private final GenreService genreService;

    public GenreManagementController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/admin/add-genre")
    public String addGenreForm(Model model) {
        GenreDto genre = new GenreDto();
        model.addAttribute("genre", genre);
        return "admin/genre-form";
    }

    @PostMapping("/admin/add-genre")
    public String addGenre(GenreDto genre, RedirectAttributes redirectAttributes) {
        genreService.addGenre(genre);
        redirectAttributes.addFlashAttribute(
                "message",
                "Genre %s saved".formatted(genre.getName())
        );
        return "redirect:/admin";
    }
}
