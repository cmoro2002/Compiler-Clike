// Test Erróneo 4. Causa declaración después de código en función/procedimiento. 

void mostrar(int resultado) {
    resultado = 4+1;
    int algo = 1;
    print(resultado);
}

void main() {
    int i = 0;
    int j = 1;
    int resultado = i*j;
    mostrar(resultado);
}