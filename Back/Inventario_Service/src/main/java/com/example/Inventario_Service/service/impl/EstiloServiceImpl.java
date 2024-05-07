package com.example.Inventario_Service.service.impl;

import com.example.Inventario_Service.entity.Estilo;
import com.example.Inventario_Service.mapper.EstiloMapper;
import com.example.Inventario_Service.repository.EstiloRepository;
import com.example.Inventario_Service.service.EstiloService;
import com.mycompany.utilities.dto.EstiloDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstiloServiceImpl implements EstiloService {

    @Autowired
    private EstiloRepository estiloRepository;

    @Autowired
    private EstiloMapper estiloMapper;

    @Transactional
    @Override
    public List<EstiloDto> readAllEstilo() {
        List<Estilo> estilos = estiloRepository.findAll();
        List<EstiloDto> estiloDtos = new ArrayList<>();
        for (Estilo estilo : estilos) {
            estiloDtos.add(estiloMapper.mapperToEstiloDto(estilo));
        }
        return estiloDtos;
    }

}
