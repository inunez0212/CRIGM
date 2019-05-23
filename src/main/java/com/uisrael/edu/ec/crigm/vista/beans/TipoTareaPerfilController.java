package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.interfaces.IPerfilGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITipoTareaGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITipoTareaPerfilGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TipoTareaPerfilDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("tipoTareaPerfilController")
public class TipoTareaPerfilController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private ITipoTareaPerfilGestor tipoTareaPerfilGestor;
	@Autowired
	private ITipoTareaGestor tipoTareaGestor;
	@Autowired
	private IPerfilGestor perfilGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<TipoTareaPerfilDTO> items = null;
    private TipoTareaPerfilDTO selected;
    private List<TipoTareaPerfilDTO> itemsFiltrados;
    private Long idTipoTarea;
    private Long idPerfil;
    
    
    public TipoTareaPerfilController() {
    }

    public TipoTareaPerfilDTO prepareCreate() {
        selected = new TipoTareaPerfilDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setTipoTarea(tipoTareaGestor.getOne(idTipoTarea));
    		selected.setPerfilDTO(perfilGestor.getOne(idPerfil));
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
    		selected.setFecharegistro(new Date());
    		tipoTareaPerfilGestor.save(selected);
    		JsfUtil.addSuccessMessage("TipoTareaPerfilDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el tipoTareaTipoTareaPerfil");
		}
    }

    public void update() {
    	try {
    		selected.setTipoTarea(tipoTareaGestor.getOne(idTipoTarea));
    		selected.setPerfilDTO(perfilGestor.getOne(idPerfil));
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		tipoTareaPerfilGestor.save(selected);
    		JsfUtil.addSuccessMessage("TipoTareaPerfilDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el tipoTareaTipoTareaPerfil");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		tipoTareaPerfilGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("TipoTareaPerfilDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el tipoTareaTipoTareaPerfil");
		}
    }

    public List<TipoTareaPerfilDTO> getItems() {
        items=tipoTareaPerfilGestor.findByEstadoActivo();
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

	/**
	 * @return the idTipoTarea
	 */
	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	/**
	 * @param idTipoTarea the idTipoTarea to set
	 */
	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	/**
	 * @return the idPerfil
	 */
	public Long getIdPerfil() {
		return idPerfil;
	}

	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

}
