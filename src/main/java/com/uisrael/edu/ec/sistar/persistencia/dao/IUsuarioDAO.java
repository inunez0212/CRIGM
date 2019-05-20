package com.uisrael.edu.ec.sistar.persistencia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.vista.persistencia.entidades.UsuarioDTO;

@Repository
public interface IUsuarioDAO extends JpaRepository<UsuarioDTO, Long>{
	
	List<UsuarioDTO> findByEstado(String estado);
	
	@Transactional
	void delete(UsuarioDTO entity);
	
	UsuarioDTO getOne(Long id);
	
	long count();
	
	@Transactional
	UsuarioDTO save(UsuarioDTO entity);
	
	@Transactional
	@Modifying
	@Query("update UsuarioDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	
}
