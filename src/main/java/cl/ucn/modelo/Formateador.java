package cl.ucn.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase encargada de aplicar formato al contenido de un {@link Mensaje}
 * y guardar dicho contenido como un archivo HTML.
 *
 * Actualmente aplica formato en <i>itálica</i> a todo el contenido del mensaje.
 */
public class Formateador {

    /**
     * Aplica formato itálico al contenido del mensaje y lo guarda
     * como archivo HTML en una carpeta llamada {@code htmls}.
     * El nombre del archivo es el ID del mensaje seguido de la extensión {@code .html}.
     *
     * @param mensaje El objeto {@link Mensaje} cuyo contenido será formateado.
     */
    public void aplicarItalicaYGuardar(Mensaje mensaje) {
        String contenidoHtml = "<html><body><i>" + escapeHtml(mensaje.getMensaje()) + "</i></body></html>";
        String nombreArchivo = mensaje.getIdMensaje() + ".html";

        File directorio = new File("htmls");
        if (!directorio.exists()) {
            boolean creado = directorio.mkdirs();
            if (!creado) {
                System.err.println("No se pudo crear el directorio 'htmls'.");
                return;
            }
        }

        File archivo = new File(directorio, nombreArchivo);

        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(contenidoHtml);
            System.out.println("Archivo HTML creado: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo HTML: " + e.getMessage());
        }
    }

    /**
     * Reemplaza los caracteres especiales del texto por sus equivalentes HTML
     * para evitar conflictos en la visualización del contenido.
     *
     * @param texto El texto original a procesar.
     * @return El texto con caracteres especiales escapados para HTML.
     */
    private String escapeHtml(String texto) {
        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }
}
