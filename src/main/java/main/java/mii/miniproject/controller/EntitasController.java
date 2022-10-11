package main.java.mii.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.service.EntitasService;

@Controller
@AllArgsConstructor
public class EntitasController {
    private EntitasService entitasService;

    @GetMapping("/guru")
    public String guru() {
        return "admin/daftar-guru";
    }

    @GetMapping("/siswa")
    public String siswa() {
        return "admin/daftar-siswa";
    }

    @GetMapping("/manageuser")
    public String manageUser() {
        return "admin/mengelola-user";
    }

}
