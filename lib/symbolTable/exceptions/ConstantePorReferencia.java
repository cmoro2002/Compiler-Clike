/*********************************************************************************
 * Excepción utilizada al intentar pasar una constante por referencia
 *
 * Fichero:    NotBoolean.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

package lib.symbolTable.exceptions;

public class ConstantePorReferencia extends Error {

    public ConstantePorReferencia() {
        super("Se ha intentado pasar una constante por referencia");
    }
}
