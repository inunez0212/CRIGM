package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IUsuarioGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.IUsuarioDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;

@Repository
public class UsuarioGestor implements IUsuarioGestor{

	@Autowired
	IUsuarioDAO usuarioDAO;
	
	@Override
	public List<UsuarioDTO> findByEstadoActivo() {
		return usuarioDAO.findByEstadoOrderByFechaRegistroDesc(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(UsuarioDTO entity) {
		usuarioDAO.delete(entity);
	}

	@Override
	public UsuarioDTO getOne(Long id) {
		return usuarioDAO.getOne(id);
	}

	@Override
	public long count() {
		return usuarioDAO.count();
	}

	@Override
	public UsuarioDTO save(UsuarioDTO entity) {
		return usuarioDAO.save(entity);
	}

	@Override	
	public int eliminar(Long id) {
		return usuarioDAO.eliminar(id);
	}

	@Override
	public UsuarioDTO identificar(UsuarioDTO usuario) {
		return this.usuarioDAO.findByCedulaAndContrasenia(usuario.getCedula(), usuario.getContrasenia());
	}

	@Override
	public UsuarioDTO findByCedula(String cedula) {
		return this.usuarioDAO.findByCedula(cedula);
	}

	@Override
	public List<UsuarioDTO> findByCedulaOrNombreOrApellido(String cedula, String nombre, 
			String apellido) {
		return this.usuarioDAO.findByCedulaOrNombreOrApellidoAndEstadoOrderByFechaRegistroDesc(cedula, nombre, apellido, Constantes.ESTADO_ACTIVO);
	}

	@Override
	public int actualizarContrasenia(String contrasenia, Long id) {
		return this.usuarioDAO.actualizarContrasenia(contrasenia, id);
	}

	
	
}
