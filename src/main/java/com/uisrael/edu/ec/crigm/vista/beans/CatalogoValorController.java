package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
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

    //objetos de busqueda
    private String filtros;
    private boolean busqueda = false;

    
    public CatalogoValorController() {
    }

    public CatalogoValorDTO prepareCreate() {
        selected = new CatalogoValorDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setCodigoreferenciarelacionado(
  					catalogoValorGestor.findByCodigoreferencia(codigoReferenciaRelacionado));
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
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
  					catalogoValorGestor.findByCodigoreferencia(codigoReferenciaRelacionado));
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
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
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		catalogoValorGestor.eliminar(selected.getCodigoreferencia());
    		JsfUtil.addSuccessMessage("CatalogoValorDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el catalogoValor");
		}
    }

    private List<CatalogoValorDTO> findByCodigoReferencia() {
    	List<CatalogoValorDTO> items = catalogoValorGestor.findByCodigoreferenciaAndEstadoOrderByCodigoreferenciaDesc(filtros);
    	if(items==null) {
			items=new ArrayList<>();
		}
        return items;
    }
    
    
    public List<CatalogoValorDTO> getItems() {
    	if(busqueda) {
    		items=this.findByCodigoReferencia();
    	}else {
    		items=catalogoValorGestor.findByEstadoActivo();
    	}
        return items;
    }

    
    public List<CatalogoValorDTO> obtenerCatalogosPorRelacionado(String codigoRelacionado) {
    	CatalogoValorDTO catalogoRelacionado = catalogoValorGestor.findByCodigoreferencia(codigoRelacionado);	
    	return catalogoValorGestor.findByCodigoreferenciarelacionadoAndEstadoOrderByCodigoreferenciaDesc
    			(catalogoRelacionado, Constantes.ESTADO_ACTIVO);
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
