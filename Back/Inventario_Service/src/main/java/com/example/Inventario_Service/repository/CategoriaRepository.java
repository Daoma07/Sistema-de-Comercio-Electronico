package com.example.Inventario_Service.repository;

import com.example.Inventario_Service.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
