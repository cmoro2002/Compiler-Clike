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

public class Attributes implements Cloneable {
    public Symbol.Types type;
    public Symbol.ParameterClass parClass;

    // Para guardar los valores de las constantes
    public int valInt;
    public boolean valBool;
    public char valChar;
    public String valString; // Siempre será constante

    // Constructor para los enteros
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, int _valInt) {
        type = _type;
        parClass = _parClass;
        valInt = _valInt;
    }

    // Constructor para los booleanos
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, boolean _valBool) {
        type = _type;
        parClass = _parClass;
        valBool = _valBool;
    }

    // Constructor para los carácteres
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, char _valChar) {
        type = _type;
        parClass = _parClass;
        valChar = _valChar;
    }

    // Constructor para los strings
    public Attributes(Symbol.Types _type, Symbol.ParameterClass _parClass, String _valString) {
        type = _type;
        parClass = _parClass;
        valString = _valString;
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
