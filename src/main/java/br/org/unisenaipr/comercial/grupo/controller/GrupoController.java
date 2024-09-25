package br.org.unisenaipr.comercial.grupo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import br.org.unisenaipr.comercial.grupo.service.GrupoService;

@Controller
@RequestMapping("/grupo")
public class GrupoController {
	
	@Autowired
	private GrupoService grupoService;

	@Autowired
	public GrupoController(GrupoService grupoService) {
		this.grupoService = grupoService;
		
	}
	
	@RequestMapping("/grupoIndex")
	public String grupoIndex(Model theModel) {
		
		List<Grupo> list = grupoService.findAll();
		
		theModel.addAttribute("grupo", list);
		
		return "grupo/list";
	}

	@RequestMapping("/grupoSave")
	public String grupoSave(Model theModel) {
		
		Grupo grupo = new Grupo();
		
		theModel.addAttribute("grupo", grupo);
		
		return "grupo/cadastro";
	}

	@PostMapping("/save-grupo")
	public String saveGrupo(@ModelAttribute("grupo") Grupo grupo) {
		
		grupoService.saveGrupo(grupo);

		return "redirect:/grupo/grupoIndex";
	}		
	
	@GetMapping("/grupoUpdate/{id}")
	public String grupoUpdate(@PathVariable("id") long id, Model theModel) {
		
		Grupo grupo = new Grupo();
		
		grupo = grupoService.findId(id);
		
		theModel.addAttribute("grupo", grupo);
		
		return "grupo/alterar";
	}

	@PostMapping("/alterar-grupo/{id}")
	public String updateGrupo(@ModelAttribute Grupo grupo) {
		
		grupoService.updateGrupo(grupo);
		
		return "redirect:/grupo/grupoIndex";
	}	

	@GetMapping("/deletar-grupo/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		
		Grupo grupo = new Grupo();
		
		grupo.setId(id);
		
		grupoService.deleteGrupo(grupo);
		
		return "redirect:/grupo/grupoIndex";
	}	
}
