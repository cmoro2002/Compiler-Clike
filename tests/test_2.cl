// Ahorcado.cl
// Juego del ahorcado

void mostrarPalabra(char palabra[], int letrasCorrectas[]) {
    int i;
    print_ln();
    print_ln();

    while (i < strlen(palabra)) {
        if (letrasCorrectas[i]) {
            print(palabra[i]);
        } else {
            print("- ");
        }
        i = i + 1;
    }
}

int main() {
    char palabra[TAM];
    // Dar valor al vector palabra uno a uno con las letras de "hipopotamo";
    palabra[0] = 'h';
    palabra[1] = 'i';
    palabra[2] = 'p';
    palabra[3] = 'o';
    palabra[4] = 'p';
    palabra[5] = 'o';
    palabra[6] = 't';
    palabra[7] = 'a';
    palabra[8] = 'm';
    palabra[9] = 'o';

    int letrasCorrectas[TAM];
    letrasCorrectas[0] = 0;
    letrasCorrectas[1] = 0;
    letrasCorrectas[2] = 0;
    letrasCorrectas[3] = 0;
    letrasCorrectas[4] = 0;
    letrasCorrectas[5] = 0;
    letrasCorrectas[6] = 0;
    letrasCorrectas[7] = 0;
    letrasCorrectas[8] = 0;
    letrasCorrectas[9] = 0;

    int intentos;
    intentos = 7;
    int i;
    char letra;

    while (intentos > 0) {
        // mostrarAhorcado(intentos);
        mostrarPalabra(palabra, letrasCorrectas);

        print_ln();
        print("Introduce una letra: ");
        read(letra);
        
        int acierto;
        acierto = 0;
        i = 0;
        int taman;
        taman = 0;
        while (taman < TAM) {
            if (palabra[i] == letra) {
                letrasCorrectas[i] = 1;
                acierto = 1;
            }
            i = i + 1;
            taman = taman + 1;
        }

        if (!acierto) {
            intentos = intentos - 1;
        }

        int acertado;
        acertado = 1;
        i = 0;
        int taman;
        taman = 0;
        while (taman < TAM) {
            if (letrasCorrectas[i] == 0) {
                acertado = 0;
            }
            int i;
            i = i + 1;
            taman = taman + 1;
        }

        if (acertado) {
            mostrarPalabra(palabra, letrasCorrectas);
            print_ln("¡Felicidades! ¡Has adivinado la palabra!");
            return 0;
        }
    }