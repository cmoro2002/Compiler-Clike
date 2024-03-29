//*****************************************************************
// File:   SymbolTable.java
// Author: Procesadores de Lenguajes-University of Zaragoza
// Date:   julio 2021
// Coms:   Atributos públicos para ahorrarnos el uso de getters y setters
//*****************************************************************

//la tabla de símbolos será un ArrayList de diccionarios (HashMap<String, Symbol>), manejada como
//una pila: se inserta y accede por la derecha
//Cada nuevo bloque se apilará, guardando los símbolos en el diccionario correspondiente
//El constructor ya genera el primer bloque, vacío inicialmente.

//https://quick-adviser.com/can-a-hashmap-have-multiple-values-for-same-key/
//HashMap doesn’t allow duplicate keys but allows duplicate values. That means A 
//single key can’t contain more than 1 value but more than 1 key can contain a single value.
//HashMap allows null key also but only once and multiple null values.
//https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html

package lib.symbolTable;

import java.util.*;
import lib.symbolTable.exceptions.SymbolNotFoundException;
import lib.symbolTable.exceptions.AlreadyDefinedSymbolException;

public class SymbolTable {
    private final int ST_SIZE = 16; // hasta 16 niveles
    private final int HASH_SIZE = 1024; // buckets
    private ArrayList<HashMap<String, Symbol>> st;
    private Set<String> reservedWords;

    public int level; // nivel actual

    public SymbolTable() {
        st = new ArrayList<HashMap<String, Symbol>>(ST_SIZE);
        level = -1; // aún no hay ningún bloque intoducido
        insertBlock();
        reservedWords = new HashSet<String>();
    }

    public SymbolTable(String[] pals) {
        st = new ArrayList<HashMap<String, Symbol>>(ST_SIZE);
        level = -1; // aún no hay ningún bloque introducido
        insertBlock();
        reservedWords = new HashSet<String>(Arrays.asList(pals));
    }

    // apila un nuevo bloque
    public void insertBlock() {
        st.add(new HashMap<String, Symbol>(HASH_SIZE));
        level++;
    }

    // elimina un bloque
    public void removeBlock() {
        st.remove(st.size() - 1);
        level--;
    }

    // inserta las palabras reservadas, sustituyendo el anterior contenido
    public void insertReservedWords(String[] pals) {
        reservedWords = new HashSet<String>(Arrays.asList(pals));
    }

    public boolean isReservedWord(String word) {
        return reservedWords.contains(word);
    }

    // Si un símbolo con el mismo nombre está o es palabra reservada, excepción.
    // Si no, se inserta
    public void insertSymbol(Symbol s) throws AlreadyDefinedSymbolException {
        if (reservedWords.contains(s.name)) {
            throw new AlreadyDefinedSymbolException(s.name);
        }
        HashMap<String, Symbol> currentBlock = st.get(st.size() - 1);
        if (currentBlock.containsKey(s.name)) { // ya está
            throw new AlreadyDefinedSymbolException(s.name);
        } else {
            s.nivel = level;
            // Leer cuantos símbolos hay en el bloque actual, calcular su offset y
            // asignárselo al nuevo símbolo
            int offset = 3;
            for (Map.Entry entry : currentBlock.entrySet()) {
                // Obtener el simbolo de la entrada
                Symbol symbol = (Symbol) entry.getValue();
                // Comprobar si el simbolo es una instancia del tipo array
                if (symbol instanceof SymbolArray) {
                    // Obtener el simbolo como instancia de Array
                    SymbolArray array = (SymbolArray) symbol;
                    // Obtener el tamaño del array
                    int arraySize;
                    if (symbol.parClass == Symbol.ParameterClass.REF) {
                        arraySize = 1;
                    } else {
                        arraySize = array.maxInd + 1;
                    }
                    offset += arraySize;
                } else if (symbol instanceof SymbolFunction || symbol instanceof SymbolProcedure) {
                    // NO SUMAR
                } else {
                    offset++;
                }
            }
            s.posicionPila = offset;
            currentBlock.put(s.name, s);
        }
    }

    // Funcion que dado el nombre de una symbolFunction o un symbolProcedure,
    // devuelve
    // el tamaño total que ocupa en la pila
    public int getFunctionSize() throws SymbolNotFoundException {
        HashMap<String, Symbol> currentBlock = st.get(st.size() - 1);
        // Leer cuantos símbolos hay en el bloque actual, calcular su offset y
        // asignárselo al nuevo símbolo
        int offset = 2;
        for (Map.Entry entry : currentBlock.entrySet()) {
            // Obtener el simbolo de la entrada
            Symbol symbol = (Symbol) entry.getValue();
            // Comprobar si el simbolo es una instancia del tipo array
            if (symbol instanceof SymbolArray) {
                // Obtener el simbolo como instancia de Array
                SymbolArray array = (SymbolArray) symbol;
                // Obtener el tamaño del array
                int arraySize;
                if (symbol.parClass == Symbol.ParameterClass.REF) {
                    arraySize = 1;
                } else {
                    arraySize = array.maxInd + 1;
                }
                offset += arraySize;
            } else if (symbol instanceof SymbolFunction || symbol instanceof SymbolProcedure) {
                // NO SUMAR
            } else {
                offset++;
            }
        }
        return offset;
    }

    // Funcion que devuelve una lista con los simbolos del nivel actual de la tabla
    // de simbolos
    public List<Symbol> getSimbolos() {
        HashMap<String, Symbol> currentBlock = st.get(st.size() - 1);
        List<Symbol> simbolos = new ArrayList<Symbol>();
        for (Map.Entry entry : currentBlock.entrySet()) {
            // Obtener el simbolo de la entrada
            Symbol symbol = (Symbol) entry.getValue();
            simbolos.add(symbol);
        }
        return simbolos;
    }

    // Si no está, excepción. Si está, devuelve su referencia
    public Symbol getSymbol(String name) throws SymbolNotFoundException {
        Symbol result = findSymbol(name);
        if (result == null) {
            throw new SymbolNotFoundException(name);
        }
        return result;
    }

    // comprueba si está el símbolo
    public boolean containsSymbol(String name) {
        return findSymbol(name) != null;
    }

    // para usar en "getSymbol" y "containsSymbol"
    private Symbol findSymbol(String name) {
        for (int i = st.size() - 1; i >= 0; i--) {
            if (st.get(i).containsKey(name)) {
                return st.get(i).get(name);
            }
        }
        return null;
    }

    // devuelve la tabla como un string
    public String toString() {
        final String linea = "------------------------------------------------\n";
        StringBuilder builder = new StringBuilder();
        builder.append(linea);
        String tabs = "";
        for (int i = 0; i < st.size(); i++) {
            for (Map.Entry entry : st.get(i).entrySet()) {
                // crear secuencia de tabuladores
                tabs = new String(new char[i]).replace("\0", "\t");
                builder.append(tabs);
                builder.append(entry.toString());
                builder.append("\n");
            }
        }
        builder.append(linea);
        return builder.toString();
    }

}