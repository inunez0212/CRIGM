package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.PerfilDTO;

@Repository
public interface IPerfilDAO extends JpaRepository<PerfilDTO, Long>{
	
	List<PerfilDTO> findByEstadoOrderByFechaRegistroDesc(String estado);
	
	@Transactional
	void delete(PerfilDTO entity);
	
	PerfilDTO getOne(Long id);
	
	long count();
	
	@Transactional
	PerfilDTO save(PerfilDTO entity);
	
	@Transactional
	@Modifying
	@Query("update PerfilDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	
}
