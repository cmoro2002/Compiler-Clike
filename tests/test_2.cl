// Ahorcado.cl
// Juego del ahorcado

void mostrarPalabra(char palabra[10], int letrasCorrectas[10]) {
    int i;
    print_ln();
    print_ln();
    i = 0;

    while (i < 10) {
        if (letrasCorrectas[i] == 1) {
            print(palabra[i]);
        } else {
            print("- ");
        }
        i = i + 1;
    }
}

void main() {
    char palabra[10];
    int letrasCorrectas[10];
    int intentos;
    int i;
    char letra;
    int taman;
    bool acierto;
    bool acertado;
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

    intentos = 15;

    while (intentos > 0) {
        // mostrarAhorcado(intentos);
        mostrarPalabra(palabra, letrasCorrectas);

        print_ln();
        print("Introduce una letra: ");
        read(letra);
        
        acierto = false;
        i = 0;
        taman = 0;
        while (taman < 10) {
            if (palabra[i] == letra) {
                letrasCorrectas[i] = 1;
                acierto = true;
            }
            i = i + 1;
            taman = taman + 1;
        }

        if (!acierto) {
            intentos = intentos - 1;
        }

        acertado = true;
        i = 0;
        taman = 0;
        while (taman < 10) {
            if (letrasCorrectas[i] == 0) {
                acertado = false;
            }
            i = i + 1;
            taman = taman + 1;
        }

        if (acertado) {
            mostrarPalabra(palabra, letrasCorrectas);
            print_ln("¡Felicidades! ¡Has adivinado la palabra!");
        }
    }
}