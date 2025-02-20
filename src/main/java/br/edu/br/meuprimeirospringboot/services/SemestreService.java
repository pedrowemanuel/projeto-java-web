package br.edu.br.meuprimeirospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.br.meuprimeirospringboot.entity.Semestre;
import br.edu.br.meuprimeirospringboot.repository.SemestreRepository;
import br.edu.br.meuprimeirospringboot.services.interfaces.GenericService;

@Service
public class SemestreService implements GenericService<Semestre> {
	@Autowired
	private SemestreRepository repository;

	@Override
	public List<Semestre> buscarTodos() {
		return repository.findAll();
	}

	@Override
	public Semestre buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Registro " + id + " não encontrado"));
	}

	@Override
	public void excluirPorId(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Semestre cadastrar(Semestre a) {
		return repository.save(a);
	}

	@Override
	public Semestre editar(Semestre a) {
		Semestre object = this.buscarPorId(a.getId());
		object.setAno(a.getAno());
		object.setSemestre(a.getSemestre());
		object.setInicio(a.getInicio());
		object.setFim(a.getFim());

		return repository.save(object);
	}
}
