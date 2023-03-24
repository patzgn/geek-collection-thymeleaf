package com.patzgn.geekcollection.web.profile;

import com.patzgn.geekcollection.domain.usergame.Status;
import com.patzgn.geekcollection.domain.usergame.UserGameDto;
import com.patzgn.geekcollection.domain.usergame.UserGameService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users/{username}/games")
@AllArgsConstructor
class UserGameController {

    private UserGameService userGameService;

    @ModelAttribute("statuses")
    public Status[] statusesAttribute() {
        return Status.values();
    }

    @GetMapping
    public String getAllUserGames(@PathVariable String username,
                                  @PageableDefault(sort = "gameTitle") Pageable pageable,
                                  Model model) {
        Page<UserGameDto> games = userGameService.findAllUserGames(username, pageable);
        return addPaginationModel(games, model);
    }

    private String addPaginationModel(Page<UserGameDto> page, Model model) {
        model.addAttribute("games", page.getContent());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("currentPage", page.getNumber() + 1);
        return "/profile/games";
    }


    //    @PostMapping
    //    public String addUserGame(@PathVariable String name,
    //                              @RequestParam long id,
    //                              @RequestParam String list,
    //                              @RequestParam String status,
    //                              Model model,
    //                              RedirectAttributes redirectAttributes) {
    //        gameListService.addGame(id, list, status, name);
    //        redirectAttributes.addFlashAttribute("message", "Game saved");
    //        return "redirect:/game/" + id;
    //    }
    //
    //    @PutMapping("/{id}")
    //    public String editUserGame(@PathVariable long id,
    //                               @RequestParam String status,
    //                               @RequestHeader String referer) {
    //        gameListService.editGame(id, status);
    //        return "redirect:" + referer;
    //    }
    //
    //    @DeleteMapping("/{id}")
    //    public String deleteUserGame(@PathVariable String name,
    //                                 @PathVariable long id,
    //                                 @RequestHeader String referer) {
    //        gameListService.deleteGame(id);
    //        return "redirect:" + referer;
    //    }

}
