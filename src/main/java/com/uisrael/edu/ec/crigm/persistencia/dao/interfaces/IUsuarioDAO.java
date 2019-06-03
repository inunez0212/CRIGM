package com.uisrael.edu.ec.crigm.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.crigm.persistencia.entidades.UsuarioDTO;

@Repository
public interface IUsuarioDAO extends JpaRepository<UsuarioDTO, Long>{
	
	List<UsuarioDTO> findByEstadoOrderByFecharegistroDesc(String estado);
	
	@Transactional
	void delete(UsuarioDTO entity);
	
	UsuarioDTO getOne(Long id);
	
	long count();
	
	@Transactional
	UsuarioDTO save(UsuarioDTO entity);
	
	@Transactional
	@Modifying
	@Query("update UsuarioDTO p set estado = 0 where p.id = ?1")
	int eliminar(Long id);
	
	UsuarioDTO findByCedulaAndContrasenia(String cedula, String contrasenia); 

	UsuarioDTO findByCedula(String cedula);

	List<UsuarioDTO> 
	findByCedulaIgnoreCaseOrNombreIgnoreCaseOrApellidoIgnoreCaseAndEstadoOrderByFecharegistroDesc(
			String cedula, String nombre, String apellido, String estado);

	@Transactional
	@Modifying
	@Query("update UsuarioDTO p set contrasenia =?1  where p.id = ?2")
	int actualizarContrasenia(String contrasenia, Long id);
}
