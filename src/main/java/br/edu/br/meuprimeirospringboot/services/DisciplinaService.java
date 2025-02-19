package br.edu.br.meuprimeirospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.br.meuprimeirospringboot.entity.Disciplina;
import br.edu.br.meuprimeirospringboot.repository.DisciplinaRepository;
import br.edu.br.meuprimeirospringboot.services.interfaces.GenericService;

@Service
public class DisciplinaService implements GenericService<Disciplina> {
	@Autowired
	private DisciplinaRepository repository;

	@Override
	public List<Disciplina> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Disciplina buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Registro " + id + " não encontrado"));
	}

	@Override
	public void excluirPorId(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Disciplina cadastrar(Disciplina a) {
		return repository.save(a);
	}

	@Override
	public Disciplina editar(Disciplina a) {
		Disciplina object = this.buscarPorId(a.getId());
		object.setNome(a.getNome());
		object.setCodigo(a.getCodigo());
		object.setCargaHoraria(a.getCargaHoraria());
		object.setEmenta(a.getEmenta());

		return repository.save(object);
	}
}
