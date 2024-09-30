package laboratorio2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author angie
 */
public class Punto1 {

    public static void main(String[] args) {
       Scanner a = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("Ingrese el tamano del arreglo: ");
        int tamaño = a.nextInt();
        
        int[] arreglo = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = rand.nextInt(75); // Números aleatorios entre 0 y 74
        }
        
        System.out.println("Arreglo: " + Arrays.toString(arreglo));
        
        // Mediana
        Arrays.sort(arreglo);
        double mediana;
        if (tamaño % 2 == 0) {
            mediana = (arreglo[tamaño/2 - 1] + arreglo[tamaño/2]) / 2.0;
        } else {
            mediana = arreglo[tamaño/2];
        }
        System.out.println("Mediana: " + mediana);
        
        // Media
        double media = Arrays.stream(arreglo).average().orElse(Double.NaN);
        System.out.println("Media: " + media);
        
        // Varianza
        double suma = 0;
        for (int num : arreglo) {
            suma += Math.pow(num - media, 2);
        }
        double varianza = suma / tamaño;
        System.out.println("Varianza: " + varianza);
        
        // Desviación estándar
        double desviacionEstandar = Math.sqrt(varianza);
        System.out.println("Desviacion estandar: " + desviacionEstandar);
        
        
        
        // Moda
        int maxRep = 0;
        int moda = arreglo[0];
        for (int i = 0; i < tamaño; i++) {
            int numRep = 0;
            for (int j = 0; j < tamaño; j++) {
                if (arreglo[j] == arreglo[i]) numRep++;
            }
            if (numRep > maxRep) {
                maxRep = numRep;
                moda = arreglo[i];
            }
        }
        System.out.println("Moda: " + moda);
        
        a.close(); 
    }
    
}


