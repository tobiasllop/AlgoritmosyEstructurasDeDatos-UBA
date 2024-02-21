## ABB
* Un arbol binario admite como máximo dos elementos por cada nodo
* **ABB**: Es un Ab que para todo nodo, los valores de su subárbol izquierdo son menores que el valor del nodo, y los valores de los elementos de su subárbol derecho son mayores que el valor del nodo.
## Algoritmos para ABB
* Vacio()
* Agregar(A,c): buscar al padre del nodo a insertar e insertarlo como hijo de ese padre.

Costo de la inserción en el peor caso:  O(n)

Costo de la inserción en el caso promedio (suponiendo una distribución uniforme de las claves):  O(log n)

* Borrar(u, A): Hay tres casos cuando u es una hoja, cuando u tiene un solo hijo y cuando u tiene dos hijos.
  1. Borrar una hoja: Busca al padre y elimina la hoja.
  2. Borrar un nodo u con un solo hijo v:
     Buscar al padre w de u.
     Si existe w, reemplazar la conexión (w,u) con la conexion (w,v)          3. Borrado de un nodo u con dos hijos:
     Encontrar el "predecesor inmediato" v (o sucesor inmediato) de u.
          v no puede tener dos hijos, en caso contrario no sería el                   predecesor inmediato (sucesor).
     Copiar la clave v en lugar de la u.
     Borrar el nodo v (v es hojo o bien tiene un solo hijo, lo que nos           lleva a casos anteriores.              

Costo del borrado de un nodo interno: O(n)

## AVL
Es un arbol k-ario, i.e cada nodo tiene 0 o k hijos. Además la longitud de dos ramas cualesquiera difiere a lo sumo en una unidad.

**Teo**: Un arbol perfectamente balanceado de n nodos tiene altura $log_2$ n + 1

Costo de búsqueda/inserción/borrado = O(log n)

**Balanceo en altura** : las alturas de los subárboles izquierdo y derecho de cada
nodo difieren en a lo sumo una unidad.

**Factor de Balanceo (FDB)** = altura subarbol Der - Altura subárbol Izq

Los arboles balanceados en altura se llaman **AVL** y cumplen que |FDB| <= 1, para cada nodo.

## Arboles de fibonacci
Un árbol de Fibonacci tiene todos los factores de
balanceo de sus nodos internos ± 1.

Un árbol de Fibonacci con n nodos tiene altura < 1.44 * log(n +2) – 0.328

**inserción en AVL**:
1. Insertar el nuevo nodo como en un ABB “clásico”
el nuevo nodo es una hoja
2. Recalcular los factores de balanceo que
cambiaron por la inserción
sólo en la rama en la que ocurrió la inserción (los otros
factores no pueden cambiar!), de abajo hacia arriba
3. Si en la rama aparece un factor de balanceo de
±2 hay que rebalancear
A través de “rotaciones”

**Borrado en los AVL**
1. Borrar el nodo como en un ABB “clásico”
2. recalcular los factores de balanceo que
cambiaron por el borrado
sólo en la rama en que ocurrió el borrado, de abajo
hacia arriba
3. para cada nodo con factor de balanceo ±2 hay
que hacer una rotación simple o doble
