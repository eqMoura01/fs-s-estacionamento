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

import com.eqmoura.estacionamento.dto.VeiculoDTO;
import com.eqmoura.estacionamento.exceptions.VeiculoException;
import com.eqmoura.estacionamento.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoDTO> save(@RequestBody VeiculoDTO veiculoDTO) throws VeiculoException {
        return ResponseEntity.ok(veiculoService.save(veiculoDTO));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        return ResponseEntity.ok(veiculoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.findById(id));
    }

    @PutMapping
    public ResponseEntity<VeiculoDTO> update(@RequestBody VeiculoDTO veiculoDTO) throws VeiculoException {
        return ResponseEntity.ok(veiculoService.update(veiculoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
