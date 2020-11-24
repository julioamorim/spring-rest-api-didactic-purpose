package io.github.julioamorim.apirest.repository;

import io.github.julioamorim.apirest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
