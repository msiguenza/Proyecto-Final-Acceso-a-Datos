/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Migue
 */
@Embeddable
public class MatriculaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idMatricula")
    private int idMatricula;
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private String idAlumno;
    @Basic(optional = false)
    @Column(name = "idAsignatura")
    private int idAsignatura;

    public MatriculaPK() {
    }

    public MatriculaPK(int idMatricula, String idAlumno, int idAsignatura) {
        this.idMatricula = idMatricula;
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMatricula;
        //hash += (String) idAlumno;
        hash += (int) idAsignatura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculaPK)) {
            return false;
        }
        MatriculaPK other = (MatriculaPK) object;
        if (this.idMatricula != other.idMatricula) {
            return false;
        }
        if (this.idAlumno != other.idAlumno) {
            return false;
        }
        if (this.idAsignatura != other.idAsignatura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vistas.MatriculaPK[ idMatricula=" + idMatricula + ", idAlumno=" + idAlumno + ", idAsignatura=" + idAsignatura + " ]";
    }
    
}
