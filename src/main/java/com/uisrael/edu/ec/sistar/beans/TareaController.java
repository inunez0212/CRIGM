package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.constantes.Constantes;
import com.uisrael.edu.ec.sistar.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.vista.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.vista.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.vista.persistencia.entidades.TipoTareaDTO;
import com.uisrael.edu.ec.vista.persistencia.entidades.UsuarioDTO;

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
    private Integer idTipoTarea;
    private String estadoValor;
    private Integer idProyecto;
    private Integer idUsuarioAsignado;
    private Integer idUsuarioAsignador;
    private Integer idUsuarioRevisor;
    
    public TareaController() {
    }

    public TareaDTO prepareCreate() {
        selected = new TareaDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setEstadotarea(new CatalogoValorDTO());
    		selected.setTipotarea(new TipoTareaDTO());
    		selected.getTipotarea().setId(idTipoTarea);
    		selected.setProyecto(new ProyectoDTO());
    		selected.getProyecto().setId(idProyecto);
    		if(idUsuarioAsignado!=null) {
    			selected.setUsuarioasignador(loginController.getUsuario());
        		selected.setUsuarioasignado(new UsuarioDTO());
        		selected.getUsuarioasignado().setId(idUsuarioAsignado);
        		selected.getEstadotarea().setCodigoreferencia(Constantes.ESTADO_TAREA_ASIGNADA);
    		}else {
        		selected.getEstadotarea().setCodigoreferencia(Constantes.ESTADO_TAREA_REGISTRADA);
    		}
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		tareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("Tarea creada correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el tarea");
		}
    }

    public void update() {
    	try {
    		selected.setEstadotarea(new CatalogoValorDTO());
    		selected.getEstadotarea().setCodigoreferencia(estadoValor);
    		selected.setTipotarea(new TipoTareaDTO());
    		selected.getTipotarea().setId(idTipoTarea);
    		selected.setProyecto(new ProyectoDTO());
    		selected.getProyecto().setId(idProyecto);
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		tareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("Tarea actaulizada correctamente");
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
    		JsfUtil.addSuccessMessage("Tarea eliminada correctamente");
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

	public Integer getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Integer idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public String getEstadoValor() {
		return estadoValor;
	}

	public void setEstadoValor(String estadoValor) {
		this.estadoValor = estadoValor;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Integer getIdUsuarioAsignado() {
		return idUsuarioAsignado;
	}

	public void setIdUsuarioAsignado(Integer idUsuarioAsignado) {
		this.idUsuarioAsignado = idUsuarioAsignado;
	}

	public Integer getIdUsuarioAsignador() {
		return idUsuarioAsignador;
	}

	public void setIdUsuarioAsignador(Integer idUsuarioAsignador) {
		this.idUsuarioAsignador = idUsuarioAsignador;
	}

	public Integer getIdUsuarioRevisor() {
		return idUsuarioRevisor;
	}

	public void setIdUsuarioRevisor(Integer idUsuarioRevisor) {
		this.idUsuarioRevisor = idUsuarioRevisor;
	}
	
}
