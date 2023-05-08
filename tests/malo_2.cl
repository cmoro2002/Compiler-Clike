// Test Erróneo 2. Causa return en procedimiento

void mostrar(int resultado) {
    print(resultado);
    return resultado;
}

void main() {
    int i = 0;
    int j = 1;
    int resultado = i*j;
    mostrar(resultado);
}