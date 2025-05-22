package cl.ucn.servicio;

import cl.ucn.modelo.Mensaje;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Clase de acceso a datos que proporciona operaciones CRUD básicas
 * para la entidad {@link Mensaje} utilizando JPA y {@link EntityManager}.
 */
public class ServicioDAO {

    /**
     * Manejador de entidades usado para las operaciones de persistencia.
     */
    private final EntityManager em;

    /**
     * Constructor que inicializa el DAO con una instancia de {@link EntityManager}.
     *
     * @param entityManager el manejador de entidades JPA.
     */
    public ServicioDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    /**
     * Recupera todos los mensajes almacenados en la base de datos.
     *
     * @return una lista con todos los mensajes.
     */
    public List<Mensaje> getMensajes() {
        TypedQuery<Mensaje> query = em.createQuery("SELECT m FROM Mensaje m", Mensaje.class);
        return query.getResultList();
    }

    /**
     * Recupera los mensajes cuyo ID coincida con el valor especificado.
     *
     * @param id el ID del mensaje a buscar.
     * @return una lista de mensajes que coincidan con el ID (típicamente uno o ninguno).
     */
    public List<Mensaje> getMensajesById(Long id) {
        TypedQuery<Mensaje> query = em.createQuery(
                "SELECT m FROM Mensaje m WHERE m.id = :id", Mensaje.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    /**
     * Inserta un nuevo mensaje en la base de datos con el contenido y tipo especificado.
     *
     * @param mensaje     el contenido textual del mensaje.
     * @param criticidad  el tipo o nivel de criticidad del mensaje (p. ej. "rojo", "verde").
     */
    public void insertarMensaje(String mensaje, String criticidad) {
        Mensaje nuevo = new Mensaje();
        nuevo.setMensaje(mensaje);
        nuevo.setTipo(criticidad);

        em.getTransaction().begin();
        em.persist(nuevo);
        em.getTransaction().commit();
    }
}
