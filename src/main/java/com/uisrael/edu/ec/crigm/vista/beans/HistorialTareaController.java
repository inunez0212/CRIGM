package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.interfaces.IHistorialTareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.HistorialTareaDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("historialTareaController")
public class HistorialTareaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IHistorialTareaGestor historialTareaGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<HistorialTareaDTO> items = null;
    private HistorialTareaDTO selected;
    private List<HistorialTareaDTO> itemsFiltrados;
    
    public HistorialTareaController() {
    }

    public HistorialTareaDTO prepareCreate() {
        selected = new HistorialTareaDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
    		selected.setFecharegistro(new Date());
    		historialTareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("HistorialTareaDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el historialTarea");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		historialTareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("HistorialTareaDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el historialTarea");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		historialTareaGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("HistorialTareaDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el historialTarea");
		}
    }

    public List<HistorialTareaDTO> getItems() {
        items=historialTareaGestor.findByEstadoActivo();
        return items;
    }

	public HistorialTareaDTO getSelected() {
		return selected;
	}

	public void setSelected(HistorialTareaDTO selected) {
		this.selected = selected;
	}

	public List<HistorialTareaDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<HistorialTareaDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}
	
}
