package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.PerfilModuloDTO;

@Repository
public interface IPerfilModuloDAO extends JpaRepository<PerfilModuloDTO, Long>{
	
	List<PerfilModuloDTO> findByEstado(String estado);
	
	@Transactional
	void delete(PerfilModuloDTO entity);
	
	PerfilModuloDTO getOne(Long id);
	
	long count();
	
	@Transactional
	PerfilModuloDTO save(PerfilModuloDTO entity);
	
	@Transactional
	@Modifying
	@Query("update PerfilModuloDTO p set estado = 0 where p.id = ?1")
	int eliminar(Integer id);
	
	
}
