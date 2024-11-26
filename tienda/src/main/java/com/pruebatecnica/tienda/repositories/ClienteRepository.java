package com.pruebatecnica.tienda.repositories;

import com.pruebatecnica.tienda.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel,Long> {
}
