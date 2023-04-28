/*********************************************************************************
 * Excepción utilizada al intentar hacer un return de un tipo diferente al de la función
 *
 * Fichero:    NotBoolean.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

package lib.symbolTable.exceptions;

public class IncompatibleTypes extends Error {

    public IncompatibleTypes(String mensaje) {
        super(mensaje);
    }
}
