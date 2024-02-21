# Complejidad
El análisis de la complejidad de un algoritmo se puede hacer de forma:
* Empirica o experimental
* Teorica

**Ventajas del enfoque teórico**:
* El análisis se puede hacer a priori, aún antes de escribir código.
* Vale para todas las instancias del problema
* Es independiente del lenguaje de programación utilizado para codificarlo.
* Es independiente de la máquina en la que se ejecuta.
* Es independiente de la pericia del programador.

**Operaciones elementales**: Considaramos OE a aquellas operaciones que el procesador realiza en tiempo acotado por una constante. Consideramos OE a las operaciones ariméticas básicas, comparaciones lógicas
transferencais de control, asignaciones a variables de tipos básicos, etc. 

El tiempo de una OE es, por definición 1.

**Principio de Invarianza**:  Dado un algoritmo y dos máquinas (o dos
implementaciones) M<sub>1</sub> y M<sub>2</sub>, que tardan T<sub>1</sub>(n) y T<sub>2</sub>(n)
respectivamente sobre inputs de tamaño n, existe una cte. real c > 0 y un n<sub>0</sub> $\in$ N tales que $\forall$ n $\geq$ n<sub>0</sub>
se verifica que:
            T<sub>1</sub>(n) $\leq$ c * T<sub>2</sub>(n)
