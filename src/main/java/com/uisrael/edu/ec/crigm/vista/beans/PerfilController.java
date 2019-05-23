package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.interfaces.IPerfilGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.PerfilDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;


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
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
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
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
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
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		perfilGestor.eliminar(selected.getId().intValue());
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
