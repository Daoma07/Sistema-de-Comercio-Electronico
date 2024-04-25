package com.example.User_Service.manager;

import com.example.User_Service.service.impl.CredencialServiceImpl;
import com.example.User_Service.service.impl.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.utilities.dto.CredencialDto;
import com.mycompany.utilities.dto.UsuarioDto;
import com.mycompany.utilities.request.RequestFormat;
import com.mycompany.utilities.response.ResponseFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ActionRouter {

    private final Map<String, Function<String, ResponseFormat>> actionMap;

    @Autowired
    private CredencialServiceImpl credencialServiceImpl;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private ObjectMapper objectMapper;

    public ActionRouter() {
        actionMap = new HashMap<>();
        actionMap.put("login", this::login);
        actionMap.put("register", this::register);
    }

    public ResponseFormat route(RequestFormat requestFormat) {
        String method = requestFormat.getMethod();
        String content = requestFormat.getContent();
        return actionMap.getOrDefault(method, this::defaultAction).apply(content);
    }

    private ResponseFormat login(String content) {
        try {
            CredencialDto credencial = objectMapper.readValue(content, CredencialDto.class);
            credencial = credencialServiceImpl.readCredencial(credencial);
            if (credencial.getId_credencial() != null) {
                UsuarioDto usuario = usuarioServiceImpl.findUsuariobyCredencial(credencial);
                return new ResponseFormat(objectMapper.writeValueAsString(usuario),
                        HttpStatus.OK.value());
            }
            return new ResponseFormat(objectMapper.writeValueAsString("No existe registros"),
                    HttpStatus.NOT_FOUND.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se pudo verificar las credenciales",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private ResponseFormat register(String content) {
        try {
            UsuarioDto usuarioDto = objectMapper.readValue(content, UsuarioDto.class);
            usuarioDto = usuarioServiceImpl.createUsuario(usuarioDto);
            return new ResponseFormat(objectMapper.writeValueAsString(usuarioDto),
                    HttpStatus.OK.value());
        } catch (Exception ex) {
            Logger.getLogger(ActionRouter.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseFormat("No se pudo registar el usuario",
                    HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    private ResponseFormat defaultAction(String payload) {
        return new ResponseFormat("Acción no reconocida",
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
