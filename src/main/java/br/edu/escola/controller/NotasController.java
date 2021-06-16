package br.edu.escola.controller;

import br.edu.escola.exceptions.NotasNaoEncontradasException;
import br.edu.escola.model.Notas;
import br.edu.escola.repository.NotasRepository;
import br.edu.escola.service.NotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private NotasService notasService;

    @GetMapping("/")
    public List<Notas> listar(){
        try{
            return notasService.listar();
        }catch (NotasNaoEncontradasException e){throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não há notas cadastradas", e);
        }
    }

    @GetMapping("/{id}")
    public Notas buscar(@PathVariable Long id){
        try{
            return notasService.buscar(id);
        }catch (NotasNaoEncontradasException e){throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Notas não encontradas", e);
        }
    }

    @PutMapping("/")
    public Notas editar(@RequestBody Notas notas){
        try{
            return notasService.editar(notas);
        }catch (NotasNaoEncontradasException e){throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Notas não encontradas", e);
        }
    }

}
