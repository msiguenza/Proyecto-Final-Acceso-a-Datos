/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Migue
 */
@Entity
@Table(name = "aula", catalog = "facultad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findByIdAula", query = "SELECT a FROM Aula a WHERE a.idAula = :idAula"),
    @NamedQuery(name = "Aula.findByNombreEdificio", query = "SELECT a FROM Aula a WHERE a.nombreEdificio = :nombreEdificio"),
    @NamedQuery(name = "Aula.findByNAula", query = "SELECT a FROM Aula a WHERE a.nAula = :nAula")})
public class Aula implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAula")
    private Integer idAula;
    @Column(name = "nombreEdificio")
    private String nombreEdificio;
    @Column(name = "nAula")
    private String nAula;

    public Aula() {
    }

    public Aula(Integer idAula) {
        this.idAula = idAula;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        Integer oldIdAula = this.idAula;
        this.idAula = idAula;
        changeSupport.firePropertyChange("idAula", oldIdAula, idAula);
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        String oldNombreEdificio = this.nombreEdificio;
        this.nombreEdificio = nombreEdificio;
        changeSupport.firePropertyChange("nombreEdificio", oldNombreEdificio, nombreEdificio);
    }

    public String getNAula() {
        return nAula;
    }

    public void setNAula(String nAula) {
        String oldNAula = this.nAula;
        this.nAula = nAula;
        changeSupport.firePropertyChange("NAula", oldNAula, nAula);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAula != null ? idAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.idAula == null && other.idAula != null) || (this.idAula != null && !this.idAula.equals(other.idAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vistas.Aula[ idAula=" + idAula + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
