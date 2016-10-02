package vistas;

import java.awt.*;
import javax.swing.*;

//CLASE QUE PERMITE INTRODUCIR IMAGEN DE FONDO A VENTANAPRINCIPAL


@SuppressWarnings("serial")
public class PanelFondo extends javax.swing.JPanel 
{

  public PanelFondo() 
  {
      initComponents();
      this.setSize(770,550);
  }
  
  public void paintComponent(Graphics g)
  {
      Dimension tam=getSize();
      ImageIcon ImagenFondo = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/fondoverde.jpg")).getImage());
      g.drawImage(ImagenFondo.getImage(), 0, 0, tam.width,tam.height,null);
      setOpaque(false);
      super.paintComponent(g);
  }
  
  private void initComponents() {

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGap(0, 1050, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGap(0, 900, Short.MAX_VALUE)
      );
  }
}