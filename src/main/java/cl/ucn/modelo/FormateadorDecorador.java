package cl.ucn.modelo;

/**
 * Clase base para todos los decoradores de formato.
 *
 * <p>
 * Implementa el patrón Decorator, permitiendo extender dinámicamente
 * la funcionalidad de los objetos que implementan la interfaz {@link IFormateador}.
 * Esta clase delega todas las operaciones al objeto {@code IFormateador} recibido en el constructor.
 * </p>
 *
 * <p>
 * Las subclases deben sobreescribir los métodos {@code aplicarFormato} y/o {@code guardar}
 * para modificar o ampliar el comportamiento.
 * </p>
 *
 * @author Irene
 */
public class FormateadorDecorador implements IFormateador {

    /**
     * Referencia al objeto formateador que se decora.
     */
    protected IFormateador iFormateador;

    /**
     * Crea un decorador que extiende el comportamiento del formateador dado.
     *
     * @param iFormateador el formateador a decorar.
     */
    public FormateadorDecorador(IFormateador iFormateador) {
        this.iFormateador = iFormateador;
    }

    /**
     * Aplica el formato delegando al formateador decorado.
     *
     * @param mensaje el mensaje a formatear.
     */
    @Override
    public void aplicarFormato(Mensaje mensaje) {
        iFormateador.aplicarFormato(mensaje);
    }

    /**
     * Guarda el mensaje delegando al formateador decorado.
     */
    @Override
    public void guardar() {
        iFormateador.guardar();
    }
}
