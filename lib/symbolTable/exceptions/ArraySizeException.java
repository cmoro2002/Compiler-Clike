/*********************************************************************************
 * Excepción utilizada al intentar acceder a una componente de un vector que no es positivo
 *
 * Fichero:    NotBoolean.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

package lib.symbolTable.exceptions;

import lib.attributes.Attributes;

public class ArraySizeException extends Error {

    public ArraySizeException() {
        super("Error: El tamaño de un array debe ser un entero positivo");
    }

}
