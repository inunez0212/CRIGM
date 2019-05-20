package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilDTO;


public interface IPerfilGestor {

	List<PerfilDTO> findByEstadoActivo();
	void delete(PerfilDTO entity);
	PerfilDTO getOne(Long id);
	long count();
	PerfilDTO save(PerfilDTO entity);
	int eliminar(Integer id);	
	
}
