package com.uisrael.edu.ec.crigm.vista.beans;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.IProyectoGestor;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ITareaGestor;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;
import com.uisrael.edu.ec.crigm.vista.beans.util.ExcelView;
import com.uisrael.edu.ec.crigm.vista.beans.util.JsfUtil;

@Named("dashBoardController")
public class DashBoardController implements Serializable {

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

	private String tipoReporte;
	private String grupo;
	
	private Date fechaInicio = new Date();
	private Date fechaFin = new Date();

	public void descargar(){
		
		CatalogoValorDTO catalogoReporte = catalogoValorGestor.findByCodigoreferencia(tipoReporte);
	    
		//Contexto de jsf
	    FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();
	    //Nombre
	    String name = (catalogoReporte.getDescripcion()+".xls");
	    ec.responseReset();
	    ec.setResponseHeader("Content-Type", "application/vnd.ms-excel");
	    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
	    //Trata de obtener un outputStream
	    try (OutputStream output = ec.getResponseOutputStream()) {
	    	//Obtiene los datos del reporte
	    	Map<String, Object> modelo = obtenerModeloReporte(catalogoReporte);
	    	//Invoca el objeto que devuelve el excel 
	        ExcelView excelView = new ExcelView();
	        excelView.buildExcelDocument(modelo,output);
	        JsfUtil.addSuccessMessage("Se ha generado el archivo correctamente");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	JsfUtil.addErrorMessage("Error al generar el archivo");
	    }
	    //finaliza el response
	    fc.responseComplete();
	}


	private Map<String, Object> obtenerModeloReporte(CatalogoValorDTO catalogoReporte) {
		Map<String, Object> modelo = new HashMap<>();
		modelo.put("tipo", catalogoReporte.getDescripcion());
		Collection<TareaDTO>tareaDTOCOL = new ArrayList<>();  
		if(tipoReporte.equals(Constantes.REPORTE_RENDIMIENTO_GRUPO)) {
			tareaDTOCOL = this.tareaGestor.findByEstadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(fechaInicio, fechaFin);
			modelo.put("tareas", tareaDTOCOL);
		}
		if(tipoReporte.equals(Constantes.REPORTE_RENDIMIENTO_TOTAL)) {
			tareaDTOCOL = this.tareaGestor.findByEstadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(fechaInicio, fechaFin);
			modelo.put("tareas", tareaDTOCOL);
		}
		if(tipoReporte.equals(Constantes.REPORTE_RENDIMIENTO_USUARIO)) {
			UsuarioDTO usuarioAsignado = new UsuarioDTO();
			tareaDTOCOL = this.tareaGestor.findByEstadoAndUsuarioasignadoAndfechainicioBetweenOrderByUsuarioAsignadoAsc(
					usuarioAsignado, fechaInicio, fechaFin);
			modelo.put("tareas", tareaDTOCOL);
		}
		return modelo;
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
	 * @return the tipoReporte
	 */
	public String getTipoReporte() {
		return tipoReporte;
	}
	/**
	 * @param tipoReporte the tipoReporte to set
	 */
	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}
	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
}
