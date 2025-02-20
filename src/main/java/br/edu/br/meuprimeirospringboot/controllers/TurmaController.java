package br.edu.br.meuprimeirospringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.br.meuprimeirospringboot.entity.Turma;
import br.edu.br.meuprimeirospringboot.services.DisciplinaService;
import br.edu.br.meuprimeirospringboot.services.SemestreService;
import br.edu.br.meuprimeirospringboot.services.TurmaService;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	@Autowired
	private TurmaService turma;
	@Autowired
	private SemestreService semestre;
	@Autowired
	private DisciplinaService disciplina;

	@GetMapping("/listar")
	String ListarAlunos(ModelMap model) {
		model.addAttribute("turmas", turma.buscarTodos());

		return "/turma/lista";
	}

	@GetMapping("/cadastrar")
	String CadastrarAlunos(ModelMap model) {
		model.addAttribute("turma", new Turma());
		model.addAttribute("semestres", semestre.buscarTodos());
		model.addAttribute("disciplinas", disciplina.buscarTodos());

		return "/turma/cadastro";
	}

	@PostMapping("/salvar")
	String Salvar(Turma a) {
		turma.cadastrar(a);
		return "redirect:/turmas/listar";
	}

	@GetMapping("/excluir/{id}")
	String excluir(@PathVariable("id") Long id) {
		turma.excluirPorId(id);
		return "redirect:/turmas/listar";
	}

	@GetMapping("/editar/{id}")
	String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("turma", turma.buscarPorId(id));
		model.addAttribute("semestres", semestre.buscarTodos());
		model.addAttribute("disciplinas", disciplina.buscarTodos());

		return "/turma/cadastro";
	}

	@PostMapping("/editar")
	String editar(Turma a) {
		turma.editar(a);
		return "redirect:/turmas/listar";
	}
}
