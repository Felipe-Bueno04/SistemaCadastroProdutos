package br.org.unisenaipr.comercial.grupo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.fabricante.entity.Fabricante;
import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import br.org.unisenaipr.comercial.grupo.repositorio.GrupoRepository;

@Service
public class GrupoService {

	private GrupoRepository grupoRepository;
	
	@Autowired
	public GrupoService(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}

	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}
	
	public void saveGrupo(Grupo grupo) {
		grupoRepository.save(grupo);
	}

	public void updateGrupo(Grupo grupo) {
		grupoRepository.save(grupo);
	}
	
	public void deleteGrupo(Grupo grupo) {
		grupoRepository.delete(grupo);
	}

	public Grupo findId(long id) {
		
		Optional<Grupo> objGrupo = grupoRepository.findById(id);
		Grupo grupo = objGrupo.get();
		
		return grupo;
	}	
	
}
