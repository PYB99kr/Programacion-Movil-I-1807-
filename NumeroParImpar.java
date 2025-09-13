
import java.util.Scanner;

public class NumeroParImpar {
    public void valida(int numero) {
        if (numero % 2 == 0) {
            System.out.println("El numero " + numero + " es par");
        } else {
            System.out.println("El numero " + numero + " es impar");
        }
    }
    
    public static void main(String[] args) {
        NumeroParImpar npi = new NumeroParImpar();
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dame un numero");
        int num = sc.nextInt();
        
        npi.valida(num);
    }
}