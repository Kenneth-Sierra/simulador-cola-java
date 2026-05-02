import java.io.*;
import java.util.Scanner;

public class Simulador {
    private static Cola<Cliente> cola = new Cola<>();
    private static Pila<Cliente> historial = new Pila<>();

    public static void main(String[] args) {
        cargarClientesDesdeArchivo("data/clientes.txt");
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Cargar clientes desde archivo");
            System.out.println("2. Agregar cliente manualmente");
            System.out.println("3. Atender siguiente cliente");
            System.out.println("4. Ver cola de espera");
            System.out.println("5. Ver historial de atenciones");
            System.out.println("6. Consultar último atendido");
            System.out.println("7. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> cargarClientesDesdeArchivo("data/clientes.txt");
                case 2 -> {
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Servicio: ");
                    String servicio = sc.nextLine();
                    cola.encolar(new Cliente(id, nombre, servicio));
                }
                case 3 -> {
                    Cliente atendido = cola.desencolar();
                    if (atendido != null) {
                        historial.push(atendido);
                        System.out.println("Atendido: " + atendido);
                    } else {
                        System.out.println("No hay clientes en cola.");
                    }
                }
                case 4 -> cola.mostrar();
                case 5 -> historial.mostrar();
                case 6 -> {
                    Cliente ultimo = historial.peek();
                    System.out.println(ultimo != null ? "Último atendido: " + ultimo : "Historial vacío.");
                }
            }
        } while (opcion != 7);
    }

    private static void cargarClientesDesdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Cliente c = new Cliente(datos[0], datos[1], datos[2]);
                cola.encolar(c);
            }
            System.out.println("Clientes cargados desde archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }
}
