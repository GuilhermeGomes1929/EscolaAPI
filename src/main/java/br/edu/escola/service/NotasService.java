package br.edu.escola.service;

import br.edu.escola.exceptions.NotasNaoEncontradasException;
import br.edu.escola.model.Aluno;
import br.edu.escola.model.Notas;
import br.edu.escola.repository.AlunoRepository;
import br.edu.escola.repository.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class NotasService {

    @Autowired
    private NotasRepository notasRepository;

    @Autowired
    private AlunoRepository alunoRepository;


    public List<Notas> listar(){
        if (notasRepository.findAll().isEmpty()){
            throw new NotasNaoEncontradasException();
        }
        return notasRepository.findAll();
    }

    public Notas editar(Notas notas){
        if (notasRepository.findById(notas.getId()).isEmpty()){
            throw new NotasNaoEncontradasException();
        }
        return notasRepository.save(notas);
    }

    public Notas buscar(Long id){
        if (notasRepository.findById(id).isEmpty()){
            throw new NotasNaoEncontradasException();
        }
        return notasRepository.findById(id).get();
    }

}
