package Interfaz;

import control.*;
import excepciones.DatosException;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import modeloDatos.FitnessCenter;


public class VentanaPrincipal extends javax.swing.JFrame {
    
    Control gestor;
    
 
    public VentanaPrincipal() throws IOException {
        super("Fitness Center");
        try {       
            gestor = new Control();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"No se encuentra el Fitness Center", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "No se encuentra el Fitness Center", ex);
        } catch (JAXBException ex) {
            JOptionPane.showMessageDialog(this,"Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Ha habido un error", ex);
        }
        initComponents();
        try {
            gestor.cargar("");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"No se encuentra el Fitness Center", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "No se encuentra el Fitness Center", ex);
        } catch (JAXBException ex) {
            JOptionPane.showMessageDialog(this,"NHa habido un error", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Ha habido un error", ex);
        }
        rellenarLista();
        setResizable(false);
        setLocation(250, 250);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMembers = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        btAlta = new javax.swing.JButton();
        btBaja = new javax.swing.JButton();
        btModif = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        labelTel1 = new javax.swing.JLabel();
        labelTel2 = new javax.swing.JLabel();
        labelColor = new javax.swing.JLabel();
        labelSal = new javax.swing.JLabel();
        labelLevel = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        textFieldTel1 = new javax.swing.JTextField();
        textFieldTel2 = new javax.swing.JTextField();
        textFieldColor = new javax.swing.JTextField();
        textFieldSal = new javax.swing.JTextField();
        textFieldLevel = new javax.swing.JTextField();
        tipotel1home = new javax.swing.JRadioButton();
        tipotel1work = new javax.swing.JRadioButton();
        tipotel2home = new javax.swing.JRadioButton();
        tipotel2work = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCargar = new javax.swing.JMenu();
        opcionCargar = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenu();
        opcionGuardar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(Color.LIGHT_GRAY);
        jPanel1.setBackground(new java.awt.Color(204, 153, 255));

        listaMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMembersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaMembers);

        btAlta.setText("Alta");
        btAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });

        btBaja.setText("Baja");
        btBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBajaActionPerformed(evt);
            }
        });

        btModif.setText("Modificar");
        btModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAlta)
                .addGap(75, 75, 75)
                .addComponent(btBaja)
                .addGap(68, 68, 68)
                .addComponent(btModif)
                .addGap(272, 272, 272))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlta)
                    .addComponent(btBaja)
                    .addComponent(btModif))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        labelNombre.setForeground(new java.awt.Color(0, 0, 0));
        labelNombre.setText("Nombre:");

        labelTel1.setForeground(new java.awt.Color(0, 0, 0));
        labelTel1.setText("Telefono 1:");

        labelTel2.setForeground(new java.awt.Color(0, 0, 0));
        labelTel2.setText("Telefono 2:");

        labelColor.setForeground(new java.awt.Color(0, 0, 0));
        labelColor.setText("Color");

        labelSal.setForeground(new java.awt.Color(0, 0, 0));
        labelSal.setText("Salario");

        labelLevel.setForeground(new java.awt.Color(0, 0, 0));
        labelLevel.setText("Level");

        buttonGroup1.add(tipotel1home);
        tipotel1home.setForeground(new java.awt.Color(0, 0, 0));
        tipotel1home.setText("Home");

        buttonGroup1.add(tipotel1work);
        tipotel1work.setForeground(new java.awt.Color(0, 0, 0));
        tipotel1work.setText("Work");

        buttonGroup2.add(tipotel2home);
        tipotel2home.setForeground(new java.awt.Color(0, 0, 0));
        tipotel2home.setText("Home");

        buttonGroup2.add(tipotel2work);
        tipotel2work.setForeground(new java.awt.Color(0, 0, 0));
        tipotel2work.setText("Work");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelTel2)
                        .addComponent(labelTel1))
                    .addComponent(labelColor)
                    .addComponent(labelSal)
                    .addComponent(labelLevel)
                    .addComponent(labelNombre))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldTel1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(textFieldTel2)
                                    .addComponent(textFieldLevel))
                                .addComponent(textFieldColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFieldSal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipotel1home, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tipotel2home))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipotel1work)
                            .addComponent(tipotel2work)))
                    .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTel1)
                            .addComponent(textFieldTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipotel1home)
                            .addComponent(tipotel1work))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTel2)
                            .addComponent(tipotel2home)
                            .addComponent(tipotel2work))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelColor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSal)
                            .addComponent(textFieldSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLevel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuCargar.setText("Cargar");

        opcionCargar.setText("Cargar archivo");
        opcionCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionCargarActionPerformed(evt);
            }
        });
        menuCargar.add(opcionCargar);

        jMenuBar1.add(menuCargar);

        menuGuardar.setText("Guardar");

        opcionGuardar.setText("Guardar archivo");
        opcionGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionGuardarActionPerformed(evt);
            }
        });
        menuGuardar.add(opcionGuardar);

        jMenuBar1.add(menuGuardar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed
        String n1 = textFieldNombre.getText();       
        String n2 = "";
        if (tipotel1home.isSelected() == true){ n2 = "home";}
        if (tipotel1work.isSelected() == true){ n2 = "work";}
        String n3 = textFieldTel1.getText();
        String n4 = "";
        if (tipotel2home.isSelected() == true){ n4 = "home";}
        if (tipotel2work.isSelected() == true){ n4 = "work";}
        String n5 = textFieldTel2.getText();
        String n6 = textFieldColor.getText();
        String n7 = textFieldSal.getText();
        String n8 = textFieldLevel.getText(); 
        try {
            gestor.alta(n1, n2, n3, n4, n5, n6, n7, n8);
        } catch (DatosException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        rellenarLista();
        JOptionPane.showMessageDialog(this,"El alta fue realizada con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_altaActionPerformed

    private void btBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBajaActionPerformed
        String n = listaMembers.getSelectedValue();
        try { 
            gestor.baja(n);
        } catch (DatosException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        textFieldNombre.setText(null);
        textFieldTel1.setText(null);
        tipotel1home.setSelected(false);
        tipotel1work.setSelected(false);
        textFieldTel2.setText(null);
        tipotel2home.setSelected(false);
        tipotel2work.setSelected(false);
        textFieldColor.setText(null);
        textFieldSal.setText(null);
        textFieldLevel.setText(null);
        rellenarLista();
        JOptionPane.showMessageDialog(this,"La baja fue realizada con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btBajaActionPerformed

    private void btModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifActionPerformed
        String n1 = textFieldNombre.getText();       
        String n2 = "";
        if (tipotel1home.isSelected() == true){ n2 = "home";}
        if (tipotel1work.isSelected() == true){ n2 = "work";}
        String n3 = textFieldTel1.getText();
        String n4 = "";
        if (tipotel2home.isSelected() == true){ n4 = "home";}
        if (tipotel2work.isSelected() == true){ n4 = "work";}
        String n5 = textFieldTel2.getText();
        String n6 = textFieldColor.getText();
        String n7 = textFieldSal.getText();
        String n8 = textFieldLevel.getText(); 
        try {
            gestor.modificar(n1, n2, n3, n4, n5, n6, n7, n8);
        } catch (DatosException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this,"La modificaci�n fue realizada con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btModifActionPerformed

    private void opcionGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionGuardarActionPerformed
          try {
            gestor.guardar("");
            JOptionPane.showMessageDialog(this,"El guardado fue realizado con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,"No se encuentra el Fitness Center", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "No se encuentra el Fitness Center", ex);
        } catch (JAXBException ex) {
            JOptionPane.showMessageDialog(this,"Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Ha habido un error", ex);
        }
    }//GEN-LAST:event_opcionGuardarActionPerformed

    private void opcionCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionCargarActionPerformed
        try { 
            gestor.cargar("");
            JOptionPane.showMessageDialog(this,"La carga fue realizada con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"No se encuentra el Fitness Center", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "No se encuentra el Fitness Center", ex);
        } catch (JAXBException ex) {
            JOptionPane.showMessageDialog(this,"Ha habido un error", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Ha habido un error", ex);
        }
    }//GEN-LAST:event_opcionCargarActionPerformed

    private void listaMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMembersMouseClicked
         String c = listaMembers.getSelectedValue();
        String [] contact = gestor.consultar2(c);
        textFieldNombre.setText(contact [0]);
        textFieldTel1.setText(contact [1]);
        if (contact [2].contains("home")) tipotel1home.setSelected(true);
        else tipotel1work.setSelected(true);       
        textFieldTel2.setText(contact [3]);
        if (contact [4].contains("home")) tipotel2home.setSelected(true);
        else tipotel2work.setSelected(true);
        textFieldColor.setText(contact [5]);  
        textFieldSal.setText(contact [6]);
        textFieldLevel.setText(contact [7]); 
    }//GEN-LAST:event_listaMembersMouseClicked

    private void rellenarLista(){
        listaMembers.removeAll();   
        DefaultListModel<String> model = new DefaultListModel<>();
        listaMembers.setModel( model );
        for (String nuevo: gestor.listadoNombres())
            model.addElement(nuevo);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new VentanaPrincipal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlta;
    private javax.swing.JButton btBaja;
    private javax.swing.JButton btModif;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelSal;
    private javax.swing.JLabel labelTel1;
    private javax.swing.JLabel labelTel2;
    private javax.swing.JList<String> listaMembers;
    private javax.swing.JMenu menuCargar;
    private javax.swing.JMenu menuGuardar;
    private javax.swing.JMenuItem opcionCargar;
    private javax.swing.JMenuItem opcionGuardar;
    private javax.swing.JTextField textFieldColor;
    private javax.swing.JTextField textFieldLevel;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldSal;
    private javax.swing.JTextField textFieldTel1;
    private javax.swing.JTextField textFieldTel2;
    private javax.swing.JRadioButton tipotel1home;
    private javax.swing.JRadioButton tipotel1work;
    private javax.swing.JRadioButton tipotel2home;
    private javax.swing.JRadioButton tipotel2work;
    // End of variables declaration//GEN-END:variables
}