package com.uisrael.edu.ec.crigm.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;


public interface ICatalogoValorGestor {

	List<CatalogoValorDTO> findByEstadoActivo();
	void delete(CatalogoValorDTO entity);
	CatalogoValorDTO findByCodigoreferencia(String id);
	long count();
	CatalogoValorDTO save(CatalogoValorDTO entity);
	int eliminar(String id);
	List<CatalogoValorDTO> findByCodigoreferenciarelacionado(CatalogoValorDTO relacionado);	
	
}
