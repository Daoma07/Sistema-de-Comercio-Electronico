/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Inventario_Service.service.impl;

import com.example.Inventario_Service.entity.Talla;
import com.example.Inventario_Service.mapper.TallaMapper;
import com.example.Inventario_Service.repository.TallaRepository;
import com.example.Inventario_Service.service.TallaService;
import com.mycompany.utilities.dto.TallaDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Daniel
 */
public class TallaServiceImpl implements TallaService {

    @Autowired
    private TallaRepository tallaRepository;

    @Override
    public List<TallaDto> readAllTalla() {
        List<Talla> tallas = tallaRepository.findAll();
        List<TallaDto> tallasDto = new ArrayList<>();
        for (Talla talla : tallas) {
            tallasDto.add(TallaMapper.mapperToTallaDto(talla));
        }
        return tallasDto;
    }

}
