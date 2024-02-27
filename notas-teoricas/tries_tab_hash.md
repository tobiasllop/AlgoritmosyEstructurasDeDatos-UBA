# Representación de diccionarios con tries y tablas de hash
## Tries
Esta estructura de datos requiere concentrarse en las claves.
Vamos a suponer que las claves x pertenecen a un alfabeto $Σ^x$.
Tenemos que pensar que no tienen todas tamaño constante (O(1) para comparar), sino que tienen una longitud ∣x∣.
Esa longitud puede ser:
* La longitud propiamente dicha, en caso de strings.
* O log(x) si x es un entero
 
Además, definimos a k = ∣Σ∣, como la cantidad de símbolos distintos del alfabeto Σ.

* Complejidad de insertar clave x : **O(|x|)**
* Complejidad de buscar clave x: **O(|x|)**

Se utilizan cuando tenemos un conjunto de datos acotados.

|Representación con listas de arreglos| Representación con arreglos y punteros|
|--------|-------|
Eficiente en terminos de tiempo solo si hay pocas claves |  Notar: puede ser muy ineficiente en terminos de espacio. En especial cuando ∣Σ∣ es grande y n es chico.|
|Requiere algoritmos sobre listas|   | 
|Mucho mas eficiente en terminos de memoria | Complejidad: En el peor caso se multiplica por k.
|Mucho menos utilizado| |
## Tablas de hash
* Son la generalización de los diccionarios al concepto de arreglos.
* Importantes para el acceso de datos en memoria secundaria
* Se asocia a cada valor de la clave un indice de un arreglo
* Busqueda en tiempo O(1)
* Desventajas: mucho desperdicio de memoria y solo sirve para claves que son enteros no negativos 

**Pre Hashing**
* Para indexar otro tipo de datos que no sean enteros usamos funciones de hashing. ejemplo: "hola" -> 10011101 -> 157
* Problema: generalmente el universo de claves que no son enteros es muy amplio y es muy difícil almacenar tantos datos. Como consecuencia va a haber claves distintas que al ser "hasheadas" van a pasar a tener la misma "pseudoclave". Este fenomeno se llama colision.
* Resolucion de colisiones:
   1. Direccionamiento cerrado o Concatenación: a la i-esima posicion de la tabla se le asocia la lista de los elementos tales que h(k) = i
   2. Direccionamiento abierto: todos los elementos se guardan en la tabla
* Requisitos de una funcion hash: Se quiere que los elementos se distribuyan en el arreglo de manera uniforme. i.e: P(k) = 1/|K|. Donde P(k) es la probabilidad de la clave k.

#### Complejidades en Concatenacion
* insert(el, k): inserción al principio de la lista
asociada a la posición h(k): costo O(1)
* buscar(k): búsqueda linear en la lista
asociada a la posición h(k): costo O(longitud
de la lista asociada a h(k))
* delete(k): búsqueda en la lista asociada a la
posición h(k): costo O(longitud de la lista
asociada a h(k))

#### Direccionamiento abierto
* Todos los elementos se almacenan en la tabla
* Las colisiones se resuelven dentro de la tabla:
  1. Si la posición calculada esta ocupada, hay que buscar una posición libre.
  2. Los distintos métodos con direccionamiento abierto se distinguen por el método de barrido que utilizan.
  3. La función hash pasa a depender también del número de intentos realizados.
  4. Dirección=h(k,i) para el i-esimo intento.
  5. h(k,i) debe generar todas las posiciones de T

**Barrido**
* La función h(k,i) debe recorrer todas las posiciones de la tabla.
* Varias formas tipicas para la función h(k,i)
  1. Barrido Linear.
  2. Barrido Cuadratico. h(k,i) = (h'(k) + c<sub>1<\sub>^i + c<sub>2<\sub>^i^2) mod |T| donde h'(k) es una función de hashing, c1 y c2 son constantes.
  3. Hashing Doble. h(k,i) = (h<sub>1<\sub>(k) + ih<sub>2<\sub>(k)) mod |T| donde h<sub>1<\sub>(k) y h<sub>2<\sub>(k) son funciones de hashing. El Hashing doble reduce los fenomenos de aglomeracion secundaria y no tiene aglomeracion primaria.

**Metodos de funciones hash**
* Division
* Particion
* Mid-square
* Extraccion
