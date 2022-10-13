package main.java.mii.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.service.MataPelajaranService;

@Controller
@AllArgsConstructor
public class MataPelajaranController {
    private MataPelajaranService mataPelajaranService;

    @GetMapping("/matapelajaran")
    public String matapelajaran(Model model) {
        model.addAttribute("matapelajaran", mataPelajaranService.getAll());
        return "admin/daftar-matpel";
    }

}
