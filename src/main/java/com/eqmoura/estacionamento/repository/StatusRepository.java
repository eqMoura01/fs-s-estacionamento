package com.eqmoura.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eqmoura.estacionamento.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

}