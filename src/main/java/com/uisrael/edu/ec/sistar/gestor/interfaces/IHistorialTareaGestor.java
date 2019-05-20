package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.HistorialTareaDTO;


public interface IHistorialTareaGestor {

	List<HistorialTareaDTO> findByEstadoActivo();
	void delete(HistorialTareaDTO entity);
	HistorialTareaDTO getOne(Long id);
	long count();
	HistorialTareaDTO save(HistorialTareaDTO entity);
	int eliminar(Integer id);	
	
}
