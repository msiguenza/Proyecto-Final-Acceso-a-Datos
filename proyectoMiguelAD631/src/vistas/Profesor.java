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
 * @author Silvia
 */
@Entity
@Table(name = "profesor", catalog = "facultad", schema = "")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdProfesor", query = "SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor"),
    @NamedQuery(name = "Profesor.findByIdSupervisor", query = "SELECT p FROM Profesor p WHERE p.idSupervisor = :idSupervisor"),
    @NamedQuery(name = "Profesor.findByApellidos", query = "SELECT p FROM Profesor p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Profesor.findByDni", query = "SELECT p FROM Profesor p WHERE p.dni = :dni"),
    @NamedQuery(name = "Profesor.findByDomicilio", query = "SELECT p FROM Profesor p WHERE p.domicilio = :domicilio"),
    @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesor.findByTelefono", query = "SELECT p FROM Profesor p WHERE p.telefono = :telefono")})
public class Profesor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProfesor")
    private Long idProfesor;
    @Basic(optional = false)
    @Column(name = "idSupervisor")
    private long idSupervisor;
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

    public Profesor() {
    }

    public Profesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor(Long idProfesor, long idSupervisor) {
        this.idProfesor = idProfesor;
        this.idSupervisor = idSupervisor;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        Long oldIdProfesor = this.idProfesor;
        this.idProfesor = idProfesor;
        changeSupport.firePropertyChange("idProfesor", oldIdProfesor, idProfesor);
    }

    public long getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(long idSupervisor) {
        long oldIdSupervisor = this.idSupervisor;
        this.idSupervisor = idSupervisor;
        changeSupport.firePropertyChange("idSupervisor", oldIdSupervisor, idSupervisor);
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
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vistas.Profesor[ idProfesor=" + idProfesor + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
