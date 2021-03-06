package com.uisrael.edu.ec.crigm.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.crigm.constantes.Constantes;
import com.uisrael.edu.ec.crigm.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.crigm.persistencia.dao.interfaces.ICatalogoValorDAO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;

@Repository
public class CatalogoValorGestor implements ICatalogoValorGestor{

	@Autowired
	ICatalogoValorDAO catalogoValorDAO;
	
	@Override
	public List<CatalogoValorDTO> findByEstadoActivo() {
		return catalogoValorDAO.findByEstadoOrderByCodigoreferenciaDesc(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(CatalogoValorDTO entity) {
		catalogoValorDAO.delete(entity);
	}

	@Override
	public CatalogoValorDTO findByCodigoreferencia(String id) {
		return catalogoValorDAO.findByCodigoreferencia(id);
	}

	@Override
	public long count() {
		return catalogoValorDAO.count();
	}

	@Override
	public CatalogoValorDTO save(CatalogoValorDTO entity) {
		return catalogoValorDAO.save(entity);
	}

	@Override	
	public int eliminar(String id) {
		return catalogoValorDAO.eliminar(id);
	}

	@Override
	public List<CatalogoValorDTO> findByCodigoreferenciarelacionadoAndEstadoOrderByCodigoreferenciaDesc(
			CatalogoValorDTO relacionado, String estado) {
		return this.catalogoValorDAO.findByCodigoreferenciarelacionadoAndEstadoOrderByCodigoreferenciaDesc(relacionado, estado); 
	}

	@Override
	public List<CatalogoValorDTO> findByCodigoreferenciaAndEstadoOrderByCodigoreferenciaDesc(String codigoReferencia) {
		return this.catalogoValorDAO.findByCodigoreferenciaIgnoreCaseAndEstadoOrderByCodigoreferenciaDesc(codigoReferencia,
				Constantes.ESTADO_ACTIVO);
				
	}


	
	
}
