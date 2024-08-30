package com.eqmoura.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eqmoura.estacionamento.model.Veiculo;
import com.eqmoura.estacionamento.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> save(Veiculo veiculo) {
        return ResponseEntity.ok(this.veiculoService.save(veiculo));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        return ResponseEntity.ok(this.veiculoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(Long id) {
        return ResponseEntity.ok(this.veiculoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Veiculo> update(Veiculo veiculo) {
        return ResponseEntity.ok(this.veiculoService.update(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        this.veiculoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
