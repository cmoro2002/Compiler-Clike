//----------------------------------------------------------------------
//  invertir_pgm.cl
//  uso: invertir_pgm < fich_pgm_orig > fich_pgm_invert
//  El formato pgm que vamos a usar es el siguiente
//
//P5
//fils cols
//max_gris
//pixels por filas(one byte per pixel, binary)
//----------------------------------------------------------------------

//---------------------------------------------------
int indice(int fils, int cols, int i, int j) {
	return i*cols + j;
}
//---------------------------------------------------
void guardar_imagen(int formato, int fils, int cols, int prof,
	               char& imagen[500000]) {
	char c; 
	int i, j; 

	print_ln('P', formato); 
	print_ln(fils, ' ', cols); 
	print_ln(prof); 
	i = 0; 
	while (i < fils) {
		j = 0; 
		while (j < cols) {
			print(imagen[indice(fils, cols, i, j)]); 
			j = j + 1; 
		}
		i = i + 1; 
	}
}
//---------------------------------------------------
bool cargar_imagen(int& formato, int& fils, int& cols, int& prof, char& imagen[500000]) {
	int i, j; 
	char c;

	read(c);
	read(formato);
	read(fils);
	read(cols); 
	read(prof); 
	read_ln(); 
	
    if (fils*cols > 500000){
        print("Imagen de dimensiones(", fils, ", ", cols, ")");
        print_ln(" demasiado grande(max 500000 pixels)!");
        return false;
    }
    else {
        i = 0; 
        while (i < fils) {
            j = 0; 
            while (j < cols) {
                read(imagen[indice(fils, cols, i, j)]); 
                j = j + 1; 
            }
            i = i + 1; 
        }
        return true;
    }
}
//---------------------------------------------------
void invertir_imagen(int formato, int fils, int cols, int prof,
	                 char& imagen[500000]) {
	char c;   
	int i, j, idx; 

	i = 0; 
	while (i < fils) {
		j = 0; 
		while (j < cols) {
            idx = indice(fils, cols, i, j); 
			imagen[idx] = int2char(prof - char2int(imagen[idx])); 			   
			j = j + 1; 
		}
		i = i + 1; 
	}
}
//---------------------------------------------------
void main() {
	int formato; 
	int fils, cols; 
	int max_gris; 
	char image[500000]; 

	if (cargar_imagen(formato, fils, cols, max_gris, image)) {
        invertir_imagen(formato, fils, cols, max_gris, image); 
        guardar_imagen(formato, fils, cols, max_gris, image);
    }
}