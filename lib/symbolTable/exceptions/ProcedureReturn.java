/*********************************************************************************
 * Excepción utilizada al intentar utilizar una operacion en una variable no booleana
 *
 * Fichero:    NotBoolean.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

package lib.symbolTable.exceptions;

public class ProcedureReturn extends Error {

    public ProcedureReturn(String procedimiento) {
        super("Se esta intentando devolver un valor del procedimiento: " + procedimiento);
    }

}
