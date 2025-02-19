package br.edu.br.meuprimeirospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.br.meuprimeirospringboot.entity.Aluno;
import br.edu.br.meuprimeirospringboot.repository.AlunoRepository;
import br.edu.br.meuprimeirospringboot.services.interfaces.GenericService;

@Service
public class AlunoService implements GenericService<Aluno> {
	@Autowired
	private AlunoRepository aluno;

	@Override
	public List<Aluno> buscarTodos() {
		return aluno.findAllAlunos();
	}

	@Override
	public Aluno buscarPorId(Long id) {
		return aluno.findById(id).orElseThrow(() -> new IllegalArgumentException("Aluno " + id + " não encontrado"));
	}

	@Override
	public void excluirPorId(Long id) {
		aluno.deleteById(id);
	}

	@Override
	public Aluno cadastrar(Aluno a) {
		return aluno.save(a);
	}

	@Override
	public Aluno editar(Aluno a) {
		Aluno al = this.buscarPorId(a.getId());
		al.setNome(a.getNome());
		al.setEmail(a.getEmail());
		al.setCpf(a.getCpf());
		al.setMatricula(a.getMatricula());
		al.setDtNascimento(a.getDtNascimento());

		return aluno.save(al);
	}
}
