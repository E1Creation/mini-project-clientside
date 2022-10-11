package main.java.mii.miniproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.model.dto.request.LoginRequest;
import main.java.mii.miniproject.model.dto.request.Register;
import main.java.mii.miniproject.service.LoginService;

@Controller
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @GetMapping("/login")
    public String index(LoginRequest loginRequest, Model model, Authentication authentication) {
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "auth/login";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String registerView(Register register, Model model, Authentication authentication) {

        return "auth/register";
    }

    // public String register(Register register) {
    // if (!loginService.Register(register)) {
    // return "auth/register";
    // }
    // return "redirect:/login";
    // }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest) {
        if (!loginService.login(loginRequest)) {
            return "redirect:/login?error=true";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = authentication.getAuthorities()
                .stream().map(authority -> authority.getAuthority())
                .collect(Collectors.toList());

        return "redirect:/dashboard";
    }
}
