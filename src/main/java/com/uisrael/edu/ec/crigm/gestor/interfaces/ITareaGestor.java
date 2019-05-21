package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;


public interface ITareaGestor {

	List<TareaDTO> findByEstadoActivo();
	void delete(TareaDTO entity);
	TareaDTO getOne(Long id);
	long count();
	TareaDTO save(TareaDTO entity);
	int eliminar(Integer id);	
	
}
