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
public class numeroHoja {
    public int content;

    public numeroHoja(ArrayList<String> strList) {
        this.content = clean(strList) + 1;
    }

    public int getNum(){
        content -= 1;
        return content;
    }


    public int clean(ArrayList<String> strList){
        int contador=0;
        for (int i = 0; i <strList.size() ; i++) {
            if(!strList.get(i).equals(".") && !strList.get(i).equals("*") && !strList.get(i).equals("|")  && !strList.get(i).equals("+")  && !strList.get(i).equals("?")){
                contador++;
            }
        }
        return contador;
    }
}