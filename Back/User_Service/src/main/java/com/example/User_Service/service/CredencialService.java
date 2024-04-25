package com.example.User_Service.service;

import com.mycompany.utilities.dto.CredencialDto;

public interface CredencialService {

    CredencialDto createCredencial(CredencialDto credencialDto);

    CredencialDto readCredencial(CredencialDto credencialDto);
}
