package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.ProyectoDTO;


public interface IProyectoGestor {

	List<ProyectoDTO> findByEstadoActivo();
	void delete(ProyectoDTO entity);
	ProyectoDTO getOne(Long id);
	long count();
	ProyectoDTO save(ProyectoDTO entity);
	int eliminar(Integer id);	
	
}
