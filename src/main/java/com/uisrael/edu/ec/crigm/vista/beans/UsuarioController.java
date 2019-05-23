package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.interfaces.IPerfilGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IUsuarioGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.PerfilDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("usuarioController")
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IUsuarioGestor usuarioGestor;
	@Autowired
	private IPerfilGestor perfilGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<UsuarioDTO> items = null;
    private UsuarioDTO selected;
    private List<UsuarioDTO> itemsFiltrados;
    private Long idPerfil;
    
    public UsuarioController() {
    }

    public UsuarioDTO prepareCreate() {
        selected = new UsuarioDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setPerfil(perfilGestor.getOne(idPerfil));
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
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
    		selected.setPerfil(perfilGestor.getOne(idPerfil));
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
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
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
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

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	
}
