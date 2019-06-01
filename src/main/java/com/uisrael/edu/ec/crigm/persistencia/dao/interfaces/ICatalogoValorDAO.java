package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.CatalogoValorDTO;

@Repository
public interface ICatalogoValorDAO extends JpaRepository<CatalogoValorDTO, Long>{
	
	List<CatalogoValorDTO> findByEstadoOrderByCodigoreferenciaASC(String estado);
	
	@Transactional
	void delete(CatalogoValorDTO entity);
	
	
	CatalogoValorDTO findByCodigoreferencia(String id);
	
	long count();
	
	@Transactional
	CatalogoValorDTO save(CatalogoValorDTO entity);
	
	@Transactional
	@Modifying
	@Query("update CatalogoValorDTO p set estado = 0 where p.id = ?1")
	int eliminar(String id);

	List<CatalogoValorDTO> findByCodigoreferenciarelacionadoOrderByCodigoreferenciaASC(
			CatalogoValorDTO relacionado);
	
	List<CatalogoValorDTO> findByCodigoreferenciaAndEstadoOrderByCodigoreferenciaASC(
			String cedula, String nombre, String apellido, String estado);
}
