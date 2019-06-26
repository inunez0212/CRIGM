/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.edu.ec.crigm.persistencia.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "proyecto")
@NamedQueries({
    @NamedQuery(name = "ProyectoDTO.findAll", query = "SELECT p FROM ProyectoDTO p")})
public class ProyectoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "numerotareas")
    private Integer numerotareas;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
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
    @OneToMany(mappedBy = "proyectoDTO")
    private Collection<TareaDTO> tareaCollection;
    @JoinColumn(name = "estadoproyecto", referencedColumnName = "codigoreferencia")
    @ManyToOne
    private CatalogoValorDTO estadoproyecto;
    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;
    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;
    @OneToMany(mappedBy = "proyectoDTO")
    private Collection<ProyectoGlobalDTO> proyectoGlobalCollection;

    public ProyectoDTO() {
    }

    public ProyectoDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumerotareas() {
        return numerotareas;
    }

    public void setNumerotareas(Integer numerotareas) {
        this.numerotareas = numerotareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
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

    public Collection<TareaDTO> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<TareaDTO> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    public CatalogoValorDTO getEstadoproyecto() {
        return estadoproyecto;
    }

    public void setEstadoproyecto(CatalogoValorDTO estadoproyecto) {
        this.estadoproyecto = estadoproyecto;
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

    public Collection<ProyectoGlobalDTO> getProyectoGlobalCollection() {
        return proyectoGlobalCollection;
    }

    public void setProyectoGlobalCollection(Collection<ProyectoGlobalDTO> proyectoGlobalCollection) {
        this.proyectoGlobalCollection = proyectoGlobalCollection;
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
        if (!(object instanceof ProyectoDTO)) {
            return false;
        }
        ProyectoDTO other = (ProyectoDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ProyectoDTO[ id=" + id + " ]";
    }
    
}
