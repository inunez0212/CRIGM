package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.impl.UsuarioGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

/**
 * 
 * @author kali
 *
 */
@Named("loginController")
public class LoginController implements Serializable {
	
	
	@Autowired
	private UsuarioGestor usuarioGestor;
	
	private static final long serialVersionUID = 1L;
	private UsuarioDTO usuarioDTO=new UsuarioDTO();
	
	public void identificar() {
		
		usuarioDTO = this.usuarioGestor.identificar(usuarioDTO);
		if(usuarioDTO!=null) {
			JsfUtil.addSuccessMessage("Bienvendo "+usuarioDTO.getNombre());
			FacesContext fContext = FacesContext.getCurrentInstance();
			ExternalContext extContext = fContext.getExternalContext();
			try {
				extContext.redirect(extContext.getRequestContextPath() + "/xhtml/proyecto/List.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			usuarioDTO = new UsuarioDTO();
			JsfUtil.addErrorMessage("Usuario y/o contraseña incorrectos");
		}
	}

	/**
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * @param usuarioDTO the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	
}
