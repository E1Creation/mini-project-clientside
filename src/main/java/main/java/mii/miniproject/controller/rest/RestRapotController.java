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
import main.java.mii.miniproject.model.Rapot;
import main.java.mii.miniproject.service.RapotService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rapot")
public class RestRapotController {
    private RapotService rapotService;

    @GetMapping
    public List<Rapot> getAll() {
        return rapotService.getAll();
    }

    @GetMapping("/{id}")
    public Rapot getById(@PathVariable Long id) {
        return rapotService.getById(id);
    }

    @PostMapping
    public Rapot create(@RequestBody Rapot rapot) {
        return rapotService.create(rapot);
    }

    @PutMapping("/{id}")
    public Rapot update(@PathVariable Long id, @RequestBody Rapot rapot) {
        return rapotService.update(id, rapot);
    }

    @DeleteMapping("/{id}")
    public Rapot delete(@PathVariable Long id) {
        return rapotService.delete(id);
    }
}
