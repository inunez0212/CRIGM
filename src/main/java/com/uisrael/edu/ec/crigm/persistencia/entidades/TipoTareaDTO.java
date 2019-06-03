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
@Table(name = "tipotarea")
@NamedQueries({
    @NamedQuery(name = "TipoTareaDTO.findAll", query = "SELECT t FROM TipoTareaDTO t")})
public class TipoTareaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String Descripcion;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @OneToMany(mappedBy = "tipotarea")
    private Collection<TareaDTO> tareaCollection;
    @OneToMany(mappedBy = "tipoTareaDTO")
    private Collection<TipoTareaPerfilDTO> tipoTareaPerfilCollection;
    @OneToMany(mappedBy = "tipotareaDTO")
    private Collection<HistorialTareaDTO> historialTareaCollection;
    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;
    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;

    public TipoTareaDTO() {
    }

    public TipoTareaDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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

    public Collection<TareaDTO> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<TareaDTO> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    public Collection<HistorialTareaDTO> getHistorialTareaCollection() {
        return historialTareaCollection;
    }

    public void setHistorialTareaCollection(Collection<HistorialTareaDTO> historialTareaCollection) {
        this.historialTareaCollection = historialTareaCollection;
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
    

    public Collection<TipoTareaPerfilDTO> getTipoTareaPerfilCollection() {
		return tipoTareaPerfilCollection;
	}

	public void setTipoTareaPerfilCollection(Collection<TipoTareaPerfilDTO> tipoTareaPerfilCollection) {
		this.tipoTareaPerfilCollection = tipoTareaPerfilCollection;
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
        if (!(object instanceof TipoTareaDTO)) {
            return false;
        }
        TipoTareaDTO other = (TipoTareaDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoTareaDTO[ id=" + id + " ]";
    }
    
}
