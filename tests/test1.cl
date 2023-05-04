int saludos;

int suma(int a, int &b, int &c, int d) {
    int ka;
    c = 5*15;
    
    ka = a;
    a = 3;
    a = suma(a,b,c,d);
    return ka + b;
}

void main () {
    int j;
    int k;
    int z;
    int hola;
    int adios;
    hola = 3;
    adios = 10;
    j = 1;
    k = 2;
    z = suma(j, k, hola, adios);
    print_ln(z, j);
    print_ln(k, hola);
}
