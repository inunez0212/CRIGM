package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.IPerfilModuloGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilDTO;
import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilModuloDTO;

@Named("perfilModuloController")
public class PerfilModuloController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IPerfilModuloGestor perfilModuloGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<PerfilModuloDTO> items = null;
    private PerfilModuloDTO selected;
    private List<PerfilModuloDTO> itemsFiltrados;
    private Integer perfilId;
    
    public PerfilModuloController() {
    }

    public PerfilModuloDTO prepareCreate() {
        selected = new PerfilModuloDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		selected.setPerfil(new PerfilDTO(perfilId));
    		perfilModuloGestor.save(selected);
    		JsfUtil.addSuccessMessage("PerfilModuloDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el perfilModulo");
		}
    }

    public void update() {
    	try {
    		selected.setPerfil(new PerfilDTO(perfilId));
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		perfilModuloGestor.save(selected);
    		JsfUtil.addSuccessMessage("PerfilModuloDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el perfilModulo");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		perfilModuloGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("PerfilModuloDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el perfilModulo");
		}
    }

    public List<PerfilModuloDTO> getItems() {
        items=perfilModuloGestor.findByEstadoActivo();
        return items;
    }

	public PerfilModuloDTO getSelected() {
		return selected;
	}

	public void setSelected(PerfilModuloDTO selected) {
		this.selected = selected;
	}

	public List<PerfilModuloDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<PerfilModuloDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}
	
	
}
