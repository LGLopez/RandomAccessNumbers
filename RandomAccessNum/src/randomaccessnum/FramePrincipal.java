package randomaccessnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FramePrincipal extends javax.swing.JFrame {
    RandomAccessFile raf = null;
    File archivo = new File("numeros.obj");
    
    DefaultListModel model = new DefaultListModel();
    
    public boolean buscar(){
        double toCheck = Double.parseDouble(txtNumber.getText());
        
        if(model.contains(toCheck)){
            JOptionPane.showMessageDialog(this, "Encontrado!");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(this, "No encontrado");
            return false;
        }
    }
    
    public FramePrincipal(){
        try {
            initComponents();
            int counter = 0;
            raf = new RandomAccessFile(archivo, "rw");
            
            raf.seek(0);
            
            while(true){
                double toShow = raf.readDouble();
                model.add(counter, toShow);
                counter++;
            }
        } catch (FileNotFoundException ex) {} catch (IOException ex) {}
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addInicio = new javax.swing.JButton();
        addFinal = new javax.swing.JButton();
        txtNumber = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNumber = new javax.swing.JList<>(model);
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addInicio.setText("Agregar al inicio");
        addInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInicioActionPerformed(evt);
            }
        });

        addFinal.setText("Agregar al final");
        addFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFinalActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listNumber);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addInicio)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBuscar)
                        .addComponent(addFinal)
                        .addComponent(btnEliminar)))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addInicio)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

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

    private void addInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInicioActionPerformed
        try {
            raf = new RandomAccessFile(archivo, "rw");
            
            raf.seek(0);
            
            double toAdd = Double.parseDouble(txtNumber.getText());
            
            raf.writeDouble(toAdd);
            
            raf.close();
            
            if(!model.isEmpty()){
                model.remove(0);
                model.add(0, toAdd);
            }
            else{
                model.add(0, toAdd);
            }
        } catch (FileNotFoundException ex) {} catch (IOException ex) {}
        
        
    }//GEN-LAST:event_addInicioActionPerformed

    private void addFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFinalActionPerformed
        try {
            raf = new RandomAccessFile(archivo, "rw");
            
            raf.seek(raf.length());
            
            double toAdd = Double.parseDouble(txtNumber.getText());
            
            raf.writeDouble(toAdd);
            
            raf.close();
            
            model.add(model.getSize(), toAdd);

        } catch (FileNotFoundException ex) {} catch (IOException ex) {}
    }//GEN-LAST:event_addFinalActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String numberToConvert = txtNumber.getText();
        double numberToCheck = Double.parseDouble(numberToConvert);
        int counter =0;
        try {
            raf = new RandomAccessFile(archivo, "r");
        
            raf.seek(0);
            
            while(true){
                double readDouble = raf.readDouble();
                
                if(readDouble == numberToCheck){
                    model.removeElement(readDouble);
                    raf.close();
                    archivo.delete();
                    
                    archivo.createNewFile();
                    
                    raf = new RandomAccessFile(archivo,"rw");
                    
                    for(int i=0; i<model.size(); i++){
                        double toAdd = (double) model.getElementAt(i);
                        System.out.println(toAdd);
                        raf.writeDouble(toAdd);
                    }
                    return;
                }
                counter++;
            }
            
        } catch (FileNotFoundException ex) {} catch (IOException ex) {}
        counter = 0;
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFinal;
    private javax.swing.JButton addInicio;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listNumber;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
