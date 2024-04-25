package com.example.User_Service.service;

import com.mycompany.utilities.dto.CredencialDto;
import com.mycompany.utilities.dto.UsuarioDto;

public interface UsuarioService {

    UsuarioDto createUsuario(UsuarioDto usuarioDto);

    UsuarioDto findUsuariobyCredencial(CredencialDto credencialDto);
}
