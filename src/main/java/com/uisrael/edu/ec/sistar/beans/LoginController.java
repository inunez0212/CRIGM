package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.uisrael.edu.ec.vista.persistencia.entidades.UsuarioDTO;

@Named("loginController")
@SessionScoped
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
