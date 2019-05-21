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
@Table(name = "tarea")
@NamedQueries({
    @NamedQuery(name = "TareaDTO.findAll", query = "SELECT t FROM TareaDTO t")})
public class TareaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fechainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
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
    @JoinColumn(name = "estadotarea", referencedColumnName = "codigoreferencia")
    @ManyToOne
    private CatalogoValorDTO estadotarea;
    @JoinColumn(name = "proyectoDTO", referencedColumnName = "id")
    @ManyToOne
    private ProyectoDTO proyectoDTO;
    @JoinColumn(name = "tipotareaDTO", referencedColumnName = "id")
    @ManyToOne
    private TipoTareaDTO tipotarea;
    @JoinColumn(name = "usuarioasignado", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioasignado;
    @JoinColumn(name = "usuarioasignador", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioasignador;
    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO revisor;
    @JoinColumn(name = "revisor", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;
    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;
    @OneToMany(mappedBy = "tareaDTO")
    private Collection<HistorialTareaDTO> historialTareaCollection;

    public TareaDTO() {
    }

    public TareaDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CatalogoValorDTO getEstadotarea() {
        return estadotarea;
    }

    public void setEstadotarea(CatalogoValorDTO estadotarea) {
        this.estadotarea = estadotarea;
    }

    public ProyectoDTO getProyecto() {
        return proyectoDTO;
    }

    public void setProyecto(ProyectoDTO proyectoDTO) {
        this.proyectoDTO = proyectoDTO;
    }

    public TipoTareaDTO getTipotarea() {
        return tipotarea;
    }

    public void setTipotarea(TipoTareaDTO tipotarea) {
        this.tipotarea = tipotarea;
    }

    public UsuarioDTO getUsuarioasignado() {
        return usuarioasignado;
    }

    public void setUsuarioasignado(UsuarioDTO usuarioasignado) {
        this.usuarioasignado = usuarioasignado;
    }

    public UsuarioDTO getUsuarioasignador() {
        return usuarioasignador;
    }

    public void setUsuarioasignador(UsuarioDTO usuarioasignador) {
        this.usuarioasignador = usuarioasignador;
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

    public Collection<HistorialTareaDTO> getHistorialTareaCollection() {
        return historialTareaCollection;
    }

    public void setHistorialTareaCollection(Collection<HistorialTareaDTO> historialTareaCollection) {
        this.historialTareaCollection = historialTareaCollection;
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
        if (!(object instanceof TareaDTO)) {
            return false;
        }
        TareaDTO other = (TareaDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TareaDTO[ id=" + id + " ]";
    }

	public UsuarioDTO getRevisor() {
		return revisor;
	}

	public void setRevisor(UsuarioDTO revisor) {
		this.revisor = revisor;
	}

    
}
