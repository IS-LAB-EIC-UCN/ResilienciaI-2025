package cl.ucn.modelo;

/**
 * Decorador que aplica formato en subrayado ({@code <u>...</u>}) al contenido del mensaje.
 *
 * <p>
 * Esta clase extiende {@link FormateadorDecorador} y permite modificar el contenido del mensaje
 * envolviéndolo en etiquetas HTML {@code <u>}, indicando que debe mostrarse subrayado.
 * </p>
 *
 * <p>
 * Este decorador no realiza la operación de guardado por sí mismo, sino que delega esa
 * responsabilidad a un decorador superior o al objeto {@link Mensaje}.
 * </p>
 *
 * @author Irene
 */
public class FormateadorSubrayado extends FormateadorDecorador {

    /**
     * Contenido HTML generado con formato subrayado.
     */
    private String contenidoHtml;

    /**
     * Nombre del archivo de salida asociado al mensaje.
     */
    private String nombreArchivo;

    /**
     * Crea un nuevo decorador que aplica formato subrayado al formateador dado.
     *
     * @param iFormateador el formateador base que se desea decorar.
     */
    public FormateadorSubrayado(IFormateador iFormateador) {
        super(iFormateador);
    }

    /**
     * Aplica formato subrayado al contenido del mensaje:
     * <ul>
     *   <li>Primero delega el formateo al decorador anterior.</li>
     *   <li>Luego envuelve el contenido actual en la etiqueta {@code <u>}.</li>
     *   <li>Actualiza el mensaje con el nuevo contenido HTML.</li>
     *   <li>Asigna el nombre del archivo HTML de salida.</li>
     * </ul>
     *
     * @param mensaje el mensaje sobre el cual se aplicará el formato.
     */
    @Override
    public void aplicarFormato(Mensaje mensaje) {
        super.aplicarFormato(mensaje);
        this.contenidoHtml = "<u>" + mensaje.getMensaje() + "</u>";
        mensaje.setMensaje(this.contenidoHtml);
        this.nombreArchivo = mensaje.getIdMensaje() + ".html";
    }

    /**
     * Delegación de la operación de guardado al decorador anterior.
     * Este decorador no realiza la escritura del archivo por sí mismo.
     */
    @Override
    public void guardar() {
        super.guardar();
    }
}
