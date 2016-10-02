/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import jcode.hibernate.modelo.Alumno1;
import jcode.hibernate.modelo.Asignatura1;
import jcode.hibernate.modelo.Aula1;
import jcode.hibernate.modelo.Matricula1;
import jcode.hibernate.modelo.MatriculaId;
import jcode.hibernate.modelo.Profesor1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vistas.VistaRegistro;

/**
 *
 * @author Migue
 */
public class ModificarDatos 
{
     private static SessionFactory sessionFactory = null;
     
      Session session = null;
      VistaRegistro vista=new VistaRegistro();
      
      
      /************************************************************************************************************************
      *************************************************MODIFICAR ALUMNOS*******************************************************
      ************************************************************************************************************************/
      
      public void ModificarAlumno(long idAlumno, String dni, String nombre, String apellidos, String domicilio, String telefono, String acceso)
      {
          try 
          {
            try 
            {
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro");
                Transaction tx = session.beginTransaction();
                
                //Creando un Objeto
                Alumno1 alumno = new Alumno1();
                alumno.setIdAlumno(idAlumno);
                alumno.setDni(dni);
                alumno.setNombre(nombre);
                alumno.setApellidos(apellidos);
                alumno.setDomicilio(domicilio);
                alumno.setTelefono(telefono);
                
                if(acceso.equals("Selectividad"))
                {
                    alumno.setAcceso("Selectividad");
                }
                
                else if(acceso.equals("Acceso mayores 25 años"))
                {
                    alumno.setAcceso("Acceso mayores 25 años");
                }
                
                //Guardando
                session.update(alumno);
                tx.commit();
                System.out.println("Finalizado...");
            } 
            
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        } 
        
        finally 
        {
            session.close();
        }
    }
      
      
      
      public void ModificarAsignatura(int idAsignatura, String titulo, String nCreditos)
      {
          try 
          {
            try 
            {
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro");
                Transaction tx = session.beginTransaction();
                
                //Creando un Objeto
                Asignatura1 asignatura = new Asignatura1();
                asignatura.setIdAsignatura(idAsignatura);
                asignatura.setTitulo(titulo);
                asignatura.setNcreditos(nCreditos);
                
                //Guardando
                session.update(asignatura);
                tx.commit();
                System.out.println("Finalizado...");
            } 
            
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        } 
        
        finally 
        {
            session.close();
        }
    }
      
      
      /************************************************************************************************************************
      *************************************************MODIFICAR PROFESOR*******************************************************
      ************************************************************************************************************************/
      
      public void ModificarProfesor(long idProfesor, String dni, String nombre, String apellidos, String domicilio, String telefono)
      {
          try 
          {
            try 
            {
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro");
                Transaction tx = session.beginTransaction();
                
                //Creando un Objeto
                Profesor1 profesor = new Profesor1();
                profesor.setIdProfesor(idProfesor);
                profesor.setDni(dni);
                profesor.setNombre(nombre);
                profesor.setApellidos(apellidos);
                profesor.setDomicilio(domicilio);
                profesor.setTelefono(telefono);
                                
                //Guardando
                session.update(profesor);
                tx.commit();
                System.out.println("Finalizado...");
            } 
            
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        } 
        
        finally 
        {
            session.close();
        }
    }
      
      
      
       public void ModificarAula(int idAula, String nombreEdificio, String nAula)
      {
          try 
          {
            try 
            {
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro");
                Transaction tx = session.beginTransaction();
                
                //Creando un Objeto
                Aula1 aula = new Aula1();
                aula.setIdAula(idAula);
                aula.setNombreEdificio(nombreEdificio);
                aula.setNaula(nAula);
                
                //Guardando
                session.update(aula);
                tx.commit();
                System.out.println("Finalizado...");
            } 
            
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        } 
        
        finally 
        {
            session.close();
        }
    }
       
       
       
       
      public void ModificarMatricula(int idMatricula, String idAlumno, int idAsignatura, String nota)
      {
          try 
          {
            try 
            {
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro");
                Transaction tx = session.beginTransaction();
                
                //Creando un Objeto
                Matricula1 matricula = new Matricula1();
                matricula.getId().setIdMatricula(idMatricula);
                matricula.getId().setIdAlumno(idAlumno);
                matricula.getId().setIdAsignatura(idAsignatura);
                matricula.setNota(nota);
                
                //Guardando
                session.update(matricula);
                tx.commit();
                System.out.println("Finalizado...");
            } 
            
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        } 
        
        finally 
        {
            session.close();
        }
    }
}
