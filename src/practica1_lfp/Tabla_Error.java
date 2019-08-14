package practica1_lfp;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Tokens;
import modelos.Trampa;

public class Tabla_Error extends javax.swing.JFrame {
    ArrayList<Trampa> listaTokens;
    DefaultTableModel md;
    String Datos [][]={};
    String Titulos [] = {"No", "Descripcion", "lexema", "Id","fila", "columna"};
    
    
    public Tabla_Error(ArrayList<Trampa> t) {
        initComponents();
        listaTokens = t;
        md = new DefaultTableModel(Datos,Titulos);
        jTable1.setModel(md);
        Ingresar_Datos();
    }
    
    public void Ingresar_Datos(){
        ArrayList<Trampa> Acepatacion = listaTokens;
        
        if (listaTokens != null)
        {
            for (int i = 0; i < Acepatacion.size(); i++)
            {
                int no = i+1;
                String descripcion = Acepatacion.get(i).getDescri();
                String lexema = Acepatacion.get(i).getError();
                int id = 99999;
                int fila = Acepatacion.get(i).getFila();
                int columna = Acepatacion.get(i).getColumna();
                
                Object datos [] = {no,descripcion,lexema,id,fila,columna};
                md.addRow(datos);
                
            }
        }
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Tabla de con Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
