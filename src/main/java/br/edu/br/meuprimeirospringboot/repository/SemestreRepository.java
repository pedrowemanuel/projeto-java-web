package br.edu.br.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.br.meuprimeirospringboot.entity.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {

}
