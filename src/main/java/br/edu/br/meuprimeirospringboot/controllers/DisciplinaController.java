package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.br.meuprimeirospringboot.entity.Disciplina;
import br.edu.br.meuprimeirospringboot.services.DisciplinaService;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
	@Autowired
	private DisciplinaService disciplina;

	@GetMapping("/listar")
	String ListarAlunos(ModelMap model) {
		model.addAttribute("disciplinas", disciplina.buscarTodos());
		return "/disciplina/lista";
	}

	@GetMapping("/cadastrar")
	String CadastrarAlunos(ModelMap model) {
		model.addAttribute("disciplina", new Disciplina());
		return "/disciplina/cadastro";
	}

	@PostMapping("/salvar")
	String Salvar(Disciplina a) {
		disciplina.cadastrar(a);
		return "redirect:/disciplinas/listar";
	}

	@GetMapping("/excluir/{id}")
	String excluir(@PathVariable("id") Long id) {
		disciplina.excluirPorId(id);
		return "redirect:/disciplinas/listar";
	}

	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("disciplina", disciplina.buscarPorId(id));
		return "/disciplina/cadastro";
	}

	@PostMapping("/editar")
	String editar(Disciplina a) {
		disciplina.editar(a);
		return "redirect:/disciplinas/listar";
	}
}
