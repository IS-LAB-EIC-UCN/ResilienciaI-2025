package cl.ucn.modelo;

/**
 * Interfaz que define las operaciones básicas de un formateador de mensajes.
 *
 * <p>
 * Los formateadores permiten aplicar una transformación al contenido de un mensaje
 * y luego guardar su representación en un formato específico (por ejemplo, HTML).
 * Esta interfaz es la base del patrón Decorator utilizado para componer múltiples
 * capas de formato sobre un mismo mensaje.
 * </p>
 *
 * @author Irene
 */
public interface IFormateador {

    /**
     * Aplica un formato al mensaje proporcionado.
     *
     * @param mensaje el mensaje al que se le debe aplicar el formato.
     */
    void aplicarFormato(Mensaje mensaje);

    /**
     * Guarda el mensaje formateado en el soporte correspondiente (por ejemplo, archivo).
     */
    void guardar();
}
