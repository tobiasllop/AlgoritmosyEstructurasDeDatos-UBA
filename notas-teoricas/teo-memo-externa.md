# Memoria Externa

#### Métodos de ordenación para mem. secundaria.
1. Fusión Múltimple Equilibrada
2. Selección por sustitución
3. Fusión Polifásica.

#### Busqueda/Diccionarios externa
1. Acceso Secuencial Indexado (ISAM). Problema de este método: muy rígido, si va a haber inserciones y/o borrados
2. Arboles B: Son arboles balanceados: todas las hojas están a la misma distancia de la raiz. Idea: Acceder a una página de memoria por nivel.
3. Hashing Extensible. A semejanza de los Árboles B, los registros se almacenan en páginas que, cuando se llenan, se dividen en dos partes. En la práctica, se va armando (y desarmando) un árbol de índices, cuyas hojas apuntan al archivo donde está el registro. Si el árbol de índices cabe en memoria principal, entonces con un sólo acceso a disco, alcanza.
