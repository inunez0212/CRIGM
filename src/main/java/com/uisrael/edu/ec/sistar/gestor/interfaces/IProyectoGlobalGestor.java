package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.ProyectoGlobalDTO;


public interface IProyectoGlobalGestor {

	List<ProyectoGlobalDTO> findByEstadoActivo();
	void delete(ProyectoGlobalDTO entity);
	ProyectoGlobalDTO getOne(Long id);
	long count();
	ProyectoGlobalDTO save(ProyectoGlobalDTO entity);
	int eliminar(Integer id);	
	
}
