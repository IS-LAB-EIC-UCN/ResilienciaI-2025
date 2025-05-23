package cl.ucn.interfaz;

import cl.ucn.modelo.*;
import cl.ucn.servicio.ServicioDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal de la aplicación que proporciona un menú de consola
 * para interactuar con mensajes almacenados en una base de datos.
 *
 * Las operaciones incluyen:
 * <ul>
 *     <li>Listar todos los mensajes</li>
 *     <li>Ingresar un nuevo mensaje</li>
 *     <li>Buscar un mensaje por ID</li>
 *     <li>Aplicar formato y guardar mensaje como archivo HTML</li>
 *     <li>Salir de la aplicación</li>
 * </ul>
 *
 * Utiliza JPA para la persistencia de datos y un servicio para gestionar los mensajes.
 */
public class Main {

    /**
     * Punto de entrada principal de la aplicación.
     *
     * @param args argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mensajes");
        EntityManager em = emf.createEntityManager();
        ServicioDAO servicioDAO = new ServicioDAO(em);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar todos los mensajes");
            System.out.println("2. Ingresar un nuevo mensaje");
            System.out.println("3. Buscar mensaje por ID");
            System.out.println("4. Aplicar formateador y guardar HTML");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    // Lista todos los mensajes en la base de datos
                    List<Mensaje> mensajes = servicioDAO.getMensajes();
                    if (mensajes.isEmpty()) {
                        System.out.println("No hay mensajes registrados.");
                    } else {
                        for (Mensaje m : mensajes) {
                            System.out.printf("ID: %d | Texto: %s | Color: %s%n",
                                    m.getIdMensaje(), m.getMensaje(), m.getTipo());
                        }
                    }
                }
                case 2 -> {
                    // Agrega un nuevo mensaje
                    System.out.print("Ingrese el texto del mensaje: ");
                    String texto = scanner.nextLine();
                    System.out.print("Ingrese el color (verde, amarillo, rojo): ");
                    String color = scanner.nextLine().toLowerCase();
                    servicioDAO.insertarMensaje(texto, color);
                    System.out.println("Mensaje insertado correctamente.");
                }
                case 3 -> {
                    // Busca un mensaje por su ID
                    System.out.print("Ingrese el ID del mensaje a buscar: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    List<Mensaje> resultado = servicioDAO.getMensajesById(id);
                    if (resultado.isEmpty()) {
                        System.out.println("No se encontró ningún mensaje con ese ID.");
                    } else {
                        for (Mensaje m : resultado) {
                            System.out.printf("ID: %d | Texto: %s | Color: %s%n",
                                    m.getIdMensaje(), m.getMensaje(), m.getTipo());
                        }
                    }
                }
                case 4 -> {
                    // Aplica formato en itálica al mensaje y lo guarda como archivo HTML
                    System.out.print("Ingrese el ID del mensaje para generar HTML: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    List<Mensaje> resultado = servicioDAO.getMensajesById(id);
                    if (resultado.isEmpty()) {
                        System.out.println("No se encontró ningún mensaje con ese ID.");
                    } else {

                        Mensaje mensaje = resultado.get(0);
                        if (mensaje.getTipo().equals("rojo")){
                            IFormateador formateador = new FormateadorH1(new FormateadorNegrita(mensaje));
                            formateador.aplicarFormato(mensaje);
                            formateador.guardar();
                        } else if (mensaje.getTipo().equals("amarillo")) {
                            IFormateador formateador = new FormateadorNegrita(new FormateadorSubrayado(mensaje));
                            formateador.aplicarFormato(mensaje);
                            formateador.guardar();
                        } else if (mensaje.getTipo().equals("verde")) {
                            IFormateador formateador = new FormateadorItalico((mensaje));
                            formateador.aplicarFormato(mensaje);
                            formateador.guardar();
                        }
                    }
                }
                case 5 -> {
                    // Finaliza la aplicación
                    em.close();
                    emf.close();
                    System.out.println("Aplicación finalizada.");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
