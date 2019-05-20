package com.uisrael.edu.ec.sistar.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.constantes.Constantes;
import com.uisrael.edu.ec.sistar.gestor.interfaces.IProyectoGlobalGestor;
import com.uisrael.edu.ec.sistar.persistencia.dao.IProyectoGlobalDAO;
import com.uisrael.edu.ec.vista.persistencia.entidades.ProyectoGlobalDTO;

@Repository
public class ProyectoGlobalGestor implements IProyectoGlobalGestor	{

	@Autowired
	IProyectoGlobalDAO proyectoGlobalDAO;
	
	@Override
	public List<ProyectoGlobalDTO> findByEstadoActivo() {
		return proyectoGlobalDAO.findByEstado(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(ProyectoGlobalDTO entity) {
		proyectoGlobalDAO.delete(entity);
	}

	@Override
	public ProyectoGlobalDTO getOne(Long id) {
		return proyectoGlobalDAO.getOne(id);
	}

	@Override
	public long count() {
		return proyectoGlobalDAO.count();
	}

	@Override
	public ProyectoGlobalDTO save(ProyectoGlobalDTO entity) {
		return proyectoGlobalDAO.save(entity);
	}

	@Override	
	public int eliminar(Integer id) {
		return proyectoGlobalDAO.eliminar(id);
	}
}
