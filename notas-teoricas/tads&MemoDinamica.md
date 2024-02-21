# Tads
●  Un TAD (tipo abstracto de datos) es una abstracción que sirve para describir una
parte de un problema

● Describe el qué y no el cómo

● Tiene estado

● Se manipula a través de operaciones, que describimos mediante un lenguaje de especificación (lógica) con pre y postcondición
 
●Son una forma de modularizar a nivel de los datos

#### Diseño de Tads
* **Transparencia Referencial**: Una funcion es **referencialmente transparente** si su resultado solo depende de sus parametros explìcitos. Ej: f(x) : = {return x + 1}, f(4) + f(3) es r.t.
* **Aliasing**: signigica la posibilidad de tener más de un nombre para la misma cosa. En concreto, dos punteros o referencias al mismo objeto. 


* **Invariante de representación** : El invariante de representación es un predicado que nos indica qué conjuntos de valores son instancias válidas de la implementación. Se tiene que cumplir siempre al entrar y al salir de todas las operaciones (en la pre y en la post). Toma un sólo parámetro: el módulo.

  El invariante determina unicamente la cota inferior de la complejidad de las operaciones. Por ejemplo, el invariante del AVL nos garantiza ciertas propiedades sobre la estructura: cada nodo es un ABB y el factor de desbalanceo F es tal que |F| ≤ 1. Gracias a esto, podemos implementar algoritmos que se apoyan en estas propiedades para ser eficientes, en el caso del AVL lograr las operaciones en O(log(n)). Aun ası, nuestros algoritmos pueden ignorar estas propiedades y ser muy ineficientes, por eso el invariante no determina una cota superior.

* **Función de abstracción** : La función de abstracción nos va a indicar, dada una instancia de implementación, a qué instancia del TAD corresponde, a qué instancia del TAD representa, qué instancia del TAD “es su abstracción”. La función de abstracción hace referencia a las variables de estado de la 
implementación y a los observadores del TAD (porque tiene que vincular unas con otros). Para definirla, se puede suponer que vale el invariante de representación.

# Memoria Dinámica
La Memoria Dinamica es el mecanismo a travès del cual los lenguajes imperativos nos proveen de primitivas para almacenar información cuando no sabemos de antemano cuánto espacio necesitamos, o incluso cuando lo sabemos pero la cota superior es muy grande (y por lo tanto la gestión estática de la memoria no resulta adecuada).

Parte de una organización de la memoria dividida en dos partes:
* El stack (pila) de memoria estática, y
* El “heap” (montón) para la memoria dinámica

**Stack**: El stack se usa para la memoria estática. Cada vez que se entra a ejecutar una rutina (incluyendo el main), se asigna un “frame” o bloque, que contiene la memoria estática
que pide el procedimiento, incluyendo espacio para los parámetros formales, que son cargados con los valores con los que se invocó (algunos de ellos, potencialmente referencias). Cuando finaliza la ejecución de la rutina, su “frame” se desapila y
esa memoria se libera automáticamente. Los detalles son transparentes al programador.

**Heap**: El “Heap” (montón), es un espacio de memoria para almacenar objetos (estructuras y arreglos) a los que se accede por medio de referencias (o punteros). Estas elementos pueden contener, además de tipos básicos, referencias a otros elementos en el heap. La memoria que es parte del Heap puede ser requerida de diversas maneras (por ejemplo, a través de la primitiva New y el tipo del dato que se quiere).

**Mecanismos de devolución de la memoria dinámica**
* Gestionada por programador (“a la C”): la gestión, incluyendo la liberación, es responsabilidad de le programador. Eficiente pero potencialmente “unsafe” o con “leaks”.
* Gestionada x Garbage Collector (“a la Java”). Hay “aliasing” pero la liberación es por medio del GC. Menos eficiente pero “safe”, y no necesita gestión de eliminación por parte de le programador.
* Mecanismo de Ownership (“a la Rust”): el concepto de ownership y salida de scope implica liberación de memoria. Requiere seguir ciertas disciplinas de programación (pero menos carga para el programador). Es más eficiente (que Java) y safe (que C y Java).

