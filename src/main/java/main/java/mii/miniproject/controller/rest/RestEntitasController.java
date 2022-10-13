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
import main.java.mii.miniproject.model.Entitas;
import main.java.mii.miniproject.service.EntitasService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/entitas")
public class RestEntitasController {
    private EntitasService entitasService;

    @GetMapping
    public List<Entitas> getAll() {
        return entitasService.getAll();
    }

    @GetMapping("/role/{id}")
    public List<Entitas> getEntitasByRoleId(@PathVariable Long id) {
        return entitasService.getAllByRole(id);
    }

    @GetMapping("/{id}")
    public Entitas getById(@PathVariable Long id) {
        return entitasService.getById(id);
    }

    @PostMapping
    public Entitas create(@RequestBody Entitas entitas) {
        return entitasService.create(entitas);
    }

    @PutMapping("/{id}")
    public Entitas update(@PathVariable Long id, @RequestBody Entitas entitas) {
        return entitasService.update(id, entitas);
    }

    @DeleteMapping("/{id}")
    public Entitas delete(@PathVariable Long id) {
        return entitasService.delete(id);
    }
}