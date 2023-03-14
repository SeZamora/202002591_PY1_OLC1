/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras;
import analizador.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import pkg202002591_py1_olc1.*;
import java.util.ArrayList;
import estructuras.*;
import java.io.BufferedWriter;
import java.io.FileWriter;



/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class Union {
    public static ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();
    public static ArrayList<Expresion> expresiones = new ArrayList<Expresion>();
    public static ArrayList<Expresion> entradas = new ArrayList<Expresion>();
    
    public static void analizar(){
        for (int i = 0; i < conjuntos.size(); i++) {
            System.out.println(conjuntos.get(i).getNombre() + " " + conjuntos.get(i).getCombinacion());
        }
        for (int i = 0; i < expresiones.size(); i++) {
            int estado = 0;
            String buffer = "";
            String centinela = "¬";
            String codigoFuente = expresiones.get(i).getExpresion() + centinela;
            char[] chars = codigoFuente.toCharArray();
            ArrayList<Character> cadaCaracter = new ArrayList<>();
            for (char ch : chars) {
                System.out.println("->"+ch);
                cadaCaracter.add(ch);
            }

            int j = 0;
            expresiones.get(i).insertarTerminalAlArray(".");
                while (j<cadaCaracter.size()){
                
                
                if (estado == 0){
                    if(cadaCaracter.get(j)==46){
                        expresiones.get(i).insertarTerminalAlArray(".");
                        j++;
                    }else if(cadaCaracter.get(j)==42){
                        expresiones.get(i).insertarTerminalAlArray("*");
                        j++;
                    } else if(cadaCaracter.get(j)==124){
                        expresiones.get(i).insertarTerminalAlArray("|");
                        j++;
                    }else if(cadaCaracter.get(j)==63){
                        expresiones.get(i).insertarTerminalAlArray("?");
                        j++;
                    }else if(cadaCaracter.get(j)==43){
                        expresiones.get(i).insertarTerminalAlArray("+");
                        j++;
                    }else if(cadaCaracter.get(j)==172){

                        System.out.println("se completo el casteo");
                        break;
                    }
                    else if (cadaCaracter.get(j)==123){

                         System.out.println("123 -> "+j+"->"+cadaCaracter.get(j));
                         //System.out.println(" "+buffer);

                        buffer += cadaCaracter.get(j);
                        j++;
                        estado = 1;
                    }
                    else if (cadaCaracter.get(j)==34){
                         System.out.println("34 estado 0 -> "+j+"->"+cadaCaracter.get(j));
                         //System.out.println(buffer);uffer += cadaCaracter.get(j);
                        j++;
                        estado = 2;
                    }else if (cadaCaracter.get(j)==92){
                        System.out.println("34 estado 0 -> "+j+"->"+cadaCaracter.get(j));
                        j++;
                        estado = 3;
                    }
                }else if (estado==1){
                    if(cadaCaracter.get(j)==125){

                        buffer += "}";
                        expresiones.get(i).insertarTerminalAlArray(buffer);
                        buffer = "";
                        j++;
                        estado = 0;
                    }else{
 
                         System.out.println("primer if else -> "+j+"->"+cadaCaracter.get(j));
                         //System.out.println(" "+buffer);

                        buffer+= cadaCaracter.get(j);
                        j++;
                    }
                }else if (estado==2){
                    if(cadaCaracter.get(j)==34){

                          System.out.println("34 -> "+j+"->"+cadaCaracter.get(j));
                         //System.out.println(" "+buffer);

                        buffer += "\"";
                        expresiones.get(i).insertarTerminalAlArray(buffer);
                        buffer = "";
                        j++;
                        estado = 0;
                    }else{

                          System.out.println("estado 2 else -> "+j+"->"+cadaCaracter.get(j));
                         //System.out.println(" "+buffer);

                        buffer+= cadaCaracter.get(j);
                        j++;
                    }

 
                }else if (estado==3){
                    System.out.println("entre 3 ->"+cadaCaracter.get(j));
                        if(cadaCaracter.get(j)==110){
                            System.out.println("entre n");
                         buffer = "\\n";
                            System.out.println("el buffer: "+buffer);
                         expresiones.get(i).insertarTerminalAlArray(buffer);
                         j++;
                          buffer = "";
                         estado = 0;
                     } else if (cadaCaracter.get(j)==39){
                            System.out.println("entre simple");
                          buffer = "\\\'";
                            System.out.println("el buffer: "+buffer);
                         expresiones.get(i).insertarTerminalAlArray(buffer);
                         j++;
                         estado = 0;
                         buffer = "";
                     } else if (cadaCaracter.get(j)==34){
                            System.out.println("entre doble");
                         buffer = "\\\"";
                            System.out.println("soy buffer"+buffer);
                         expresiones.get(i).insertarTerminalAlArray(buffer);
                         j++;
                         buffer = "";
                         estado = 0;
                     }
                }
            }
            expresiones.get(i).insertarTerminalAlArray("#");
            System.out.println(expresiones.get(i).getNombre() + " " + expresiones.get(i).getExpresion());
        }
        
        /////-------------------------------------------------
         for (int i = 0; i < expresiones.size(); i++) {
            String er = "..a*|{c}{x}b";

            ArrayList<Nodo> leaves = new ArrayList();
            ArrayList<ArrayList> table = new ArrayList();

            er = "." + er + "#";


            Arbol arbol = new Arbol(expresiones.get(i).getExpresionArray(), leaves, table); // CREA EL ARBOL
            Nodo raiz = arbol.getRoot();

            raiz.getNode(); // DETERMINA SI LOS NODOS SON ANULABLES, SUS PRIMEROS Y ULTIMOS
            raiz.follow();
 
            
            String graphvizArbol = Arbol.imprimir+"}";
            EscribirArchivo(graphvizArbol,"./reportes/Arbol_202002591/Arbol"+(i+1)+".dot");
            ProcessBuilder proceso0;
            proceso0 = new ProcessBuilder("dot", "-Tpng", "-o","./reportes/Arbol_202002591/Arbol"+(i+1)+".png","./reportes/Arbol_202002591/Arbol"+(i+1)+".dot");
            proceso0.redirectErrorStream(true);
            try {
                proceso0.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
  
    


            System.out.println("        ==TABLA SIGUIENTES        ==");
            Siguiente ft = new Siguiente();
            String graphviz = ft.graphviz(table);
            EscribirArchivo(graphviz,"./reportes/Siguientes_202002591/Tabla"+(i+1)+".dot");
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot", "-Tpng", "-o","./reportes/Siguientes_202002591/Tabla"+(i+1)+".png","./reportes/Siguientes_202002591/Tabla"+(i+1)+".dot");
            proceso.redirectErrorStream(true);
            try {
                proceso.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            
   
            tablaTran tran = new tablaTran(raiz, table, leaves); // bug
            System.out.println("        =TABLA TRANSICIONES        =");
             graphviz = tran.graphviz(table);
            EscribirArchivo(graphviz,"./reportes/Transiciones_202002591/Tabla"+(i+1)+".dot");
            ProcessBuilder proceso2;
            proceso2 = new ProcessBuilder("dot", "-Tpng", "-o","./reportes/Transiciones_202002591/Tabla"+(i+1)+".png","./reportes/Transiciones_202002591/Tabla"+(i+1)+".dot");
            proceso2.redirectErrorStream(true);
            try {
                proceso2.start();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
   
                }
      
    
    
    public static void EscribirArchivo(String contenido, String ruta){
        try {

            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }






