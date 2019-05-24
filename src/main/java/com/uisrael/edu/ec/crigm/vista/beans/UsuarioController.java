package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.gestor.interfaces.IPerfilGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IUsuarioGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("usuarioController")
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6438741790634876364L;

	@Autowired
	private IUsuarioGestor usuarioGestor;
	@Autowired
	private IPerfilGestor perfilGestor;
	
	@Inject
	private LoginController loginController;
	
    private List<UsuarioDTO> items = null;
    private UsuarioDTO selected;
    private List<UsuarioDTO> itemsFiltrados;
    private Long idPerfil;
    
    //objetos de busqueda
    private Long perfilId;
    private String cedula;
    private String nombre;
    private String apellido;
    private boolean busqueda = false;
    
    public UsuarioController() {
    }

    public UsuarioDTO prepareCreate() {
        selected = new UsuarioDTO();
        return selected;
    }

    public void create() {
    	try {
    		selected.setPerfil(perfilGestor.getOne(idPerfil));
    		selected.setUsuarioregistro(loginController.getUsuarioDTO());
    		selected.setFecharegistro(new Date());
    		usuarioGestor.save(selected);
    		JsfUtil.addSuccessMessage("UsuarioDTO creado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el usuario");
		}
    }

    public void update() {
    	try {
    		selected.setPerfil(perfilGestor.getOne(idPerfil));
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		usuarioGestor.save(selected);
    		JsfUtil.addSuccessMessage("UsuarioDTO actualizado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo actualizar el usuario");
		}
    }

    public void destroy() {
    	try {
    		selected.setUsuariomodificacion(loginController.getUsuarioDTO());
    		selected.setFechamodificacion(new Date());
    		usuarioGestor.eliminar(selected.getId());
    		JsfUtil.addSuccessMessage("UsuarioDTO eliminado correctamente");
    	}catch (Exception e) {
    		e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo elminar el usuario");
		}
    }

    public void busqueda(){
    	if(StringUtils.isNotBlank(cedula)|| StringUtils.isNotBlank(nombre) || StringUtils.isNotBlank(apellido)) {
    		busqueda = true;
    	}    	
    }
    
    private List<UsuarioDTO> findByCedulaOrNombreOrApellido() {
    	List<UsuarioDTO> items = usuarioGestor.findByCedulaOrNombreOrApellido(cedula, nombre, apellido);
    	if(items==null) {
			items=new ArrayList<>();
		}
        return items;
    }
    
    
    public List<UsuarioDTO> getItems() {
    	if(busqueda) {
    		items=this.findByCedulaOrNombreOrApellido();
    		busqueda=false;
    	}else {
    		items=usuarioGestor.findByEstadoActivo();
    	}
    	cedula = null;
    	nombre = null;
    	apellido = null;
        return items;
    }

	public UsuarioDTO getSelected() {
		return selected;
	}

	public void setSelected(UsuarioDTO selected) {
		this.selected = selected;
	}

	public List<UsuarioDTO> getItemsFiltrados() {
		return itemsFiltrados;
	}

	public void setItemsFiltrados(List<UsuarioDTO> itemsFiltrados) {
		this.itemsFiltrados = itemsFiltrados;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	/**
	 * @return the perfilId
	 */
	public Long getPerfilId() {
		return perfilId;
	}

	/**
	 * @param perfilId the perfilId to set
	 */
	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	
}
