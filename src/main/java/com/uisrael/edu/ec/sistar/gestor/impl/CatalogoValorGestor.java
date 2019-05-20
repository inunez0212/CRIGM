package com.uisrael.edu.ec.sistar.gestor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uisrael.edu.ec.constantes.Constantes;
import com.uisrael.edu.ec.sistar.gestor.interfaces.ICatalogoValorGestor;
import com.uisrael.edu.ec.sistar.persistencia.dao.ICatalogoValorDAO;
import com.uisrael.edu.ec.vista.persistencia.entidades.CatalogoValorDTO;

@Repository
public class CatalogoValorGestor implements ICatalogoValorGestor	{

	@Autowired
	ICatalogoValorDAO catalogoValorDAO;
	
	@Override
	public List<CatalogoValorDTO> findByEstadoActivo() {
		return catalogoValorDAO.findByEstado(Constantes.ESTADO_ACTIVO); 
	}

	@Override
	public void delete(CatalogoValorDTO entity) {
		catalogoValorDAO.delete(entity);
	}

	@Override
	public CatalogoValorDTO getOne(Long id) {
		return catalogoValorDAO.getOne(id);
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
	public List<CatalogoValorDTO> findByCodigoreferenciarelacionado(String relacionado) {
		return this.catalogoValorDAO.findByCodigoreferenciarelacionado(relacionado);
	}
}