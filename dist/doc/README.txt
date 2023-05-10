Compilador clike.jar (V1.0)
------------------------------
Generación de codigo
------------------------------
Autores:
    - César Moro Latorre 815078
    - Alejandro Lalaguna Maza 819860

Invocar como:

-------------------------------------------------------------
java -jar clike.jar <fichero_fuente_clike>
-------------------------------------------------------------

Si se invoca sin parámetros, lee la entrada estándar.

Características generales:
1) No permite funciones anidadas (se ha comentado la parte que lo permite)
2) Usa LOOKAHEAD, aunque es fácilmente transformable en LL(1)
3) En el nivel más alto, se pueden intercalar declaraciones de funciones/procedimientos y declaraciones de variables. No así dentro de una función (ya que no hay anidamiento)
4) No se pueden intercalar instrucciones con declaraciones dentro de una func/proc: primero las declaraciones de variables, luego las instrucciones

Características de implementación:
1) Se permite la definición de variables globales.
2) No se permite la instrucción 'return' en un procedimiento ni en la funcion main.
3) En una función puede aparecer o no la instrucción 'return'. 
4) No se permite la definición de matrices, solo de vectores simples.

TESTS:
Hemos realizado 3 tests que funcionan correctamente y realizan un programa funcional, 
explicando en una linea al comienzo que hace. 
También hemos hecho 6 tests que dan error para comprobar algunos de los casos de 
error que hemos considerado necesarios.