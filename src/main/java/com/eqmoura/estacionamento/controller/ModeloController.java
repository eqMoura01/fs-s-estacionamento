package com.eqmoura.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eqmoura.estacionamento.dto.ModeloDTO;
import com.eqmoura.estacionamento.service.ModeloService;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ResponseEntity<ModeloDTO> save(@RequestBody ModeloDTO modeloDTO) {
        return ResponseEntity.ok(modeloService.save(modeloDTO));
    }

    @GetMapping
    public ResponseEntity<List<ModeloDTO>> findAll() {
        return ResponseEntity.ok(modeloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(modeloService.findById(id));
    }

    @PutMapping
    public ResponseEntity<ModeloDTO> update(@RequestBody ModeloDTO modeloDTO) {
        return ResponseEntity.ok(modeloService.update(modeloDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        modeloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
