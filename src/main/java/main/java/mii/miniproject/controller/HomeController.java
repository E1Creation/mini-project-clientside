package main.java.mii.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
    @GetMapping
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/index";
    }
}
