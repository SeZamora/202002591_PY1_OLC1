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

    public Arbol( ArrayList<String> strList, ArrayList<Nodo> leaves, ArrayList<ArrayList> table ) {

        numeroHoja numHoja = new numeroHoja(strList);
        Stack pila = new Stack();


        Collections.reverse(strList);

        strList.forEach((character) -> {
            switch (character) {
                case "|":
                    Nodo lefto = (Nodo) pila.pop();
                    Nodo righto = (Nodo) pila.pop();

                    Nodo no = new Nodo(character, Tipo.Tipos.OR, 0, lefto, righto, leaves, table);
                    pila.push(no);

                    break;
                case ".":
                    Nodo lefta = (Nodo) pila.pop();
                    Nodo righta = (Nodo) pila.pop();

                    Nodo na = new Nodo(character, Tipo.Tipos.AND, 0, lefta, righta, leaves, table);
                    pila.push(na);

                    break;
                case "*":
                    Nodo unario = (Nodo) pila.pop();

                    Nodo nk = new Nodo(character, Tipo.Tipos.KLEENE, 0, unario, null, leaves, table);
                    pila.push(nk);

                    break;
                case "+":
                    Nodo unario1 = (Nodo) pila.pop();

                    Nodo nk1 = new Nodo(character, Tipo.Tipos.MAS, 0, unario1, null, leaves, table);
                    pila.push(nk1);

                    break;
                case "?":
                    Nodo unario2 = (Nodo) pila.pop();

                    Nodo nk2 = new Nodo(character, Tipo.Tipos.INTERROGACION, 0, unario2, null, leaves, table);
                    pila.push(nk2);

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
    }

    public Nodo getRoot(){
        return this.root;
    }
}
