/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.edu.ec.crigm.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author David Alvarez
 */
@Entity
@Table(name = "proyectoglobal")
@NamedQueries({
    @NamedQuery(name = "ProyectoGlobalDTO.findAll", query = "SELECT p FROM ProyectoGlobalDTO p")})
public class ProyectoGlobalDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numerotareas")
    private Integer numerotareas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kilometraje")
    private BigDecimal kilometraje;
    @Size(max = 200)
    @Column(name = "rutacarpeta")
    private String rutacarpeta;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @JoinColumn(name = "estadoglobal", referencedColumnName = "codigoreferencia")
    @ManyToOne
    private CatalogoValorDTO estadoglobal;
    @JoinColumn(name = "proyectoDTO", referencedColumnName = "id")
    @ManyToOne
    private ProyectoDTO proyectoDTO;
    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;
    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;

    public ProyectoGlobalDTO() {
    }

    public ProyectoGlobalDTO(Integer id) {
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

    public Integer getNumerotareas() {
        return numerotareas;
    }

    public void setNumerotareas(Integer numerotareas) {
        this.numerotareas = numerotareas;
    }

    public BigDecimal getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(BigDecimal kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getRutacarpeta() {
        return rutacarpeta;
    }

    public void setRutacarpeta(String rutacarpeta) {
        this.rutacarpeta = rutacarpeta;
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

    public CatalogoValorDTO getEstadoglobal() {
        return estadoglobal;
    }

    public void setEstadoglobal(CatalogoValorDTO estadoglobal) {
        this.estadoglobal = estadoglobal;
    }

    public ProyectoDTO getProyecto() {
        return proyectoDTO;
    }

    public void setProyecto(ProyectoDTO proyectoDTO) {
        this.proyectoDTO = proyectoDTO;
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
        if (!(object instanceof ProyectoGlobalDTO)) {
            return false;
        }
        ProyectoGlobalDTO other = (ProyectoGlobalDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProyectoGlobalDTO[ id=" + id + " ]";
    }
    
}
