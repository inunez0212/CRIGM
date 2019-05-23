package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("catalogoValorController")
public class CatalogoValorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private ICatalogoValorGestor catalogoValorGestor;
	
	@Autowired
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
    		selected.setCodigoreferenciarelacionado(
  					catalogoValorGestor.getOne(codigoReferenciaRelacionado));
    		selected.setUsuarioregistro(loginController.getUsuario());
    		selected.setFecharegistro(new Date());
    		catalogoValorGestor.save(selected);
    		JsfUtil.addSuccessMessage("CatalogoValor creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el catalogoValor");
		}
    }

    public void update() {
    	try {
  			selected.setCodigoreferenciarelacionado(
  					catalogoValorGestor.getOne(codigoReferenciaRelacionado));
    		selected.setUsuariomodificacion(loginController.getUsuario());
    		selected.setFechamodificacion(new Date());
    		catalogoValorGestor.save(selected);
    		JsfUtil.addSuccessMessage("CatalogoValor actaulizado correctamente");
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
    	CatalogoValorDTO catalogoRelacionado = catalogoValorGestor.getOne(codigoRelacionado);	
    	return catalogoValorGestor.findByCodigoreferenciarelacionado(catalogoRelacionado);
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

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	
}
