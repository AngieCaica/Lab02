
package laboratorio2;

import java.util.Scanner;

/**
 *
 * @author angie
 */
public class Punto2 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Ingrese una linea de texto:");
        String linea = a.nextLine();
        
        
        //esta parte sirve para encontrar el caracter que mas veces se repite
        int[] contador = new int[256];
        for (char c : linea.toCharArray()) {
            contador[c]++;
        }
        
        char caracterf = ' ';
        int maxF= 0;
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] > maxF) {
                maxF= contador[i];
                caracterf= (char) i;
            }
        }
        
        // Reemplazar vocales 
        String lineaM = linea.replaceAll("[aeiouAEIOU]", String.valueOf(caracterf));
        System.out.println("Linea con vocales reemplazadas: " + lineaM);
        
        // Se invierte la linea 
        String lineaI = new StringBuilder(lineaM).reverse().toString();
        System.out.println("Linea invertida: " + lineaI);
        
        a.close();
    }
}
