package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
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
	@Autowired
	private ITareaGestor tareaGestor;

	@Inject
	private LoginController loginController;

	@Inject
	private TareaController tareaController;

	@Inject
	private ProyectoGlobalController proyectoGlobalController;

	private List<ProyectoDTO> items = null;
	private ProyectoDTO selected;
	private List<ProyectoDTO> itemsFiltrados;
	private String codigoRefereciaEstado;
	private Collection<String> modelos;
	//objetos de busqueda
	private String filtros;
	private boolean busqueda = false;

	//Objetos pausa
	private String codigoReferenciaCausal;
	private Date fechaInicio;
	private Date fechaFin;

	private UploadedFile file;

	public ProyectoDTO prepareCreate() {
		selected = new ProyectoDTO();
		file=null;
		return selected;
	}

	public void create() {
		try {
			selected.setNumerotareas(0);
			selected.setEstadoproyecto(catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_REGISTRADA));
			selected.setUsuarioregistro(loginController.getUsuarioDTO());
			selected.setFecharegistro(new Date());
			proyectoGestor.save(selected, modelos);
			JsfUtil.addSuccessMessage("ProyectoDTO creado correctamente");
		}catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage("No se pudo crear el proyecto");
		}
	}

	public void update() {
		try {
			selected.setNumerotareas(selected.getTareaCollection().size());
			selected.setEstadoproyecto(this.catalogoValorGestor.findByCodigoreferencia(codigoRefereciaEstado));
			selected.setUsuariomodificacion(loginController.getUsuarioDTO());
			selected.setFechamodificacion(new Date());
			proyectoGestor.save(selected, null);
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
		busqueda = StringUtils.isNotBlank(filtros);
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

	public void seleccionarTareas() {
		try {
			if(this.selected!=null && this.selected.getId()!=null) {
				this.tareaController.setIdProyecto(this.selected.getId());
				FacesContext fContext = FacesContext.getCurrentInstance();
				ExternalContext extContext = fContext.getExternalContext();
				extContext.redirect(extContext.getRequestContextPath() + "/xhtml/tarea/List.xhtml");
			}else {
				JsfUtil.addErrorMessage("Debe seleccionar un proyecto");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void seleccionarGlobal() {
		try {
			if(this.selected!=null && this.selected.getId()!=null) {
				this.proyectoGlobalController.setIdProyecto(this.selected.getId());
				FacesContext fContext = FacesContext.getCurrentInstance();
				ExternalContext extContext = fContext.getExternalContext();
				extContext.redirect(extContext.getRequestContextPath() + "/xhtml/proyectoGlobal/List.xhtml");
			}else {
				JsfUtil.addErrorMessage("Debe seleccionar un proyecto");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void pausarTarea() {
		try {
			CatalogoValorDTO estadoCatValDTO = this.catalogoValorGestor.findByCodigoreferencia(Constantes.ESTADO_EN_PAUSA);
			//this.tareaGestor.actualizarTareas(estadoCatValDTO, selected);
			JsfUtil.addSuccessMessage("Tarea pausada");
		}catch (Exception e) {
			JsfUtil.addErrorMessage("Error al pausar la tarea");
		}
	}

	public void pausarTodo() {
		try {
			JsfUtil.addSuccessMessage("Todas las tareas se han pausado");
		}catch (Exception e) {
			JsfUtil.addErrorMessage("Error al pausar la tarea");
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		file = event.getFile();
		this.readExcel();
	}


	private  void readExcel() {
		int i=0;
		XSSFWorkbook wb=null;
		try {
			modelos=new ArrayList<>();
			wb = new XSSFWorkbook(file.getInputstream());
			XSSFSheet sheet = wb.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			for (i=1; i < rows; ++i) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell modeloCell = row.getCell(0);
				String modelo =  modeloCell.getStringCellValue();
				modelos.add(modelo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage("Error al leer el archivo en la fila: "+i);
		}finally {
			if(wb!=null) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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
	 * @return the codigoReferenciaCausal
	 */
	public String getCodigoReferenciaCausal() {
		return codigoReferenciaCausal;
	}

	/**
	 * @param codigoReferenciaCausal the codigoReferenciaCausal to set
	 */
	public void setCodigoReferenciaCausal(String codigoReferenciaCausal) {
		this.codigoReferenciaCausal = codigoReferenciaCausal;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @param filtros the filtros to set
	 */
	public void setFiltros(String filtros) {
		this.filtros = filtros;
	}

	/**
	 * @return
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * @param file
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}


}
