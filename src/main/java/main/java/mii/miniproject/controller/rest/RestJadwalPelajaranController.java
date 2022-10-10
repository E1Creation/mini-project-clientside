package main.java.mii.miniproject.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import main.java.mii.miniproject.model.JadwalPelajaran;
import main.java.mii.miniproject.service.JadwalPelajaranService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/jadwal-pelajaran")
public class RestJadwalPelajaranController {
    private JadwalPelajaranService jadwalPelajaranService;

    @GetMapping
    public List<JadwalPelajaran> getAll() {
        return jadwalPelajaranService.getAll();
    }

    @GetMapping("/{id}")
    public JadwalPelajaran getById(@PathVariable Long id) {
        return jadwalPelajaranService.getById(id);
    }

    @PostMapping
    public JadwalPelajaran create(@RequestBody JadwalPelajaran jadwalPelajaran) {
        return jadwalPelajaranService.create(jadwalPelajaran);
    }

    @PutMapping("/{id}")
    public JadwalPelajaran update(@PathVariable Long id, @RequestBody JadwalPelajaran jadwalPelajaran) {
        return jadwalPelajaranService.update(id, jadwalPelajaran);
    }

    @DeleteMapping("/{id}")
    public JadwalPelajaran delete(@PathVariable Long id) {
        return jadwalPelajaranService.delete(id);
    }
}
