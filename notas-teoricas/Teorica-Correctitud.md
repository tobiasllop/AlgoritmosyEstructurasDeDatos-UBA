## Correctitud
  * Un programa es **correcto respecto de la especificación** si se tiene **un requiere = P** y un **asegura = Q** y siempre que el programa empieza en un estado que cumple P, el programa termina su ejecución y en el estado final se cumple Q. (En otras palabras, cumple el requiere y como consecuencia el asegura)
  * Un programa **S** que es correcto se nota: **{P} S {Q}**
  EJ: {x ≥ 4} x := x + 1 {x ≥ 5}
* La precondición **más débil de un programa S** respecto de una postcondición Q es el **predicado P más débil posible** tal que {P}S{Q}
  Notación: **wp(S,Q)**
* Teorema: 
  Una tripla de Hoare {P}S{Q} es válida si y sólo si:
   **P =><sub>L</sub> wp(S,Q)**
* para demostrar la validez de {P}S{Q} nos alcanza con
probar la fórmula: P ⇒<sub>L</sub> wp(S, Q)
  *Necesitamos un mecanismo para hallar la wp(S,Q)*
* Dada una expresión E, llamamos **def(E)** a las
condiciones necesarias para que E este definida.
 Ej: def(x/y) ≡ def(x) ∧ (def(y) ∧<sub>L</sub> y ̸= 0).
 * Dado un predicado Q, el predicado Q<sub>E</sub><sup>x</sup> reemplaza todas las variables x por E en Q.
* *Aignacion de elementos en una secuencia b*: b[i] := E se escribe como: 
  b = setAt(b, i, E)
* **Corolario de la monotonia**: Si:

                         P ⇒ wp(S1, Q), 
                         Q ⇒ wp(S2, R), e
                         entonces:  P ⇒ wp(S1; S2, R).

#### Axiomas
* **Axioma 1** (Asignación) : Dado un programa S: x:= E, 
  Ax1 = wp(S,Q) = def(x=E) ^<sub>L</sub> Q<sub>E</sub><sup>x</sup>
* **Axioma 2** : wp(skip,Q) = Q
*  **Axioma 3**  : wp(S1,S2,Q) = wp(S1,wp(S2,Q))
*  **Axioma 4** : Dado un programa S: if B then S1 else S2,
   wp(S,Q) = def(B) ^<sub>L</sub> ((B ^ wp(S1,Q)) v (not(B) ^ wp(S2,Q)))
* **AXioma 5** : wp(While B do S endwhile Q) = ($\exists$<sub>i $\geq$ 0</sub>)(H<sub>i</sub>(Q))

