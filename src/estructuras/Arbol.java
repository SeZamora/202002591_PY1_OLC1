/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class Arbol {
    Nodo root;
    public static String conectores = "";
    public static String imprimir = "";

    public Arbol( ArrayList<String> strList, ArrayList<Nodo> leaves, ArrayList<ArrayList> table ) {

        numeroHoja numHoja = new numeroHoja(strList);
        Stack pila = new Stack();


        Collections.reverse(strList);
        StringBuilder dot = new StringBuilder();
         StringBuilder afnd = new StringBuilder();
        dot.append("digraph G {\n");
        dot.append(" layout=dot \n" +
                "labelloc = \"t\"edge [weigth=1000  color=darkgreen  arrowtail=\"open\" arrowhead=\"open\"]\n");
        

        conectores = "";

        
        strList.forEach((character) -> {
            switch (character) {
                case "|":
                    Nodo lefto = (Nodo) pila.pop();
                    Nodo righto = (Nodo) pila.pop();

                    Nodo no = new Nodo(character, Tipo.Tipos.OR, 0, lefto, righto, leaves, table);
                    
                    conectores+=String.format("Nodo%d -> Nodo%d;\n", no.hashCode(), lefto.hashCode());
                    conectores+=String.format("Nodo%d -> Nodo%d;\n", no.hashCode(), righto.hashCode());
                    

     
                    pila.push(no);
                    break;
                case ".":
                    Nodo lefta = (Nodo) pila.pop();
                    Nodo righta = (Nodo) pila.pop();
                    
                    
                    Nodo na = new Nodo(character, Tipo.Tipos.AND, 0, lefta, righta, leaves, table);
                    pila.push(na);
                    
                    conectores+=String.format("Nodo%d -> Nodo%d;\n", na.hashCode(), lefta.hashCode());
                    conectores+=String.format("Nodo%d -> Nodo%d;\n", na.hashCode(), righta.hashCode());
                    
                    
                    
  
                    

                    break;
                case "*":
                    Nodo unario = (Nodo) pila.pop();

                    Nodo nk = new Nodo(character, Tipo.Tipos.KLEENE, 0, unario, null, leaves, table);
                    pila.push(nk);
                    
                    conectores+=String.format("Nodo%d -> Nodo%d;\n", nk.hashCode(), unario.hashCode());
                    
             

                    break;
                case "+":
                    Nodo unario1 = (Nodo) pila.pop();

                    Nodo nk1 = new Nodo(character, Tipo.Tipos.MAS, 0, unario1, null, leaves, table);
                    pila.push(nk1);
                    
                    conectores+=String.format("Nodo%d -> Nodo%d;\n", nk1.hashCode(), unario1.hashCode());
       

                    break;
                case "?":
                    Nodo unario2 = (Nodo) pila.pop();

                    Nodo nk2 = new Nodo(character, Tipo.Tipos.INTERROGACION, 0, unario2, null, leaves, table);
                    pila.push(nk2);
                    
                    conectores+=String.format("Nodo%d -> Nodo%d;\n", nk2.hashCode(), unario2.hashCode());
                    
      

                    break;
                default:
                    Nodo nd = new Nodo(character, Tipo.Tipos.HOJA, numHoja.getNum(), null, null, leaves, table);
                    pila.push(nd);
                    hojita hoja = new hojita();
                    hoja.addLeave(nd, leaves);
                    break;
            }
        });
        this.root = (Nodo) pila.pop();
        dot.append(conectores);
        imprimir = dot.toString();

    }

    public Nodo getRoot(){
        return this.root;
    }
}
