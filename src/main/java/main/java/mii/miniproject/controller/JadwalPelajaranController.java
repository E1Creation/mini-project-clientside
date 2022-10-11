package main.java.mii.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.service.JadwalPelajaranService;

@Controller
@AllArgsConstructor
@RequestMapping("/jadwalpelajaran")
public class JadwalPelajaranController {
    private JadwalPelajaranService jadwalPelajaranService;

    @GetMapping
    public String index() {
        return "admin/jadwal-matapelajaran";
    }

}
