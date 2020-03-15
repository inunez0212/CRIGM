/**
 * 
 */
package com.uisrael.edu.ec.crigm.vista.beans.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;

/**
 * @author David Alvarez
 *
 */
public class ExcelView{

	public void buildExcelDocument(Map<String, Object> model, OutputStream outputStream) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		try {
		    Sheet sheet = workbook.createSheet((String)model.get("tipo")+".xsl");
		    sheet.setDefaultColumnWidth(50);
		    // create style for header cells
		    CellStyle style = workbook.createCellStyle();
		    Font font = workbook.createFont();
		    font.setFontName("Arial");
		    style.setFillForegroundColor(HSSFColor.BLUE.index);
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    font.setBold(true);
		    font.setColor(HSSFColor.WHITE.index);
		    style.setFont(font);
		
		    // create header row
		    Row header = sheet.createRow(0);
		    header.createCell(0).setCellValue("Operador");
		    header.getCell(0).setCellStyle(style);
		    header.createCell(1).setCellValue("Grupo");
		    header.getCell(1).setCellStyle(style);
		    header.createCell(2).setCellValue("Nro");
		    header.getCell(2).setCellStyle(style);
		    header.createCell(3).setCellValue("Proyecto");
		    header.getCell(3).setCellStyle(style);
		    header.createCell(4).setCellValue("Zona");
		    header.getCell(4).setCellStyle(style);
		    header.createCell(5).setCellValue("Address");
		    header.getCell(5).setCellStyle(style);
		    header.createCell(6).setCellValue("Actividad");
		    header.getCell(6).setCellStyle(style);
		    header.createCell(7).setCellValue("Modelo/Carta");
		    header.getCell(7).setCellStyle(style);
		    header.createCell(8).setCellValue("Área");
		    header.getCell(8).setCellStyle(style);
		    header.createCell(9).setCellValue("Tipo");
		    header.getCell(9).setCellStyle(style);
		    header.createCell(10).setCellValue("Factor");
		    header.getCell(10).setCellStyle(style);
		    header.createCell(11).setCellValue("Inicio");
		    header.getCell(11).setCellStyle(style);
		    header.createCell(12).setCellValue("Hora inicio");
		    header.getCell(12).setCellStyle(style);
		    header.createCell(13).setCellValue("Fin");
		    header.getCell(13).setCellStyle(style);
		    header.createCell(14).setCellValue("Hora fin");
		    header.getCell(14).setCellStyle(style);
		    header.createCell(15).setCellValue("Horas laboradas");
		    header.getCell(15).setCellStyle(style);
		    header.createCell(16).setCellValue("Horas productivas");
		    header.getCell(16).setCellStyle(style);
		    header.createCell(17).setCellValue("Rendimiento productivo");
		    header.getCell(17).setCellStyle(style);
		    header.createCell(18).setCellValue("Rendimiento homologado");
		    header.getCell(18).setCellStyle(style);
		    header.createCell(19).setCellValue("Observaciones");
		    header.getCell(19).setCellStyle(style);
		
		    List<TareaDTO> tareasList = (List<TareaDTO>) model.get("tareas");
		    int rowCount = 1;
		    
		    for(TareaDTO tarea : tareasList){
		        Row tareaRow =  sheet.createRow(rowCount++);
		        tareaRow.createCell(0).setCellValue(tarea.getUsuarioasignado().getApellido() + " " +
		        tarea.getUsuarioasignado().getNombre());
		     }
	
		    workbook.write(outputStream);
	        outputStream.flush();
	
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			workbook.close();
			outputStream.close();
		}
	    	    
	}

}
