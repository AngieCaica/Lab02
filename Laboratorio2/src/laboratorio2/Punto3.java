
package laboratorio2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author angie
 */
public class Punto3 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] sizes = {100, 500, 1000, 5000, 10000};
        System.out.println("Seleccione el algoritmo de ordenamiento:");
        System.out.println("1. Burbuja");
        System.out.println("2. Insercion");
        System.out.println("3. Seleccion");
        System.out.println("4. MergeSort");
        int option = scanner.nextInt();

        System.out.printf("%-10s %-15s\n", "Tamano", "Tiempo (ms)");
        for (int size : sizes) {
            double[] array = generateRandom(size);
            double[] arrayC = Arrays.copyOf(array, array.length);

            long startT = System.currentTimeMillis();
            switch (option) {
                case 1:
                    bubble(array);
                    break;
                case 2:
                    insertion(array);
                    break;
                case 3:
                    selection(array);
                    break;
                case 4:
                    merge(array);
                    break;
                default:
                    System.out.println(" no valido.");
                    return;
            }
            long endT = System.currentTimeMillis();
            long duration = endT - startT;
            System.out.printf("%-10d %-15d\n", size, duration);
        }
    }
    // Generar un arreglo de números aleatorios
    public static double[] generateRandom(int size) {
        Random rand = new Random();
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextDouble() * 100; // Números aleatorios entre 0 y 100
        }
        return array;
    }

    // Implementación de ordenamiento con los cuatro metodos
    public static void bubble(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    
    public static void insertion(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void selection(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    
    public static void merge(double[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            double[] left = Arrays.copyOfRange(array, 0, mid);
            double[] right = Arrays.copyOfRange(array, mid, array.length);
            
            merge(left);
            merge(right);

            merge(array, left, right);
        }
    }

    private static void merge(double[] array, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
