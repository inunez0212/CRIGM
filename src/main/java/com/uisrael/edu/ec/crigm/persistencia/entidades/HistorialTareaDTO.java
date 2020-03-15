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
 * @author David Alvarez
 */
@Entity
@Table(name = "historialtarea")
@NamedQueries({
    @NamedQuery(name = "HistorialTareaDTO.findAll", query = "SELECT h FROM HistorialTareaDTO h")})
public class HistorialTareaDTO implements Serializable {

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
    
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    
    @Column(name = "fechamodificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    
    @JoinColumn(name = "estadoinicio", referencedColumnName = "codigoreferencia")
    @ManyToOne
    private CatalogoValorDTO estadoInicio;
    
    @JoinColumn(name = "estadofin", referencedColumnName = "codigoreferencia")
    @ManyToOne
    private CatalogoValorDTO estadoFin;
    
    @JoinColumn(name = "causal", referencedColumnName = "codigoreferencia")
    @ManyToOne
    private CatalogoValorDTO causal;
    
    @JoinColumn(name = "tareaDTO", referencedColumnName = "id")
    @ManyToOne
    private TareaDTO tareaDTO;

    @JoinColumn(name = "usuariomodificacion", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuariomodificacion;

    @JoinColumn(name = "usuarioregistro", referencedColumnName = "id")
    @ManyToOne
    private UsuarioDTO usuarioregistro;

    public HistorialTareaDTO() {
    }

    public HistorialTareaDTO(Integer id) {
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

    public CatalogoValorDTO getCausal() {
        return causal;
    }

    public void setCausal(CatalogoValorDTO causal) {
        this.causal = causal;
    }

    public TareaDTO getTarea() {
        return tareaDTO;
    }

    public void setTarea(TareaDTO tareaDTO) {
        this.tareaDTO = tareaDTO;
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

    
    /**
	 * @return the estadoInicio
	 */
	public CatalogoValorDTO getEstadoInicio() {
		return estadoInicio;
	}

	/**
	 * @param estadoInicio the estadoInicio to set
	 */
	public void setEstadoInicio(CatalogoValorDTO estadoInicio) {
		this.estadoInicio = estadoInicio;
	}

	/**
	 * @return the estadoFin
	 */
	public CatalogoValorDTO getEstadoFin() {
		return estadoFin;
	}

	/**
	 * @param estadoFin the estadoFin to set
	 */
	public void setEstadoFin(CatalogoValorDTO estadoFin) {
		this.estadoFin = estadoFin;
	}

	/**
	 * @return the tareaDTO
	 */
	public TareaDTO getTareaDTO() {
		return tareaDTO;
	}

	/**
	 * @param tareaDTO the tareaDTO to set
	 */
	public void setTareaDTO(TareaDTO tareaDTO) {
		this.tareaDTO = tareaDTO;
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
        if (!(object instanceof HistorialTareaDTO)) {
            return false;
        }
        HistorialTareaDTO other = (HistorialTareaDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.HistorialTareaDTO[ id=" + id + " ]";
    }
    
}
