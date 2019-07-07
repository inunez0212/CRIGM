package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.IProyectoDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;

@Repository
public class ProyectoGestor implements IProyectoGestor	{

	@Autowired
	IProyectoDAO proyectoDAO;
	
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
	public ProyectoDTO save(ProyectoDTO entity) {
		return proyectoDAO.save(entity);
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
