package cl.ucn.modelo;

/**
 * Decorador que aplica formato en negrita ({@code <b>...</b>}) al contenido del mensaje.
 *
 * <p>
 * Esta clase implementa el patrón Decorator, y permite aplicar una capa de formato en negrita
 * al contenido del mensaje, envolviéndolo dentro de la etiqueta HTML {@code <b>}.
 * </p>
 *
 * <p>
 * El método {@link #aplicarFormato(Mensaje)} primero delega la operación en el formateador anterior
 * y luego modifica el contenido del mensaje. El método {@link #guardar()} simplemente delega,
 * asumiendo que la responsabilidad de persistencia está en otra parte de la cadena.
 * </p>
 *
 * @author Irene
 */
public class FormateadorNegrita extends FormateadorDecorador {

    /**
     * Contenido HTML resultante tras aplicar el formato en negrita.
     */
    private String contenidoHtml;

    /**
     * Nombre del archivo HTML que se generará.
     */
    private String nombreArchivo;

    /**
     * Construye un decorador que aplica formato en negrita al formateador dado.
     *
     * @param iFormateador el formateador que se desea decorar.
     */
    public FormateadorNegrita(IFormateador iFormateador) {
        super(iFormateador);
    }

    /**
     * Aplica formato en negrita al contenido del mensaje:
     * <ul>
     *   <li>Primero delega el formateo al decorador anterior.</li>
     *   <li>Luego envuelve el contenido actual en {@code <b>...</b>}.</li>
     *   <li>Actualiza el mensaje con el nuevo HTML generado.</li>
     *   <li>Asigna el nombre del archivo basado en el ID del mensaje.</li>
     * </ul>
     *
     * @param mensaje el mensaje sobre el cual se aplicará el formato.
     */
    @Override
    public void aplicarFormato(Mensaje mensaje) {
        super.aplicarFormato(mensaje);
        this.contenidoHtml = "<b>" + mensaje.getMensaje() + "</b>";
        mensaje.setMensaje(this.contenidoHtml);
        this.nombreArchivo = mensaje.getIdMensaje() + ".html";
    }

    /**
     * Delegación del método {@code guardar()} al decorador anterior.
     * Este decorador no guarda directamente en disco.
     */
    @Override
    public void guardar() {
        super.guardar();
    }
}
