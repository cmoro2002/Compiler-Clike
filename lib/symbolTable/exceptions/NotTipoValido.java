/*********************************************************************************
 * Excepción utilizada al intentar utilizar una operacion en una variable no booleana
 *
 * Fichero:    NotBoolean.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

package lib.symbolTable.exceptions;

import lib.attributes.Attributes;
import lib.symbolTable.Symbol;

public class NotTipoValido extends Error {

    public NotTipoValido(Attributes var1) {
        super("La variable " + var1.toString() + " no es ni booleana ni char ni int ni string.");
    }

    public NotTipoValido(Symbol.Types var1) {
        super("No es ni booleana ni char ni int ni string. (completar este error si eso :)");
    }

    public NotTipoValido(Symbol var1) {
        super("La variable " + var1.toString() + " no es ni booleana ni char ni int.");
    }

}
