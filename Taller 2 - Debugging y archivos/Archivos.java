package aed;

import java.util.Scanner;
import java.io.PrintStream;

class Archivos {
    float[] leerVector(Scanner entrada, int largo) {
        float[] res = new float[largo];
        for(int i=0; i < largo; i++) {
            res[i] = entrada.nextFloat();
        }
        return res;
    }

    float[][] leerMatriz(Scanner entrada, int filas, int columnas) {
        float[][] res = new float[filas][columnas];
        for(int i=0; i < filas; i++) {
            for (int j = 0; j < columnas; j++){
                res[i][j] = entrada.nextFloat();
            }
        }
        return res;
    }

    void imprimirPiramide(PrintStream salida, int alto) {
        for (int i = 1; i <= alto; i++){
            String linea = "";
            for (int j = 0; j < (alto-i);j++){
                linea += " ";
            }
            for (int k = 0; k < (2*i - 1); k++){
                linea += "*";
            }
            for (int h= 0; h < (alto-i); h++){
                linea += " ";
            }
            salida.println(linea);
        }
    }
}
