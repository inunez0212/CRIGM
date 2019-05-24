package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.impl.CatalogoValorGestor;
import com.uisrael.edu.ec.crigm.gestor.impl.UsuarioGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
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
	@Autowired
    private JavaMailSender sender;
	@Autowired 
	private CatalogoValorGestor catalogoValorGestor;
	
	private static final long serialVersionUID = 1L;
	private UsuarioDTO usuarioDTO=new UsuarioDTO();
	private String cedula;
	
	public void identificar() {
		try {
			usuarioDTO = this.usuarioGestor.identificar(usuarioDTO);
			if(usuarioDTO!=null) {
				JsfUtil.addSuccessMessage("Bienvendo "+usuarioDTO.getNombre());
				FacesContext fContext = FacesContext.getCurrentInstance();
				ExternalContext extContext = fContext.getExternalContext();
				extContext.redirect(extContext.getRequestContextPath() + "/xhtml/proyecto/List.xhtml");
			}else {
				usuarioDTO = new UsuarioDTO();
				JsfUtil.addErrorMessage("Usuario y/o contraseña incorrectos");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage("Problemas internos con el servicio");
		}
	}

	//Enviar correo
	public void solicitarReseteo(){
		try {
			UsuarioDTO usuarioDTO = this.usuarioGestor.findByCedula(cedula);
			if(usuarioDTO!=null) {
				CatalogoValorDTO catalogoEmail = catalogoValorGestor.
						findByCodigoreferencia(Constantes.EMAIL_RESETEO);
				String[] emailsReseteo = catalogoEmail.getDescripcion().split(";");
				MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message);
		        
		        helper.setTo(emailsReseteo);
		        helper.setText("<html><body><h3>"
		        		+ "Se ha solicitado un reseteo de contrase&ntilde;a para el usuario con CI:"+
		        		cedula+" </h3><body></html>", true);
		        helper.setSubject("CRIGM - Solicitud de reseteo");
		        sender.send(message);
		        JsfUtil.addSuccessMessage("Se ha enviado un email solicitado reseteo de clave");
			}else {
				JsfUtil.addErrorMessage("No existe registro del usuario: "+cedula);
			}
		}catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo enviar el correo");
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

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	
}
