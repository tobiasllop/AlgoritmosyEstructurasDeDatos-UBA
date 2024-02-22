## Colas de prioridad
* Generalmente la prioridad se expresa con un entero pero puede ser cualquier otro tipo $\alpha$ con un orden asociado.
* La implementacióm más eficiente de una cola de prioridad es a través de heaps.
  
## Heap o max-heap
1. Es un AVL
2. Cada nodo tiene mayor o igual prioridad que sus hijos, en caso de que tenga.
3. Todo subárbol es un heap
4. (no obligatorio) Es izquierdista. i.e el último nivel esta lleno desde la izquierda.

Variante: **min heap** 

Cumple las mismas condiciones que antes pero cambia el punto 2. ya que cada nodo tiene menor o igual prioridad que sus hijos

## Implementación de heaps - Representación con arrays.
* Cada nodo v es almacenado en la posición p(v)

- Si v es la raiz, entonces p(v) = 0
- Si v es el hijo izquierdo de u, entonces p(v)=2p(u) + 1
- Si v es el hijo derecho de u, entonces p(v)=2p(u) + 2

**Heaps sobre Arrays**
| Ventajas | Desventajas |
- - - - - - - - - - - - - - 
| Muy eficientes en términos de espacio y facilidad de navegación | Implementación estática (puede ser necesario duplicar el arreglo (o achicarlo) a medida que se agregan/eliminan elementos.| 
## Algoritmos de heaps
* **Proximo**: el elemento de prioridad máxima está en la posición 0 de un arreglo.

Operación de costo: constante O(1)

* **Encolar**: Insertamos el elemento al final del heap, e implementamos la operación subir.

Subir(elemento): 

    while (elemento no es raiz) y_L (prioridad(padre(elemento))> prioridad(padre(elemento))):
      intercambiar elemento con el padre 
* **Desencolar**: 
  - Reemplazar el primer elemento con la última hoja y eliminar la última hoja. Luego implementamos la operación bajar(raíz).
  
  Bajar(p):

      while (p no es hoja) y_L (prioridad(p)< prioridad(algun hijo de p)):
         intercambiar p con el hijo de mayor prioridad
  
* Tanto para encolar como para desencolar, el costo es proporcional a la altura del heap que es O(log n)

## Array2Heap
Dado un array arr, lo transforma en un array que representa un heap a través de una permutación de sus elementos.

* Algoritmo simple:

      para i desde 1 hasta tam(arr):
          encolar(arr[i]);

Costo *O*(n log n)

* Algoritmo de Floyd
- Está basado en la idea de aplicar la operación bajar a árboles binarios tales que los hijos de la raíz son raíces de heaps
- Progresivamente se "heapifican" los subárboles con raíz en el penúltimo nivel, luego los del antepenúltimo, etc..

- Caso peor: cada llamada a bajar hace el máximo número de intercambios.

max de intercambios = O(n)
