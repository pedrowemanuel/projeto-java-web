package br.edu.br.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.br.meuprimeirospringboot.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
