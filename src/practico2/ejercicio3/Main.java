package practico2.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Por favor ingrese el numero que desea convertir a binario: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int bin = integerToBinary(num);
        System.out.println("El binario de " + num + " es: " + bin);
    }

    private static int integerToBinary(int num) {
        if (num<=0) return 0;
        if  (num >= 2) {
            return num%2 + integerToBinary(num / 2)*10;
        } else {
            return num;
        }
    }
}
