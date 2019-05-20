package com.uisrael.edu.ec.sistar.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.sistar.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.vista.beans.util.JsfUtil;
import com.uisrael.edu.ec.vista.persistencia.entidades.CatalogoValorDTO;

@Named("catalogoValorController")
public class CatalogoValorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private ICatalogoValorGestor catalogoValorGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<CatalogoValorDTO> items = null;
    private CatalogoValorDTO selected;
    private List<CatalogoValorDTO> itemsFiltrados;
    private String codigoReferenciaRelacionado;

    
    
    public CatalogoValorController() {
    }

    public CatalogoValorDTO prepareCreate() {
        selected = new CatalogoValorDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		catalogoValorGestor.save(selected);
    		JsfUtil.addSuccessMessage("CatalogoValorDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el catalogoValor");
		}
    }

    public void update() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		catalogoValorGestor.save(selected);
    		JsfUtil.addSuccessMessage("CatalogoValorDTO actaulizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el catalogoValor");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		catalogoValorGestor.eliminar(selected.getCodigoreferencia());
    		JsfUtil.addSuccessMessage("CatalogoValorDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el catalogoValor");
		}
    }

    public List<CatalogoValorDTO> getItems() {
        items=catalogoValorGestor.findByEstadoActivo();
        return items;
    }
    
    public List<CatalogoValorDTO> obtenerCatalogosPorRelacionado(String codigoRelacionado) {
    	return catalogoValorGestor.findByCodigoreferenciarelacionado(codigoRelacionado);
    }
    
	public CatalogoValorDTO getSelected() {
		return selected;
	}

	public void setSelected(CatalogoValorDTO selected) {
		this.selected = selected;
	}

	public List<CatalogoValorDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<CatalogoValorDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

	public String getCodigoReferenciaRelacionado() {
		return codigoReferenciaRelacionado;
	}

	public void setCodigoReferenciaRelacionado(String codigoReferenciaRelacionado) {
		this.codigoReferenciaRelacionado = codigoReferenciaRelacionado;
	}
	
}
