package br.org.unisenaipr.comercial.subgrupo.controller;

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
import br.org.unisenaipr.comercial.subgrupo.entity.SubGrupo;
import br.org.unisenaipr.comercial.subgrupo.service.SubGrupoService;

@Controller
@RequestMapping("/subgrupo")
public class SubGrupoController {
	
	@Autowired
	private SubGrupoService subGrupoService;
	
	@Autowired
	private GrupoService grupoService;

	@Autowired
	public SubGrupoController(SubGrupoService subGrupoService) {
		this.subGrupoService = subGrupoService;
	}

	@RequestMapping("/subGrupoIndex")
	public String subGrupoIndex(Model theModel) {
		
		List<SubGrupo> list = subGrupoService.findAll();
		
		theModel.addAttribute("subgrupo", list);
		
		return "subgrupo/list";
	}

	@RequestMapping("/subgrupoSave")
	public String subGrupoSave(Model theModel) {
		
        List<Grupo> grupos = grupoService.findAll();    
		SubGrupo subgrupo = new SubGrupo();
		
		theModel.addAttribute("grupos", grupos);
		theModel.addAttribute("subgrupo", subgrupo);
		
		return "subgrupo/cadastro";
	}

	@PostMapping("/save-subgrupo")
	public String saveSubGrupo(@ModelAttribute("subgrupo") SubGrupo subgrupo) {
		
		subGrupoService.saveSubGrupo(subgrupo);

		return "redirect:/subgrupo/subGrupoIndex";
	}		
	
	@GetMapping("/subgrupoUpdate/{id}")
	public String subGrupoUpdate(@PathVariable("id") long id, Model theModel) {
		
		List<Grupo> grupos = grupoService.findAll();  
		SubGrupo subgrupo = new SubGrupo();
		
		subgrupo = subGrupoService.findId(id);

		theModel.addAttribute("grupos", grupos);
		theModel.addAttribute("subgrupo", subgrupo);
		
		return "subgrupo/alterar";
	}

	@PostMapping("/alterar-subgrupo/{id}")
	public String updateSubGrupo(@ModelAttribute SubGrupo subgrupo) {
		
		subGrupoService.updateSubGrupo(subgrupo);
		
		return "redirect:/subgrupo/grupoIndex";
	}	

	@GetMapping("/deletar-subgrupo/{id}")
	public String deleteSubGrupo(@PathVariable("id") long id) {
		
		SubGrupo subgrupo = new SubGrupo();
		
		subgrupo.setId(id);
		
		subGrupoService.deleteSubGrupo(subgrupo);
		
		return "redirect:/subgrupo/subGrupoIndex";
	}	
	
}
