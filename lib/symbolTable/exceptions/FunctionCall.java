/*********************************************************************************
 * Excepción utilizada al intentar llamar a una funcion sin hacer una asignación
 *
 * Fichero:    FunctionCall.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

package lib.symbolTable.exceptions;

public class FunctionCall extends Error {

    public FunctionCall() {
        super("No esta permitido llamar a una funcion sin hacer una asignacion");
    }
}
