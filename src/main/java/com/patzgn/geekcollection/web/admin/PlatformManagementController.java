package com.patzgn.geekcollection.web.admin;

import com.patzgn.geekcollection.domain.genre.GenreService;
import com.patzgn.geekcollection.domain.genre.dto.GenreDto;
import com.patzgn.geekcollection.domain.platform.PlatformService;
import com.patzgn.geekcollection.domain.platform.dto.PlatformDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PlatformManagementController {
    private final PlatformService platformService;

    public PlatformManagementController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping("/admin/add-platform")
    public String addPlatformForm(Model model) {
        PlatformDto platform = new PlatformDto();
        model.addAttribute("platform", platform);
        return "admin/platform-form";
    }

    @PostMapping("/admin/add-platform")
    public String addPlatform(PlatformDto platform, RedirectAttributes redirectAttributes) {
        platformService.addPlatform(platform);
        redirectAttributes.addFlashAttribute(
                "message",
                "Platform %s saved".formatted(platform.getName())
        );
        return "redirect:/admin";
    }
}
