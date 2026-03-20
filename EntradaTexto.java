/* 
Vamos a crear una instancia de un objeto para la entrada de datos estandar y la salida de datos
*/

//libreria Scanner
import java.util.Scanner;

class EntradaTexto {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        String nombre;
        int edad;
        System.out.println("Escribe tu nombre");
        nombre = System.console().readLine();

        System.out.println("Hola " + nombre + ", Bienvenido a programar muy feo");
        
        System.out.println("Escribe tu edad");
        edad = scanner.nextInt();
    }
}