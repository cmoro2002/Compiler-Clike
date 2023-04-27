int suma(int &a, int b) {
    int ka;
    ka = a;
    a = 3;
    return ka + b;
}

void main () {
    int j;
    int k;
    int z;
    j = 1;
    k = 2;
    z = suma(j, k);
    print(z, j);
}
