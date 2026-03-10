/*
Vamos a crear 14 programas dentro de un menu gigante 
para poner a prueba sus conocimientos de algoritmia
1.-Desarrollar un programa para calcular el bono de un descuento por edad
2.- Convertir numeros decimales a binarios
3.-Convertir temperaturas entre los 3 prinicpales gradps c-> F y k
4.- Realizar un programa para contar el numero de positivos y negativos de una serie de numeros 
5.- Desarrolar ua tiendita para agregar productos y precios 
6.- Desarrollar un programa para calcular el area y peri,etro de 5 diferentes figuras
7.-Dessarrollaruna tabla ahorita a ver de que se me ocurre
8- Desarrollar un programa para calcular el factorial con recursividad 
9-Vamos hacer dibujitos wiiii
10.- Dessarrollar una figura hueca
11.- Realizar algunos patrones
12.- Realizae un diamante
13.- Dessarrolar una calculadora basica
+ - / *

*/
import java.util.Scanner;
public class EstructuraDatos {
    public static void main(String[] args) {
        //aqui van los objetos 
        int opcion;
        char letrapararepetir;
        //aqio van los objetos
        Scanner entrada = new Scanner(System.in);
        //aqui va el menu 
        do{
        System.out.println("Bienvenido a este programa para verificar que tanto saben programar a base de algoritmos basicos");
        System.out.println("Porfavor elija la opcion deseada");
        System.out.println("1.-Desarrollar un programa para calcular el bono de un descuento por edad");     
        System.out.println("2.- Convertir numeros decimales a binarios");   
        System.out.println("3.-Convertir temperaturas entre los 3 prinicpales gradps c-> F y k");   
        System.out.println("4.- Realizar un programa para contar el numero de positivos y negativos de una serie de numeros"); 
        System.out.println("5.- Desarrolar ua tiendita para agregar productos y precios");   
        System.out.println("6.- Desarrollar un programa para calcular el area y peri,etro de 5 diferentes figuras");   
        System.out.println("7.-Dessarrollaruna tabla ahorita a ver de que se me ocurre");   
        System.out.println("8- Desarrollar un programa para calcular el factorial con recursividad ");   
        System.out.println("9-Vamos hacer dibujitos wiiii");      
        System.out.println("10.- Dessarrollar una figura hueca");   
        System.out.println("11.- Realizar algunos patrones");   
        System.out.println("12.- Realizae un diamante");   
        System.out.println("13.- Dessarrolar una calculadora basica");   
        System.out.println("14.- Salir");

        //Entrada de datos
        opcion = entrada.nextInt();

        //Ahora tengo qu evaluar la entrada
        switch (opcion) {
            case 1:
                
                break;

            case 2:
                //convertir un numero decimal a binario
                System.err.println("Ingrese un numero positivo entero que se desee comvertir a binario");
                int numerobinario = entrada.nextInt();
                int numbinario = entrada.nextInt();
                String guardarbinario ="";
                if(numerobinario > 0){
                    //realizamos el modulo de 2
                    while(numerobinario%2 == 0){
                        if(numbinario%2 == 0){
                            guardarbinario = "0" + guardarbinario;
                        } else {guardarbinario ="1" + guardarbinario;
                            
                        }

                    }
                }else if(numbinario == 0){
                    guardarbinario = "0";
                }
                else {
                    //aqui no se puede 
                    guardarbinario = "No se puede convertir ese numero solo acepta positivos ";
                }
                System.out.println("El numero convertido a binario es:" + guardarbinario);
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            case 10:
                
                break;
            case 11:
                
                break;
            case 12:
                
                break;
            case 13:
                
                break;

            default:

                throw new AssertionError();
        }
        System.out.println("Deseas repetir el programa escribe s o S para si ");
        letrapararepetir = entrada.next().charAt(0); 
    }while(letrapararepetir == 's' || letrapararepetir == 'S');
    

}
    
}

