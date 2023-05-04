int saludos;

void vaBien() {
    print("Hola");
}

int suma(int a) {
    saludos = 2;
    a = 4;
    vaBien();
    return saludos + 5;
}

void main () {
    int j;
    int z;
    saludos = 3;
    j = 1;
    z = suma(j);
}
