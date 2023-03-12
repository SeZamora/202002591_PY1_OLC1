//-------> Paquete, importaciones
package analizador; 
import java_cup.runtime.Symbol; 
import java.util.ArrayList;
import estructuras.*;

%%

%column
%full
%class Lexico
%public
%cupsym sym
%line
%char
%unicode
%cup
%ignorecase

//expresion regular
comentarioLineas = "<!"[^"!>"]*"!>"
cadena = ([\"][^\n\"]+[\"])|([\'][^\n\']+[\'])
comentario = ("//" [^"\n"]+)
numero = [0-9]+
letra = [a-zA-Z]
id = {letra}+("_"|{numero})*
acci = ("!")|("\"")|("#")|("$")|("%")|("&")|("\'")|("(")|(")")|("*")|("+")|(",")|("-")|(".")|("/")|(":")|(";")|("<")|("=")|(">")|("?")|("@")|("[")|("]")|("^")|("_")|("`")|("{")|("}")
caracterEspecial = ([\"][^\n\"]+[\"][\"])
flecha =([-][\t\r\n\f ]*[>]')
%%


<YYINITIAL> ("{")   {System.out.println("se encontro una llave abierta");               return new Symbol(sym.llavea, yycolumn, yyline, yytext());}
<YYINITIAL> ("}")   {System.out.println("se encontro una llave cerrada");               return new Symbol(sym.llavec, yycolumn, yyline, yytext());}
<YYINITIAL> (":")   {System.out.println("se encontro el simbolo dos puntos");           return new Symbol(sym.dospuntos, yycolumn, yyline, yytext());}
<YYINITIAL> (";")   {System.out.println("se encontro el simbolo punto coma");           return new Symbol(sym.puntocoma, yycolumn, yyline, yytext());}
<YYINITIAL> {flecha}  {System.out.println("se encontro el simbolo flecha");               return new Symbol(sym.flecha, yycolumn, yyline, yytext());}
<YYINITIAL> (".")   {System.out.println("se encontro el simbolo punto");                return new Symbol(sym.punto, yycolumn, yyline, yytext());}
<YYINITIAL> ("*")   {System.out.println("se encontro el simbolo asterisco");            return new Symbol(sym.asterisco, yycolumn, yyline, yytext());}
<YYINITIAL> (",")   {System.out.println("se encontro el simbolo coma");                 return new Symbol(sym.coma, yycolumn, yyline, yytext());}
<YYINITIAL> ("|")   {System.out.println("se encontro el simbolo or");                   return new Symbol(sym.or, yycolumn, yyline, yytext());}
<YYINITIAL> ("+")   {System.out.println("se encontro el simbolo mas");                  return new Symbol(sym.mas, yycolumn, yyline, yytext());}
<YYINITIAL> ("~")   {System.out.println("se encontro el simbolo guionondulado");        return new Symbol(sym.guionondulado, yycolumn, yyline, yytext());}
<YYINITIAL> ("?")   {System.out.println("se encontro el simbolo ?");                    return new Symbol(sym.interrogacion, yycolumn, yyline, yytext());}
<YYINITIAL> ("CONJ")    {System.out.println("se encontro la palabra reservada CONJ");   return new Symbol(sym.conj, yycolumn, yyline, yytext());}
<YYINITIAL> ("%%")  {System.out.println("se encontraron los porcentajes");              return new Symbol(sym.porcentajes, yycolumn, yyline, yytext());}
<YYINITIAL> {comentarioLineas}  {System.out.println("se encontro un comentarioLineas");}
<YYINITIAL> {cadena}    {System.out.println("se encontro una cadena");                  return new Symbol(sym.cadena, yycolumn, yyline, yytext());}
<YYINITIAL> {comentario}    {System.out.println("se encontro un comentario");}
<YYINITIAL> {numero}    {System.out.println("se encontro una numero");                  return new Symbol(sym.numero, yycolumn, yyline, yytext());}
<YYINITIAL> {letra} {System.out.println("se encontro una letra");                       return new Symbol(sym.letra, yycolumn, yyline, yytext());}
<YYINITIAL> {id}    {System.out.println("se encontro un id");                           return new Symbol(sym.id, yycolumn, yyline, yytext());}
<YYINITIAL> {acci}  {System.out.println("se encontro un simbolo");                  return new Symbol(sym.acci, yycolumn, yyline, yytext());}
<YYINITIAL> {caracterEspecial} {System.out.println("se encontro un caracterEspecial");                  return new Symbol(sym.caracterEspecial, yycolumn, yyline, yytext());}


[ \t\r\n\f] { /* ignorar */ }

. {
    System.out.println("Este es un error lexico: " +yytext() + " en linea " + yyline + " y columna " + yycolumn);
  
}



