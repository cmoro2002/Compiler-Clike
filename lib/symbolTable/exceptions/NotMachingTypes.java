/*********************************************************************************
 * Excepción utilizada al intentar utilizar un símbolo no definido en
 * la tabla de símbolos
 *
 * Fichero:    NotMachingTypes.java
 * Fecha:      02/03/2022
 * Versión:    v1.1
 * Asignatura: Procesadores de Lenguajes, curso 2021-2022, basado en código del 19-20
 **********************************************************************************/

 package lib.symbolTable.exceptions;

import lib.attributes.Attributes;

public class NotMachingTypes extends Error {
 
    public NotMachingTypes(Attributes var1, Attributes var2) {
		super("Las variables no son del mismo tip:" + var1.toString() + 
		" y " + var2.toString());
	}

}
 
 