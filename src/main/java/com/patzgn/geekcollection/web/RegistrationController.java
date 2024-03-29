package com.patzgn.geekcollection.web;

import com.patzgn.geekcollection.domain.user.UserService;
import com.patzgn.geekcollection.domain.user.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserRegistrationDto userRegistration = new UserRegistrationDto();
        model.addAttribute("user", userRegistration);
        return "registration-form";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDto userRegistration,
                           RedirectAttributes redirectAttributes) {
        userService.registerUserWithDefaultRole(userRegistration);
        redirectAttributes.addFlashAttribute("message", "You have successfully registered");
        return "redirect:/";
    }

}
