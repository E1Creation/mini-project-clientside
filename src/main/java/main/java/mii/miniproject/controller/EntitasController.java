package main.java.mii.miniproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.model.Entitas;
import main.java.mii.miniproject.service.EntitasService;
import main.java.mii.miniproject.service.MataPelajaranService;

@Controller
@AllArgsConstructor
public class EntitasController {
    private EntitasService entitasService;

    @GetMapping("/guru")
    public String guru(Model model, Long id) {
        SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("guru", entitasService.getAllByRole(2L));
        return "admin/daftar-guru";
    }

    @GetMapping("/siswa")
    public String siswa(Model model, Long id) {
        model.addAttribute("siswa", entitasService.getAllByRole(1L));
        return "admin/daftar-siswa";
    }

    @GetMapping("/manageuser")
    public String manageUser() {
        return "admin/mengelola-user";
    }
}
