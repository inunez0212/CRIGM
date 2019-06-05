package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;

@Repository
public interface ITareaDAO extends JpaRepository<TareaDTO, Long>{
	
	List<TareaDTO> findByEstadoOrderByFecharegistroDesc(String estado);
	
	@Transactional
	void delete(TareaDTO entity);
	
	TareaDTO getOne(Long id);
	
	long count();
	
	@Transactional
	TareaDTO save(TareaDTO entity);
	
	@Transactional
	@Modifying
	@Query("update TareaDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	@Transactional
	@Modifying
	@Query("update TareaDTO p set estado = 0 where p.proyectoDTO = ?1")
	int pausarTareas(ProyectoDTO proyecto);
	
	@Transactional
	@Modifying
	@Query("update TareaDTO p set estadotarea = ?1 where p.proyectoDTO = ?2")
	int actualizarTareas(CatalogoValorDTO estado, ProyectoDTO proyecto);
	
	List<TareaDTO> findByProyectoDTOAndEstadoOrderByFecharegistroDesc(ProyectoDTO proyecto, String estado);
}
