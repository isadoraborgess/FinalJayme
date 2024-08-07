package com.br.FinalJayme.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.FinalJayme.dto.ProntuarioDto;
import com.br.FinalJayme.entities.Prontuario;
import com.br.FinalJayme.repository.ProntuarioRepository;

@Service
public class ProntuarioService {

    @Autowired
    ProntuarioRepository repository;

    public String cadastro(Prontuario prontuario) {
        repository.save(prontuario);
        return "Cadastrado com sucesso!";
    }

    public List<ProntuarioDto> listar() {
        List<Prontuario> prontuarios = repository.findAll();
        return prontuarios.stream().map(x -> new ProntuarioDto(x)).collect(Collectors.toList());
    }

    public String deletar(@PathVariable("id") int id) {
        Prontuario prontuario = repository.findById(id).orElse(null);

        if (prontuario != null) {
            repository.delete(prontuario);
            return "Deletado com sucesso!";
        }
        return "Nao encontrado!";

    }

    public String editar(Prontuario newProntuario, @PathVariable("id") int id) {
        Prontuario prontuario = repository.findById(id).orElse(null);

        if (prontuario == null) {
            return "Prontuário não encontrado!";
        }

        prontuario.setConvenios(newProntuario.getConvenios());
        prontuario.setDataAlta(newProntuario.getDataAlta());
        prontuario.setDataEntrada(newProntuario.getDataEntrada());
        prontuario.setDiagnostico(newProntuario.getDiagnostico());
        prontuario.setPaciente(newProntuario.getPaciente());
        prontuario.setRegistros(newProntuario.getRegistros());

        repository.save(prontuario);

        return "Editado com sucesso!";
    }

}
