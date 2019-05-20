package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.ProyectoDTO;

@Named("proyectoController")
public class ProyectoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IProyectoGestor proyectoGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<ProyectoDTO> items = null;
    private ProyectoDTO selected;
    private List<ProyectoDTO> itemsFiltrados;
    private String codigoRefereciaEstado;
    
    public ProyectoController() {
    }

    public ProyectoDTO prepareCreate() {
        selected = new ProyectoDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		proyectoGestor.save(selected);
    		JsfUtil.addSuccessMessage("ProyectoDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el proyecto");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		proyectoGestor.save(selected);
    		JsfUtil.addSuccessMessage("ProyectoDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el proyecto");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		proyectoGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("ProyectoDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el proyecto");
		}
    }

    public List<ProyectoDTO> getItems() {
        items=proyectoGestor.findByEstadoActivo();
        return items;
    }

	public ProyectoDTO getSelected() {
		return selected;
	}

	public void setSelected(ProyectoDTO selected) {
		this.selected = selected;
	}

	public List<ProyectoDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<ProyectoDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

	public String getCodigoRefereciaEstado() {
		return codigoRefereciaEstado;
	}

	public void setCodigoRefereciaEstado(String codigoRefereciaEstado) {
		this.codigoRefereciaEstado = codigoRefereciaEstado;
	}
	
}
