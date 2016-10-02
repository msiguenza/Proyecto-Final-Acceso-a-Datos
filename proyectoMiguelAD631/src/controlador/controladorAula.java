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
import jcode.hibernate.modelo.Aula1;
import vistas.VistaRegistro;
import vistas.tablaAulas;

/**
 *
 * @author Silvia
 */
public class controladorAula implements ActionListener
{
     VistaRegistro vr=new VistaRegistro();
     tablaAulas ta=new tablaAulas();
     InsertarDatos id=new InsertarDatos();
     Aula1 a=new Aula1();
     ModificarDatos md=new ModificarDatos();
     boolean comprobado=false;
    
    public controladorAula(VistaRegistro vrr, tablaAulas taa)
    {
	this.vr=vrr;
        this.ta=taa;
    }
    
    
    
    public void iniciar()
    {
        vr.btnAceptarInsertarAula.setActionCommand("boton insertar aula");
        vr.btnAceptarInsertarAula.addActionListener(this);
        
        ta.btnModificar.setActionCommand("boton modificar");
        ta.btnModificar.addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String s=e.getActionCommand();
        
        if(s.equals("boton insertar aula"))
        {
            String nombreEdificio=vr.textNombreEdificio.getText();
            String nAula=vr.textnAula.getText();
            
            if(vr.textNombreEdificio.getText().equals("") || vr.textnAula.getText().equals(""))
            {
                comprobado=true;
            }
            
            else
            {
                comprobado=false;
            }
            
            if(comprobado)
            {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
            
            else if(!comprobado)
            {
                id.insertarAula(nombreEdificio, nAula);
                JOptionPane.showMessageDialog(null, "Registro correcto");
                
                vr.textNombreEdificio.setText("");
                vr.textnAula.setText("");
            }
        }
        
        
        
        else if(s.equals("boton modificar"))
        {
            int filaSelec = 0;
	    String nombreEdificio="", nAula = "";
            int idAula;
            int resp = 0;
            
            try 
            {
                filaSelec = ta.jTableAulas.getSelectedRow();
				
		if (filaSelec == -1) 
		{
			JOptionPane.showMessageDialog(null, "Debe seleccionar el aula que desea modificar");
		}

		else 
		{
			resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar el aula seleccionada?",
			"Modificar", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) 
			{
				TableModel dtm = ta.jTableAulas.getModel();
                                
				idAula= (int) dtm.getValueAt(filaSelec, 0);
				//a.setIdAlumno1(idAlumno);
						
				nombreEdificio= (String) dtm.getValueAt(filaSelec, 1);
				a.setNombreEdificio(nombreEdificio);
						
				nAula = (String) dtm.getValueAt(filaSelec, 2);
				a.setNaula(nAula);
						
				md.ModificarAula(idAula, nombreEdificio, nAula);
				JOptionPane.showMessageDialog(null, "Aula modificada correctamente");
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
