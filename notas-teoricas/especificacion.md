# Especificacion

* Una **Especificación** es un contrato entre el programador de una función y el usuario de esa función. Es la descripción de un problema.
* Una **Programa** es la descripción de la solución a un problema escrita para ser ejecutada por una computadora.
* Un **Algoritmo** es la descripción de la solución escrita para humanos.
* Una **Implementación** es la ejecución de un programa en una computadora  
  
* Partes de una especificación:
    * Encabezado
    * Precondición
    * Postcondición
* Escribir la especificación de un problema nos ayuda a entenderlo mejor y a construir el programa. Además de prevenir errores  mediante el testing.
*  **Sobre-especificación** : Consiste en dar una postcondición más restrictiva de la que se necesita
*  **Sub-especificación** : Consiste en dar una precondición más restrictiva de la que se necesita o  bien una postcondición más débil que la que se puede dar.
* Pasaje de parámetros:
   * entrada (in)
   * salida (out)
   * entrada-salida (inout)
* Un **tipo de datos** es un conjunto de valores (el conjunto base del tipo) provisto de una serie de operaciones que involucran a esos valores.
* Tipos de datos: 
    * Enteros ($\mathbb{Z}$)
    * Reales ($\mathbb{R}$)
    * Booleanos (bool)
    * Caracteres (char)
    * Enumerados
    * Uplas
    * Secuencias
    * Conjuntos
* Funciones y predicados auxiliares
    * $\texttt{aux f(argumentos): tipo = e;}$
    * $\texttt{pred p(argumentos)\{f\}}$
* Operaciones sobre secuencias
  *  length(a: seq $\langle T\rangle$ ): $\mathbb{Z}$ (notación |a|)
  *  indexación: seq $\langle T\rangle$[ i : $\mathbb{Z}$ ] : $T$
  *  igualdad: seq $\langle T \rangle$ = seq $\langle T \rangle$
  *  head(a: seq $\langle T \rangle$) : $T$
  *  tail(a: seq $\langle T \rangle$) : $T$
  *  addfirst(t: $T$, a: seq $\langle T \rangle$ ): seq $\langle T \rangle$
  *  concat(a: seq $\langle T \rangle$ , b: seq $\langle T \rangle$ ): seq $\langle T \rangle$ . (notación a++b)
  *  subseq(a: seq $\langle T \rangle$ , d,h: $\mathbb{Z}$ ): seq $\langle T \rangle$ 
  *  setAt(a: seq $\langle T \rangle$ , i: $\mathbb{Z}$ , val: $T$): seq $\langle T \rangle$
* En el lenguaje de especificación también se pueden usar sumatorias($\sum$) y productorias($\prod$)
* Matriz: es una secuencia de secuencias, todas con la misma longitud y ninguna vacía.
