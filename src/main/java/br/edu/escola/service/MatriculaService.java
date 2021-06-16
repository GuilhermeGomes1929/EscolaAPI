package br.edu.escola.service;

import br.edu.escola.exceptions.AlunoNaoEncontradoException;
import br.edu.escola.model.Aluno;
import br.edu.escola.model.Notas;
import br.edu.escola.repository.AlunoRepository;
import br.edu.escola.repository.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private NotasRepository notasRepository;


    public List<Aluno> listar(){
        if (alunoRepository.findAll().isEmpty()){throw new AlunoNaoEncontradoException();}
        return alunoRepository.findAll();
    }


    public Aluno buscar(Long matricula){
        if(alunoRepository.findById(matricula).isEmpty()){throw new AlunoNaoEncontradoException();}
        return alunoRepository.findById(matricula).get();
    }

    public Aluno matricular(Aluno aluno){

        Notas notas = notasRepository.save(new Notas());
        aluno.setMatricula(notas.getId());
        aluno.setNotas(notas);
        return alunoRepository.save(aluno);
    }

    public Aluno cancelarMatricula(Long matricula){
        Optional<Aluno> aluno = alunoRepository.findById(matricula);
        if (aluno.isEmpty()){throw new AlunoNaoEncontradoException();}
        alunoRepository.delete(aluno.get());
        return aluno.get();
    }

    public Aluno editarMatricula(Aluno aluno){
        if (alunoRepository.findById(aluno.getMatricula()).isEmpty()){
            throw new AlunoNaoEncontradoException();
        }
        return alunoRepository.save(aluno);
    }

    public List<Aluno> buscarPorNome(String nome){
        if (alunoRepository.findByNomeContains(nome).isEmpty()){
            throw new AlunoNaoEncontradoException();
        }
        return  alunoRepository.findByNomeContains(nome);
    }

    public Aluno buscarPorNomeExato(String nome){
        if (alunoRepository.findByNome(nome) == null){
            throw new AlunoNaoEncontradoException();
        }
        return alunoRepository.findByNome(nome);
    }

}
