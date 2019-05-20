	package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.ITipoTareaGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.TipoTareaDTO;

@Named("tipoTareaController")
public class TipoTareaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private ITipoTareaGestor tipoTareaGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<TipoTareaDTO> items = null;
    private TipoTareaDTO selected;
    private List<TipoTareaDTO> itemsFiltrados;
    
    public TipoTareaController() {
    }

    public TipoTareaDTO prepareCreate() {
        selected = new TipoTareaDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		tipoTareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("TipoTareaDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el tipoTarea");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		tipoTareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("TipoTareaDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el tipoTarea");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		tipoTareaGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("TipoTareaDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el tipoTarea");
		}
    }

    public List<TipoTareaDTO> getItems() {
        items=tipoTareaGestor.findByEstadoActivo();
        return items;
    }

	public TipoTareaDTO getSelected() {
		return selected;
	}

	public void setSelected(TipoTareaDTO selected) {
		this.selected = selected;
	}

	public List<TipoTareaDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<TipoTareaDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}
	
}
