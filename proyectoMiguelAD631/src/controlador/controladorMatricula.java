/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hibernate.FacultadFactory;
import hibernate.InsertarDatos;
import hibernate.ModificarDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import jcode.hibernate.modelo.Matricula1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vistas.VerMatriculas;
import vistas.VistaMatricular;
import vistas.VistaRegistro;

/**
 *
 * @author Silvia
 */
public class controladorMatricula implements ActionListener
{
     VistaRegistro vr=new VistaRegistro();
     VerMatriculas vm=new VerMatriculas();
     InsertarDatos id=new InsertarDatos();
     Matricula1 a=new Matricula1();
     ModificarDatos md=new ModificarDatos();
     VistaMatricular vista=new VistaMatricular();
     
    private static SessionFactory sessionFactory = null;
    Query q, q1;
    List<String> resultado;
    List<String> resultado1;
    Session session = null;
    boolean encontrado=false;
    
     public controladorMatricula(VistaRegistro vrr, VerMatriculas vmm)
    {
	this.vr=vrr;
        this.vm=vmm;
    }
     
    
     
     public void iniciar()
     {        
        vista.btnMatricular.setActionCommand("boton matricular");
        vista.btnMatricular.addActionListener(this);
     }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       String s=e.getActionCommand();
 
       if(s.equals("boton matricular"))
       {
            int filaSelecAlu=0, filaSelecAsig=0;
            
            if(filaSelecAlu == -1 || filaSelecAsig == -1)
            {
                JOptionPane.showMessageDialog(null, "Tiene que seleccionar el alumno y la asignatura que desea matricular");
            }
            
            else
            {
               TableModel dtmAlu = vista.jTableAlumnos.getModel();
               TableModel dtmAsig = vista.jTableAsignaturas.getModel();
               
               String idAsignatura1=dtmAsig.getValueAt(filaSelecAsig, 2).toString();
               int idAsignatura=Integer.parseInt(idAsignatura1);
               
               String dniAlumno=dtmAlu.getValueAt(filaSelecAlu, 1).toString();
               
               String nota=vista.txtNota.getText();
               
               sessionFactory = FacultadFactory.getSessionFactory();
               session = sessionFactory.openSession();
                
                String consulta="select idAlumno from Matricula1 where idAlumno='";
                consulta=consulta+(dniAlumno) + "'";
                      
                String consulta1="select idAsignatura from Matricula1 where idAsignatura='";
                consulta1=consulta1+(idAsignatura)+"'";
                      
                      q=session.createQuery(consulta);
                      q1=session.createQuery(consulta1);
       
                      resultado = new ArrayList<String>();
                      resultado=q.list();
                      
                      resultado1=new ArrayList<String>();
                      resultado1=q1.list();
                      
                      
                      boolean encontrado=false, encontrado1=false;

                      for(int i=0; i<resultado.size(); i++)
                      {
                          String numero=String.valueOf(resultado.get(i));

                          //VAMOS COMPROBANDO LOS RESULTADOS PARA VER SI COINCIDEN
                          if(numero.equals(dniAlumno))
                          {
                              encontrado=true;
                          }
                      }
                      
                      for(int j=0; j<resultado1.size(); j++)
                      {
                          String tituloEncontrado=resultado1.get(j);

                          //VAMOS COMPROBANDO LOS RESULTADOS PARA VER SI COINCIDEN
                          if(tituloEncontrado.equals(idAsignatura))
                          {
                              encontrado1=true;
                          }
                      }
                      
                      if(encontrado && encontrado1)
                      {
                          JOptionPane.showMessageDialog(null, "Este alumno ya esta matriculado en esta asignatura");
                      }
                      
                      else
                      {
                        id.insertarMatricula(dniAlumno, idAsignatura, nota);
                        JOptionPane.showMessageDialog(null, "Registro correcto");
                      }
                  }
       }
    }
}
