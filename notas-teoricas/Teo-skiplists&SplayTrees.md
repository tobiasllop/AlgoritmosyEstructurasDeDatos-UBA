## Skip Lists
* Diccionarios con listas encadenadas ordenadas.
* Muy simples pero ineficientes: O(n)
* Podemos ir "salteando punteros".
* **Costo de búsqueda en skip lists**: el análisis completo puede ser complicado pero intuitivamente es O(log n) en promedio

#### Algoritmos probabilisticos: Algoritmo + azar
**algoritmos las vegas** con T(n) como variable aleatoria.
* Ejemplo: skip lists y quick sort
* E(T(n)) $\in$ O(n log n) o sea la esperanza de T(n) pertenece a O(n log n)

**Algoritmos monte Carlo**
* Ejemplo: test de primalidad

## Splay Trees (ST)
* Idea: tratar de "tender" todo el tiempo al ABB óptimo, osea un árbol en el que los elementos más accedidos
 esten más cerca de la raíz.
* Estructuras "auto-ajustantes" (self-adjusting)
* Cada vez que accedemos a un elemento lo "subimos" en el arbol, llevandolo a la raíz a través de rotaciones
 del tipo AVL.
* Más simples de implementar que AVLs (no hay que verificar condiciones de balanceo)
* Sin requerimientos de memoria adicionales.
* Podemos garantizar O(m log n) para secuencias de m operaciones. 
* **TEO**: asintoticamente, los ST son tan eficientes como cualquier ABB fijo
* **CONJETURA**: asintoticamente, los ST son tan eficientes como cualquier ABB que se modifique a traves de
  rotaciones

  #### Splaying
  * Si accedemos a la raíz del árbol, no hacemos nada.
 * Si accedemos a k, y el padre de k es la raíz, hacemos una rotación simple.
 * Si accedemos a k, y el padre de k no es la raíz, hay dos casos posibles (y sus especulares): rotación zig-zag, y rotación zig-zig.
