//-------> Paquete, importaciones
package analizador; 
import java_cup.runtime.Symbol; 

%%

%{
    //Código de usuario
%}

//-------> Directivas
%class Lexico
%cup            // trabajar con cup 
%public         // tipo publico
%line           // conteo de lineas - linea por linea
%char           // caracter por caracter
%unicode        // tipo de codigicacion para que acepte la  ñ u otro caracter
%ignorecase     // case insensitive 
%column

//expresion regular
CMULTI = "<!"[^"!>"]*"!>"
CADENA = ([\"][^\n\"]+[\"])|([\'][^\n\']+[\'])
CLINEA = ("//" [^"\n"]+)
NUMERO = [0-9]+
LETRA = [a-zA-Z]
ID = {LETRA}({LETRA}|LETRA}|"_")*
ACCI = [!-/] | [:-@] | [\[-`] | [\{-\}]
ESPECIAL = ([\"][^\n\"]+[\"][\"])
ALLAVE = "{"
CLLAVE = "}"
DOSPUNTOS = ":"
PUNTOCOMA = ";"
FLECHA = "->"
PUNTO = "."
ASTERISCO = "*"
COMA = ","
BARRA = "|"
MAS = "+"
GUION = "~"
INTERROGACION = "?" 
CONJ = "CONJ"
PORCENTAJES = "%%"

%%

<YYINITIAL> {ALLAVE}                         {System.out.println("se encontro una llave abierta");                    return new Symbol(sym.ALLAVE, yyline, yycolumn, yytext());}
<YYINITIAL> {CLLAVE}                          {System.out.println("se encontro una llave cerrada");                  return new Symbol(sym.CLLAVE, yyline, yycolumn, yytext());}
<YYINITIAL> {DOSPUNTOS}                          {System.out.println("se encontro el simbolo dos puntos");            return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());}
<YYINITIAL> {PUNTOCOMA}                          {System.out.println("se encontro el simbolo punto coma");           return new Symbol(sym.PUNTOCOMA, yyline, yycolumn, yytext());}
<YYINITIAL> {FLECHA}                        {System.out.println("se encontro el simbolo flecha");                    return new Symbol(sym.FLECHA, yyline, yycolumn, yytext());}
<YYINITIAL> {PUNTO}                         {System.out.println("se encontro el simbolo punto");                     return new Symbol(sym.PUNTO, yyline, yycolumn, yytext());}
<YYINITIAL> {ASTERISCO}                          {System.out.println("se encontro el simbolo asterisco");               return new Symbol(sym.ASTERISCO, yyline, yycolumn, yytext());}
<YYINITIAL> {COMA}                          {System.out.println("se encontro el simbolo coma");                     return new Symbol(sym.COMA, yyline, yycolumn, yytext());}
<YYINITIAL> {BARRA}                          {System.out.println("se encontro el simbolo or");                          return new Symbol(sym.BARRA, yyline, yycolumn, yytext());}
<YYINITIAL> {MAS}                         {System.out.println("se encontro el simbolo mas");                       return new Symbol(sym.MAS, yyline, yycolumn, yytext());}
<YYINITIAL> {GUION}                         {System.out.println("se encontro el simbolo guionondulado");      return new Symbol(sym.GUION, yyline, yycolumn, yytext());}
<YYINITIAL> {INTERROGACION}                         {System.out.println("se encontro el simbolo ?");                           return new Symbol(sym.INTERROGACION, yyline, yycolumn, yytext());}
<YYINITIAL> {CONJ}                  {System.out.println("se encontro la palabra reservada CONJ");   return new Symbol(sym.CONJ, yyline, yycolumn, yytext());}
<YYINITIAL> {PORCENTAJES}                    {System.out.println("se encontraron los porcentajes");                return new Symbol(sym.PORCENTAJES, yyline, yycolumn, yytext());}
<YYINITIAL> {CMULTI}               {System.out.println("se encontro un comentarioLineas");}
<YYINITIAL> {CADENA}                {System.out.println("se encontro una cadena");                          return new Symbol(sym.CADENA, yyline, yycolumn, yytext());}
<YYINITIAL> {CLINEA}                {System.out.println("se encontro un comentario");}
<YYINITIAL> {NUMERO}                {System.out.println("se encontro una numero");                return new Symbol(sym.NUMERO, yyline, yycolumn, yytext());}
<YYINITIAL> {LETRA}                    {System.out.println("se encontro una letra");                    return new Symbol(sym.LETRA, yyline, yycolumn, yytext());}
<YYINITIAL> {ID}                           {System.out.println("se encontro un id");                           return new Symbol(sym.ID, yyline, yycolumn, yytext());}
<YYINITIAL> {ACCI}                      {System.out.println("se encontro un simbolo");                  return new Symbol(sym.ACCI, yyline, yycolumn, yytext());}
<YYINITIAL> {ESPECIAL}              {System.out.println("se encontro un caracterEspecial");   return new Symbol(sym.ESPECIAL, yyline, yycolumn, yytext());}


[ \t\r\n\f] { /* ignorar */ }


<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        System.out.println(errLex);
}





