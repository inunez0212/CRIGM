package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITipoTareaGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IUsuarioGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("tareaController")
public class TareaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private ITareaGestor tareaGestor;
	@Autowired
	private ICatalogoValorGestor catalogoValorGestor;
	@Autowired
	private IUsuarioGestor usuarioGestor;
	@Autowired
	private ITipoTareaGestor tipoTareaGestor;
	@Autowired
	private IProyectoGestor proyectoGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<TareaDTO> items = null;
    private TareaDTO selected;
    private List<TareaDTO> itemsFiltrados;
    private Long idTipoTarea;
    private String estadoValor;
    private Long idProyecto;
    private Long idUsuarioAsignado;
    private Long idUsuarioAsignador;
    private Long idUsuarioRevisor;
    
    //objetos de busqueda
    private boolean busqueda = false;
    
    
    public TareaController() {
    }

    public TareaDTO prepareCreate() {
        selected = new TareaDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setTipotarea(tipoTareaGestor.getOne(idTipoTarea));
    		selected.setProyecto(proyectoGestor.getOne(idProyecto));
    		if(idUsuarioAsignado!=null) {
    			selected.setUsuarioasignador(loginController.getUsuarioDTO());
        		selected.setUsuarioasignado(usuarioGestor.getOne(idUsuarioAsignado));
        		selected.setEstadotarea(catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_ASIGNADA));
    		}else {
        		selected.setEstadotarea(catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_REGISTRADA));
    		}
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
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
    		selected.setTipotarea(tipoTareaGestor.getOne(idTipoTarea));
    		selected.setProyecto(proyectoGestor.getOne(idProyecto));
    		if(idUsuarioAsignado!=null && selected.getEstadotarea().getCodigoreferencia().equals(Constantes.ESTADO_ASIGNADA)) {
    			selected.setUsuarioasignador(loginController.getUsuarioDTO());
        		selected.setUsuarioasignado(usuarioGestor.getOne(idUsuarioAsignado));
        		selected.setEstadotarea(catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_ASIGNADA));
    		}else {
        		selected.setEstadotarea(catalogoValorGestor.findByCodigoreferencia(estadoValor));
    		}
    		selected.setRevisor(usuarioGestor.getOne(idUsuarioRevisor));
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		tareaGestor.save(selected);
    		JsfUtil.addSuccessMessage("Tarea actaulizada correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el tarea");
		}finally {
			idProyecto=null;
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		tareaGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("Tarea eliminada correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el tarea");
		}
    }
    
    private List<TareaDTO> findByNombreAndEstado() {
    	ProyectoDTO proyecto= proyectoGestor.getOne(idProyecto);
    	List<TareaDTO> items = new ArrayList<>();
    	if(proyecto!=null && proyecto.getId()!=null) {
    		 items = tareaGestor.
    				 findByProyectoDTOAndEstadoOrderByFecharegistroDesc(proyecto);
    	}
    	if(items==null) {
			items=new ArrayList<>();
		}
        return items;
    }
    
    public void busqueda(){
  		busqueda = idProyecto!=null && idProyecto>0;
    }
    
    public List<TareaDTO> getItems() {
    	busqueda();
    	if(busqueda) {
    		items=this.findByNombreAndEstado();
    	}else {
    		items=tareaGestor.findByEstadoActivo();
    	}
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
	 * @return the estadoValor
	 */
	public String getEstadoValor() {
		return estadoValor;
	}

	/**
	 * @param estadoValor the estadoValor to set
	 */
	public void setEstadoValor(String estadoValor) {
		this.estadoValor = estadoValor;
	}

	/**
	 * @return the idProyecto
	 */
	public Long getIdProyecto() {
		return idProyecto;
	}

	/**
	 * @param idProyecto the idProyecto to set
	 */
	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	/**
	 * @return the idUsuarioAsignado
	 */
	public Long getIdUsuarioAsignado() {
		return idUsuarioAsignado;
	}

	/**
	 * @param idUsuarioAsignado the idUsuarioAsignado to set
	 */
	public void setIdUsuarioAsignado(Long idUsuarioAsignado) {
		this.idUsuarioAsignado = idUsuarioAsignado;
	}

	/**
	 * @return the idUsuarioAsignador
	 */
	public Long getIdUsuarioAsignador() {
		return idUsuarioAsignador;
	}

	/**
	 * @param idUsuarioAsignador the idUsuarioAsignador to set
	 */
	public void setIdUsuarioAsignador(Long idUsuarioAsignador) {
		this.idUsuarioAsignador = idUsuarioAsignador;
	}

	/**
	 * @return the idUsuarioRevisor
	 */
	public Long getIdUsuarioRevisor() {
		return idUsuarioRevisor;
	}

	/**
	 * @param idUsuarioRevisor the idUsuarioRevisor to set
	 */
	public void setIdUsuarioRevisor(Long idUsuarioRevisor) {
		this.idUsuarioRevisor = idUsuarioRevisor;
	}

	
	
}
