package com.uisrael.edu.ec.sistar.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.constantes.Constantes;
import com.uisrael.edu.ec.sistar.gestor.interfaces.IHistorialTareaGestor;
import com.uisrael.edu.ec.sistar.persistencia.dao.IHistorialTareaDAO;
import com.uisrael.edu.ec.vista.persistencia.entidades.HistorialTareaDTO;

@Repository
public class HistorialTareaGestor implements IHistorialTareaGestor	{

	@Autowired
	IHistorialTareaDAO historialTareaDAO;
	
	@Override
	public List<HistorialTareaDTO> findByEstadoActivo() {
		return historialTareaDAO.findByEstado(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(HistorialTareaDTO entity) {
		historialTareaDAO.delete(entity);
	}

	@Override
	public HistorialTareaDTO getOne(Long id) {
		return historialTareaDAO.getOne(id);
	}

	@Override
	public long count() {
		return historialTareaDAO.count();
	}

	@Override
	public HistorialTareaDTO save(HistorialTareaDTO entity) {
		return historialTareaDAO.save(entity);
	}

	@Override	
	public int eliminar(Integer id) {
		return historialTareaDAO.eliminar(id);
	}
}
