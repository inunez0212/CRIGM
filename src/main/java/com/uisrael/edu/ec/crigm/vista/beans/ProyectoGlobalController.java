package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGlobalGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoGlobalDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("proyectoGlobalController")
public class ProyectoGlobalController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IProyectoGlobalGestor proyectoGlobalGestor;
	@Autowired
	private IProyectoGestor proyectoGestor;
	@Autowired
	private ICatalogoValorGestor catalogoValorGestor; 
	
	
	
	@Inject
	private LoginController loginController;
	
    private List<ProyectoGlobalDTO> items = null;
    private ProyectoGlobalDTO selected;
    private List<ProyectoGlobalDTO> itemsFiltrados;
    private String codigoReferenciaEstado;
    private Long codigoProyecto;
    
    public ProyectoGlobalController() {
    }

    public ProyectoGlobalDTO prepareCreate() {
        selected = new ProyectoGlobalDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
    		selected.setFecharegistro(new Date());
    		selected.setProyecto(proyectoGestor.getOne(codigoProyecto));
    		selected.setEstadoglobal(catalogoValorGestor.getOne(Constantes.ESTADO_EN_PROCESO));
    		proyectoGlobalGestor.save(selected);
    		JsfUtil.addSuccessMessage("ProyectoGlobalDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el proyectoGlobal");
		}
    }

    public void update() {
    	try {
    		selected.setProyecto(proyectoGestor.getOne(codigoProyecto));
    		selected.setEstadoglobal(catalogoValorGestor.getOne(codigoReferenciaEstado));
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
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
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
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

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public Long getCodigoProyecto() {
		return codigoProyecto;
	}

	public void setCodigoProyecto(Long codigoProyecto) {
		this.codigoProyecto = codigoProyecto;
	}

	
}
