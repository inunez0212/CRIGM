package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoGlobalDTO;

@Repository
public interface IProyectoGlobalDAO extends JpaRepository<ProyectoGlobalDTO, Long>{
	
	List<ProyectoGlobalDTO> findByEstadoOrderByFecharegistroDesc(String estado);
	
	@Transactional
	void delete(ProyectoGlobalDTO entity);
	
	ProyectoGlobalDTO getOne(Long id);
	
	long count();
	
	@Transactional
	ProyectoGlobalDTO save(ProyectoGlobalDTO entity);
	
	@Transactional
	@Modifying
	@Query("update ProyectoGlobalDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	List<ProyectoGlobalDTO> findByProyectoDTOAndEstadoOrderByFecharegistroDesc(ProyectoDTO proyecto,
			String estado);
}
