# Representación de diccionarios con tries y tablas de hash
## Tries
Esta estructura de datos requiere concentrarse en las claves.
Vamos a suponer que las claves x pertenecen a un alfabeto$Σ^x$.
Tenemos que pensar que no tienen todas tamaño constante (O(1) para comparar), sino que tienen una longitud ∣x∣.
Esa longitud puede ser:
* La longitud propiamente dicha, en caso de strings.
* O log(x) si x es un entero
 
Además, definimos a k = ∣Σ∣, como la cantidad de símbolos distintos del alfabeto Σ.

* Complejidad de insertar clave x : **O(|x|)**
* Complejidad de buscar clave x: **O(|x|)**

## Tablas de hash
* Son la generalización de los diccionarios al concepto de arreglos.
* Importantes para el acceso de datos en memoria secundaria
* Se asocia a cada valor de la clave un indice de un arreglo
* Busqueda en tiempo O(1)
* Desventajas: mucho desperdicio de memoria y solo sirve para claves que son enteros no negativos 
* Para indexar otro tipo de datos que no sean enteros usamos funciones de hashing. ejemplo: "hola" -> 10011101 -> 157

#### Complejidades
* insert(el, k): inserción al principio de la lista
asociada a la posición h(k): costo O(1)
* buscar(k): búsqueda linear en la lista
asociada a la posición h(k): costo O(longitud
de la lista asociada a h(k))
* delete(k): búsqueda en la lista asociada a la
posición h(k): costo O(longitud de la lista
asociada a h(k))
