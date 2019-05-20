package com.uisrael.edu.ec.sistar.persistencia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.vista.persistencia.entidades.TipoTareaDTO;

@Repository
public interface ITipoTareaDAO extends JpaRepository<TipoTareaDTO, Long>{
	
	List<TipoTareaDTO> findByEstado(String estado);
	
	@Transactional
	void delete(TipoTareaDTO entity);
	
	TipoTareaDTO getOne(Long id);
	
	long count();
	
	@Transactional
	TipoTareaDTO save(TipoTareaDTO entity);
	
	@Transactional
	@Modifying
	@Query("update TipoTareaDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	
}