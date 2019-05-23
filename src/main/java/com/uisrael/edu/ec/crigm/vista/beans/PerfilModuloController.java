package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.interfaces.IPerfilGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IPerfilModuloGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.PerfilDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.PerfilModuloDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("perfilModuloController")
public class PerfilModuloController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IPerfilModuloGestor perfilModuloGestor;
	@Autowired
	private IPerfilGestor perfilGestor;
	
	
	@Inject
	private LoginController loginController;
	
    private List<PerfilModuloDTO> items = null;
    private PerfilModuloDTO selected;
    private List<PerfilModuloDTO> itemsFiltrados;
    private Long perfilId;
    
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
    		selected.setPerfil(perfilGestor.getOne(perfilId));
    		perfilModuloGestor.save(selected);
    		JsfUtil.addSuccessMessage("Permisos creados correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el permiso para el modulo indicado");
		}
    }

    public void update() {
    	try {
    		selected.setPerfil(perfilGestor.getOne(perfilId));
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		perfilModuloGestor.save(selected);
    		JsfUtil.addSuccessMessage("Permisos actualizados correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el permiso para el modulo indicado");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		perfilModuloGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("Permisos eliminados correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el permiso indicado");
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

	public Long getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}
	
	
}
