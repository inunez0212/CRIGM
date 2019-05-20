package com.uisrael.edu.ec.sistar.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.constantes.Constantes;
import com.uisrael.edu.ec.sistar.gestor.interfaces.IPerfilModuloGestor;
import com.uisrael.edu.ec.sistar.persistencia.dao.IPerfilModuloDAO;
import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilModuloDTO;

@Repository
public class PerfilModuloGestor implements IPerfilModuloGestor	{

	@Autowired
	IPerfilModuloDAO perfilModuloDAO;
	
	@Override
	public List<PerfilModuloDTO> findByEstadoActivo() {
		return perfilModuloDAO.findByEstado(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(PerfilModuloDTO entity) {
		perfilModuloDAO.delete(entity);
	}

	@Override
	public PerfilModuloDTO getOne(Long id) {
		return perfilModuloDAO.getOne(id);
	}

	@Override
	public long count() {
		return perfilModuloDAO.count();
	}

	@Override
	public PerfilModuloDTO save(PerfilModuloDTO entity) {
		return perfilModuloDAO.save(entity);
	}

	@Override	
	public int eliminar(Integer id) {
		return perfilModuloDAO.eliminar(id);
	}
}
