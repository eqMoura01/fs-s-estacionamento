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

import com.eqmoura.estacionamento.model.Status;
import com.eqmoura.estacionamento.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public ResponseEntity<Status> save(@RequestBody Status status) {
        return ResponseEntity.ok(this.statusService.save(status));
    }

    @GetMapping
    public ResponseEntity<List<Status>> findAll() {
        return ResponseEntity.ok(this.statusService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.statusService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Status> update(@RequestBody Status status) {
        return ResponseEntity.ok(this.statusService.update(status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.statusService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
