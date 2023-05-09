//*****************************************************************
// Tratamiento de errores sintácticos
//
// Fichero:    ErrorSintactico.java
// Fecha:      03/03/2022
// Versión:    v1.0
// Asignatura: Procesadores de Lenguajes, curso 2021-2022
//*****************************************************************

package lib.errores;

import traductor.Token;

import lib.symbolTable.exceptions.*;

public class ErrorSemantico {
	final static String sep = "*************************************************************************";

	private static int contadorErrores = 0;
	private static int contadorWarnings = 0;

	public static void deteccion(AlreadyDefinedSymbolException e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. No se puede redefinir el símbolo");
		System.err.println(sep);
	}

	public static void deteccion(SymbolNotFoundException e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. El símbolo no está definido");
		System.err.println(sep);
	}

	public static void deteccion(NotBoolean e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Se esperaba un booleano");
		System.err.println(sep);
	}

	public static void deteccion(NotInt e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Se esperaba un entero");
		System.err.println(sep);
	}

	public static void deteccion(NotChar e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Se esperaba un caracter");
		System.err.println(sep);
	}

	public static void deteccion(NotMachingTypes e, Token t1, Token g2) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t1.beginLine + "," + t1.beginColumn + "): " +
				"Símbolo: '" + t1.image + "'. Se esperaba un " + g2.image + " y se ha encontrado un " + t1.image);
		System.err.println(sep);
	}

	public static void deteccion(NotTipoValido e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Tipo no válido, se esperaba un entero, booleano o caracter");
		System.err.println(sep);
	}

	public static void deteccion(NotTipoValido e, Token t, String a) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Tipo no válido, se esperaba un entero, booleano, caracter o string");
		System.err.println(sep);
	}

	public static void deteccion(IncompatibleTypes e, Token t, String tipoVar, String tipo2) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Se esperaba que la variable fuera de tipo " + tipoVar + " y es de tipo "
				+ tipo2);
		System.err.println(sep);
	}

	// Tamaños incompatibles en llamada a una funcion (numero de parametros
	// incorrecto)
	public static void deteccion(IncompatibleSizes e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Numero de parametros incorrecto en la llamada a la función " + t.image);
		System.err.println(sep);
	}

	public static void deteccion(ConstantePorReferencia e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. No se puede pasar una constante por referencia");
		System.err.println(sep);
	}

	// public static void deteccion(ActionInvocationException e, String mensaje,
	// Token t) {
	// contadorErrores++;
	// System.err.println(sep);
	// System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn +
	// "): " +
	// "Error al invocar a: '" + t.image + "'. " + mensaje);
	// System.err.println(sep);
	// }

	public static void deteccion(String mensaje, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. " + mensaje);
		System.err.println(sep);
	}

	public static void deteccion(ArraySizeException e, Token t) {
		contadorErrores++;
		System.err.println(sep);
		System.err.println("ERROR SEMÁNTICO (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. Error al acceder a una componente fuera del vector");
		System.err.println(sep);
	}

	public static void warning(String mensaje, Token t) {
		contadorWarnings++;
		System.err.println(sep);
		System.err.println("WARNING: (" + t.beginLine + "," + t.beginColumn + "): " +
				"Símbolo: '" + t.image + "'. " + mensaje);
		System.err.println(sep);
	}

	public static void warning(String mensaje) {
		contadorWarnings++;
		System.err.println(sep);
		System.err.println("WARNING: " + mensaje);
		System.err.println(sep);
	}

	public static int getContadorErrores() {
		return contadorErrores;
	}

	public static int getContadorWarnings() {
		return contadorWarnings;
	}
}
