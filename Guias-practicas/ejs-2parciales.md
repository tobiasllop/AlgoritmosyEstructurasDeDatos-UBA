# 2do parcial - 1C2023
## 1.a
Como tenemos que ordenar distintos numeros según el rango en el que se encuentren utilizaremos Bucket Sort. Que tiene complejidad O(n)

    proc OrdenarSemi(A: arreglo(nat), L: nat, H: nat): arreglo(nat) {
        n = lenght(A)
        B = new arr[n] // Inicializamos array de de buckets
        for i in range(n): //O(n)
            if A[i] <= 4:
                agregarAdelante(A[i], B[0]) //Sigue crec
            elif A[i] > 12:
                AgregarAtras(A[i], B[1]) //Sigue decrec
            else:
                AgregarAtras(A[i], B[2])
        endfor
        InsertionSort(B[2]) //O(sqrt(n) ^ 2) == O(n)
        res := concat(B[0], B[1], C) //O(n)
    }

    //Preguntar si esta bien usado el InsertionSort
    //Preguntar si se puede decir bucketSort() y listo, y cual seria la complej de bucket en este caso
    //Preguntar si hay que hacer a cada lita lo de list2Array
### b.
Complejidad del algoritmo sera O(n+n+n)=O(n)

# 1er parc - 1C2019
## 3
a. 
1. Todas las claves en $tienedueña$ que poseen valor Falso deben pertenecer al conjnto $huerfanas$
2. Todas las claves en $tienedueña$ que poseen valor Verdadero deben ser claves de los dicc $dueña$ y $distdueña$
3. La longitud de $dueña$ y $distDueña$ es la misma
4. Si una antena es valor en el dict *dueña* entonces el Nro de clientes en $nroClientes$ debe ser > 0.
5. Una antena es dueña de una unidad sii está a alguna distancia de la unidad y es la mínima respecto al resto de las antenas o es igual y su número es mayor.
6. La distancia a su dueña de una unidad es igual a la distancia de la antena a la unidad.

<hr>

###### 1. y 2.
    for all c in tieneDueña :: 
    if c.clave == false then c in huerfanas 
    else c in dueña and c in distdueña fi
###### 3.
    |dueña| == |distdueña|
###### 4.
    for all u:clave in dueña ::
            forall a:clave in nroClientes::
                 if dueña[u] == a then
                    nroclientes[a] > 0
                else 
                    nroClientes[a] = 0  

