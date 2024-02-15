# Correctitud de ciclos

#### Teorema del invariante
Si existe un predicado $I$ tal que:
1. $P_c \implies I $ ("El invariante se cumple antes de iniciar un ciclo")
2. { $I \land B$ }S{ $I$ } = $I \land B \implies wp(S,I)$ ("Ejecutar el cuerpo del ciclo preserva el invariante")
3. $I \land B \implies Q_c$ ("El invariante y la guarda implican la postCondicion del ciclo")
 
entonces el ciclo **while($B$) S** es parcialmente correcto respecto de la especificación ($P_c, Q_c$).

#### Teorema de terminación de un ciclo
Sea $\mathbb{V}$ el producto cartesiano de los dominios de las variables del programa y sea $I$ un invariante del ciclo **while B do S endwhile**. Si existe una funcion $f_v: \mathbb{V} \rightarrow \mathbb{Z}$ tal que: 
1.  { $I \land B \land v_0 = f_v$ } S { $f_v < v_0$ } ("La funcion es estritamente creciente")
2.  $I \land f_v \leq 0 \implies \neg B$, ("Cuando la funcion variante llega a 0 deja de valer la guarda")

entonces la ejecución del ciclo **while B do S endwhile** siempre termina.
**Teorema**: Si  se cumple el teorema de terminación y el teorema del invariante, entonces el ciclo es correcto y la siguiente tripla de Hoare es valida: { $P_c$ } **while B do S endwhile** { $Q_c$ }
