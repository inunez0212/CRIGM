package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.ITareaDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;

@Repository
public class TareaGestor implements ITareaGestor	{

	@Autowired
	ITareaDAO tareaDAO;
	
	@Override
	public List<TareaDTO> findByEstadoActivo() {
		return tareaDAO.findByEstado(Constantes.ESTADO_ACTIVO); 
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
		return tareaDAO.save(entity);
	}

	@Override	
	public int eliminar(Integer id) {
		return tareaDAO.eliminar(id);
	}
}
