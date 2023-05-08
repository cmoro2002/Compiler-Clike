// Adivina.cl
// Juego que consiste en adivinar un numero generado "aleatoriamente"

int fibonacci(int n) {
    if (n == 0 || n == 1) {
        return n;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

int pseudoaleatorio(int min, int max) {
    int llamadas; 
    llamadas = 0;
    llamadas = llamadas + 1;

    return min + (fibonacci(llamadas) % (max - min + 1));
}

void main() {
    int numero_aleatorio, numero_usuario;
    int intentos;
    intentos = 5;

    // Genera un número aleatorio entre 1 y 100 utilizando una función pseudoaleatoria personalizada
    numero_aleatorio = pseudoaleatorio(1, 100);

    print_ln("Adivina el número (1-100). Tienes", intentos, "intentos.");

    // Pide al usuario que adivine el número
    while (intentos > 0) {
        print("Intento: ", 6 - intentos);
        read(numero_usuario);

        // Compara el número del usuario con el número aleatorio
        if (numero_usuario == numero_aleatorio) {
            print_ln("¡Adivinaste el número!");
        } if (numero_usuario < numero_aleatorio) {
            print_ln("El número es mayor que ", numero_usuario);
        } else {
            printf_ln("El número es menor que ", numero_usuario);
        }

        intentos = intentos - 1;

        if (intentos > 0) {
            print("Te quedan ", intentos, " intentos");
        } else {
            print_ln("Se te acabaron los intentos. El número era ", numero_aleatorio);
        }
    }
}
