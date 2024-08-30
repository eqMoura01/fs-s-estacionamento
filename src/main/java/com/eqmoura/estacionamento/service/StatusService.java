package com.eqmoura.estacionamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eqmoura.estacionamento.model.Status;
import com.eqmoura.estacionamento.repository.StatusRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Status findById(Long id) {
        Optional<Status> status = statusRepository.findById(id);

        if (status.isEmpty()) {
            throw new EntityNotFoundException("Status com id " + id + " não encontrado");
        }

        return status.get();
    }

    public Status update(Status status) {

        Status statusEncontrado = findById(status.getId());

        BeanUtils.copyProperties(status, statusEncontrado);

        return statusRepository.save(status);
    }

    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }
}
