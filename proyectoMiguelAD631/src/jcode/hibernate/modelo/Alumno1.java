package jcode.hibernate.modelo;
// Generated 20-nov-2013 12:23:54 by Hibernate Tools 3.2.1.GA



/**
 * Alumno1 generated by hbm2java
 */
public class Alumno1  implements java.io.Serializable {


     private Long idAlumno;
     private String acceso;
     private String apellidos;
     private String dni;
     private String domicilio;
     private String nombre;
     private String telefono;

    public Alumno1() {
    }

    public Alumno1(String acceso, String apellidos, String dni, String domicilio, String nombre, String telefono) {
       this.acceso = acceso;
       this.apellidos = apellidos;
       this.dni = dni;
       this.domicilio = domicilio;
       this.nombre = nombre;
       this.telefono = telefono;
    }
   
    public Long getIdAlumno() {
        return this.idAlumno;
    }
    
    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }
    public String getAcceso() {
        return this.acceso;
    }
    
    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }




}


