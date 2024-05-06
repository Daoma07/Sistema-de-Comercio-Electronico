/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Inventario_Service.manager;

import com.example.Inventario_Service.repository.ProductoRepository;
import com.example.Inventario_Service.service.impl.CategoriaServiceImp;
import com.example.Inventario_Service.service.impl.ProductoServiceImpl;
import com.example.Inventario_Service.service.impl.TallaServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.utilities.dto.CategoriaDto;
import com.mycompany.utilities.dto.CredencialDto;
import com.mycompany.utilities.dto.ProductoDto;
import com.mycompany.utilities.dto.TallaDto;
import com.mycompany.utilities.dto.UsuarioDto;
import com.mycompany.utilities.request.RequestFormat;
import com.mycompany.utilities.response.ResponseFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 *
 * @author Daniel
 */
@Component
public class ActionRouter {

    private final Map<String, Function<String, ResponseFormat>> actionMap;

//    @Autowired
//    private CredencialServiceImpl credencialServiceImpl;
//
//    @Autowired
//    private UsuarioServiceImpl usuarioServiceImpl;
    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    @Autowired
    private TallaServiceImpl tallaServiceImpl;

    @Autowired
    private CategoriaServiceImp categoriaServiceImp;

    @Autowired
    private ObjectMapper objectMapper;

    public ActionRouter() {
        actionMap = new HashMap<>();
        actionMap.put("create-product", this::createProduct);
        actionMap.put("read-tallas", this::readTallas);
        actionMap.put("read-categorias", this::readCategorias);
    }

    public ResponseFormat route(RequestFormat requestFormat) {
        String method = requestFormat.getMethod();
        String content = requestFormat.getContent();
        return actionMap.getOrDefault(method, this::defaultAction).apply(content);
    }

    private ResponseFormat createProduct(String content) {
        try {
            ProductoDto productoDto = objectMapper.readValue(content, ProductoDto.class);
            productoDto = productoServiceImpl.createProduct(productoDto);
            return new ResponseFormat(objectMapper.writeValueAsString(productoDto),
                    HttpStatus.OK.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se pudo registrar el producto",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private ResponseFormat readTallas(String content) {
        try {

            List<TallaDto> tallas = tallaServiceImpl.readAllTalla();
            return new ResponseFormat(objectMapper.writeValueAsString(tallas),
                    HttpStatus.OK.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se pudo consultar las tallas",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private ResponseFormat readCategorias(String content) {
        try {

            List<CategoriaDto> categoriaDtos = categoriaServiceImp.readAllCategoria();
            return new ResponseFormat(objectMapper.writeValueAsString(categoriaDtos),
                    HttpStatus.OK.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se pudo consultar las categorias",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private ResponseFormat defaultAction(String payload) {
        return new ResponseFormat("Acción no reconocida",
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
