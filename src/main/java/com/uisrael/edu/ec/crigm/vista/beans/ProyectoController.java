package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("proyectoController")
public class ProyectoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IProyectoGestor proyectoGestor;
	@Autowired
	private ICatalogoValorGestor catalogoValorGestor; 
	
	@Inject
	private LoginController loginController;
	
    private List<ProyectoDTO> items = null;
    private ProyectoDTO selected;
    private List<ProyectoDTO> itemsFiltrados;
    private String codigoRefereciaEstado;
    
    //objetos de busqueda
    private String filtros;
    private boolean busqueda = false;
    
    public ProyectoController() {
    }

    public ProyectoDTO prepareCreate() {
        selected = new ProyectoDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setEstadoproyecto(catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_REGISTRADA));
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
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
    		selected.setEstadoproyecto(this.catalogoValorGestor.findByCodigoreferencia(codigoRefereciaEstado));
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
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
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		proyectoGestor.eliminar(selected.getId().intValue());
    		JsfUtil.addSuccessMessage("ProyectoDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el proyecto");
		}
    }

    public void busqueda(){
    	if(StringUtils.isNotBlank(filtros)) {
    		busqueda = true;
    	}else {
    		busqueda = false;
    	}
    }

    private List<ProyectoDTO> findByNombreAndEstado() {
    	List<ProyectoDTO> items = proyectoGestor.findByNombreAndEstadoOrderByFecharegistroDesc(filtros);
    	if(items==null) {
			items=new ArrayList<>();
		}
        return items;
    }
    
    
    public List<ProyectoDTO> getItems() {
    	if(busqueda) {
    		items=this.findByNombreAndEstado();
    	}else {
    		items=proyectoGestor.findByEstadoActivo();
    	}
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

	/**
	 * @return the filtros
	 */
	public String getFiltros() {
		return filtros;
	}

	/**
	 * @param filtros the filtros to set
	 */
	public void setFiltros(String filtros) {
		this.filtros = filtros;
	}

}
