package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.Date;
import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;


public interface ITareaGestor {

	List<TareaDTO> findByEstadoActivo();
	void delete(TareaDTO entity);
	TareaDTO getOne(Long id);
	long count();
	TareaDTO save(TareaDTO entity);
	int eliminar(Integer id);	
	int actualizarTareas(CatalogoValorDTO estado, ProyectoDTO proyecto);
	
	//Obtiene tareas por fecha inicio
	List<TareaDTO> findByProyectoDTOAndEstadoOrderByFecharegistroDesc(ProyectoDTO proyecto);
	
	//Obtiene las tareas por fecha inicio 
	List<TareaDTO> findByEstadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(Date fechaInicio, Date fechaFin);
	
	//Obtiene las tareas por usuario y fecha inicio 
	List<TareaDTO> findByEstadoAndUsuarioasignadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc( 
		UsuarioDTO usuarioasignado, Date fechaInicio, Date fechaFin);

	
}
