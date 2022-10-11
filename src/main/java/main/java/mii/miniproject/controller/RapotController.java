package main.java.mii.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.service.RapotService;

@Controller
@AllArgsConstructor
@RequestMapping("/rapot")
public class RapotController {
    private RapotService rapotService;

    @GetMapping
    public String index() {
        return "admin/rapot";
    }
}
