/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.edu.ec.crigm.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Ivan
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "UsuarioDTO.findAll", query = "SELECT u FROM UsuarioDTO u")})
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 10)
    @Column(name = "cedula")
    private String cedula;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;
    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;

    @JoinColumn(name = "perfilDTO", referencedColumnName = "id")
    @ManyToOne
    private PerfilDTO perfilDTO;
    @OneToMany(mappedBy = "usuariomodificacion")
    private Collection<ProyectoGlobalDTO> proyectoGlobalCollection;
    @OneToMany(mappedBy = "usuarioregistro")
    private Collection<ProyectoGlobalDTO> proyectoGlobalCollection1;
    @OneToMany(mappedBy = "usuariomodificacion")
    private Collection<PerfilDTO> perfilCollection;
    @OneToMany(mappedBy = "usuarioregistro")
    private Collection<PerfilDTO> perfilCollection1;
    @OneToMany(mappedBy = "usuariomodificacion")
    private Collection<TipoTareaDTO> tipoTareaCollection;
    @OneToMany(mappedBy = "usuarioregistro")
    private Collection<TipoTareaDTO> tipoTareaCollection1;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public PerfilDTO getPerfil() {
        return perfilDTO;
    }

    public void setPerfil(PerfilDTO perfilDTO) {
        this.perfilDTO = perfilDTO;
    }

    public Collection<ProyectoGlobalDTO> getProyectoGlobalCollection() {
        return proyectoGlobalCollection;
    }

    public void setProyectoGlobalCollection(Collection<ProyectoGlobalDTO> proyectoGlobalCollection) {
        this.proyectoGlobalCollection = proyectoGlobalCollection;
    }

    public Collection<ProyectoGlobalDTO> getProyectoGlobalCollection1() {
        return proyectoGlobalCollection1;
    }

    public void setProyectoGlobalCollection1(Collection<ProyectoGlobalDTO> proyectoGlobalCollection1) {
        this.proyectoGlobalCollection1 = proyectoGlobalCollection1;
    }

    public Collection<PerfilDTO> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<PerfilDTO> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    public Collection<PerfilDTO> getPerfilCollection1() {
        return perfilCollection1;
    }

    public void setPerfilCollection1(Collection<PerfilDTO> perfilCollection1) {
        this.perfilCollection1 = perfilCollection1;
    }

    public Collection<TipoTareaDTO> getTipoTareaCollection() {
        return tipoTareaCollection;
    }

    public void setTipoTareaCollection(Collection<TipoTareaDTO> tipoTareaCollection) {
        this.tipoTareaCollection = tipoTareaCollection;
    }

    public Collection<TipoTareaDTO> getTipoTareaCollection1() {
        return tipoTareaCollection1;
    }

    public void setTipoTareaCollection1(Collection<TipoTareaDTO> tipoTareaCollection1) {
        this.tipoTareaCollection1 = tipoTareaCollection1;
    }
    

    public UsuarioDTO getUsuariomodificacion() {
		return usuariomodificacion;
	}

	public void setUsuariomodificacion(UsuarioDTO usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}

	public UsuarioDTO getUsuarioregistro() {
		return usuarioregistro;
	}

	public void setUsuarioregistro(UsuarioDTO usuarioregistro) {
		this.usuarioregistro = usuarioregistro;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDTO)) {
            return false;
        }
        UsuarioDTO other = (UsuarioDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UsuarioDTO[ id=" + id + " ]";
    }
    
}
