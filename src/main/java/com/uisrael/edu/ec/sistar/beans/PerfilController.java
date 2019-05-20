package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.IPerfilGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilDTO;

@Named("perfilController")
public class PerfilController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IPerfilGestor perfilGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<PerfilDTO> items = null;
    private PerfilDTO selected;
    private List<PerfilDTO> itemsFiltrados;
    
    public PerfilController() {
    }

    public PerfilDTO prepareCreate() {
        selected = new PerfilDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		perfilGestor.save(selected);
    		JsfUtil.addSuccessMessage("PerfilDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el perfil");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		perfilGestor.save(selected);
    		JsfUtil.addSuccessMessage("PerfilDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el perfil");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		perfilGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("PerfilDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el perfil");
		}
    }

    public List<PerfilDTO> getItems() {
        items=perfilGestor.findByEstadoActivo();
        return items;
    }

	public PerfilDTO getSelected() {
		return selected;
	}

	public void setSelected(PerfilDTO selected) {
		this.selected = selected;
	}

	public List<PerfilDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<PerfilDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}
	
}
