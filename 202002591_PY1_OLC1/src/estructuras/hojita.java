/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import java.util.ArrayList;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class hojita {
    public void addLeave(Nodo nodo, ArrayList<Nodo> leaves){
        leaves.add(nodo);
    }

    public Nodo getLeave(int numLeave, ArrayList<Nodo> leaves){
        for (Nodo item : leaves) {
            if(item.number == numLeave) return item;
        }
        return null;
    }

    public boolean isAccept(int numLeave, ArrayList<Nodo> leaves){
        for (Nodo item : leaves) {
            if(item.number == numLeave) return item.accept;
        }
        return false;
    }
}
