package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;


public interface IUsuarioGestor {

	List<UsuarioDTO> findByEstadoActivo();
	List<UsuarioDTO> findByCedulaOrNombreOrApellido(String cedula, String nombre, String apellido);
	void delete(UsuarioDTO entity);
	UsuarioDTO getOne(Long id);
	long count();
	UsuarioDTO save(UsuarioDTO entity);
	int eliminar(Long id);	
	UsuarioDTO identificar(UsuarioDTO usuario);
	UsuarioDTO findByCedula(String cedula);
	
}
