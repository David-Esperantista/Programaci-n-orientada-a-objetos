package calculetor;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Main {

    /**
     * * metodo principal que ejecuta el menu de la calculadora
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aritmetica ar = new Aritmetica();
        Conversor conv = new Conversor();
        Sistemaconversion sis = new Sistemaconversion();
        String opcionPrincipal;

        do {
            System.out.println("\n     Calculadora        ");
            System.out.println("1. Operaciones Aritméticas");
            System.out.println("2. Conversión de Bases");
            System.out.println("3. Sistema de Conversión (Longitud, Peso, Temperatura)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcionPrincipal = sc.nextLine().trim();

            switch (opcionPrincipal) {
                case "1":
                    VentanaCalculadoraAritmetrica.abrir();
                break;
                case "2":
                    menuConversor(sc, conv);
                    break;
                case "3":
                    menuSistemaConversion(sc, sis);
                    break;
                case "4":
                    System.out.println("adios ");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcionPrincipal.equals("4"));

        sc.close();
    }

    /**
     * * muestra y gestiona el menu de operaciones aritmeticas
     */
    private static void menuAritmetica(Scanner sc, Aritmetica ar) {
        String opcion;
        do {
            System.out.println("\n--- ---");
            System.out.println("Acumulado: " + ar.getResultado());
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Limpiar acumulador");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                case "2":
                case "3":
                case "4":
                    System.out.print("Ingresa el número: ");
                    String num = sc.nextLine().trim();
                    if (opcion.equals("1")) ar.sum(num);
                    else if (opcion.equals("2")) ar.resta(num);
                    else if (opcion.equals("3")) ar.multiplicacion(num);
                    else ar.division(num);

                    if (ar.getResultado().equals("Error")) {
                        System.out.println("Error: valor inválido o división entre 0. Se reinició el acumulador.");
                        ar.limpiar();
                    }
                    break;
                case "5":
                    ar.limpiar();
                    System.out.println("Acumulador reiniciado.");
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("6"));
    }

    /**
     * * muestra y gestiona el menu de conversion de bases numericas
     */
    private static void menuConversor(Scanner sc, Conversor conv) {
        String opcion;
        do {
            System.out.println("\n--- ---");
            System.out.println("1. Realizar conversión de bases");
            System.out.println("2. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextLine().trim();

            if (opcion.equals("1")) {
                // 1. Pedir a qué base pertenece el dato de entrada
                System.out.println("Elige la base del dato de entrada:");
                System.out.println("2. Binario\n8. Octal\n10. Decimal\n16. Hexadecimal");
                System.out.print("Ingresa la base de origen (2, 8, 10, 16): ");
                String orgStr = sc.nextLine().trim();

                int baseOrigen;
                try {
                    baseOrigen = Integer.parseInt(orgStr);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Base no válida.");
                    continue;
                }

                if (baseOrigen != 2 && baseOrigen != 8 && baseOrigen != 10 && baseOrigen != 16) {
                    System.out.println("Error: Base no soportada. Usa 2, 8, 10 o 16.");
                    continue;
                }

                // 2. Pedir el dato
                System.out.print("Ingresa el valor a convertir: ");
                String valor = sc.nextLine().trim();

                // 3. Pedir a qué base se quiere convertir
                System.out.println("Elige la base a la que deseas convertir:");
                System.out.println("2. Binario\n8. Octal\n10. Decimal\n16. Hexadecimal");
                System.out.print("Ingresa la base de destino (2, 8, 10, 16): ");
                String destStr = sc.nextLine().trim();

                int baseDestino;
                try {
                    baseDestino = Integer.parseInt(destStr);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Base no válida.");
                    continue;
                }

                if (baseDestino != 2 && baseDestino != 8 && baseDestino != 10 && baseDestino != 16) {
                    System.out.println("Error: Base no soportada. Usa 2, 8, 10 o 16.");
                    continue;
                }

                // Realizar la conversión
                conv.convertirBase(valor, baseOrigen, baseDestino);

                if (conv.hayError()) {
                    System.out.println("Error: El valor ingresado no coincide con los caracteres permitidos para la base de origen seleccionada.");
                } else {
                    System.out.println(">> Resultado: " + conv.getResultado());
                }

            } else if (!opcion.equals("2")) {
                System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("2"));
    }

    /**
     * * muestra y gestiona el menu del sistema de conversion de unidades
     */
    private static void menuSistemaConversion(Scanner sc, Sistemaconversion sis) {
        String opcion;
        do {
            System.out.println("\n--- ---");
            System.out.println("1. Longitud");
            System.out.println("2. Peso");
            System.out.println("3. Temperatura");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    menuLongitud(sc, sis);
                    break;
                case "2":
                    menuPeso(sc, sis);
                    break;
                case "3":
                    menuTemperatura(sc, sis);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("4"));
    }

    /**
     * * gestiona las conversiones de unidades de longitud
     */
    private static void menuLongitud(Scanner sc, Sistemaconversion sis) {
        System.out.println("\n--- ---");
        System.out.println("1. Milímetros\n2. Centímetros\n3. Metros\n4. Kilómetros\n5. Pulgadas\n6. Pies\n7. Yardas\n8. Millas");
        System.out.print("Elige la unidad de entrada: ");
        String sub = sc.nextLine().trim();
        System.out.print("Ingresa el valor: ");
        String val = sc.nextLine().trim();

        if (sub.equals("1")) sis.milimetrosAMetros(val);
        else if (sub.equals("2")) sis.centimetrosAMetros(val);
        else if (sub.equals("3")) sis.metrosAMetros(val);
        else if (sub.equals("4")) sis.kilometrosAMetros(val);
        else if (sub.equals("5")) sis.pulgadasAMetros(val);
        else if (sub.equals("6")) sis.piesAMetros(val);
        else if (sub.equals("7")) sis.yardasAMetros(val);
        else if (sub.equals("8")) sis.millasAMetros(val);
        else {
            System.out.println("Unidad no válida.");
            return;
        }

        if (sis.hayError()) {
            System.out.println("Error: Valor inválido o negativo.");
        } else {
            System.out.println("--- Resultados de Longitud ---");
            System.out.println("Milímetros: " + sis.aMilimetros());
            System.out.println("Centímetros: " + sis.aCentimetros());
            System.out.println("Metros: " + sis.aMetros());
            System.out.println("Kilómetros: " + sis.aKilometros());
            System.out.println("Pulgadas: " + sis.aPulgadas());
            System.out.println("Pies: " + sis.aPies());
            System.out.println("Yardas: " + sis.aYardas());
            System.out.println("Millas: " + sis.aMillas());
        }
    }

    /**
     * * gestiona las conversiones de unidades de peso
     */
    private static void menuPeso(Scanner sc, Sistemaconversion sis) {
        System.out.println("\n--- ---");
        System.out.println("1. Gramos\n2. Kilogramos\n3. Libras\n4. Onzas");
        System.out.print("Elige la unidad de entrada: ");
        String sub = sc.nextLine().trim();
        System.out.print("Ingresa el valor: ");
        String val = sc.nextLine().trim();

        if (sub.equals("1")) sis.gramosAKilogramos(val);
        else if (sub.equals("2")) sis.kilogramosAKilogramos(val);
        else if (sub.equals("3")) sis.librasAKilogramos(val);
        else if (sub.equals("4")) sis.onzasAKilogramos(val);
        else {
            System.out.println("Unidad no válida.");
            return;
        }

        if (sis.hayError()) {
            System.out.println("Error: Valor inválido o negativo.");
        } else {
            System.out.println("--- Resultados de Peso ---");
            System.out.println("Gramos: " + sis.aGramos());
            System.out.println("Kilogramos: " + sis.aKilogramos());
            System.out.println("Libras: " + sis.aLibras());
            System.out.println("Onzas: " + sis.aOnzas());
        }
    }

    /**
     * * gestiona las conversiones de unidades de temperatura
     */
    private static void menuTemperatura(Scanner sc, Sistemaconversion sis) {
        System.out.println("\n--- ---");
        System.out.println("1. Celsius\n2. Fahrenheit\n3. Kelvin");
        System.out.print("Elige la unidad de entrada: ");
        String sub = sc.nextLine().trim();
        System.out.print("Ingresa el valor: ");
        String val = sc.nextLine().trim();

        if (sub.equals("1")) sis.celsiusACelsius(val);
        else if (sub.equals("2")) sis.fahrenheitACelsius(val);
        else if (sub.equals("3")) sis.kelvinACelsius(val);
        else {
            System.out.println("Unidad no válida.");
            return;
        }

        if (sis.hayError()) {
            System.out.println("Error: Valor inválido o por debajo del cero absoluto.");
        } else {
            System.out.println("--- Resultados de Temperatura ---");
            System.out.println("Celsius: " + sis.aCelsius());
            System.out.println("Fahrenheit: " + sis.aFahrenheit());
            System.out.println("Kelvin: " + sis.aKelvin());
        }
    }
}
