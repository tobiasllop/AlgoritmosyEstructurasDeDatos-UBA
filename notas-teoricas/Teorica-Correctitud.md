## Correctitud
  * Un programa es **correcto respecto de la especificación** si se tiene **un requiere = P** y un **asegura = Q** y siempre que el programa empieza en un estado que cumple P, el programa termina su ejecución y en el estado final se cumple Q. (En otras palabras, cumple el requiere y como consecuencia el asegura)
  * Un programa **S** que es correcto se nota: **{P} S {Q}**
  EJ: {x ≥ 4} x := x + 1 {x ≥ 5}
* La precondición **más débil de un programa S** respecto de una postcondición Q es el **predicado P más débil posible** tal que {P}S{Q}
  Notación: **wp(S,Q)**
* Teorema: 
  Una tripla de Hoare {P}S{Q} es válida si y sólo si:
   **P =>L wp(S,Q)**
* para demostrar la validez de {P}S{Q} nos alcanza con
probar la fórmula: P ⇒L wp(S, Q)
  *Necesitamos un mecanismo para hallar la wp(S,Q)*
* Dada una expresión E, llamamos **def(E)** a las
condiciones necesarias para que E este definida.
 Ej: def(x/y) ≡ def(x) ∧ (def(y) ∧L y ̸= 0).
 