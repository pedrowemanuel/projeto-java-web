package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.br.meuprimeirospringboot.entity.Semestre;
import br.edu.br.meuprimeirospringboot.services.SemestreService;

@Controller
@RequestMapping("/semestres")
public class SemestreController {
	@Autowired
	private SemestreService semestre;

	@GetMapping("/listar")
	String ListarAlunos(ModelMap model) {
		model.addAttribute("semestres", semestre.buscarTodos());
		return "/semestre/lista";
	}

	@GetMapping("/cadastrar")
	String CadastrarAlunos(ModelMap model) {
		model.addAttribute("semestre", new Semestre());
		return "/semestre/cadastro";
	}

	@PostMapping("/salvar")
	String Salvar(Semestre a) {
		semestre.cadastrar(a);
		return "redirect:/semestres/listar";
	}

	@GetMapping("/excluir/{id}")
	String excluir(@PathVariable("id") Long id) {
		semestre.excluirPorId(id);
		return "redirect:/semestres/listar";
	}

	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("semestre", semestre.buscarPorId(id));
		return "/semestre/cadastro";
	}

	@PostMapping("/editar")
	String editar(Semestre a) {
		semestre.editar(a);
		return "redirect:/semestres/listar";
	}
}
