//*****************************************************************
// File:   Attributes.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   enero 2022
//         Clase única para almacenar los atributos que pueden aparecer en el traductor de adac
//         Se hace como clase plana, por simplicidad. Los atributos que se pueden almacenar
//         se autoexplican con el nombre
//*****************************************************************

package lib.attributes;

import lib.symbolTable.*;
import traductor.Token;

public class Attributes implements Cloneable {
    public Symbol.Types type;
    public Symbol.ParameterClass parClass;

    public Token token; // Para guardar el token y mostrar los warnings

    // Para guardar los valores de las constantes
    public int valInt;
    public boolean valBool;
    public char valChar;
    public String valString; // Siempre será constante

    public int posicionPila; // Sirve para subir la posicion de la pila
    public boolean constante; // Para saber si es un parametro constante y poder operar con el

    // Constructor para los enteros
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, int _valInt) {
        type = _type;
        parClass = _parClass;
        valInt = _valInt;
        constante = false;
    }

    // Constructor para los booleanos
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, boolean _valBool) {
        type = _type;
        parClass = _parClass;
        valBool = _valBool;
        constante = false;
    }

    // Constructor para los carácteres
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, char _valChar) {
        type = _type;
        parClass = _parClass;
        valChar = _valChar;
        constante = false;
    }

    // Constructor para los strings
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, String _valString) {
        type = _type;
        parClass = _parClass;
        valString = _valString;
        constante = false;
    }

    // Constructor para los enteros constantes
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, int _valInt, boolean _constante) {
        type = _type;
        parClass = _parClass;
        valInt = _valInt;
        constante = _constante;
    }

    // Constructor para los booleanos constantes
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, boolean _valBool, boolean _constante) {
        type = _type;
        parClass = _parClass;
        valBool = _valBool;
        constante = _constante;
    }

    // Constructor para los carácteres constantes
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, char _valChar, boolean _constante) {
        type = _type;
        parClass = _parClass;
        valChar = _valChar;
        constante = _constante;
    }

    // Constructor para los strings constantes
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, String _valString, boolean _constante) {
        type = _type;
        parClass = _parClass;
        valString = _valString;
        constante = _constante;
    }

    public Attributes clone() {
        try {
            return (Attributes) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String toString() {
        String valor;
        switch (type) {
            case INT:
                valor = String.valueOf(valInt);
                break;
            case BOOL:
                if (valBool) {
                    valor = "true";
                } else {
                    valor = "false";
                }
                break;
            case CHAR:
                valor = String.valueOf(valChar);
                break;
            case STRING:
                valor = valString;
                break;
            default:
                valor = "ERROR";
                break;
        }
        return "type = " + type + "\n" +
                "parClass = " + parClass + "\n" +
                "value = " + valor + "\n";

    }
}
