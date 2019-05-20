package com.uisrael.edu.ec.sistar.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.constantes.Constantes;
import com.uisrael.edu.ec.sistar.gestor.interfaces.ITipoTareaPerfilGestor;
import com.uisrael.edu.ec.sistar.persistencia.dao.ITipoTareaPerfilDAO;
import com.uisrael.edu.ec.vista.persistencia.entidades.TipoTareaPerfilDTO;

@Repository
public class TipoTareaPerfilGestor implements ITipoTareaPerfilGestor	{

	@Autowired
	ITipoTareaPerfilDAO tipoTareaPerfilDAO;
	
	@Override
	public List<TipoTareaPerfilDTO> findByEstadoActivo() {
		return tipoTareaPerfilDAO.findByEstado(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(TipoTareaPerfilDTO entity) {
		tipoTareaPerfilDAO.delete(entity);
	}

	@Override
	public TipoTareaPerfilDTO getOne(Long id) {
		return tipoTareaPerfilDAO.getOne(id);
	}

	@Override
	public long count() {
		return tipoTareaPerfilDAO.count();
	}

	@Override
	public TipoTareaPerfilDTO save(TipoTareaPerfilDTO entity) {
		return tipoTareaPerfilDAO.save(entity);
	}

	@Override	
	public int eliminar(Integer id) {
		return tipoTareaPerfilDAO.eliminar(id);
	}
}