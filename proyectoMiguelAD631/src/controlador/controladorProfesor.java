/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import hibernate.InsertarDatos;
import hibernate.ModificarDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import jcode.hibernate.modelo.Profesor1;
import vistas.VistaRegistro;
import vistas.tablaProfesor;

/**
 *
 * @author Silvia
 */
public class controladorProfesor implements ActionListener
{
    VistaRegistro vr=new VistaRegistro();
    InsertarDatos id=new InsertarDatos();
    tablaProfesor tp=new tablaProfesor();
    Profesor1 a=new Profesor1();
    ModificarDatos md=new ModificarDatos();
    boolean comprobado=false;
    
    public controladorProfesor(VistaRegistro vrr, tablaProfesor tpp)
    {
	this.vr=vrr;
        this.tp=tpp;
    }
    
    public void iniciar()
    {
        vr.btnAceptarProfesor.setActionCommand("boton insertar profesor");
        vr.btnAceptarProfesor.addActionListener(this);
        
        tp.btnModificar.setActionCommand("boton modificar profesor");
        tp.btnModificar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        
        if(s.equals("boton insertar profesor"))
        {
            String dni=vr.textDni1.getText();
            String nombre=vr.textNombre1.getText();
            String apellidos=vr.textApellidos1.getText();
            String domicilio=vr.textDomicilio1.getText();
            String telefono=vr.textTelefono1.getText();
            
            if((dni.equals("") || nombre.equals("") || apellidos.equals("") || domicilio.equals("")) || telefono.equals(""))
            {
                comprobado=true;
            }
            
            else
            {
                comprobado=false;
            }
            
            if(!comprobado)
            {
                id.insertarProfesor(dni, nombre, apellidos, domicilio, telefono);
                JOptionPane.showMessageDialog(null, "Registro correcto");
                
                vr.textDni1.setText("");
                vr.textNombre1.setText("");
                vr.textApellidos1.setText("");
                vr.textDomicilio1.setText("");
                vr.textTelefono1.setText("");
            }
            
            
            else if(comprobado)
            {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
            
        }
        
        
        
        
        else if(s.equals("boton modificar profesor"))
        {
            int filaSelec = 0;
	    String dni="", nombre = "", apellidos="", domicilio="", telefono="";
            int resp = 0;
            long idProfesor;
            
            try 
            {
                filaSelec = tp.jTableProfesores.getSelectedRow();
				
		if (filaSelec == -1) 
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar el profesor que desea modificar");
		}

		else 
		{
			resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar el profesor seleccionado?",
			"Modificar", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) 
			{
				TableModel dtm = tp.jTableProfesores.getModel();
				
                                
				idProfesor= (long) dtm.getValueAt(filaSelec, 0);
				//a.setIdAlumno1(idAlumno);
						
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
						
				md.ModificarProfesor(idProfesor, dni, nombre, apellidos, domicilio, telefono);
				JOptionPane.showMessageDialog(null, "Profesor modificado correctamente");
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
