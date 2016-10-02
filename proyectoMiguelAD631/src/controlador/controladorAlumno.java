/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hibernate.InsertarDatos;
import hibernate.ModificarDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import jcode.hibernate.modelo.Alumno1;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import vistas.VistaRegistro;
import vistas.tablaAlumnos;

/**
 *
 * @author Silvia
 */
public class controladorAlumno implements ActionListener
{
    //DECLARACION DE VARIABLES
    
    VistaRegistro vr=new VistaRegistro();
    InsertarDatos id=new InsertarDatos();
    tablaAlumnos ta=new tablaAlumnos();
    Alumno1 a=new Alumno1();
    ModificarDatos md=new ModificarDatos();
    boolean comprobado=false;
    
    
    private static SessionFactory sessionFactory = null;
    Query q;
    List<String> resultado;
    int filaSelec=0;
    
    public controladorAlumno(VistaRegistro vrr, tablaAlumnos taa)
    {
	this.vr=vrr;
        this.ta=taa;
    }
    
    public void iniciar()
    {
        vr.btnAceptar.setActionCommand("boton insertar alumno");
        vr.btnAceptar.addActionListener(this);
        
       // tm.btnMatricular.setActionCommand("boton matricular");
        //tm.btnMatricular.addActionListener(this);
        
        ta.btnModificar.setActionCommand("boton modificar alumno");
        ta.btnModificar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        
        if(s.equals("boton insertar alumno"))
        {
            //COGEMOS LOS DATOS DE LA INTERFAZ
            
            String dni=vr.textDni.getText();
            String nombre=vr.textNombre.getText();
            String apellidos=vr.textApellido.getText();
            String domicilio=vr.textDomicilio.getText();
            String telefono=vr.textTelefono.getText();
            String nota=vr.textNota.getText();
            
            if(vr.textDni.getText().equals("") || vr.textNombre.getText().equals("") || vr.textNota.getText().equals("")
                    || vr.textDomicilio.getText().equals("") || vr.textTelefono.getText().equals(""))
            {
                comprobado=true;
            }
            
            else
            {
                comprobado=false;
            }

            String acceso=vr.jComboBox1.getSelectedItem().toString();
            
            if(comprobado)
            {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
            
            else if(!comprobado)
            {
                filaSelec=vr.jTableAsignatura1.getSelectedRow();
                
                if(filaSelec == -1)
                {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una asignatura de la tabla");
                }
                
                else
                {
                      TableModel dtm = vr.jTableAsignatura1.getModel();
                      
                      String idAsignatura1=dtm.getValueAt(filaSelec, 0).toString();
                      int idAsignatura=Integer.parseInt(idAsignatura1);
                      
                    id.insertarAlumno(dni, nombre, apellidos, domicilio, telefono, acceso);
                    id.insertarMatricula(dni, idAsignatura, nota);
                    
                    JOptionPane.showMessageDialog(null, "Registro correcto");
                }

                vr.textDni.setText("");
                vr.textNombre.setText("");
                vr.textNota.setText("");
                vr.textDomicilio.setText("");
                vr.textTelefono.setText("");
                vr.textNota.setText("");
            }
        }
        
        
      /************************************************************************************************************************
      *************************************************MATRICULAR ALUMNOS******************************************************
      ************************************************************************************************************************/
        
     /*   else if(s.equals("boton matricular"))
        {
            int filaSelec = 0, filaSelec1=0;
            int idAlumno, idAsignatura, nota;
            boolean correcto=false;

            //COGEMOS LOS DATOS QUE HEMOS SELECCIONADO DE LA TABLA
            
            filaSelec = tm.jTableAlumno.getSelectedRow();
            filaSelec1= tm.jTableAsignatura.getSelectedRow();

            TableModel dtm = tm.jTableAlumno.getModel();
            TableModel dtm1 = tm.jTableAsignatura.getModel();

            //SI NO HAY FILA SELECCIONADA...
            if (filaSelec == -1) 
            {
                    JOptionPane.showMessageDialog(null,"Debe seleccionar el alumno que desea matricular");
                    correcto=true;
            }

            else if(filaSelec1 == -1)
            {
                JOptionPane.showMessageDialog(null,"Debe seleccionar la asignatura en la que desea matricular");
                correcto=true;
            }

            else
            {
                correcto=false;
            }

            if(!correcto)
            {
                idAlumno= (int)dtm.getValueAt(filaSelec, 0);

                idAsignatura=(int)dtm1.getValueAt(filaSelec1, 0);
                
                nota=Integer.parseInt(tm.textNota.getText());
                
                //INVOCAMOS AL METODO EL CUAL COMPROBARA SI ESE ALUMNO ESTA YA MATRICULADO
                //EN ESA ASIGNATURA
                
                id.consultarDatos(idAlumno, idAsignatura, nota);
            }
        }*/
        
        
     /************************************************************************************************************************
      *************************************************MODIFICAR ALUMNOS******************************************************
      ************************************************************************************************************************/        
        
        
        
        else if(s.equals("boton modificar alumno"))
        {
            int filaSelec = 0;
	    String dni="", nombre = "", apellidos="", domicilio="", telefono="", acceso="";
            int resp = 0;
            
            try 
            {
                filaSelec = ta.jTableAlumnos.getSelectedRow();
				
		if (filaSelec == -1) 
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar el alumno que desea modificar");
		}

		else 
		{
			resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar el alumno seleccionado?",
			"Modificar", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) 
			{
				TableModel dtm = ta.jTableAlumnos.getModel();
				long idAlumno1;
                                
				idAlumno1= (long) dtm.getValueAt(filaSelec, 0);
                                
				dni= (String) dtm.getValueAt(filaSelec, 1);
				a.setDni(dni);
						
				nombre = (String) dtm.getValueAt(filaSelec, 2);
				a.setNombre(nombre);
						
				apellidos = (String) dtm.getValueAt(filaSelec, 3);
				a.setApellidos(apellidos);
						
				domicilio=(String) dtm.getValueAt(filaSelec, 4);
				a.setDomicilio(domicilio);
		
				telefono = (String) dtm.getValueAt(filaSelec, 5);
				a.setTelefono(telefono);
                                
                                acceso = (String) dtm.getValueAt(filaSelec, 6);
				a.setAcceso(acceso);
						
				md.ModificarAlumno(idAlumno1, dni, nombre, apellidos, domicilio, telefono, acceso);
				JOptionPane.showMessageDialog(null, "Alumno modificada correctamente");
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
