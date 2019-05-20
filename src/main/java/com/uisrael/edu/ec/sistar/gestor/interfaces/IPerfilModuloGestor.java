package com.uisrael.edu.ec.sistar.gestor.interfaces;

import java.util.List;

import com.uisrael.edu.ec.vista.persistencia.entidades.PerfilModuloDTO;


public interface IPerfilModuloGestor {

	List<PerfilModuloDTO> findByEstadoActivo();
	void delete(PerfilModuloDTO entity);
	PerfilModuloDTO getOne(Long id);
	long count();
	PerfilModuloDTO save(PerfilModuloDTO entity);
	int eliminar(Integer id);	
	
}
