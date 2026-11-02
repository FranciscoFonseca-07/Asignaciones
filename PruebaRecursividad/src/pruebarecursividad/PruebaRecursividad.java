package pruebarecursividad;

import java.util.Arrays;

public class PruebaRecursividad {
    public static void main(String[] args) {
        System.out.println(" Pruebas de recursividad\n");
        
        System.out.println("1. Fibonacci de 5: " + Recursividad.fibonacci(5));
        
        System.out.println("2. Fibonacci de 40: " + Recursividad.fibonacci(40));
        
        System.out.println("3. MCD de 45 y 75: " + Recursividad.mcd(45, 75));
        
        System.out.println("4. MCD de 47 y 91: " + Recursividad.mcd(47, 91));
        
        Integer[] arrEnteros = {1, 2, 3, 3, 2, 3, 1};
        Character[] arrCaracteres = {'A', 'B', 'C', 'B', 'A', 'B', 'D'};
        
        System.out.println("5. Ocurrencias de 3: " + Recursividad.count(arrEnteros, arrEnteros.length, 3));
        
        System.out.println("6. Ocurrencias de 1:  " + Recursividad.count(arrEnteros, arrEnteros.length, 1));
        
        System.out.println("7. Ocurrencias de 'C': " + Recursividad.count(arrCaracteres, arrCaracteres.length, 'C'));

        System.out.println("8. Ocurrencias de 'E': " + Recursividad.count(arrCaracteres, arrCaracteres.length, 'E'));
        
        Integer[] arrInvertir1 = {1, 2, 3, 4, 5};
        Recursividad.reverse(arrInvertir1, 0, arrInvertir1.length - 1);
        System.out.println("9. Arreglo invertido [1, 2, 3, 4, 5]: " + Arrays.toString(arrInvertir1));
    
        Character[] arrInvertir2 = {'A', 'B', 'C', 'D'};
        Recursividad.reverse(arrInvertir2, 0, arrInvertir2.length - 1);
        System.out.println("10. Arreglo invertido ['A', 'B', 'C', 'D']: " + Arrays.toString(arrInvertir2));
    }
    
}
