package cl.ucn.modelo;

import jakarta.persistence.*;

/**
 * Representa un mensaje almacenado en la base de datos.
 * Cada mensaje tiene un identificador único, contenido textual y un nivel de criticidad (tipo).
 *
 * La clase está anotada como una entidad JPA y se mapea a la tabla {@code mensaje}.
 */
@Entity
@Table(name = "mensaje")
public class Mensaje {

    /**
     * Identificador único del mensaje.
     * Se genera automáticamente mediante la estrategia {@code IDENTITY}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMensaje;

    /**
     * Contenido textual del mensaje.
     */
    private String mensaje;

    /**
     * Tipo de mensaje que representa su criticidad.
     * Puede ser por ejemplo: {@code "verde"}, {@code "amarillo"} o {@code "rojo"}.
     */
    private String tipo;

    /**
     * Obtiene el ID del mensaje.
     * @return el identificador único del mensaje.
     */
    public long getIdMensaje() {
        return idMensaje;
    }

    /**
     * Establece el ID del mensaje.
     * @param idMensaje el identificador único a asignar.
     */
    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * Devuelve el contenido textual del mensaje.
     * @return el texto del mensaje.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Establece el contenido textual del mensaje.
     * @param mensaje el nuevo texto del mensaje.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Obtiene el tipo de mensaje, que representa su criticidad.
     * @return una cadena que representa el tipo de criticidad del mensaje.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de criticidad del mensaje.
     * @param tipo el nuevo tipo (por ejemplo, {@code "rojo"}, {@code "verde"}, etc.)
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
