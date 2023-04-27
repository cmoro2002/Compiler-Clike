//----------------------------------------------------------------------
//  min_a_may.cl
//  Convierte min a de lo leído de stdin
//  Un ejemplo para detectar fin de fichero
//      min_a_may < fichOrig > fichTrad
//----------------------------------------------------------------------
	
//-------------------------------------------------
char aMay(char c) {
	int ascii;
	int difAsciis;

	difAsciis = char2int('a')-char2int('A');
	ascii = char2int(c);
	if ((char2int('a') <= ascii) && (ascii <= char2int('z'))){
		return int2char(ascii - difAsciis);
	}
	else{
		return c;	
	}
}
//-------------------------------------------------
void main() {
	char c;
	read(c);
	while (char2int(c) >= 0) {
		print(aMay(c));
		read(c);
	}
	
	print_ln("");
}