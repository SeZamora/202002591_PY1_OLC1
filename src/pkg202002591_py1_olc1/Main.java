/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg202002591_py1_olc1;
//soy el principal
/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola Mundo");
         java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {

                    new Interfaz().setVisible(true);
                }

          });
      
}
}
