package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.CatalogoValorDTO;


public interface ICatalogoValorGestor {

	List<CatalogoValorDTO> findByEstadoActivo();
	void delete(CatalogoValorDTO entity);
	CatalogoValorDTO getOne(Long id);
	long count();
	CatalogoValorDTO save(CatalogoValorDTO entity);
	int eliminar(String id);
	List<CatalogoValorDTO> findByCodigoreferenciarelacionado(String relacionado);	
	
}
