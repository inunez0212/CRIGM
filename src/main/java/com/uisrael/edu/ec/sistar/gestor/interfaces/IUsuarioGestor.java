package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.UsuarioDTO;


public interface IUsuarioGestor {

	List<UsuarioDTO> findByEstadoActivo();
	void delete(UsuarioDTO entity);
	UsuarioDTO getOne(Long id);
	long count();
	UsuarioDTO save(UsuarioDTO entity);
	int eliminar(Integer id);	
	
}
