# Correctitud de ciclos

#### Teorema del invariante
Si existe un predicado $I$ tal que:
1. $P_c \implies I $ 
2. $\{I \land B\}$S$\{I\}$
3. $I \land B \implies Q_c$
 
entonces el ciclo **while($B$) S** es parcialmente correcto respecto de la especificación ($P_c, Q_c$).

#### Teorema de terminación de un ciclo
Sea $\mathbb{V}$ el producto cartesiano de los dominios de las variables del programa y sea $I$ un invariante del ciclo **while B do S endwhile**. Si existe una funcion $f_v: \mathbb{V} \rightarrow \Z $ tal que: 
1.  { $I \land B \land v_0 = f_v$ } S { $f_v < v_0$ }
2.  $I \land f_v \leq 0 \implies \neg B$,

**Teorema**: Si  se cumple el teorema de terminación y el teorema del invariante, entonces el ciclo es correcto y la siguiente tripla de Hoare es valida: {$P_c$} **while B do S endwhile** {$Q_c$}
