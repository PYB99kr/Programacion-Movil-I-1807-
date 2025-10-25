/*
 * Tarea 1: Numeros pares e impares
 * Alumno: Park Daniel
 */
import java.util.Scanner;

public class Prueba{
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero");
        int num = sc.nextInt(); 
        
        NumerosParImpar npi = new NumerosParImpar();
        npi.valida(num); 
    }
}
