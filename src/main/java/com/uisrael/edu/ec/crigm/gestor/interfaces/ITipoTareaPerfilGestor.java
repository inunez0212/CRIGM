package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.TipoTareaPerfilDTO;


public interface ITipoTareaPerfilGestor {

	List<TipoTareaPerfilDTO> findByEstadoActivo();
	void delete(TipoTareaPerfilDTO entity);
	TipoTareaPerfilDTO getOne(Long id);
	long count();
	TipoTareaPerfilDTO save(TipoTareaPerfilDTO entity);
	int eliminar(Integer id);	
	
}
