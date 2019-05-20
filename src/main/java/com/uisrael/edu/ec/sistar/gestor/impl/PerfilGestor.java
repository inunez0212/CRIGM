package com.uisrael.edu.ec.sistar.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.constantes.Constantes;
import com.uisrael.edu.ec.sistar.gestor.interfaces.IPerfilGestor;
import com.uisrael.edu.ec.sistar.persistencia.dao.IPerfilDAO;
import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilDTO;

@Repository
public class PerfilGestor implements IPerfilGestor	{

	@Autowired
	IPerfilDAO perfilDAO;
	
	@Override
	public List<PerfilDTO> findByEstadoActivo() {
		return perfilDAO.findByEstado(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(PerfilDTO entity) {
		perfilDAO.delete(entity);
	}

	@Override
	public PerfilDTO getOne(Long id) {
		return perfilDAO.getOne(id);
	}

	@Override
	public long count() {
		return perfilDAO.count();
	}

	@Override
	public PerfilDTO save(PerfilDTO entity) {
		return perfilDAO.save(entity);
	}

	@Override	
	public int eliminar(Integer id) {
		return perfilDAO.eliminar(id);
	}
}
