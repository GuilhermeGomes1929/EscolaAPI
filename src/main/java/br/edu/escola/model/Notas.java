package br.edu.escola.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 2, scale = 2)
    private Float primeiroBimestre;

    @Column(precision = 2, scale = 2)
    private Float segundoBimestre;

    @Column(precision = 2, scale = 2)
    private Float terceiroBimestre;

    @Column(precision = 2, scale = 2)
    private Float quartoBimestre;

    @Column
    private Boolean aprovado;

    public Notas() {}

    public Notas(Long id, Float primeiroBimestre, Float segundoBimestre, Float terceiroBimestre, Float quartoBimestre, Boolean aprovado) {
        this.id = id;
        this.primeiroBimestre = primeiroBimestre;
        this.segundoBimestre = segundoBimestre;
        this.terceiroBimestre = terceiroBimestre;
        this.quartoBimestre = quartoBimestre;
        this.aprovado = aprovado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notas notas = (Notas) o;
        return Objects.equals(id, notas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public Notas setId(Long id) {
        this.id = id;
        return this;
    }

    public Float getPrimeiroBimestre() {
        return primeiroBimestre;
    }

    public void setPrimeiroBimestre(Float primeiroBimestre) {
        this.primeiroBimestre = primeiroBimestre;
    }

    public Float getSegundoBimestre() {
        return segundoBimestre;
    }

    public void setSegundoBimestre(Float segundoBimestre) {
        this.segundoBimestre = segundoBimestre;
    }

    public Float getTerceiroBimestre() {
        return terceiroBimestre;
    }

    public void setTerceiroBimestre(Float terceiroBimestre) {
        this.terceiroBimestre = terceiroBimestre;
    }

    public Float getQuartoBimestre() {
        return quartoBimestre;
    }

    public void setQuartoBimestre(Float quartoBimestre) {
        this.quartoBimestre = quartoBimestre;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }
}
