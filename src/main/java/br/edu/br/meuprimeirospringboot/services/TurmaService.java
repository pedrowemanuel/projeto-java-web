package br.edu.br.meuprimeirospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.br.meuprimeirospringboot.entity.Turma;
import br.edu.br.meuprimeirospringboot.repository.TurmaRepository;
import br.edu.br.meuprimeirospringboot.services.interfaces.GenericService;

@Service
public class TurmaService implements GenericService<Turma> {
	@Autowired
	private TurmaRepository repository;

	@Override
	public List<Turma> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Turma buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Registro " + id + " não encontrado"));
	}

	@Override
	public void excluirPorId(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Turma cadastrar(Turma a) {
		return repository.save(a);
	}

	@Override
	public Turma editar(Turma a) {
		Turma object = this.buscarPorId(a.getId());
		object.setSemestre(a.getSemestre());
		object.setHorario(a.getHorario());
		object.setProfessor(a.getProfessor());
		object.setDescricao(a.getDescricao());

		return repository.save(object);
	}
}
