package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.TipoTareaDTO;


public interface ITipoTareaGestor {

	List<TipoTareaDTO> findByEstadoActivo();
	void delete(TipoTareaDTO entity);
	TipoTareaDTO getOne(Long id);
	long count();
	TipoTareaDTO save(TipoTareaDTO entity);
	int eliminar(Long id);	
	
}
