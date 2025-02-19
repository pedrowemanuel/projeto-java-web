package br.edu.br.meuprimeirospringboot.services.interfaces;

import java.util.List;

public interface GenericService<T> {

	List<T> buscarTodos();

	T buscarPorId(Long id);

	void excluirPorId(Long id);

	T cadastrar(T a);

	T editar(T a);

}
