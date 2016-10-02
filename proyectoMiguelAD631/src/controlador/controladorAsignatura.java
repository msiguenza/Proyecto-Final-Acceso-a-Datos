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
import jcode.hibernate.modelo.Asignatura1;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import vistas.VistaRegistro;
import vistas.tablaAsignaturas;

/**
 *
 * @author Silvia
 */
public class controladorAsignatura implements ActionListener
{
    
     VistaRegistro vr=new VistaRegistro();
     tablaAsignaturas ta=new tablaAsignaturas();
     InsertarDatos id=new InsertarDatos();
     Asignatura1 a=new Asignatura1();
     ModificarDatos md=new ModificarDatos();
     boolean comprobado=false;
     private static SessionFactory sessionFactory = null;
     boolean encontrado=false;
     
    
     public controladorAsignatura(VistaRegistro vrr, tablaAsignaturas taa)
     {
        this.vr=vrr;
        this.ta=taa;
     }
     
    
    
    public void iniciar()
    {
        vr.btnAceptarAsignatura.setActionCommand("boton insertar asignatura");
        vr.btnAceptarAsignatura.addActionListener(this);
        
        ta.btnModificar.setActionCommand("boton modificar");
        ta.btnModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        
        if(s.equals("boton insertar asignatura"))
        {
            String titulo=vr.textTitulo.getText();
            String nCredito=vr.textNCredito.getText();
                
                //HACEMOS UNA CONSULTA PARA SABER SI YA HAY REGISTRADA ALGUNA ASIGNATURA CON ESE TITULO
                
                Session session = null;
                sessionFactory = FacultadFactory.getSessionFactory();
                session = sessionFactory.openSession();
                
                 String consulta="select titulo from Asignatura1";
                 Query q=session.createQuery(consulta);
       
                 List<String> resultado = new ArrayList<String>();
                 resultado=q.list();
        
                  for(int i=0; i<resultado.size(); i++)
                  {
                      //VAMOS COMPROBANDO LOS RESULTADOS PARA VER SI COINCIDEN
                      
                      if(resultado.get(i).equals(titulo))
                      {
                          comprobado=true;
                      }
                  }
                  
                if(titulo.equals("") || nCredito.equals(""))
                {
                    encontrado=true;
                }
                
                else
                {
                    encontrado=false;
                }
                  
            if(comprobado)
            {
                JOptionPane.showMessageDialog(null, "Esta asignatura ya está registrada");
            }
            
            if(encontrado)
            {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
            
            if(!comprobado && !encontrado)
            {
                id.insertarAsignatura(titulo, nCredito);

                vr.textTitulo.setText("");
                vr.textNCredito.setText("");

                JOptionPane.showMessageDialog(null, "Asignatura registrada correctamente");
            }
        }
        
        
        
        
        else if(s.equals("boton modificar"))
        {
            int filaSelec = 0;
	    String titulo="", nCreditos = "";
            int idAsignatura;
            int resp = 0;
            
            try 
            {
                filaSelec = ta.jTableAsignaturas.getSelectedRow();
				
		if (filaSelec == -1) 
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar la asignatura que desea modificar");
		}

		else 
		{
			resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar la asignatura seleccionada?",
			"Modificar", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) 
			{
				TableModel dtm = ta.jTableAsignaturas.getModel();
                                
				idAsignatura= (int) dtm.getValueAt(filaSelec, 0);
				//a.setIdAlumno1(idAlumno);
						
				titulo= (String) dtm.getValueAt(filaSelec, 1);
				a.setTitulo(titulo);
						
				nCreditos = (String) dtm.getValueAt(filaSelec, 2);
				a.setNcreditos(nCreditos);
						
				md.ModificarAsignatura(idAsignatura, titulo, nCreditos);
				JOptionPane.showMessageDialog(null, "Asignatura modificada correctamente");
			}
		}
	}

	catch (Exception e1) 
	{
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: no se ha podido modificar correctamente");
	}
      }
    }
}
