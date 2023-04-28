/*********************************************************************************
 * Excepción utilizada al intentar utilizar una operacion en una variable no char
 *
 * Fichero:    NotChar.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

package lib.symbolTable.exceptions;

import lib.attributes.Attributes;

public class NotChar extends Error {

    public NotChar(Attributes var1) {
        super("La variable " + var1.toString() + " no es un char.");
    }

}
