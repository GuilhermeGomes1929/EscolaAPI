package br.edu.escola.repository;

import br.edu.escola.model.Notas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasRepository extends JpaRepository<Notas, Long> { }
