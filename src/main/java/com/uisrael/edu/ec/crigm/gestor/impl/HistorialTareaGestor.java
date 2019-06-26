package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IHistorialTareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.IHistorialTareaDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.HistorialTareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;

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

	public HistorialTareaDTO guardarHistorialTarea(CatalogoValorDTO estadoHistorial, UsuarioDTO usuarioRegistro, TareaDTO tareaDTO, 
			boolean finalizado) {
		HistorialTareaDTO historialTarea = new HistorialTareaDTO();
		historialTarea.setEstado(Constantes.ESTADO_ACTIVO);
		historialTarea.setCausal(estadoHistorial);
		historialTarea.setFechainicio(new Date());
		historialTarea.setFecharegistro(new Date());
		historialTarea.setUsuarioregistro(usuarioRegistro);
		historialTarea.setTarea(tareaDTO);
		if(finalizado) {
			historialTarea.setFechafin(new Date());
		}
		return this.historialTareaDAO.save(historialTarea);
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
