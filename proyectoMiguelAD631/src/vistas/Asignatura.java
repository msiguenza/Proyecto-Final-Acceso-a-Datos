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
@Table(name = "asignatura", catalog = "facultad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a"),
    @NamedQuery(name = "Asignatura.findByIdAsignatura", query = "SELECT a FROM Asignatura a WHERE a.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Asignatura.findByTitulo", query = "SELECT a FROM Asignatura a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Asignatura.findByNCreditos", query = "SELECT a FROM Asignatura a WHERE a.nCreditos = :nCreditos"),
    @NamedQuery(name = "Asignatura.findByIdProfesor", query = "SELECT a FROM Asignatura a WHERE a.idProfesor = :idProfesor"),
    @NamedQuery(name = "Asignatura.findByAulaidAula", query = "SELECT a FROM Asignatura a WHERE a.aulaidAula = :aulaidAula")})
public class Asignatura implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAsignatura")
    private Integer idAsignatura;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "nCreditos")
    private String nCreditos;
    @Basic(optional = false)
    @Column(name = "idProfesor")
    private int idProfesor;
    @Basic(optional = false)
    @Column(name = "aula_idAula")
    private int aulaidAula;

    public Asignatura() {
    }

    public Asignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Asignatura(Integer idAsignatura, int idProfesor, int aulaidAula) {
        this.idAsignatura = idAsignatura;
        this.idProfesor = idProfesor;
        this.aulaidAula = aulaidAula;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        Integer oldIdAsignatura = this.idAsignatura;
        this.idAsignatura = idAsignatura;
        changeSupport.firePropertyChange("idAsignatura", oldIdAsignatura, idAsignatura);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        changeSupport.firePropertyChange("titulo", oldTitulo, titulo);
    }

    public String getNCreditos() {
        return nCreditos;
    }

    public void setNCreditos(String nCreditos) {
        String oldNCreditos = this.nCreditos;
        this.nCreditos = nCreditos;
        changeSupport.firePropertyChange("NCreditos", oldNCreditos, nCreditos);
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        int oldIdProfesor = this.idProfesor;
        this.idProfesor = idProfesor;
        changeSupport.firePropertyChange("idProfesor", oldIdProfesor, idProfesor);
    }

    public int getAulaidAula() {
        return aulaidAula;
    }

    public void setAulaidAula(int aulaidAula) {
        int oldAulaidAula = this.aulaidAula;
        this.aulaidAula = aulaidAula;
        changeSupport.firePropertyChange("aulaidAula", oldAulaidAula, aulaidAula);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vistas.Asignatura[ idAsignatura=" + idAsignatura + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
