// Impuestos.cl
// Programa que calcula los impuestos segun la opcion elegida por el usuario

void main() {
    int salario_bruto, salario_neto, impuesto;
    int opcion;

    // Solicita el salario bruto del usuario
    print("Ingrese su salario bruto: ");
    read(salario_bruto);

    // Permite al usuario seleccionar un método de cálculo de impuestos
    print("Seleccione el método de cálculo de impuestos:\n");
    print("1 - Tarifa plana de impuestos (20%)\n");
    print("2 - Tasa de impuestos progresiva\n");
    print("Ingrese su selección: ");
    read(opcion);

    // Calcula el impuesto y el salario neto según la opción seleccionada
    if (opcion == 1) {
        impuesto = salario_bruto * 2;
    } else {
        if (salario_bruto <= 1000) {
            impuesto = 0;
        } 
        if (salario_bruto <= 5000) {
            impuesto = salario_bruto * 1;
        } 
        else {
            impuesto = salario_bruto * 2;
        }
    }

    salario_neto = salario_bruto - impuesto;

    // Imprime el resultado
    print_ln("Salario neto: ", salario_neto);
}
