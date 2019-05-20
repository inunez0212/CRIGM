package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.IUsuarioGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilDTO;
import com.uisrael.edu.ec.vista.persistencia.entidades.UsuarioDTO;

@Named("usuarioController")
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IUsuarioGestor usuarioGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<UsuarioDTO> items = null;
    private UsuarioDTO selected;
    private List<UsuarioDTO> itemsFiltrados;
    private Integer idPerfil;
    
    public UsuarioController() {
    }

    public UsuarioDTO prepareCreate() {
        selected = new UsuarioDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setPerfil(new PerfilDTO(idPerfil));
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		usuarioGestor.save(selected);
    		JsfUtil.addSuccessMessage("UsuarioDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el usuario");
		}
    }

    public void update() {
    	try {
    		selected.setPerfil(new PerfilDTO(idPerfil));
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		usuarioGestor.save(selected);
    		JsfUtil.addSuccessMessage("UsuarioDTO actualizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el usuario");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		usuarioGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("UsuarioDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el usuario");
		}
    }

    public List<UsuarioDTO> getItems() {
        items=usuarioGestor.findByEstadoActivo();
        return items;
    }

	public UsuarioDTO getSelected() {
		return selected;
	}

	public void setSelected(UsuarioDTO selected) {
		this.selected = selected;
	}

	public List<UsuarioDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<UsuarioDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	
}
