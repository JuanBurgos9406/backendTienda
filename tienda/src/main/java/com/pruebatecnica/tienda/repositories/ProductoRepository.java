package com.pruebatecnica.tienda.repositories;

import com.pruebatecnica.tienda.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Long> {
}
