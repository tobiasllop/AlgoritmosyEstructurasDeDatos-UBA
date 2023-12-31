package aed;

class Debugging {
/* ORIGINAL
   boolean xor(boolean a, boolean b) {
        return a || b && !(a && b);
    } 
*/
    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

/* ORIGINAL
    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }
*/

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;
        if (xs.length == ys.length) {
            for (int i = 0; i < xs.length; i++) {
                if (xs[i] != ys[i]) {
                    res = false;
                }
            }
        }
        else {
            res = false;
        }
        return res;
    }

/* ORIGINAL
    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        return res;
    }
*/  
    boolean ordenado(int[] xs) {
        boolean res = true;
        if (xs.length >= 2) {
        for (int i = 0; i < xs.length-1; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        }
        return res;
    }

/* ORIGINAL
    int maximo(int[] xs) {
        int res = 0;
        for (int i = 0; i <= xs.length; i++) {
            if (xs[i] > res) res = i;
        }
        return res;
    }
*/  
    
    int maximo(int[] xs) {
        int res = xs[0];
        for (int i = 1; i < xs.length; i++) {
            if (xs[i] > res) res = xs[i];
        }
        return res;
    }

/* ORIGINAL
    boolean todosPositivos(int[] xs) {
        boolean res = false;
        for (int x : xs) {
            if (x > 0) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }
*/  
    
    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int i=0; i < xs.length; i++) {
            if (xs[i] <= 0) {
                res = false;
            } 
        }
        return res;
    }
}

