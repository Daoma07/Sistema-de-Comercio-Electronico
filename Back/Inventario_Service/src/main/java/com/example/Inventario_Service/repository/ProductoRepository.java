package com.example.Inventario_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario_Service.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
