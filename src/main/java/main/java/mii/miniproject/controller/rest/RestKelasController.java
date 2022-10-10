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
import main.java.mii.miniproject.model.Kelas;
import main.java.mii.miniproject.service.KelasService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kelas")
public class RestKelasController {
    private KelasService kelasService;

    @GetMapping
    public List<Kelas> getAll() {
        return kelasService.getAll();
    }

    @GetMapping("/{id}")
    public Kelas getById(@PathVariable Long id) {
        return kelasService.getById(id);
    }

    @PostMapping
    public Kelas create(@RequestBody Kelas kelas) {
        return kelasService.create(kelas);
    }

    @PutMapping("/{id}")
    public Kelas update(@PathVariable Long id, @RequestBody Kelas kelas) {
        return kelasService.update(id, kelas);
    }

    @DeleteMapping("/{id}")
    public Kelas delete(@PathVariable Long id) {
        return kelasService.delete(id);
    }

}
