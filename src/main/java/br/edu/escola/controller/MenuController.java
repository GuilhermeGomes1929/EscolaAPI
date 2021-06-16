package br.edu.escola.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MenuController {

    @GetMapping("/")
    public String showMenu(){
        return "API para matricular alunos numa escola e cadastrar as notas bimestrais.\n" +
                "-----------------------------------------------------------------------\n" +
                "Caminho /matricula\n" +
                "-----------------------------------------------------------------------\n" +
                "método post cadastra o aluno, método get retorna todos os alunos, método\n" +
                "put (informando o número de matrícula) edita a matrícula, o método delete\n" +
                "deleta o aluno e o método get (informando a matrícula) retorna todos os \n" +
                "dados do aluno matriculado.\n" +
                "-----------------------------------------------------------------------\n" +
                "Caminho /notas\n" +
                "-----------------------------------------------------------------------\n" +
                "método post cadastra as notas do aluno, método get retorna todas notas \n" +
                "dos alunos, método put(informando a matrícula) edita as notas, método \n" +
                "delete deleta as notas do aluno e o método get (informando a matrícula)\n" +
                "retorna todas as notas do aluno.";
    }
}
