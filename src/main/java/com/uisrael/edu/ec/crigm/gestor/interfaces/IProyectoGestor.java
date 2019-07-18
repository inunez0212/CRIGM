package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.Collection;
import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;


public interface IProyectoGestor {

	List<ProyectoDTO> findByEstadoActivo();
	void delete(ProyectoDTO entity);
	ProyectoDTO getOne(Long id);
	long count();
	ProyectoDTO save(ProyectoDTO entity, Collection<String> modelos);
	int eliminar(Integer id);	
	List<ProyectoDTO> findByNombreAndEstadoOrderByFecharegistroDesc(String filtros);
	int actualizarNumeroTareas(Integer numeroTareas, Long id);

}
