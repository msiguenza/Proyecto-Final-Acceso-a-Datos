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
@Table(name = "alumno", catalog = "facultad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdAlumno", query = "SELECT a FROM Alumno a WHERE a.idAlumno = :idAlumno"),
    @NamedQuery(name = "Alumno.findByAcceso", query = "SELECT a FROM Alumno a WHERE a.acceso = :acceso"),
    @NamedQuery(name = "Alumno.findByApellidos", query = "SELECT a FROM Alumno a WHERE a.apellidos = :apellidos"),
    @NamedQuery(name = "Alumno.findByDni", query = "SELECT a FROM Alumno a WHERE a.dni = :dni"),
    @NamedQuery(name = "Alumno.findByDomicilio", query = "SELECT a FROM Alumno a WHERE a.domicilio = :domicilio"),
    @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alumno.findByTelefono", query = "SELECT a FROM Alumno a WHERE a.telefono = :telefono")})
public class Alumno implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlumno")
    private Long idAlumno;
    @Column(name = "acceso")
    private String acceso;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "dni")
    private String dni;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono")
    private String telefono;

    public Alumno() {
    }

    public Alumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        Long oldIdAlumno = this.idAlumno;
        this.idAlumno = idAlumno;
        changeSupport.firePropertyChange("idAlumno", oldIdAlumno, idAlumno);
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        String oldAcceso = this.acceso;
        this.acceso = acceso;
        changeSupport.firePropertyChange("acceso", oldAcceso, acceso);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        String oldApellidos = this.apellidos;
        this.apellidos = apellidos;
        changeSupport.firePropertyChange("apellidos", oldApellidos, apellidos);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        String oldDni = this.dni;
        this.dni = dni;
        changeSupport.firePropertyChange("dni", oldDni, dni);
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        String oldDomicilio = this.domicilio;
        this.domicilio = domicilio;
        changeSupport.firePropertyChange("domicilio", oldDomicilio, domicilio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        String oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vistas.Alumno[ idAlumno=" + idAlumno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
