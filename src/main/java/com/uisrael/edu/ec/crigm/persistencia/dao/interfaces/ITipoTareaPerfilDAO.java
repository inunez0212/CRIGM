package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.TipoTareaPerfilDTO;

@Repository
public interface ITipoTareaPerfilDAO extends JpaRepository<TipoTareaPerfilDTO, Long>{
	
	List<TipoTareaPerfilDTO> findByEstadoOrderByFechaRegistroDesc(String estado);
	
	@Transactional
	void delete(TipoTareaPerfilDTO entity);
	
	TipoTareaPerfilDTO getOne(Long id);
	
	long count();
	
	@Transactional
	TipoTareaPerfilDTO save(TipoTareaPerfilDTO entity);
	
	@Transactional
	@Modifying
	@Query("update TipoTareaPerfilDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	
}
