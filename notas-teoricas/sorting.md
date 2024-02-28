# Sorting
|        | Descripcion    | Complejidad | Estable?    |
|--------|-----------|------|----------|
| **Insertion Sort** | Se va insertando en el lugar correspondiente cada elemento en un arreglo ordenado | O(n^2)  | Si|
| **Selection Sort**   | Busca el mínimo elemento entre una posición i y el final de la lista, lo intercambia con el elemento de la posición i e incrementa i.   | O(n^2)   | No   |
| **Merge Sort**   |  Algoritmo recursivo que ordena sus dos mitades y luego las fusiona  | O(n log n) | Si|
| **Quick Sort** |  Elige un pivote y separa los elementos entre los menores y los mayores a él. Luego, se ejecuta el mismo procedimiento sobre cada una de las partes | O(n^2)   | No|
| **Heap Sort**   |  Arma el Heap en O(n) y va sacando los elementos ordenados pagando O(log n). | O(n log n)   | No|

* **Estabilidad**: Decimos que un algoritmo es estable si mantiene el orden anterior de elementos con igual clave.

* Corolario: ningún algoritmo de ordenamiento tiene complejidad mejor que O(n log n).
