import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Lara_Reyes_Examen {
    private static final Scanner sc = new Scanner(System.in);
    private static final double IVA = 0.16;
    private static final double DESCUENTO = 0.0795;
    private static final int MIN_CUARTOS = 2;
    private static final int MAX_CUARTOS = 4;

    private static final double PRECIO_PORCELANATO = 22.35;
    private static final double PRECIO_MARMOLEADO = 34.27;
    private static final double PRECIO_ACRILICO = 22.94;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT);

    private static String nombre;
    private static String apellidoPaterno;
    private static String apellidoMaterno;
    private static LocalDate fechaNacimiento;
    private static String direccion;

    private static boolean datosCapturados = false;
    private static boolean cotizacionRealizada = false;
    private static boolean compraRealizada = false;

    private static int numeroCuartos;
    private static double[] largoCuartos;
    private static double[] anchoCuartos;
    private static int[] tipoPisoCuartos;

    private static double subtotal;
    private static double ivaTotal;
    private static double totalGeneral;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1 -> ingresarDatosComprador();
                case 2 -> visualizarTiposPiso();
                case 3 -> cotizarCompra();
                case 4 -> realizarCompra();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opcion no valida, intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Ingresar datos del comprador");
        System.out.println("2. Visualizar tipos de piso");
        System.out.println("3. Cotizar compra");
        System.out.println("4. Realizar compra");
        System.out.println("5. Salir");
    }

    private static void ingresarDatosComprador() {
        System.out.println("*** Ingreso de datos del comprador ***");
        nombre = leerTextoNoVacio("Ingrese su nombre: ");
        apellidoPaterno = leerTextoNoVacio("Ingrese su apellido paterno: ");
        apellidoMaterno = leerTextoNoVacio("Ingrese su apellido materno: ");
        fechaNacimiento = leerFecha("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
        direccion = leerTextoNoVacio("Ingrese su direccion residencial: ");
        datosCapturados = true;
        cotizacionRealizada = false;
        compraRealizada = false;
        System.out.println("Datos del comprador ingresados correctamente.");
    }

    private static void visualizarTiposPiso() {
        System.out.println("*** Tipos de piso disponibles ***");
        System.out.printf("1) Porcelanato: $%.2f por m2\n", PRECIO_PORCELANATO);
        System.out.printf("2) Marmoleado: $%.2f por m2\n", PRECIO_MARMOLEADO);
        System.out.printf("3) Acrilico: $%.2f por m2\n", PRECIO_ACRILICO);
    }

    private static void cotizarCompra() {
        if (!datosCapturados) {
            System.out.println("Primero debe ingresar los datos del comprador (opcion 1). ");
            return;
        }
        numeroCuartos = leerNumeroCuartos("Ingrese el numero de cuartos (2-4): ");
        largoCuartos = new double[numeroCuartos];
        anchoCuartos = new double[numeroCuartos];
        tipoPisoCuartos = new int[numeroCuartos];
        subtotal = 0.0;
        for (int i = 0; i < numeroCuartos; i++) {
            System.out.println("\n-- Cuarto " + (i + 1) + " --");
            largoCuartos[i] = leerDoublePositivo("Ingrese el largo del cuarto en metros: ");
            anchoCuartos[i] = leerDoublePositivo("Ingrese el ancho del cuarto en metros: ");
            tipoPisoCuartos[i] = leerTipoPiso("Elija el tipo de piso (1: Porcelanato, 2: Marmoleado, 3: Acrilico): ");
            double area = largoCuartos[i] * anchoCuartos[i];
            double precio = precioPorTipo(tipoPisoCuartos[i]);
            double costo = area * precio;
            subtotal += costo;
            System.out.printf("Cuarto %d: area = %.2f m2, costo = $%.2f (tipo %s)%n", i + 1, area, costo, nombreTipoPiso(tipoPisoCuartos[i]));
        }
        ivaTotal = subtotal * IVA;
        totalGeneral = subtotal + ivaTotal;
        cotizacionRealizada = true;
        imprimirResumenCotizacion();
    }

    private static void imprimirResumenCotizacion() {
        System.out.println("*** Resumen de cotizacion ***");
        System.out.println("Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento.format(FORMATO_FECHA));
        System.out.println("Direccion: " + direccion);
        System.out.println("Numero de cuartos: " + numeroCuartos);
        for (int i = 0; i < numeroCuartos; i++) {
            double area = largoCuartos[i] * anchoCuartos[i];
            double costo = area * precioPorTipo(tipoPisoCuartos[i]);
            System.out.printf("Cuarto %d: %.2f x %.2f = %.2f m2, piso: %s, costo: $%.2f%n", i + 1, largoCuartos[i], anchoCuartos[i], area, nombreTipoPiso(tipoPisoCuartos[i]), costo);
        }
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("IVA (16%%): $%.2f%n", ivaTotal);
        System.out.printf("Total general: $%.2f%n", totalGeneral);
    }

    private static void realizarCompra() {
        if (!datosCapturados) {
            System.out.println("Primero debe ingresar los datos del comprador (opcion 1). ");
            return;
        }
        if (!cotizacionRealizada) {
            System.out.println("Primero debe realizar la cotizacion (opcion 3). ");
            return;
        }
        if (compraRealizada) {
            System.out.println("La compra ya ha sido realizada. ");
            return;
        }
        if (leerSiNo("Desea realizar la compra? (s/n): ")) {
            double descuento = totalGeneral * DESCUENTO;
            double totalConDescuento = totalGeneral - descuento;
            System.out.println("\n*** TICKET DE COMPRA ***");
            System.out.println("Comprador: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
            System.out.println("Fecha de nacimiento: " + fechaNacimiento.format(FORMATO_FECHA));
            System.out.println("Direccion residencial: " + direccion);
            System.out.printf("Subtotal: $%.2f%n", subtotal);
            System.out.printf("IVA (16%%): $%.2f%n", ivaTotal);
            System.out.printf("Total general: $%.2f%n", totalGeneral);
            System.out.printf("Descuento (7.95%%): $%.2f%n", descuento);
            System.out.printf("Total a pagar: $%.2f%n", totalConDescuento);
            compraRealizada = true;
        } else {
            System.out.println("Compra cancelada. ");
        }
    }

    private static int leerNumeroCuartos(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor >= MIN_CUARTOS && valor <= MAX_CUARTOS) {
                return valor;
            }
            System.out.println("Debe ingresar un numero entero entre " + MIN_CUARTOS + " y " + MAX_CUARTOS + ".");
        }
    }

    private static int leerTipoPiso(String mensaje) {
        while (true) {
            int opcion = leerEntero(mensaje);
            if (opcion >= 1 && opcion <= 3) {
                return opcion;
            }
            System.out.println("Opcion invalida. Ingrese 1, 2 o 3.");
        }
    }

    private static double precioPorTipo(int tipo) {
        switch (tipo) {
            case 1: return PRECIO_PORCELANATO;
            case 2: return PRECIO_MARMOLEADO;
            case 3: return PRECIO_ACRILICO;
            default: return 0.0;
        }
    }

    private static String nombreTipoPiso(int tipo) {
        switch (tipo) {
            case 1: return "Porcelanato";
            case 2: return "Marmoleado";
            case 3: return "Acrilico";
            default: return "Desconocido";
        }
    }

    private static double leerDoublePositivo(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(sc.nextLine().trim());
                if (valor > 0) {
                    return valor;
                }
                System.out.println("El valor debe ser mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida, ingrese un numero decimal valido.");
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no valida, ingrese un numero entero.");
            }
        }
    }

    private static String leerTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El campo no puede quedar vacio.");
        }
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                return LocalDate.parse(entrada, FORMATO_FECHA);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha invalida. Ingrese en formato dd/MM/yyyy.");
            }
        }
    }

    private static boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String r = sc.nextLine().trim().toLowerCase();
            if (r.equals("s") || r.equals("si")) {
                return true;
            }
            if (r.equals("n") || r.equals("no")) {
                return false;
            }
            System.out.println("Respuesta invalida. Ingrese 's' o 'n'.");
        }
    }
}
