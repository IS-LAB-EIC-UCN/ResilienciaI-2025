package cl.ucn.modelo;

/**
 * Decorador que aplica formato en cursiva ({@code <i>...</i>}) al contenido del mensaje.
 *
 * <p>
 * Esta clase implementa el patrón Decorator, permitiendo aplicar formato en cursiva
 * a un mensaje. Primero delega en el formateador anterior con {@code super.aplicarFormato(mensaje)},
 * y luego modifica el contenido del mensaje envolviéndolo en la etiqueta {@code <i>}.
 * </p>
 *
 * <p>
 * El método {@link #guardar()} simplemente delega en el formateador anterior,
 * dejando la responsabilidad de escribir el archivo al decorador final o a la clase {@link Mensaje}.
 * </p>
 *
 * @author Irene
 */
public class FormateadorItalico extends FormateadorDecorador {

    /**
     * Contenido HTML generado por este decorador, con formato en cursiva.
     */
    private String contenidoHtml;

    /**
     * Nombre del archivo HTML asociado al mensaje.
     */
    private String nombreArchivo;

    /**
     * Crea un nuevo decorador que aplica formato en cursiva al formateador dado.
     *
     * @param iFormateador el formateador base que se decorará.
     */
    public FormateadorItalico(IFormateador iFormateador) {
        super(iFormateador);
    }

    /**
     * Aplica formato en cursiva al mensaje:
     * <ol>
     *   <li>Invoca primero al decorador anterior.</li>
     *   <li>Luego envuelve el contenido actual del mensaje en {@code <i> ... </i>}.</li>
     *   <li>Actualiza el contenido del mensaje con el HTML resultante.</li>
     *   <li>Asigna el nombre del archivo de salida basado en el ID del mensaje.</li>
     * </ol>
     *
     * @param mensaje el objeto {@link Mensaje} que se formateará.
     */
    @Override
    public void aplicarFormato(Mensaje mensaje) {
        super.aplicarFormato(mensaje);
        this.contenidoHtml = "<i>" + mensaje.getMensaje() + "</i>";
        mensaje.setMensaje(this.contenidoHtml);
        this.nombreArchivo = mensaje.getIdMensaje() + ".html";
    }

    /**
     * Delegación del método {@code guardar()} al decorador anterior.
     * La escritura en disco debe realizarse en una capa superior o final.
     */
    @Override
    public void guardar() {
        super.guardar();
    }
}
