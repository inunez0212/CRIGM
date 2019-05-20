package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.TipoTareaDTO;


public interface ITipoTareaGestor {

	List<TipoTareaDTO> findByEstadoActivo();
	void delete(TipoTareaDTO entity);
	TipoTareaDTO getOne(Long id);
	long count();
	TipoTareaDTO save(TipoTareaDTO entity);
	int eliminar(Integer id);	
	
}
