package com.laveronica.siscontrol.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.laveronica.siscontrol.services.ContratoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(ContratosController.class)
class ContratosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ContratoService contratoService;

    @BeforeEach
    void setup() {
        objectMapper.registerModule(new JavaTimeModule());
    }





    @Test
    void registrar() {
    }

    @Test
    void contratosLista() {
    }

    @Test
    void contratoBuscarId() {
    }

    @Test
    void actualizarContrato() {
    }

    @Test
    void eliminarContrato() {
    }
}