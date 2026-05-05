import java.util.Scanner;

public class Ejercicios {
    
    //vamos hacer una calculadora rapida

    Scanner entrada = new Scanner(System.in);



    //la calculadora debe de tener un menu
    public void menu(){
        //las instrucciones
        boolean continuar = true;
        do {
            System.out.println("Bienvenido a la calculadora");
            System.out.println("Elige la opcion deseada");
            System.out.println("1.- Sumar");
            System.out.println("2.- Restar");
            System.out.println("3.- Multiplicar");
            System.out.println("4.- Salir");

            int opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1:
                    suma();             
                    break;
                case 2:
                    restar();
                    break;
                case 3:
                    multiplicar();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
                    break;
            }
        } while (continuar);
    }

    public void suma(){
        double num1 = 0.00, num2=0.00, resultado=0.00;

        System.out.println("Ingresa el primer numero:");
        num1 = entrada.nextDouble();
        System.out.println("Ingresa el segundo numero:");
        num2 = entrada.nextDouble();
        resultado = num1 + num2;
        System.out.println("La suma es: " + resultado);
        
    }

    public void restar(){
        double num1 = 0.00, num2=0.00, resultado=0.00;

        System.out.println("Ingresa el primer numero:");
        num1 = entrada.nextDouble();
        System.out.println("Ingresa el segundo numero:");
        num2 = entrada.nextDouble();
        resultado = num1 - num2;
        System.out.println("La resta es: " + resultado);
        
    }

    public void multiplicar(){
        double num1 = 0.00, num2=0.00, resultado=0.00;

        System.out.println("Ingresa el primer numero:");
        num1 = entrada.nextDouble();
        System.out.println("Ingresa el segundo numero:");
        num2 = entrada.nextDouble();
        resultado = num1 * num2;
        System.out.println("La multiplicacion es: " + resultado);
        
    }
}

