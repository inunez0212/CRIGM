package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.TareaDTO;

@Named("tareaController")
public class TareaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private ITareaGestor tareaGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<TareaDTO> items = null;
    private TareaDTO selected;
    private List<TareaDTO> itemsFiltrados;
    
    public TareaController() {
    }

    public TareaDTO prepareCreate() {
        selected = new TareaDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		tareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("TareaDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el tarea");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		tareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("TareaDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el tarea");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		tareaGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("TareaDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el tarea");
		}
    }

    public List<TareaDTO> getItems() {
        items=tareaGestor.findByEstadoActivo();
        return items;
    }

	public TareaDTO getSelected() {
		return selected;
	}

	public void setSelected(TareaDTO selected) {
		this.selected = selected;
	}

	public List<TareaDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<TareaDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}
	
}
