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

import com.eqmoura.estacionamento.model.Tipo;
import com.eqmoura.estacionamento.service.TipoService;

@RestController
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping
    public ResponseEntity<Tipo> save(@RequestBody Tipo tipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.tipoService.save(tipo));
    }

    @GetMapping
    public ResponseEntity<List<Tipo>> findAll() {
        return ResponseEntity.ok(this.tipoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.tipoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Tipo> update(@RequestBody Tipo tipo) {
        return ResponseEntity.ok(this.tipoService.update(tipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.tipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
