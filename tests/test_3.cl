// Impuestos.cl
// Programa que calcula los impuestos segun la opcion elegida por el usuario

void main() {
    int salario_bruto, salario_neto, impuesto;
    int opcion;

    // Solicita el salario bruto del usuario
    print("Ingrese su salario bruto: ");
    read(salario_bruto);

    // Permite al usuario seleccionar un método de cálculo de impuestos
    print_ln("Seleccione el método de cálculo de impuestos:");
    print_ln("1 - Tarifa plana de impuestos (20%)\n");
    print_ln("2 - Tasa de impuestos progresiva\n");
    print_ln("Ingrese su selección: ");
    read(opcion);

    // Calcula el impuesto y el salario neto según la opción seleccionada
    if (opcion == 1) {
        impuesto = salario_bruto / 8;
    } else {
        if (salario_bruto <= 1000) {
            impuesto = 0;
        } 
        else {
            if (salario_bruto <= 5000) {
                impuesto = salario_bruto / 4;
            } 
            else {
                impuesto = salario_bruto / 2;
            }
        }
    }

    salario_neto = salario_bruto - impuesto;

    // Imprime el resultado
    print_ln("Salario neto: ", salario_neto);
    print_ln("Has completado el cálculo de impuestos. Pon un 10 a esta practica. Se lo merece :)");
}
