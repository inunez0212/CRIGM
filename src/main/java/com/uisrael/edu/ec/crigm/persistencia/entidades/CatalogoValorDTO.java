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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David Alvarez
 */
@Entity
@Table(name = "catalogovalor")
@NamedQueries({
    @NamedQuery(name = "CatalogoValorDTO.findAll", query = "SELECT c FROM CatalogoValorDTO c")})
public class CatalogoValorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigoreferencia")
    private String codigoreferencia;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @OneToMany(mappedBy = "estadotarea")
    private Collection<TareaDTO> tareaCollection;
    @OneToMany(mappedBy = "codigoreferenciarelacionado")
    private Collection<CatalogoValorDTO> catalogoValorCollection;
    @JoinColumn(name = "codigoreferenciarelacionado", referencedColumnName = "codigoreferencia")
    @ManyToOne
    private CatalogoValorDTO codigoreferenciarelacionado;
    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;
    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;
    
    @OneToMany(mappedBy = "estadoproyecto")
    private Collection<ProyectoDTO> proyectoCollection;
    @OneToMany(mappedBy = "estadoglobal")
    private Collection<ProyectoGlobalDTO> proyectoGlobalCollection;

    public CatalogoValorDTO() {
    }

    public CatalogoValorDTO(String codigoreferencia) {
        this.codigoreferencia = codigoreferencia;
    }

    public String getCodigoreferencia() {
        return codigoreferencia;
    }

    public void setCodigoreferencia(String codigoreferencia) {
        this.codigoreferencia = codigoreferencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Collection<CatalogoValorDTO> getCatalogoValorCollection() {
        return catalogoValorCollection;
    }

    public void setCatalogoValorCollection(Collection<CatalogoValorDTO> catalogoValorCollection) {
        this.catalogoValorCollection = catalogoValorCollection;
    }

    public CatalogoValorDTO getCodigoreferenciarelacionado() {
        return codigoreferenciarelacionado;
    }

    public void setCodigoreferenciarelacionado(CatalogoValorDTO codigoreferenciarelacionado) {
        this.codigoreferenciarelacionado = codigoreferenciarelacionado;
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

    public Collection<ProyectoDTO> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<ProyectoDTO> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    public Collection<ProyectoGlobalDTO> getProyectoGlobalCollection() {
        return proyectoGlobalCollection;
    }

    public void setProyectoGlobalCollection(Collection<ProyectoGlobalDTO> proyectoGlobalCollection) {
        this.proyectoGlobalCollection = proyectoGlobalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoreferencia != null ? codigoreferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoValorDTO)) {
            return false;
        }
        CatalogoValorDTO other = (CatalogoValorDTO) object;
        if ((this.codigoreferencia == null && other.codigoreferencia != null) || (this.codigoreferencia != null && !this.codigoreferencia.equals(other.codigoreferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CatalogoValorDTO[ codigoreferencia=" + codigoreferencia + " ]";
    }
    
}
