package com.br.FinalJayme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.FinalJayme.entities.Agendamento;
import com.br.FinalJayme.services.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoService service;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(Agendamento agendamento) {
        return new ResponseEntity<>(service.cadastro(agendamento), HttpStatus.OK);
    }
}
