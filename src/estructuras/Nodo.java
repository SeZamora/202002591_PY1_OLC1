/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import T_Sigueinte.Siguiente;
import estructuras.*;
import java.util.ArrayList;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class Nodo {
    ArrayList<Integer> first;
    ArrayList<Integer> last;
    boolean anullable;

    String lexeme;
    Tipo.Tipos type;
    int number;

    boolean accept;

    Object left;
    Object right;

    ArrayList<Nodo> leaves;
    ArrayList<ArrayList> table;

    public Nodo(String lexeme, Tipo.Tipos type, int number, Object left, Object right, ArrayList<Nodo> leaves, ArrayList<ArrayList> table) {
        first = new ArrayList();
        last = new ArrayList();
        anullable = true;

        this.lexeme = lexeme;
        this.type = type;
        this.number = number;

        accept = "#".equals(this.lexeme);

        this.left = left;
        this.right = right;

        this.leaves = leaves;
        this.table = table;
    }

    public Nodo getNode(){

        
        Object leftNode = this.left instanceof Nodo ? ((Nodo) this.left).getNode() : null;
        Object rightNode = this.right instanceof Nodo ? ((Nodo) this.right).getNode() : null;

        if(null != this.type)switch (this.type) {
            case HOJA:
                this.anullable = false;
                this.first.add(this.number);
                this.last.add(this.number);
                break;
            case AND:
                if(leftNode instanceof Nodo && rightNode instanceof Nodo){
                    this.anullable = ((Nodo)leftNode).anullable && ((Nodo) rightNode).anullable;

                    this.first.addAll(((Nodo)leftNode).first);
                    if(((Nodo)leftNode).anullable){
                        this.first.addAll(((Nodo)rightNode).first);
                    }

                    if(((Nodo)rightNode).anullable){
                        this.last.addAll(((Nodo)leftNode).last);
                    }
                    this.last.addAll(((Nodo)rightNode).last);
                }
                break;
            case OR:
                if(leftNode instanceof Nodo && rightNode instanceof Nodo){
                    this.anullable = ((Nodo)leftNode).anullable || ((Nodo) rightNode).anullable;

                    this.first.addAll(((Nodo)leftNode).first);
                    this.first.addAll(((Nodo)rightNode).first);


                    this.last.addAll(((Nodo)leftNode).last);
                    this.last.addAll(((Nodo)rightNode).last);
                }
                break;
            case MAS:
                if(leftNode instanceof Nodo){
                    this.anullable = ((Nodo) leftNode).anullable;
                    this.first.addAll(((Nodo)leftNode).first);
                    this.last.addAll(((Nodo)leftNode).last);
                }
                break;
            case INTERROGACION:
            case KLEENE:
                if(leftNode instanceof Nodo){
                    this.anullable = true;
                    this.first.addAll(((Nodo)leftNode).first);
                    this.last.addAll(((Nodo)leftNode).last);
                }
                break;
            default:
                break;
        }
        return this;
    }

    public Object follow(){
        Object leftFollow=  this.left instanceof Nodo ? ((Nodo) this.left).follow() : null;
        Object rightFollow =  this.right instanceof Nodo ? ((Nodo) this.right).follow() : null;

        if(null != this.type)switch (this.type) {
            case AND:
                for (int item : ((Nodo)leftFollow).last) {
                    hojita hoja = new hojita();
                    Nodo nodo = hoja.getLeave(item, leaves);
                    Siguiente tabla = new Siguiente();
                    tabla.append(nodo.number, nodo.lexeme, ((Nodo) rightFollow).first, table);
                }
                break;
            case MAS:
            case KLEENE:
                for (int item : ((Nodo)leftFollow).last) {
                    hojita hoja = new hojita();
                    Nodo nodo = hoja.getLeave(item, leaves);
                    Siguiente tabla = new Siguiente();
                    tabla.append(nodo.number, nodo.lexeme, ((Nodo) leftFollow).first, table);
                }
                break;
            default:
                break;
        }
        if(this.lexeme.equals("\"" + "\\" + "n" + "\"")){
            this.lexeme="\\"+"\\"+"n"; }
        if(this.lexeme.equals("\""+"\\"+"\"")){
            this.lexeme="''"; }

        String anulable = "";
        if(this.anullable==true){ anulable="A"; }else{anulable="N";}




        Arbol.imprimir+="Nodo"+ this.hashCode()+ "[label=\""+ this.lexeme.replace("\"","") +" \n "+this.first+" \n "+ this.last +" \n "+ anulable + " \"];\n";
       
        return this;
    }
}