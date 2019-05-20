package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.IProyectoGlobalGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.ProyectoGlobalDTO;

@Named("proyectoGlobalController")
public class ProyectoGlobalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IProyectoGlobalGestor proyectoGlobalGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<ProyectoGlobalDTO> items = null;
    private ProyectoGlobalDTO selected;
    private List<ProyectoGlobalDTO> itemsFiltrados;
    private String codigoReferenciaEstado;
    private Integer codigoProyecto;
    
    public ProyectoGlobalController() {
    }

    public ProyectoGlobalDTO prepareCreate() {
        selected = new ProyectoGlobalDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		proyectoGlobalGestor.save(selected);
    		JsfUtil.addSuccessMessage("ProyectoGlobalDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el proyectoGlobal");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		proyectoGlobalGestor.save(selected);
    		JsfUtil.addSuccessMessage("ProyectoGlobalDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el proyectoGlobal");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		proyectoGlobalGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("ProyectoGlobalDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el proyectoGlobal");
		}
    }

    public List<ProyectoGlobalDTO> getItems() {
        items=proyectoGlobalGestor.findByEstadoActivo();
        return items;
    }

	public ProyectoGlobalDTO getSelected() {
		return selected;
	}

	public void setSelected(ProyectoGlobalDTO selected) {
		this.selected = selected;
	}

	public List<ProyectoGlobalDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<ProyectoGlobalDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

	public String getCodigoReferenciaEstado() {
		return codigoReferenciaEstado;
	}

	public void setCodigoReferenciaEstado(String codigoReferenciaEstado) {
		this.codigoReferenciaEstado = codigoReferenciaEstado;
	}

	
}
