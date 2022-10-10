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
import main.java.mii.miniproject.model.MataPelajaran;
import main.java.mii.miniproject.service.MataPelajaranService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/mata-pelajaran")
public class RestMataPelajaranController {
    private MataPelajaranService mataPelajaranService;

    @GetMapping
    public List<MataPelajaran> getAll() {
        return mataPelajaranService.getAll();
    }

    @GetMapping("/{id}")
    public MataPelajaran getById(@PathVariable Long id) {
        return mataPelajaranService.getById(id);
    }

    @PostMapping
    public MataPelajaran create(@RequestBody MataPelajaran mataPelajaran) {
        return mataPelajaranService.create(mataPelajaran);
    }

    @PutMapping("/{id}")
    public MataPelajaran update(@PathVariable Long id, @RequestBody MataPelajaran mataPelajaran) {
        return mataPelajaranService.update(id, mataPelajaran);
    }

    @DeleteMapping("/{id}")
    public MataPelajaran delete(@PathVariable Long id) {
        return mataPelajaranService.delete(id);
    }

}
