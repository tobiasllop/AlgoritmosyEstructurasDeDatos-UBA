package aed;

import javax.swing.plaf.TreeUI;

class Funciones {
    int cuadrado(int x) {
        int res = x * x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x+y*y);
        return res;
    }

    boolean esPar(int n) {
        boolean res = Math.floorMod(n, 2) == 0;
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res;
        if (Math.floorMod(n, 4) == 0 && Math.floorMod(n, 100) != 0 ){
            res = true;
        }
        else if (Math.floorMod(n,400) == 0){
                res = true; 
        }
        else{
            res = false;
        }
        return res;
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i=1; i <= n; i++){
            res = res * i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n > 0){
           res = n * factorialRecursivo(n-1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        boolean res = true;
        if (n == 0 || n == 1){
            res = false;
        }
        for (int i = 2; i < n; i++){
            if (n%i == 0){
                  res = false;
                }
        }
        return res;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i=0; i < numeros.length; i++){
            res = res + numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 999;
        for (int i=0; i < numeros.length; i++){
            if (buscado ==  numeros[i]){
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res = false;
        for (int i=0; i < numeros.length; i++){
            if (esPrimo(numeros[i])){
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res = true;
        for (int i=0; i < numeros.length; i++){
            if (esPar(numeros[i]) == false){
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res = false;
        if (s1.length() <= s2.length()){
            for (int i=0; i < s1.length(); i++){
                if (s1.charAt(i) == s2.charAt(i)){
                    res = true;
                }
                else{
                    res = false;
                }
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        boolean res = false;
        if (s1.length() <= s2.length()){
            for (int i=0; i < s1.length(); i++){
                if (s1.charAt(s1.length()-i-1) == s2.charAt(s2.length()-i-1)){
                    res = true;
                }
                else{
                    res = false;
                }
            }
        }
        return res;
    }
}
