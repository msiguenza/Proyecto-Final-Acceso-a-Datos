/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jcode.hibernate.modelo.Alumno1;
import jcode.hibernate.modelo.Asignatura1;
import jcode.hibernate.modelo.Aula1;
import jcode.hibernate.modelo.Imparte;
import jcode.hibernate.modelo.Matricula1;
//import vistas.Matricula1;
import jcode.hibernate.modelo.MatriculaId;
import jcode.hibernate.modelo.Profesor1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vistas.MatriculaPK;
import vistas.VistaRegistro;

/**
 *
 * @author Migue
 */
public class InsertarDatos 
{
     private static SessionFactory sessionFactory = null;
     
      Session session = null, session1=null;
      VistaRegistro vista=new VistaRegistro();
      
      
      /************************************************************************************************************************
      *************************************************INSERTAR ALUMNOS********************************************************
      ************************************************************************************************************************/
      
      public void insertarAlumno(String dni, String nombre, String apellidos, String domicilio, String telefono, String acceso)
      {
          try 
          {
            try 
            {
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro de alumno");
                Transaction tx = session.beginTransaction();
                //Creando un Objeto
                Alumno1 alumno = new Alumno1();
                alumno.setDni(dni);
                alumno.setNombre(nombre);
                alumno.setApellidos(apellidos);
                alumno.setDomicilio(domicilio);
                alumno.setTelefono(telefono);
                
                if(acceso.equals("Selectividad"))
                {
                    alumno.setAcceso("Selectividad");
                }
                
                else if(acceso.equals("Grado Superior"))
                {
                    alumno.setAcceso("Grado Superior");
                }
                
                //Guardando
                session.save(alumno);
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
      *************************************************INSERTAR ASIGNATURAS****************************************************
      ************************************************************************************************************************/
      
     public void insertarAsignatura(String titulo, String nCreditos)
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
                asignatura.setTitulo(titulo);
                asignatura.setNcreditos(nCreditos);
                
                
                //Guardando
                session.save(asignatura);
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
      *************************************************INSERTAR PROFESORES****************************************************
      ************************************************************************************************************************/
     
      public void insertarProfesor(String dni, String nombre, String apellidos, String domicilio, String telefono)
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
                profesor.setDni(dni);
                profesor.setNombre(nombre);
                profesor.setApellidos(apellidos);
                profesor.setDomicilio(domicilio);
                profesor.setTelefono(telefono);
                
                //Guardando
                session.save(profesor);
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
      *************************************************INSERTAR AULAS**********************************************************
      ************************************************************************************************************************/
      
      
           public void insertarAula(String nombreEdificio, String nAula)
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
                      aula.setNombreEdificio(nombreEdificio);
                      aula.setNaula(nAula);

                      //Guardando
                      session.save(aula);
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
      *************************************************MATRICULAR ALUMNOS******************************************************
      ************************************************************************************************************************/
           
          public void matricular(String idAlumno, int idAsignatura, String nota)
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
                      MatriculaId matriculaId=new MatriculaId();
                      
                      matriculaId.setIdAlumno(idAlumno);
                      
                      matriculaId.setIdAsignatura(idAsignatura);
                      matricula.setNota(nota);
                      
                      //Guardando
                      session.save(matricula);
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
          
          
    //METODO QUE COMPRUEBA QUE UN ALUMNO NO ESTE YA MATRICULADO EN ESA ASIGNATURA
          
    public void consultarDatos(String idAlumno, int idAsignatura, String nota)
     {
         boolean encontrado=false;
         
        try 
        {              
              try 
              {
                  sessionFactory = FacultadFactory.getSessionFactory();
                  session = sessionFactory.openSession();
                  
                  //HACEMOS LA CONSULTA QUE NOSE DEVUELVE LOS ID DE LAS ASIGNATURAS DONDE ESTA
                  //MATRICULADO EL ALUMNO QUE QUEREMOS MATRICULAR
                  
                  String consulta="select idAlumno from Matricula where exists (select 1 from Matricula m where m.idAsignatura= ";
                  consulta=consulta+String.valueOf(idAsignatura) + ")";
                  Query q=session.createQuery(consulta);
       
                  List<String> resultado = new ArrayList<String>();
                  resultado=q.list();
        
                  for(int i=0; i<resultado.size(); i++)
                  {
                      //VAMOS COMPROBANDO LOS RESULTADOS PARA VER SI COINCIDEN
                      
                      if(resultado.get(i).equals(idAlumno))
                      {
                          encontrado=true;
                      }
                  }
            
            //SI EL USUARIO ES ENCONTRADO YA ESTA MATRICULADO EN ESA ASIGNATURA
                  
            if(encontrado)
            {
                JOptionPane.showMessageDialog(null, "Este alumno ya está matriculado en esta asignatura");
            }
        
            else if(!encontrado)
            {
                matricular(idAlumno, idAsignatura, nota);
                JOptionPane.showMessageDialog(null, "Matricula realizada correctamente");
            }
        } 

         catch (Exception e) 
         {
              System.out.println(e.getMessage());
              JOptionPane.showMessageDialog(null, "No se ha podido registrar correctamente");
         }
     } 

     finally 
      {
          session.close();
      }
       
   }
    
    
    
    
    
           public void insertarImparte(String tituloAsignatura, String nombreProfesor, int nAula)
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
                      Imparte imparte = new Imparte();
                      imparte.setTituloAsignatura(tituloAsignatura);
                      imparte.setNombreProfesor(nombreProfesor);
                      imparte.setNaula(nAula);

                      //Guardando
                      session.save(imparte);
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
           
           
           
         public void insertarMatricula(String dni, int idAsignatura, String nota)
           {
                  try 
                  {
                      sessionFactory = FacultadFactory.getSessionFactory();
                      session = sessionFactory.openSession();
                      

                      System.out.println("Insertando registro");
                      Transaction tx = session.beginTransaction();
                      System.out.println("1");
                      //Creando un Objeto
                      Matricula1 matricula=new Matricula1();
                      
                      System.out.println("2");
                      matricula.getId().setIdAlumno(dni);
                      System.out.println("3");
                      matricula.getId().setIdAsignatura(idAsignatura);
                      System.out.println("4o");
                      matricula.setNota(nota);
                      
                      System.out.println("DNi"+dni+"idAsignatura"+idAsignatura+"nota"+nota);
                      
                      System.out.println(nota+"NOTAAAAA?????");

                      //Guardando
                      session.save(matricula);
                      System.out.println("ME DESESPEROOOOO");
                      tx.commit();
                      System.out.println("Finalizado...");
                  } 

                  catch (Exception e) 
                  {
                      System.out.println(e.getMessage());
                  }

              finally 
              {
                  session.close();
              }
        }
}
