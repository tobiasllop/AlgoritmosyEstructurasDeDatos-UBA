# Ejercicio Parcial TM- Estructuras
Sistema para registrar Notas de alumnos en la facultad.

Materias tienen un nombre, puede haber cant infinita

notas entre 0 y 10

cada alumno tiene LU, nro menor a 1000 (acotado)

Requerimientos: 
m = cant materias
* RegistrarMateria: O(log m)
* RegistrarNota: O(log m)
* NotasDeAlumno: O(log m)
* CantAlumnosConNota y CantAlumnosAprobados: O(log m)

Modulo:
    
    modulo SistemaImpl Implementa Sistema{
        var alumnos: diccTrie(alumno, diccAVL(materia, nota ))
        var materias: diccAVL(materia, (array(int)))
    }  
<hr>

#### Repaso estructuras:
* ListaEnlazada: Su beneficio es que le puedo agregar algo adelante o atrás en O(1).
   Es lineal, para buscar un elemento tengo que recorrer toda la lista. Se usa para Pilas o Colas.
* Vector: Igual que el array, pero se puede agrandar. Su limitación es que insertar un elemento o varios se realiza en O(n)
* Array : su limitacion es el tamaño fijo, si uno sabe cuantos elementos hay, usar array. 
  Insertar: O(1)
* Heap: Se utiliza cuando yo necesito fácilmente el máximo o el mínimo.
   Insertar, sacar: O(log n)
   Armar: O(n) con algo de FLoyd
* Trie: Se utiliza cuando esta acotada la key. Su complejidad no depende de la cantidad de elementos
* AVL/ABB: Se utiliza para insertar y buscar con O(log n)
* Hash

## Ejercicio Rep y Abs

**Invrep informal**
1. En contrincantes tengo que si es bueno tiene malos y si es malo tiene buenos
2. si a es contrincante de b, b lo es de a
3. buenos y malos son distintos/disjuntos
4. todos los contrincantes son buenos o malos
5. para cada tupla de HistLuchas, b es bueno y m malo.
6. para cada tupla de HistLuchas, b tiene entre sus signif (de contrincantes) a m y viceversa.
7. Si a tiene a b en sus contrincantes (a,b) o (b,a) aparecen al menos una vez en HistLuchas.

**Invrep Formal**
1- 
    
    forall p:int :: p in L'.contrincantes :: p in L'.buenos ==> L'.cont[p] incluidoEn( L'.malos) &&L
        (p in L'.malos ==> (L'.contrinc[p] incluidoEn(L'.buenos))) 

2- 
    
    forall a:int :: a in L'.contrinc ==>
        forall b:int :: a != b && b in L'.contrincantes ::
            a in L'.contrinc[b] <==> b in L'.contrinc[a]
3-

    forall a:int :: a in L'.buenos :: !(a in L'.malos) && 
    forall a:int :: a in L'.malos :: !(a in L'.buenos)
4-

    forall a:int :: a in L'.contrincantes :: a in L'.buenos or a in L'.malos
5-

    forall i:int :: 0 <= i <= L'.histLuchas.lenght ::
        L'.HistLuchas[i].b in L'buenos && L'.HistLuchas[i].m in L'.malos
6-

    forall i : int :: 0 <= i < L'.HistLuchas.lenght ::
        L'.HistLuchas[i].b in L'.contrincantes[L'.HistLuchas[i].m] &&
        L'.HistLuchas[i].m in L'.contrincantes[L'.HistLuchas[i].b]
7- 
    
    forall a,b:int :: a in L'.contrinc && b in L'.contrinc[a] ::
        exists i:int :: 0 <= i < L'.HistLuchas[i] ::
            (L'.HistLuchas[i] == tupla<a,b>) or (L'.HistLuchas[i] == tupla<b,a>)

**Final**

    pred Invrep(L': 99%LuchaIMpl){
    1 && 2 && 3 && 4 && 5 && 6 && 7
    }

**FuncAbs**

    pred abs(L: 99%Lucha L': 99%luchaImpl){
        L'.buenos.elems == L.buenos &&
        L'.malos.elems == L,malos &&
        forall: b, m : int :: b in L.buenos && m in L.malos :: 
            L.cantLuchas(b,m) == cantApariciones(L'.HistLuchas.elems, <b,m>)
    }

#### Ejercicio complejidad
    AlgoritmoExótico(A: arreglo de int, R: arreglo de tupla<val: int, reps: int>) {
        n := long(A).   						// O(1)
        R[0] := <A[0],1> 						// O(1)
        r := 0								// O(1)
        i := 1								// O(1)
        res := 0								// O(1)
        
        while (i < n) {						// O(n)
            if A[i] == R[r].val {				// O(1)
                R[r] := <R[r].val, R[r].reps + 1>	// O(1)
            } else {							// O(r)
                j := 1							// O(1)
                
                while (j <= R[r].reps) {			// O(r)
                    res := res + R[r].val * j 	// O(1)    	
                    j := j + 1					// O(1)
                }

                r := r + 1						// O(1)	
                R[r] := <A[i], 1>				// O(1)
            }
            i := i + 1							// O(1)
        }
        
        return res 							// O(1)	
    }

**Peor Caso: O(n)**
**Mejor caso: O(n)**

Para multiplicar las complejidades de dos ciclos, los ciclos tienen que ser independientes, en este caso no puedo tener un arreglo en el que todos los numeros se repiten n veces, por lo que los ciclos son dependientes y las complejidades de los dos ciclos no se suman.

#### Ejercicio Sorting
Me pide Ordenarlo en O(n + klog(n))

    Alg(s:secuencia, k:int): secuencia {
        //extender la tupla con la posicion (nombre,ptos,intentos,indice)
        max heapify(s) // primero comparo por puntos de forma decreciente, segundo por intentos de forma creciente y finalmente por posición creciente //O(n)
        res := new arr<k> //O(k)
        for i=0...k do // O(k * log n)
            res[i] := próximo(s).nombre //O(1)
            desencolar(s) //O(log n)
        return res
    }
    
