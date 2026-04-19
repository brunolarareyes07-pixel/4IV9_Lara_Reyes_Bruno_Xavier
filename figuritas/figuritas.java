import java.util.Scanner;

abstract class Figura {
    public abstract float calcularArea();
    public abstract float calcularPerimetro();

    public void mostrarResultados() {
        System.out.printf("Area      : %.4f%n", calcularArea());
        System.out.printf("Perimetro : %.4f%n", calcularPerimetro());
    }
}
class Circulo extends Figura {
    private float radio;

    public Circulo(Scanner sc) {
        capturarDatos(sc);
    }

    private void capturarDatos(Scanner sc) {
        System.out.println("CIRCULO");
        System.out.print("Ingresa el radio: ");
        radio = sc.nextFloat();
    }

    @Override
    public float calcularArea() {
        return (float) (Math.PI * Math.pow(radio, 2));
    }

    @Override
    public float calcularPerimetro() {
        return (float) (2 * Math.PI * radio);
    }
    public String toString() {
        return String.format("Circulo -> Radio: %.2f | Area: %.4f | Perimetro: %.4f",
                radio, calcularArea(), calcularPerimetro());
    }
}
class Cuadrado extends Figura {
    private float lado;

    public Cuadrado(Scanner sc) {
        capturarDatos(sc);
    }

    private void capturarDatos(Scanner sc) {
        System.out.println("CUADRADO");
        System.out.print("Ingresa el lado: ");
        lado = sc.nextFloat();
    }

    @Override
    public float calcularArea() {
        return lado * lado;
    }

    @Override
    public float calcularPerimetro() {
        return 4 * lado;
    }

    @Override
    public String toString() {
        return String.format("Cuadrado -> Lado: %.2f | Area: %.4f | Perimetro: %.4f",
                lado, calcularArea(), calcularPerimetro());
    }
}
class Triangulo extends Figura {
    private float base;
    private float lado2;
    private float altura;

    public Triangulo(Scanner sc) {
        capturarDatos(sc);
    }

    private void capturarDatos(Scanner sc) {
        System.out.println("TRIANGULO");
        System.out.print("Ingresa la base: ");
        base = sc.nextFloat();
        System.out.print("Ingresa el lado 2: ");
        lado2 = sc.nextFloat();
        System.out.print("Ingresa la altura: ");
        altura = sc.nextFloat();
    }

    @Override
    public float calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public float calcularPerimetro() {
        float hipotenusa = (float) Math.sqrt(base * base + altura * altura);
        return base + lado2 + hipotenusa;
    }

    @Override
    public String toString() {
        return String.format("Triangulo -> Base: %.2f | Lado2: %.2f | Altura: %.2f | Area: %.4f | Perimetro: %.4f",
                base, lado2, altura, calcularArea(), calcularPerimetro());
    }
}
class Hexagono extends Figura {
    private int angulo;
    private float lado;

    public Hexagono(Scanner sc) {
        capturarDatos(sc);
    }

    private void capturarDatos(Scanner sc) {
        System.out.println("HEXAGONO");
        System.out.print("Ingresa el lado: ");
        lado = sc.nextFloat();
                System.out.print("Ingresa el angulo interior (grados): ");
        angulo = sc.nextInt();
    }
    public float calcularArea() {
        return (float) ((3 * Math.sqrt(3) / 2) * lado * lado);
    }

    public float calcularPerimetro() {
        return 6 * lado;
    }

    public String toString() {
        return String.format("Hexagono -> Lado: %.2f | Angulo: %d | Area: %.4f | Perimetro: %.4f",
                lado, angulo, calcularArea(), calcularPerimetro());
    }
}
public class figuritas {
    private Figura objFigura;
    private int opcion;
    private final Scanner sc = new Scanner(System.in);
    public void menu() {
        do {
            System.out.println("Lara Reyes Bruno Xavier 4IV9");
            System.out.println("1. Circulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triangulo");
            System.out.println("4. Hexagono");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            if (!sc.hasNextInt()) {
                System.out.println("\nEntrada no valida. Debes escribir un numero.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    objFigura = new Circulo(sc);
                    objFigura.mostrarResultados();
                    System.out.println(objFigura);
                    break;
                case 2:
                    objFigura = new Cuadrado(sc);
                    objFigura.mostrarResultados();
                    System.out.println(objFigura);
                    break;
                case 3:
                    objFigura = new Triangulo(sc);
                    objFigura.mostrarResultados();
                    System.out.println(objFigura);
                    break;
                case 4:
                    objFigura = new Hexagono(sc);
                    objFigura.mostrarResultados();
                    System.out.println(objFigura);
                    break;
                case 5:
                    System.out.println("\nHasta luego!");
                    break;
                default:
                    System.out.println("\nOpcion no valida, intenta de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }

    public static void main(String[] args) {
        new figuritas().menu();
    }
}

