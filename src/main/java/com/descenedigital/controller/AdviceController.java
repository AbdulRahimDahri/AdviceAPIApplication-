package com.descenedigital.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.descenedigital.dto.AdviceDTO;
import com.descenedigital.model.Advice;
import com.descenedigital.service.AdviceService;

@RestController
@RequestMapping("/api/advice")
public class AdviceController {	


    private final AdviceService service;

    public AdviceController(AdviceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdviceDTO>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdviceDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AdviceDTO> create(@RequestBody Advice input) {
        return ResponseEntity.ok(service.create(input));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdviceDTO> update(@PathVariable Long id, @RequestBody Advice input) {
        return ResponseEntity.ok(service.update(id, input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/rate")
    public ResponseEntity<AdviceDTO> rate(@PathVariable Long id, @RequestParam("value") Integer value) {
        if (value == null || value < 1 || value > 5) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.rate(id, value));
    }

    @GetMapping("/top-rated")
    public ResponseEntity<List<AdviceDTO>> topRated(@RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        return ResponseEntity.ok(service.getTopRated(limit));
    }



}