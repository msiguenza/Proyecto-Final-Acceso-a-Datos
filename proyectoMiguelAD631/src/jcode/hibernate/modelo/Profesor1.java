package jcode.hibernate.modelo;
// Generated 20-nov-2013 12:23:54 by Hibernate Tools 3.2.1.GA


/**
 * Profesor1 generated by hbm2java
 */
public class Profesor1  implements java.io.Serializable {


     private Long idProfesor;
     private long idSupervisor;
     private String apellidos;
     private String dni;
     private String domicilio;
     private String nombre;
     private String telefono;

    public Profesor1() {
    }

	
    public Profesor1(long idSupervisor) {
        this.idSupervisor = idSupervisor;
    }
    public Profesor1(long idSupervisor, String apellidos, String dni, String domicilio, String nombre, String telefono) {
       this.idSupervisor = idSupervisor;
       this.apellidos = apellidos;
       this.dni = dni;
       this.domicilio = domicilio;
       this.nombre = nombre;
       this.telefono = telefono;
    }
   
    public Long getIdProfesor() {
        return this.idProfesor;
    }
    
    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }
    public long getIdSupervisor() {
        return this.idSupervisor;
    }
    
    public void setIdSupervisor(long idSupervisor) {
        this.idSupervisor = idSupervisor;
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


