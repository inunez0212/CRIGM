package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;

@Named("loginController")
public class LoginController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDTO usuarioDTO;
	
	
	
	public UsuarioDTO getUsuario() {
		return usuarioDTO;
	}
	public void setUsuario(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	
}
