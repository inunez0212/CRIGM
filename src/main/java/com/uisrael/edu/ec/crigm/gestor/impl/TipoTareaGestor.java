package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITipoTareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.ITipoTareaDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TipoTareaDTO;

@Repository
public class TipoTareaGestor implements ITipoTareaGestor	{

	@Autowired
	ITipoTareaDAO tipoTareaDAO;
	
	@Override
	public List<TipoTareaDTO> findByEstadoActivo() {
		return tipoTareaDAO.findByEstadoOrderByFecharegistroDesc(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(TipoTareaDTO entity) {
		tipoTareaDAO.delete(entity);
	}

	@Override
	public TipoTareaDTO getOne(Long id) {
		return tipoTareaDAO.getOne(id);
	}

	@Override
	public long count() {
		return tipoTareaDAO.count();
	}

	@Override
	public TipoTareaDTO save(TipoTareaDTO entity) {
		return tipoTareaDAO.save(entity);
	}

	@Override	
	public int eliminar(Long id) {
		return tipoTareaDAO.eliminar(id);
	}
}
