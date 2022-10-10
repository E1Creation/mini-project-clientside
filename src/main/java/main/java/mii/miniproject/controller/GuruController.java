package main.java.mii.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.service.EntitasService;

@Controller
@AllArgsConstructor
@RequestMapping("/entitas/guru")
public class GuruController {
    private EntitasService entitasService;

    @GetMapping
    
}
