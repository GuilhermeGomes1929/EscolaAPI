package br.edu.escola.controller;

import br.edu.escola.exceptions.AlunoNaoEncontradoException;
import br.edu.escola.model.Aluno;
import br.edu.escola.model.Notas;
import br.edu.escola.repository.NotasRepository;
import br.edu.escola.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@RestController
@RequestMapping("/matricula")
public class MatriculaController {


    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("/")
    public List<Aluno> listar(){
        try{
            return matriculaService.listar();

        }catch (AlunoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não há alunos matriculados", e);
        }
    }

    @GetMapping("/{matricula}")
    public Aluno buscar(@PathVariable Long matricula){
        try{
            return matriculaService.buscar(matricula);
        }catch (AlunoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado.", e);
        }
    }

    @PostMapping("/")
    public Aluno matricular(@RequestBody Aluno aluno){
        return matriculaService.matricular(aluno);
    }

    @DeleteMapping("/{matricula}")
    public Aluno cancelarMatricula(@PathVariable Long matricula){
        try{
            return matriculaService.cancelarMatricula(matricula);
        }catch (AlunoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado", e);
        }
    }

    @PutMapping("/")
    public Aluno editarMatricula(@RequestBody Aluno aluno){
        try{
            return matriculaService.editarMatricula(aluno);
        }catch (AlunoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado", e);
        }
    }

    @GetMapping("/filtro/{nome}")
    public List<Aluno> buscarPorNome(@PathVariable String nome){
        try{
            return matriculaService.buscarPorNome(nome);
        }catch (AlunoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum aluno com nome "+nome+" encontrado.", e);
        }
    }

    @GetMapping("/nome")
    public Aluno buscarPorNomeExato(@RequestBody String nome){
        try {
            return matriculaService.buscarPorNomeExato(nome);
        }catch (AlunoNaoEncontradoException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Aluno não encontrado", e);
        }
    }
}
