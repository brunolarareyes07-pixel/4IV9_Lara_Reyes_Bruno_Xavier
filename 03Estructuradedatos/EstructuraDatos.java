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
                System.out.println("Ingrese su edad para calcular el descuento, no puedes tener mas de 100 años ni menos de 0:)");
                int edad = entrada.nextInt();
                double descuento = 0;
                if(edad>0 && edad < 100){
                if (edad >0 && edad <10){
                    descuento = 0.80;
                }
                else if (edad >=10 && edad <18){
                    descuento = 0.50;
                }
                else if (edad >=18 && edad <40){
                    descuento = 0.40;
                }
                else if (edad >=40 && edad <60){
                    descuento = 0.20;
                }
                else if (edad >=60){
                    descuento = 0.80;
                }
                System.out.println("El descuento que se le aplicara es de:" + (descuento*100) + "%");
                
            }else{ 
                System.out.println("Edad no valida");
            }
                break;

            case 2:
                //convertir un numero decimal a binario
                System.out.println("Ingrese un numero positivo entero que se desee comvertir a binario");
                int numbinario;
                String guardarbinario ="";
                numbinario = entrada.nextInt();
                
                if(numbinario > 0){

                    //realizamos el modulo de 2
                    while(numbinario > 0){
                        int residuo = numbinario % 2;
                        guardarbinario = residuo + guardarbinario;
                        numbinario /= 2;
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
                System.out.println("Que temperatura deseas convertir");
                System.out.println("1.- Celsius a Fahrenheit");
                System.out.println("2.- Celsius a Kelvin");
                System.out.println("3.- Fahrenheit a Celsius");
                System.out.println("4.- Fahrenheit a Kelvin");
                System.out.println("5.- Kelvin a Fahrenheit");
                System.out.println("6.- Kelvin a Celsius");
                int opciontemperatura = entrada.nextInt();
                System.out.println("Ingresa la temperatura ");

                double temperatura = entrada.nextDouble();
                double resultado;
                switch (opciontemperatura) {
                    case 1:
                        resultado = (temperatura + 9/5) + 32;
                        System.out.println("La temperatura es: " + resultado );
                    break;
                    case 2: 
                        resultado = temperatura + 273.15;
                        System.err.println("La temperatura es: " + resultado);
                        break;
                    case 3:
                        resultado = (temperatura - 32) * 5/9;
                        System.out.println("La temperatura es: " + resultado);
                        break;
                    case 4:
                        resultado = (temperatura - 32) * 5/9 + 273.15;
                        System.out.println("La temperatura es: " + resultado);
                        break;
                    case 5:
                        resultado = (temperatura - 273.15) * 9/5 + 32;
                        System.out.println("La temperatura es: " + resultado);
                        break;
                    case 6:
                        resultado = temperatura -273.15;
                        System.out.println("La temperatura es: " + resultado);
                        break;
                }

                break;
            case 4:
                System.out.println("Ingresa un numero");
                int cantidad = entrada.nextInt();

                int negativos = 0;
                int ceros = 0;
                int positivos = 0;
                
                if(cantidad > 0){
                    for(int i = 1; i <= cantidad; i++){
                        System.out.println("Ingresa el numero " + i);
                        double numero = entrada.nextDouble();
                        
                        if (numero > 0){
                            positivos = positivos + 1;
                        }
                        else if (numero < 0){
                            negativos = negativos + 1;
                        }
                        else {
                            ceros = ceros + 1;
                        }
                    }
                }
                break;
            case 5:
                System.out.println("Bienvenidos a esta hermosa tiendita linda y Kawaii");
                System.out.println("Por favor ingrese cuantos elementos ca a acomprar");
                int elementosproducto;
                elementosproducto = entrada.nextInt();
                double compra = 0;
                if( elementosproducto > 0 ){
                    for(int i= 1; i<= elementosproducto;i++){
                        System.out.println("Ingresa el nombre del producto");
                        entrada.next(); // Consumir el nombre pero no almacenar
                        System.out.println("ingrese el precio");
                        double precio = entrada.nextDouble();
                        System.out.println("Ingrese la cantidad de producto");
                        int cantidad = entrada.nextInt();
                        double resultado = precio * cantidad;
                        compra += resultado;
                    }
                    System.out.println("El total de la compra es:" + compra);

                }else{
                    System.out.println("ingrese solo cantidades positivas");
                }
                
                break;
            case 6:
                System.out.println("elija una figura");
                System.out.println("1. Cuadrado");
                System.out.println("2. Rectangulo");
                System.out.println("3. Triangulo");
                System.out.println("4. Circulo");
                System.out.println("5. Pentagono");
                
                int figura = entrada.nextInt();
                double area;
                double perimetro;

                switch (figura) {
                    case 1:
                        System.out.println("Ingrese el lado del cuadrado");
                        double lado = entrada.nextDouble();
                        area = lado * lado;
                        perimetro = 4 * lado;
                        System.out.println("El área del cuadrado es: " + area);
                        System.out.println("El perímetro del cuadrado es: " + perimetro);
                        break;
                    case 2:
                        System.out.print("Ingrese la base del rectángulo: ");
                        double base = entrada.nextDouble();

                        System.out.print("Ingrese la altura del rectángulo: ");
                        double altura = entrada.nextDouble();

                        area = base * altura;
                        perimetro = 2 * (base + altura);

                        System.out.println("Area" + area);
                        System.out.println("Perimetro" + perimetro);
                        break;
                    case 3:
                        System.out.print("Ingrese la base del triángulo: ");
                        double baseTriangulo = entrada.nextDouble();

                        System.out.print("Ingrese la altura del triángulo: ");
                        double alturaTriangulo = entrada.nextDouble();

                        System.out.println("Lado 1");
                        double lado1 = entrada.nextDouble();
                        System.out.println("Lado 2");
                        double lado2 = entrada.nextDouble();
                        System.out.println("Lado 3");
                        double lado3 = entrada.nextDouble();

                        area = (baseTriangulo * alturaTriangulo) / 2;
                        perimetro = lado1 + lado2 + lado3;

                        System.out.println("Area" + area);
                        System.out.println("Perimetro" + perimetro);
                        break;
                    case 4:
                        System.out.print("Ingrese el radio del círculo: ");
                        double radio = entrada.nextDouble();

                        area = 3.14 * radio * radio;
                        perimetro = 2 * 3.14 * radio;

                        System.out.println("area" + area);
                        System.out.println("perimetro" + perimetro);
                        break;
                    case 5:
                        System.out.println("Lado del pentagono");
                        double pentagono = entrada.nextDouble();

                        System.out.println("Apotema del pentagono");
                        double apotema = entrada.nextDouble();

                        perimetro = 5 * pentagono;
                        area = (perimetro * apotema) / 2;
                        System.out.println("Area" + area);
                        System.out.println("Perimetro" + perimetro);
                        break;
                            default:
            System.out.println("Figura no valida");
                }

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
