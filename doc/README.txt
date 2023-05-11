Compilador clike.jar (V1.0)
------------------------------
Generación de codigo
------------------------------
Autores:
    - César Moro Latorre 815078
    - Alejandro Lalaguna Maza 819860

Invocar como:

-------------------------------------------------------------
java -jar clike_4.jar <fichero_fuente_clike>
-------------------------------------------------------------

Si se invoca sin parámetros, lee la entrada estándar.

Características generales:
1) No permite funciones anidadas
2) Usa LOOKAHEAD, aunque es fácilmente transformable en LL(1)
3) En el nivel más alto, se pueden intercalar declaraciones de funciones/procedimientos y declaraciones de variables. No así dentro de una función (ya que no hay anidamiento)
4) No se pueden intercalar instrucciones con declaraciones dentro de una func/proc: primero las declaraciones de variables, luego las instrucciones

Características de implementación:
1) Se permite la definición de variables globales.
2) No se permite la instrucción 'return' en un procedimiento ni en la funcion main.
3) En una función debe aparecer almenos una vez la instrucción 'return'. 
4) No se permite la definición de matrices, solo de vectores simples.
5) Se permite el paso de vectores y escalares como parámetros de funciones y procedimientos tanto por valor como por referencia.
6) Durante la compilación de un fichero clike pueden aparecer warnings y errores. Los errores se muestran por pantalla y no generan pcode. Los warnings se muestran por pantalla pero si se genera el codigo.
7) No se permite el paso por referencia de constantes.


TESTS:
Hemos realizado 3 tests que funcionan correctamente y realizan un programa funcional, 
explicando en una linea al comienzo que hace. Estos tests son:
    - test1.cl
    - test2.cl
    - test3.cl