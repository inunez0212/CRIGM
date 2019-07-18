package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.ProyectoDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.TareaDTO;
import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;

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
	//Obtiene tareas por fecha inicio
	List<TareaDTO> findByProyectoDTOAndEstadoOrderByFecharegistroDesc(ProyectoDTO proyecto, String estado);
	
	//Obtiene las tareas por fecha inicio 
	List<TareaDTO> findByEstadoAndUsuarioasignadoNotNullAndFecharegistroBetweenOrderByUsuarioasignadoAsc(String estado, Date fechaInicio, Date fechaFin);
	
	//Obtiene las tareas por usuario y fecha inicio 
	List<TareaDTO> findByEstadoAndUsuarioasignadoAndFecharegistroBetweenOrderByUsuarioasignadoAsc(String estado, 
		UsuarioDTO usuarioasignado, Date fechaInicio, Date fechaFin);
		
}
