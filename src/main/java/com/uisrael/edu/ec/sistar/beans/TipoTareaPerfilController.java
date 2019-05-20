package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.ITipoTareaPerfilGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.TipoTareaPerfilDTO;

@Named("tipoTareaPerfilController")
public class TipoTareaPerfilController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private ITipoTareaPerfilGestor tipoTareaTipoTareaPerfilGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<TipoTareaPerfilDTO> items = null;
    private TipoTareaPerfilDTO selected;
    private List<TipoTareaPerfilDTO> itemsFiltrados;
    private Integer idTipoTarea;
    private Integer idPerfil;
    
    
    public TipoTareaPerfilController() {
    }

    public TipoTareaPerfilDTO prepareCreate() {
        selected = new TipoTareaPerfilDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		tipoTareaTipoTareaPerfilGestor.save(selected);
    		JsfUtil.addSuccessMessage("TipoTareaPerfilDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el tipoTareaTipoTareaPerfil");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		tipoTareaTipoTareaPerfilGestor.save(selected);
    		JsfUtil.addSuccessMessage("TipoTareaPerfilDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el tipoTareaTipoTareaPerfil");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		tipoTareaTipoTareaPerfilGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("TipoTareaPerfilDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el tipoTareaTipoTareaPerfil");
		}
    }

    public List<TipoTareaPerfilDTO> getItems() {
        items=tipoTareaTipoTareaPerfilGestor.findByEstadoActivo();
        return items;
    }

	public TipoTareaPerfilDTO getSelected() {
		return selected;
	}

	public void setSelected(TipoTareaPerfilDTO selected) {
		this.selected = selected;
	}

	public List<TipoTareaPerfilDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<TipoTareaPerfilDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

	public Integer getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Integer idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
}
