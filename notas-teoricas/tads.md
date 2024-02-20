# Tads
●  Un TAD (tipo abstracto de datos) es una abstracción que sirve para describir una
parte de un problema

● Describe el qué y no el cómo

● Tiene estado

● Se manipula a través de operaciones, que describimos mediante un lenguaje de especificación (lógica) con pre y postcondición

#### Diseño de Tads
* **Invariante de representación** : El invariante de representación es un predicado que nos indica qué conjuntos de valores son instancias válidas de la implementación. Se tiene que cumplir siempre al entrar y al salir de todas las operaciones (en la pre y en la post). Toma un sólo parámetro: el módulo.

  El invariante determina uunicamente la cota inferior de la complejidad de las operaciones. Por ejemplo, el invariante del AVL nos garantiza ciertas propiedades sobre la estructura: cada nodo es un ABB y el factor de desbalanceo F es tal que |F| ≤ 1. Gracias a esto, podemos implementar algoritmos que se apoyan en estas propiedades para ser eficientes, en el caso del AVL lograr las operaciones en O(log(n)). Aun ası, nuestros algoritmos pueden ignorar estas propiedades y ser muy ineficientes, por eso el invariante no determina una cota superior.

* **Función de abstracción** : La función de abstracción nos va a indicar, dada una instancia de implementación, a qué instancia del TAD corresponde, a qué instancia del TAD representa, qué instancia del TAD “es su abstracción”. La función de abstracción hace referencia a las variables de estado de la 
implementación y a los observadores del TAD (porque tiene que vincular unas con otros). Para definirla, se puede suponer que vale el invariante de representación.
