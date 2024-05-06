package com.example.Inventario_Service.service.impl;

import com.example.Inventario_Service.entity.Categoria;
import com.example.Inventario_Service.mapper.CategoriaMapper;
import com.example.Inventario_Service.repository.CategoriaRepository;
import com.example.Inventario_Service.service.CategoriaService;
import com.mycompany.utilities.dto.CategoriaDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    @Override
    public List<CategoriaDto> readAllCategoria() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaDto> categoriaDtos = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriaDtos.add(CategoriaMapper.mapperToCategoriaDto(categoria));
        }
        return categoriaDtos;
    }

}
