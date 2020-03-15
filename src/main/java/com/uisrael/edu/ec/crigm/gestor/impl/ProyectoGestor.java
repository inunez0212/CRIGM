package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITipoTareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.ICatalogoValorDAO;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.IProyectoDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TipoTareaDTO;

@Repository
public class ProyectoGestor implements IProyectoGestor	{

	@Autowired
	IProyectoDAO proyectoDAO;
	@Autowired
	ICatalogoValorDAO catalogoValorDAO;
	@Autowired
	ITareaGestor tareaGestor;
	@Autowired
	ITipoTareaGestor tipoTareaGestor;

	@Override
	public List<ProyectoDTO> findByEstadoActivo() {
		return proyectoDAO.findByEstadoOrderByFecharegistroDesc(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(ProyectoDTO entity) {
		proyectoDAO.delete(entity);
	}

	@Override
	public ProyectoDTO getOne(Long id) {
		return proyectoDAO.getOne(id);
	}

	@Override
	public long count() {
		return proyectoDAO.count();
	}

	@Override
	public ProyectoDTO save(ProyectoDTO entity, Collection<String> modelos) {

		ProyectoDTO proyectoDTO =  proyectoDAO.save(entity);
		TipoTareaDTO tipoTareaDTO = tipoTareaGestor.findByNombreAndEstadoActivo(Constantes.TIPO_TAREA_RESTITUCION);
		if(!CollectionUtils.isEmpty(modelos)) {
			CatalogoValorDTO estadoRegistrado = catalogoValorDAO.findByCodigoreferencia(
					Constantes.ESTADO_REGISTRADA);
			for(String dato : modelos) {
				TareaDTO tarea= new TareaDTO();
				tarea.setEstado(Constantes.ESTADO_ACTIVO);
				tarea.setEstadotarea(estadoRegistrado);
				tarea.setFecharegistro(entity.getFecharegistro());
				tarea.setProyecto(proyectoDTO);
				tarea.setRutacarpeta(dato);
				tarea.setUsuarioregistro(entity.getUsuarioregistro());
				tarea.setTipotarea(tipoTareaDTO);
				
				tareaGestor.save(tarea);
			}
		}
		return proyectoDTO;
	}

	@Override	
	public int eliminar(Integer id) {
		return proyectoDAO.eliminar(id);
	}

	@Override
	public List<ProyectoDTO> findByNombreAndEstadoOrderByFecharegistroDesc(String filtros) {
		return this.proyectoDAO.findByNombreIgnoreCaseAndEstadoOrderByFecharegistroDesc(filtros,
				Constantes.ESTADO_ACTIVO);
	}

	@Override
	public int actualizarNumeroTareas(Integer numeroTareas, Long id) {
		return this.proyectoDAO.actualizarNumeroTareas(numeroTareas, id);
	}
}
