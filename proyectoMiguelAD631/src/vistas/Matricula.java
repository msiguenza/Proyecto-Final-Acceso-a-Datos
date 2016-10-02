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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Migue
 */
@Entity
@Table(name = "matricula", catalog = "facultad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByIdMatricula", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.idMatricula = :idMatricula"),
    @NamedQuery(name = "Matricula.findByIdAlumno", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.idAlumno = :idAlumno"),
    @NamedQuery(name = "Matricula.findByIdAsignatura", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Matricula.findByNota", query = "SELECT m FROM Matricula m WHERE m.nota = :nota")})
public class Matricula implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaPK matriculaPK = new MatriculaPK();
    @Basic(optional = false)
    @Column(name = "nota")
    private String nota;

    public Matricula() {
    }

    public Matricula(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Matricula(MatriculaPK matriculaPK, String nota) {
        this.matriculaPK = matriculaPK;
        this.nota = nota;
    }

    public Matricula(int idMatricula, String idAlumno, int idAsignatura) {
        this.matriculaPK = new MatriculaPK(idMatricula, idAlumno, idAsignatura);
    }

    public MatriculaPK getMatriculaPK() {
        return matriculaPK;
    }

    public void setMatriculaPK(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        String oldNota = this.nota;
        this.nota = nota;
        changeSupport.firePropertyChange("nota", oldNota, nota);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaPK != null ? matriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.matriculaPK == null && other.matriculaPK != null) || (this.matriculaPK != null && !this.matriculaPK.equals(other.matriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vistas.Matricula[ matriculaPK=" + matriculaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
