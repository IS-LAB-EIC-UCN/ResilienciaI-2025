package cl.ucn.modelo;

/**
 * Decorador que aplica formato HTML de título principal (etiqueta {@code &lt;h1&gt;}) al contenido del mensaje.
 *
 * <p>
 * Esta clase extiende {@link FormateadorDecorador} y modifica el contenido del mensaje
 * envolviéndolo dentro de etiquetas {@code &lt;h1&gt;...&lt;/h1&gt;}, asignando además un nombre de archivo
 * basado en el identificador del mensaje.
 * </p>
 *
 * <p>
 * Este decorador no guarda directamente el archivo, sino que delega en la cadena de decoradores
 * hasta que un componente concreto (como {@link Mensaje}) ejecute la operación {@code guardar()}.
 * </p>
 *
 * @author Irene
 */
public class FormateadorH1 extends FormateadorDecorador {

    /**
     * Contenido HTML generado con el formato {@code &lt;h1&gt;}.
     */
    String contenidoHtml;

    /**
     * Nombre del archivo HTML resultante.
     */
    String nombreArchivo;

    /**
     * Crea un decorador que aplica formato de título principal al mensaje.
     *
     * @param iFormateador el formateador al que se le desea añadir este formato.
     */
    public FormateadorH1(IFormateador iFormateador) {
        super(iFormateador);
    }

    /**
     * Aplica el formato {@code &lt;h1&gt;} al mensaje recibido, delegando primero al decorador anterior.
     *
     * @param mensaje el mensaje a formatear.
     */
    @Override
    public void aplicarFormato(Mensaje mensaje) {
        super.aplicarFormato(mensaje);
        this.contenidoHtml = "&lt;h1&gt;" + mensaje.getMensaje() + "&lt;/h1&gt;";
        mensaje.setMensaje(this.contenidoHtml);
        this.nombreArchivo = mensaje.getIdMensaje() + ".html";
    }

    /**
     * Delegación del guardado al decorador anterior.
     * Este decorador no realiza la escritura del archivo directamente.
     */
    @Override
    public void guardar() {
        super.guardar();
    }
}
