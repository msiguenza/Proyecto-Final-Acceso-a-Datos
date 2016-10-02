/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hibernate.FacultadFactory;
import hibernate.InsertarDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vistas.VistaRegistro;

/**
 *
 * @author Silvia
 */
public class controladorImparte implements ActionListener
{
    VistaRegistro vr=new VistaRegistro();
    InsertarDatos id=new InsertarDatos();
    String consulta="", consulta1="";
    Session session = null;
    
    private static SessionFactory sessionFactory = null;
    Query q, q1;
    List<String> resultado;
    List<String> resultado1;
    
    public controladorImparte(VistaRegistro vrr)
    {
        this.vr=vrr;
    }
    
    public void iniciar()
    {
        vr.btnAceptarImparte.setActionCommand("boton insertar imparte");
        vr.btnAceptarImparte.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       String s=e.getActionCommand();
       
       if(s.equals("boton insertar imparte"))
       {
           int filaSelecPro=0, filaSelecAsig=0, filaSelecAula=0;
           
           filaSelecPro = vr.jTableProfesores.getSelectedRow();
           filaSelecAsig = vr.jTableAsignaturas.getSelectedRow();
           filaSelecAula = vr.jTableAulas.getSelectedRow();
           
           if(filaSelecPro == -1 || filaSelecAsig == -1 || filaSelecAula == -1)
           {
               JOptionPane.showMessageDialog(null, "Tiene que seleccionar una fila de cada tabla");
           }
           
           else
           {
               TableModel dtmPro = vr.jTableProfesores.getModel();
               TableModel dtmAsig = vr.jTableAsignaturas.getModel();
               TableModel dtmAula = vr.jTableAulas.getModel();
               
               String tituloAsignatura=dtmAsig.getValueAt(filaSelecAsig, 1).toString();
               String nombreProfesor=dtmPro.getValueAt(filaSelecPro, 2).toString();
               String nAula1=dtmAula.getValueAt(filaSelecAula, 0).toString();
               
               int nAula=Integer.parseInt(nAula1);
               
               int contador=0;
              
                
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
                
                consulta="select nombreProfesor from Imparte where nombreProfesor='";
                consulta=consulta+(nombreProfesor) + "'";
                
                q=session.createQuery(consulta);
       
                resultado = new ArrayList<String>();
                resultado=q.list();
                
                
                boolean maximo=false;
        
                  for(int i=0; i<resultado.size(); i++)
                  {
                      String numero=String.valueOf(resultado.get(i));
                      
                      //VAMOS COMPROBANDO LOS RESULTADOS PARA VER SI COINCIDEN
                      if(numero.equals(nombreProfesor))
                      {
                          contador++;
                      }
                  }
                  
                  //SI EL PROFESOR YA HA LLEGADO AL NUMERO MAXIMO DE ASIGNATURAS QUE PUEDE IMPARTIR NO
                  //SE PERMITE EL REGISTRO Y SE AVISA AL USUARIO
                  
                  if(contador==5)
                  {
                      maximo=true;
                  }
                  
                  if(maximo)
                  {
                       JOptionPane.showMessageDialog(null, "Este profesor ya ha llegado al numero de asignaturas que puede impartir");
                  }
                  
                  else if(!maximo)
                  {
                      consulta="select nombreProfesor from Imparte where nombreProfesor='";
                      consulta=consulta+(nombreProfesor) + "'";
                      
                      consulta1="select tituloAsignatura from Imparte where tituloAsignatura='";
                      consulta1=consulta1+(tituloAsignatura)+"'";
                      
                      System.out.println(consulta1+"CONSULTAAAAAAA");
                      
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
                          if(numero.equals(nombreProfesor))
                          {
                              encontrado=true;
                          }
                      }
                      
                      for(int j=0; j<resultado1.size(); j++)
                      {
                          String tituloEncontrado=resultado1.get(j);

                          //VAMOS COMPROBANDO LOS RESULTADOS PARA VER SI COINCIDEN
                          if(tituloEncontrado.equals(tituloAsignatura))
                          {
                              encontrado1=true;
                          }
                      }
                      
                      if(encontrado && encontrado1)
                      {
                          JOptionPane.showMessageDialog(null, "Este profesor ya imparte esta asignatura");
                      }
                      
                      else
                      {
                        id.insertarImparte(tituloAsignatura, nombreProfesor, nAula);
                        JOptionPane.showMessageDialog(null, "Registro correcto");
                      }
                  }
           }
       }
    }
    
    
}
