package main.java.mii.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.service.MataPelajaranService;

@Controller
@AllArgsConstructor
@RequestMapping("/matapelajaran")
public class MataPelajaranController {
    private MataPelajaranService mataPelajaranService;

    @GetMapping
    public String index() {
        return "admin/daftar-matpel";
    }

}
