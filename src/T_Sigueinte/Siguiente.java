/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package T_Sigueinte;

import java.util.ArrayList;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class Siguiente {
    public void append(int numNode, String lexeme, ArrayList flwList, ArrayList<ArrayList> table){
        for (ArrayList item : table){
            if( (int) item.get(0) == numNode && item.get(1) == lexeme ){
                for (Object flwItem : flwList){
                    if(! ((ArrayList)item.get(2)).contains((int)flwItem) ){
                        ((ArrayList)item.get(2)).add(flwItem);
                    }
                }
                return;
            }
        }
        ArrayList dato = new ArrayList();
        dato.add(numNode);
        dato.add(lexeme);
        dato.add(flwList);

        table.add(dato);
    }

    public ArrayList next(int numNode, ArrayList<ArrayList> table){
        ArrayList result = new ArrayList();
        for(ArrayList item : table){
            if( (int) item.get(0) == numNode ){
                result.add(item.get(1));
                result.add(((ArrayList)item.get(2)).clone());
                return result;
            }
        }
        result.add("");
        result.add(new ArrayList());
        return result;
    }

  

    public String graphviz(ArrayList<ArrayList> table){
        StringBuilder dot = new StringBuilder();

        dot.append("digraph G {\n");
        dot.append("bgcolor=\"#df806c\" label=\"Tabla de Siguientes\"layout=dot \n" +
                "labelloc = \"t\"edge [weigth=1000  color=darkgreen  arrowtail=\"open\" arrowhead=\"open\"]\n");
        dot.append("node[shape=box, style=\"filled\", color=#7fc9d1\"];\n");
        dot.append("a0 [label=<\n" +
                "<TABLE>");
        int size = 0;
        for(ArrayList item : table){
            size++;
            dot.append("<TR><TD>"+item.get(0)+"</TD>\n" +
                    "  <TD>-</TD>\n" +
                    "  <TD>"+item.get(1)+"</TD>\n" +
                    "  <TD>-</TD>\n" +
                    "  <TD>"+item.get(2)+"</TD>\n" +
                    "  </TR>");
        }
        dot.append("<TR><TD>"+(size+1)+"</TD>\n" +
                "  <TD>-</TD>\n" +
                "  <TD>#</TD>\n" +
                "  </TR>");
        dot.append("</TABLE>>];");
        dot.append("}");
        return dot.toString();

    }
}