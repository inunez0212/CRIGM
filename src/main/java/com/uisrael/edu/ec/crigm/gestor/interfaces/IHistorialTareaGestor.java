package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.HistorialTareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;


public interface IHistorialTareaGestor {

	List<HistorialTareaDTO> findByEstadoActivo();
	void delete(HistorialTareaDTO entity);
	HistorialTareaDTO getOne(Long id);
	long count();
	HistorialTareaDTO save(HistorialTareaDTO entity);
	int eliminar(Integer id);	
	HistorialTareaDTO guardarHistorialTarea(CatalogoValorDTO estadoHistorial, UsuarioDTO usuarioRegistro, TareaDTO tareaDTO, 
		boolean finalizado);
}
