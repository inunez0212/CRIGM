package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;

@Repository
public interface IProyectoDAO extends JpaRepository<ProyectoDTO, Long>{
	
	List<ProyectoDTO> findByEstadoOrderByFecharegistroDesc(String estado);
	
	@Transactional
	void delete(ProyectoDTO entity);
	
	ProyectoDTO getOne(Long id);
	
	long count();
	
	@Transactional
	ProyectoDTO save(ProyectoDTO entity);
	
	@Transactional
	@Modifying
	@Query("update ProyectoDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	List<ProyectoDTO> findByNombreIgnoreCaseAndEstadoOrderByFecharegistroDesc(
			String filtros, String estado);
	
}
