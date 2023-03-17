/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Errores;
import estructuras.*;
/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class html_error {
    private static String imprimirhtml = "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>Ejemplo de tabla con CSS</title>\n" +
"	<style>\n" +
"		table {\n" +
"			font-family: Arial, sans-serif;\n" +
"			border-collapse: collapse;\n" +
"			width: 100%;\n" +
"			margin-bottom: 20px;\n" +
"		}\n" +
"\n" +
"		th,\n" +
"		td {\n" +
"			border: 1px solid #ddd;\n" +
"			text-align: left;\n" +
"			padding: 8px;\n" +
"		}\n" +
"\n" +
"		th {\n" +
"			background-color: #f2f2f2;\n" +
"			color: #444;\n" +
"		}\n" +
"\n" +
"		tr:nth-child(even) {\n" +
"			background-color: #f2f2f2;\n" +
"		}\n" +
"\n" +
"		tr:hover {\n" +
"			background-color: #ddd;\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"<body>\n" +
"	<table>\n" +
"		<thead>\n" +
"			<tr>\n" +
"				<th>Tipo</th>\n" +
"				<th>Descripcion</th>\n" +
"				<th>Linea</th>\n" +
"				<th>Columna</th>\n" +
"			</tr>\n" +
"		</thead>\n" +
"		<tbody>";
    
    public static void error_lexico(String tipo, String descripcion, String linea, String columna){
        imprimirhtml +=  "			<tr>\n" +
"				<td>"+tipo+"</td>\n" +
"				<td>"+descripcion+"</td>\n" +
"				<td>"+linea+"</td>\n" +
"				<td>"+columna+"</td>\n" +
"			</tr>\n";
        
    }
    public static void error_sintactico(String tipo, String descripcion, String linea, String columna){
        imprimirhtml +=  "			<tr>\n" +
"				<td>"+tipo+"</td>\n" +
"				<td>"+descripcion+"</td>\n" +
"				<td>"+linea+"</td>\n" +
"				<td>"+columna+"</td>\n" +
"			</tr>\n";
        
    }
    
    public static void cerrar(){
        imprimirhtml +=  "</tbody>\n" +
"	</table>\n" +
"</body>\n" +
"</html>";
        Union.EscribirArchivo(imprimirhtml, "./reportes/Errores_202002591/errores.html");
    }
    
}
