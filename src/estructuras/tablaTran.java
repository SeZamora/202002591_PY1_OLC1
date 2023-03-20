/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;

import T_Sigueinte.Siguiente;
import T_Transicion.Transicion;
import estructuras.Nodo;
import estructuras.hojita;
import java.util.ArrayList;
import estructuras.*;

/**
 *
 * @author SEBASTIAN ZAMORA
 */

public class tablaTran {
    public ArrayList<ArrayList> states;
    public int cont;

    public tablaTran(Nodo root, ArrayList tabla, ArrayList<Nodo> leaves) {
        this.states = new ArrayList();

        ArrayList datos = new ArrayList();
        datos.add("S0");
        datos.add(root.first);
        datos.add(new ArrayList());
        datos.add(false);

        this.states.add(datos);
        this.cont = 1;

        for(int i = 0; i < states.size(); i++){
            ArrayList state = states.get(i);
            ArrayList<Integer> elementos = (ArrayList) state.get(1);

            // TODO  Aqui se encuentra el bug
            for(int hoja : elementos){
                Siguiente sigTabla = new Siguiente();
                ArrayList lexemeNext = (ArrayList) sigTabla.next(hoja, tabla).clone();


                boolean existe = false;
                String found = "";

                for( ArrayList e : states ){
                    if(e.get(1).equals(lexemeNext.get(1))){
                        existe = true;
                        found = (String)e.get(0);
                        break;
                    }
                }

                if(!existe){
                    hojita hojas = new hojita();
                    if(hojas.isAccept(hoja, leaves)){
                        state.set(3, true);
                    }
                    if(lexemeNext.get(0)==""){
                        continue;
                    }

                    ArrayList nuevo = new ArrayList();
                    nuevo.add("S"+cont);
                    nuevo.add(lexemeNext.get(1));
                    nuevo.add(new ArrayList());
                    nuevo.add(false);

                    Transicion trans = new Transicion(state.get(0) + "", lexemeNext.get(0) + "", nuevo.get(0) + "");
                    ((ArrayList)state.get(2)).add(trans);

                    cont += 1;
                    states.add(nuevo);

                }
                else{
                    hojita hojas = new hojita();
                    if(hojas.isAccept(hoja, leaves)){
                        state.set(3, true);
                    }

                    boolean trans_exist = false;

                    for(Object trans : (ArrayList)state.get(2)){
                        Transicion t = (Transicion) trans;
                        if(t.compare(state.get(0) + "", lexemeNext.get(0) + "")){
                            trans_exist = true;
                            break;
                        }
                    }
                    if(!trans_exist){
                        Transicion trans = new Transicion(state.get(0) + "", lexemeNext.get(0) + "", found + "");
                        ((ArrayList)state.get(2)).add(trans);
                    }
                }
            }

        }
    }

    public void impTable(){
        for(ArrayList state : states){
            String tran = "[";
            for(Object tr : (ArrayList)state.get(2)){
                Transicion t = (Transicion) tr;
                tran += t.toString() + ", ";
            }
            tran += "]";

            tran = tran.replace(", ]", "]");

            System.out.println(state.get(0) + " " + state.get(1) + " " + tran + " " + state.get(3));

        }
    }

    public String T_AFD(){
        
        System.out.println("----------------");
        for(ArrayList state : states){
            System.out.println("--------1-----------");
            System.out.println(state.get(0));
       
            System.out.println("-------------3----------");
            System.out.println(state.get(2));
        }
        System.out.println("----------------");
        
        //---------------------------------------------------
        
        String texto = "digraph G {\n rankdir=LR;\n label=\"AFD\"; \nnodex [style=invisible label = \"\"];\n";

        for(ArrayList state : states){
            texto += "node"+state.get(0) + " [shape=circle label=" +state.get(0) + "];\n";
        }
        texto+="Inicio->nodeS0;";

        for(ArrayList state : states){
            for(Object tr : (ArrayList)state.get(2)){
                Transicion t = (Transicion) tr;
                texto += t.graph();
                System.out.println(t.graph());
            }
            

            if (state.get(3).equals(true)){
                texto += "node"+state.get(0) + " [shape=doublecircle label=" +state.get(0) + "];\n";
            }
        }


        return  texto +="}";
    }
    
  

    public String graphviz(ArrayList<ArrayList> table){
        StringBuilder dot = new StringBuilder();
        StringBuilder dot2 = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("bgcolor=\"#df806c\" label=\"Tabla de Transicion\" layout=dot \n" +
                "labelloc = \"t\" edge [weigth=1000  color=darkgreen  arrowtail=\"open\" arrowhead=\"open\"]\n");
        dot.append("node[shape=box, style=\"filled\", color=#7fc9d1\"];\n");
        dot.append("a0 [label=<\n" +
                "<TABLE border=\"10\" cellspacing=\"10\" cellpadding=\"10\" style=\"rounded\">");
        dot.append("<TR><TD> </TD>\n" );

        int size = 0;

        for(ArrayList item : table){
            size++;
            dot.append("<TD>"+item.get(1)+"</TD>\n");
        }
        dot.append("  </TR>\n");

        for(ArrayList state : states){

            dot.append("<TR><TD>"+state.get(0)+state.get(1)+"</TD>\n");

            ArrayList itemTemp = new ArrayList();
            for(ArrayList item : table){
                itemTemp.add(item.get(1));
            }
            String[] columnas = new String[itemTemp.size()];
            int c= 0;
            for(Object tr : (ArrayList)state.get(2)){
                Transicion t = (Transicion) tr;
                c= 0;
                for(Object item : itemTemp){
                    if (t.transition.equals(item)){
                        columnas[c] = t.finalState;
                        break;
                        //dot.append( "  <TD>"+t.finalState+"</TD>\n");
                    }//dot.append( "  <TD> </TD>\n");
                   c++;
                }
            }
            for (int i=0; i<columnas.length ; i++) {
                if (columnas[i]!=null){
                    dot.append( "  <TD>"+columnas[i]+"</TD>\n");
                }else{dot.append( "  <TD> </TD>\n");}
            }
            dot.append("</TR>\n");

        }


        dot.append("</TABLE>>];");
        dot.append("}");
        return dot.toString();


    }

}
    