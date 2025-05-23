package cl.ucn.modelo;

import jakarta.persistence.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Representa un mensaje almacenado en la base de datos.
 *
 * <p>
 * Cada mensaje tiene un identificador único, un contenido textual y un tipo que representa su criticidad.
 * Además, esta clase puede participar en la cadena de decoradores al implementar la interfaz {@link IFormateador}.
 * </p>
 *
 * <p>
 * Esta clase está anotada como una entidad JPA y se mapea a la tabla {@code mensaje}.
 * </p>
 *
 * <p>
 * También actúa como el componente concreto responsable de guardar el contenido final del mensaje formateado
 * en un archivo HTML, envolviéndolo con etiquetas estándar {@code <html><body>...</body></html>}.
 * </p>
 *
 * @author Irene
 */
@Entity
@Table(name = "mensaje")
public class Mensaje implements IFormateador {

    /**
     * Identificador único del mensaje.
     * Se genera automáticamente mediante la estrategia {@code IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMensaje;

    /**
     * Contenido textual original del mensaje.
     */
    private String mensaje;

    /**
     * Tipo de mensaje que representa su nivel de criticidad.
     * Por ejemplo: {@code "verde"}, {@code "amarillo"}, {@code "rojo"}.
     */
    private String tipo;

    /**
     * Retorna el identificador único del mensaje.
     *
     * @return el ID del mensaje.
     */
    public long getIdMensaje() {
        return idMensaje;
    }

    /**
     * Asigna un nuevo ID al mensaje.
     *
     * @param idMensaje el identificador a establecer.
     */
    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * Obtiene el contenido textual del mensaje.
     *
     * @return el texto del mensaje.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Asigna el contenido textual al mensaje.
     *
     * @param mensaje el nuevo contenido textual.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Retorna el tipo de criticidad del mensaje.
     *
     * @return una cadena que indica el tipo del mensaje.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Asigna un nuevo tipo de criticidad al mensaje.
     *
     * @param tipo el tipo a establecer (por ejemplo: {@code "rojo"}, {@code "verde"}).
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método vacío que cumple con la interfaz {@link IFormateador}.
     * Esta clase no aplica formatos directamente, sino que delega esta responsabilidad a los decoradores.
     *
     * @param mensaje el mensaje a formatear (sin efecto en esta implementación).
     */
    @Override
    public void aplicarFormato(Mensaje mensaje) {
        // Este método no aplica formato; el formateo ocurre en los decoradores.
    }

    /**
     * Guarda el contenido del mensaje en un archivo HTML.
     *
     * <p>
     * El contenido se envuelve en etiquetas {@code <html><body>...</body></html>} y se escribe
     * en un archivo ubicado en el directorio {@code htmls}, cuyo nombre corresponde al ID del mensaje.
     * </p>
     */
    @Override
    public void guardar() {
        File directorio = new File("htmls");
        if (!directorio.exists() && !directorio.mkdirs()) {
            System.err.println("No se pudo crear el directorio 'htmls'.");
            return;
        }

        File archivo = new File(directorio, this.idMensaje + ".html");

        String htmlCompleto = "<html><body>\n" + this.getMensaje() + "\n</body></html>";

        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(htmlCompleto);
            System.out.println("Archivo HTML creado: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo HTML: " + e.getMessage());
        }
    }
}
