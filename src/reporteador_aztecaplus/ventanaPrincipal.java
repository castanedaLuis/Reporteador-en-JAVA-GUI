/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package reporteador_aztecaplus;

import Conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jose Luis Castañeda
 */
public class ventanaPrincipal extends javax.swing.JFrame {

 
    public ventanaPrincipal() {
        initComponents();
    }


    public ventanaPrincipal(JButton boton_sistema, JLabel jLabel1, JTextField jTextField1, JTextField jTextField2, JLabel password, JLabel usuario) throws HeadlessException {
        this.boton_sistema = boton_sistema;
        this.jLabel1 = jLabel1;
        this.usuario2 = jTextField1;
        //this.password3 = jTextField2;
        this.password = password;
        this.usuario = usuario;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_sistema = new javax.swing.JButton();
        usuario = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        usuario2 = new javax.swing.JTextField();
        password3 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 3, 24)); // NOI18N
        jLabel1.setText("CUENTAS PENDIENTES");

        boton_sistema.setBackground(new java.awt.Color(255, 0, 0));
        boton_sistema.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        boton_sistema.setText("Entrar al Sistema");
        boton_sistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_sistemaActionPerformed(evt);
            }
        });

        usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usuario.setText("Usuario");

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(boton_sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(usuario))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usuario2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(password3))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario)
                    .addComponent(usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(password3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(boton_sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_sistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_sistemaActionPerformed
        // TODO add your handling code here:
        validarUsuario();
    }//GEN-LAST:event_boton_sistemaActionPerformed

public void validarUsuario()
{
        int resultado = 0;
        String usu = usuario2.getText();
        String pass = password3.getText();
        String sql="SELECT * FROM Employees WHERE usuario='"+usu+"' and password='"+pass+"'";

        //Conexion a la base de datos
        Conexion conectar = new Conexion("reporteador");
        try{
            conectar.Conectar();
        }catch(SQLException |ClassNotFoundException ex){
        }
        PreparedStatement ps = null;
        


        try{

        ps=conectar.Conectar().prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);

        if(rs.next())
        {
            resultado = 1;

            if(resultado == 1)
                {
                    ventanaSecundaria v2 = new ventanaSecundaria();
                    v2.setVisible(true);
                    this.dispose();
                }
         }else
            {
                JOptionPane.showMessageDialog(null,"Credenciales incorrectas");
            }
       // rs.close();
       // ps.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error"+e);
        }



}


    public static void main(String args[]){
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_sistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField password3;
    private javax.swing.JLabel usuario;
    private javax.swing.JTextField usuario2;
    // End of variables declaration//GEN-END:variables
}
