//----------------------------------------------------------------------
//  text_stats.cl
//  uso: text_stats < fichero_de_texto
//----------------------------------------------------------------------

//------------------------------------------------------
bool separator(char c) {

    if ((c >= '0') && (c <= '9')) {
        return false;
    }
    else {
        if ((c >= 'A') && (c <= 'Z')) {
            return false;
        }
        else {
            return ((c >= 'a') && (c <= 'z'));
        }
    }
}

//------------------------------------------------------
char upcase(char c) {

    if ((c >= 'a') && (c <= 'z')) {
        return int2char(char2int(c) - 32);
    }
    else {
        return c;
    }
}
//------------------------------------------------------
char c, separador[10];
int chars, words, lines;
bool in_word;

void main() {
    chars = 0;
    words = 0;
    lines = 0;
    in_word = false;
	read (c);
	while (c != int2char(-1)) {
        chars = chars + 1;
        if (c == int2char(10)) {
            lines = lines + 1;
        }
        else {
            if (separator(c)) {
                in_word = false;
            }
            else {
                if (!in_word) {
                    in_word = true;
                    words = words + 1;
                }
            }
        }
		read (c);
	}
    print_ln ("uso: text_stats < fichero_de_texto");
    print_ln ();
    print_ln ("Chars: ", chars);
    print_ln ("Words: ", words);
    print_ln ("Lines: ", lines);
}
