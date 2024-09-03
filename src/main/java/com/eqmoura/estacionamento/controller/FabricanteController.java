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

import com.eqmoura.estacionamento.model.Fabricante;
import com.eqmoura.estacionamento.service.FabricanteService;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping
    public ResponseEntity<Fabricante> save(@RequestBody Fabricante fabricante) {
        return ResponseEntity.ok(fabricanteService.save(fabricante));
    }

    @GetMapping
    public ResponseEntity<List<Fabricante>> findAll() {
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> findById(@PathVariable Long id) {
        return ResponseEntity.ok(fabricanteService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Fabricante> update(@RequestBody Fabricante fabricante) {
        return ResponseEntity.ok(fabricanteService.update(fabricante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fabricanteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Fabricante>> findAllAtivos() {
        return ResponseEntity.ok(fabricanteService.findAllAtivos());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Fabricante>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(fabricanteService.findByNome(nome));
    }

    @GetMapping("/nome/{nome}/ativos")
    public ResponseEntity<List<Fabricante>> findByNomeAtivos(@PathVariable String nome) {
        return ResponseEntity.ok(fabricanteService.findByNomeAtivos(nome));
    }
}
