package com.eqmoura.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eqmoura.estacionamento.model.Modelo;
import com.eqmoura.estacionamento.service.ModeloService;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ResponseEntity<Modelo> save(@RequestBody Modelo modelo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.modeloService.save(modelo));
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> findAll() {
        return ResponseEntity.ok(this.modeloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.modeloService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Modelo> update(@RequestBody Modelo modelo) {
        return ResponseEntity.ok(this.modeloService.update(modelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.modeloService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
