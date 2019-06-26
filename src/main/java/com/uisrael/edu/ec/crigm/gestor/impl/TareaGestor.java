package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IHistorialTareaGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.ITareaDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;

@Component
public class TareaGestor implements ITareaGestor{

	@Autowired
	ITareaDAO tareaDAO;
	@Autowired
	ICatalogoValorGestor catalogoValorGestor;
	@Autowired 
	IHistorialTareaGestor historialTareaGestor;
	
	@Override
	public List<TareaDTO> findByEstadoActivo() {
		return tareaDAO.findByEstadoOrderByFecharegistroDesc(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(TareaDTO entity) {
		tareaDAO.delete(entity);
	}

	@Override
	public TareaDTO getOne(Long id) {
		return tareaDAO.getOne(id);
	}

	@Override
	public long count() {
		return tareaDAO.count();
	}

	@Override
	public TareaDTO save(TareaDTO entity) {
		//Registra la tarea 
		TareaDTO tareaDTO = tareaDAO.save(entity);
		tareaDTO.setHistorialTareaCollection(new ArrayList<>());
		//Regista los estados de la tarea
		if(entity.getEstadotarea().getCodigoreferencia().equals(Constantes.ESTADO_ASIGNADA)) {
			//registrada
			tareaDTO.getHistorialTareaCollection().add(historialTareaGestor.guardarHistorialTarea(
					this.catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_REGISTRADA), 
					entity.getUsuarioregistro(), tareaDTO, Boolean.TRUE));
			//asignada
			tareaDTO.getHistorialTareaCollection().add(historialTareaGestor.guardarHistorialTarea(
					this.catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_ASIGNADA), 
					entity.getUsuarioregistro(), tareaDTO, Boolean.FALSE));
		}else {
			//registrada
			tareaDTO.getHistorialTareaCollection().add(historialTareaGestor.guardarHistorialTarea(
					this.catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_REGISTRADA), 
					entity.getUsuarioregistro(), tareaDTO, Boolean.FALSE));
		}
		return tareaDTO;
	}

	@Override	
	public int eliminar(Integer id) {
		return tareaDAO.eliminar(id);
	}

	@Override
	public List<TareaDTO> findByProyectoDTOAndEstadoOrderByFecharegistroDesc(ProyectoDTO proyecto) {
		return this.tareaDAO.findByProyectoDTOAndEstadoOrderByFecharegistroDesc(proyecto, Constantes.ESTADO_ACTIVO);
	}

	@Override
	public int actualizarTareas(CatalogoValorDTO estado, ProyectoDTO proyecto) {
		return this.tareaDAO.actualizarTareas(estado, proyecto);
	}

	@Override
	public List<TareaDTO> findByEstadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(Date fechaInicio,
			Date fechaFin) {
		return this.tareaDAO.findByEstadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(Constantes.ESTADO_ACTIVO,
			fechaInicio, fechaFin);
	}

	@Override
	public List<TareaDTO> findByEstadoAndUsuarioasignadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(
			UsuarioDTO usuarioasignado, Date fechaInicio, Date fechaFin) {
		return this.tareaDAO.findByEstadoAndUsuarioasignadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(
				Constantes.ESTADO_ACTIVO, usuarioasignado, fechaInicio, fechaFin); 
	}

}
