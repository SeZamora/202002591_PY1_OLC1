/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkg202002591_py1_olc1;
import analizador.Lexico;
import analizador.compilador;
import analizador.parser;
import estructuras.*;
import Errores.*;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class Interfaz extends javax.swing.JFrame {
    File texto = null;
    int posicionArchivo = 0;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        Imagenes = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        rutaimagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton3.setText("Guardar como");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar Automana");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Analizar Entrada");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(225, 225, 225));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        Imagenes.setBackground(new java.awt.Color(225, 225, 225));
        Imagenes.setForeground(new java.awt.Color(225, 225, 225));
        Imagenes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arboles", "Siguientes", "Transiciones", "Automatas" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton6.setText("Siguiente Imagen");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Imagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutaimagen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Imagenes, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(jTextArea1);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String contenido = " ";

            texto = fileChooser.getSelectedFile();
            try {
                Scanner input = new Scanner(texto);
                while (input.hasNextLine()) {
                    contenido += input.nextLine() + "\n";
                }
                input.close();
            } catch (Exception ex) {
                ex.printStackTrace();

    }//GEN-LAST:event_jButton1ActionPerformed
            jTextArea1.setText(contenido);
        }
        
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String entrada = jTextArea1.getText();
       
        try {
           Lexico scanner = new Lexico(new java.io.StringReader(entrada));
            parser parser = new parser(scanner);
            parser.parse();
            System.out.println("Analisis finalizado");
            
             // generar reporte de errores lexicos
            if (scanner.erroresLexicos.isEmpty()) {
                System.out.println("No se encontraron errores lexicos");
            } else {
                scanner.erroresLexicos.forEach((error) -> {
                    html_error.error_lexico(error.getTipo(), error.getDescripcion(), error.getLinea(), error.getColumna());
                });
            }
            
            // generar reporte de errores sintacticos
            if (parser.erroresSintacticos.isEmpty()) {
                System.out.println("No se encontraron errores sintacticos");
                html_error.cerrar();
            } else {
                parser.erroresSintacticos.forEach((error) -> {        
                        html_error.error_sintactico(error.getTipo(), error.getDescripcion(), error.getLinea(), error.getColumna());
                        html_error.cerrar();
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Union.analizar();

        Union.arboles();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        File file = texto ;
        String text = jTextArea1.getText();
       try {
       
          
            
            // Creamos el objeto FileOutputStream
            FileOutputStream fos = new FileOutputStream(file);
            
            // Escribimos los datos en el archivo
            String mensaje = jTextArea1.getText();
            fos.write(mensaje.getBytes());
            
            // Cerramos el objeto FileOutputStream
            fos.close();
            
            System.out.println("El archivo se ha creado correctamente.");
            
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Creamos un JFileChooser
            JFileChooser chooser = new JFileChooser();
            
            // Mostramos el cuadro de diálogo "Guardar como"
            int opcion = chooser.showSaveDialog(this);
            
            if (opcion == JFileChooser.APPROVE_OPTION) {
                // Obtenemos la ruta y el nombre del archivo seleccionado
                File archivo = chooser.getSelectedFile();
                
                // Guardamos el contenido del JTextArea en el archivo seleccionado
                try {
                    FileWriter escritor = new FileWriter(archivo);
                    escritor.write(jTextArea1.getText());
                    escritor.close();
                    
                    JOptionPane.showMessageDialog(this, "El archivo se ha guardado correctamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error: " + ex.getMessage());
                }
    }//GEN-LAST:event_jButton3ActionPerformed
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        System.out.println("Se eligió: " + jComboBox1.getSelectedItem().toString());
        posicionArchivo = 0;
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
          String rutaImagenes = "";
        String nombreFinalImagen = "";
        if (jComboBox1.getSelectedItem().toString().equals("Arboles")) {
            rutaImagenes = "./reportes/Arbol_202002591/";
            File carpeta = new File(rutaImagenes);
            if(posicionArchivo >= carpeta.list().length)posicionArchivo = 0;
            nombreFinalImagen = carpeta.list()[posicionArchivo];
            rutaImagenes += nombreFinalImagen;
            ImageIcon imagen = new ImageIcon(rutaImagenes);
            ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(Imagenes.getWidth(), Imagenes.getHeight(), Image.SCALE_DEFAULT));
            Imagenes.setIcon(icono);
            rutaimagen.setText(rutaImagenes);
            posicionArchivo++;
        } else if (jComboBox1.getSelectedItem().toString().equals("Siguientes")) {
            rutaImagenes = "./reportes/Siguientes_202002591/";
            File carpeta = new File(rutaImagenes);
            if(posicionArchivo >= carpeta.list().length)posicionArchivo = 0;
            nombreFinalImagen = carpeta.list()[posicionArchivo];
            rutaImagenes += nombreFinalImagen;
            ImageIcon imagen = new ImageIcon(rutaImagenes);
            ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(Imagenes.getWidth(), Imagenes.getHeight(), Image.SCALE_DEFAULT));
            Imagenes.setIcon(icono);
            rutaimagen.setText(rutaImagenes);
            posicionArchivo++;
        } else if (jComboBox1.getSelectedItem().toString().equals("Transiciones")) {
            rutaImagenes = "./reportes/Transiciones_202002591/";
            File carpeta = new File(rutaImagenes);
            if(posicionArchivo >= carpeta.list().length)posicionArchivo = 0;
            nombreFinalImagen = carpeta.list()[posicionArchivo];
            rutaImagenes += nombreFinalImagen;
            ImageIcon imagen = new ImageIcon(rutaImagenes);
            ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(Imagenes.getWidth(), Imagenes.getHeight(), Image.SCALE_DEFAULT));
            Imagenes.setIcon(icono);
            rutaimagen.setText(rutaImagenes);
            posicionArchivo++;
        } else {
            rutaImagenes = "./reportes/afd_202002591/";
            File carpeta = new File(rutaImagenes);
            if(posicionArchivo >= carpeta.list().length)posicionArchivo = 0;
            nombreFinalImagen = carpeta.list()[posicionArchivo];
            rutaImagenes += nombreFinalImagen;
            ImageIcon imagen = new ImageIcon(rutaImagenes);
            ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(Imagenes.getWidth(), Imagenes.getHeight(), Image.SCALE_DEFAULT));
            Imagenes.setIcon(icono);
            rutaimagen.setText(rutaImagenes);
            posicionArchivo++;
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagenes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel rutaimagen;
    // End of variables declaration//GEN-END:variables
}
