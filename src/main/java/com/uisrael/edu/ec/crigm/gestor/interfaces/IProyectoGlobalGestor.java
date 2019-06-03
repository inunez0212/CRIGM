package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoGlobalDTO;


public interface IProyectoGlobalGestor {

	List<ProyectoGlobalDTO> findByEstadoActivo();
	void delete(ProyectoGlobalDTO entity);
	ProyectoGlobalDTO getOne(Long id);
	long count();
	ProyectoGlobalDTO save(ProyectoGlobalDTO entity);
	int eliminar(Integer id);	
	List<ProyectoGlobalDTO> findByProyectoDTOAndEstadoOrderByFecharegistroDesc(ProyectoDTO proyecto,
			String estado);
}
