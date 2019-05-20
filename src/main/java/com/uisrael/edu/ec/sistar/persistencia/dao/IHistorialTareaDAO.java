package com.uisrael.edu.ec.sistar.persistencia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.vista.persistencia.entidades.HistorialTareaDTO;

@Repository
public interface IHistorialTareaDAO extends JpaRepository<HistorialTareaDTO, Long>{
	
	List<HistorialTareaDTO> findByEstado(String estado);
	
	@Transactional
	void delete(HistorialTareaDTO entity);
	
	HistorialTareaDTO getOne(Long id);
	
	long count();
	
	@Transactional
	HistorialTareaDTO save(HistorialTareaDTO entity);
	
	@Transactional
	@Modifying
	@Query("update HistorialTareaDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	
}
