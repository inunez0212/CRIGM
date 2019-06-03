/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.edu.ec.crigm.persistencia.entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Ivan
 */
@Entity
@Table(name = "perfilmodulo")
@NamedQueries({
    @NamedQuery(name = "PerfilModuloDTO.findAll", query = "SELECT p FROM PerfilModuloDTO p")})
public class PerfilModuloDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "Descripcion")
    private String Descripcion;
    @Size(max = 100)
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "crear")
    private Boolean crear;
    @Column(name = "modificar")
    private Boolean modificar;
    @Column(name = "listar")
    private Boolean listar;
    @Column(name = "eliminar")
    private Boolean eliminar;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @JoinColumn(name = "perfilDTO", referencedColumnName = "id")
    @ManyToOne
    private PerfilDTO perfilDTO;
    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;
    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;

    public PerfilModuloDTO() {
    }

    public PerfilModuloDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Boolean getCrear() {
        return crear;
    }

    public void setCrear(Boolean crear) {
        this.crear = crear;
    }

    public Boolean getModificar() {
        return modificar;
    }

    public void setModificar(Boolean modificar) {
        this.modificar = modificar;
    }

    public Boolean getListar() {
        return listar;
    }

    public void setListar(Boolean listar) {
        this.listar = listar;
    }

    public Boolean getEliminar() {
        return eliminar;
    }

    public void setEliminar(Boolean eliminar) {
        this.eliminar = eliminar;
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
        if (!(object instanceof PerfilModuloDTO)) {
            return false;
        }
        PerfilModuloDTO other = (PerfilModuloDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PerfilModuloDTO[ id=" + id + " ]";
    }
    
}
