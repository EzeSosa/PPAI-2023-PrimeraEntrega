package cu44.Modelo;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RespuestaDeCliente {
    // Atributos por valor de RespuestaDeCliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaEncuesta;

    // Atributos por referencia de RespuestaDeCliente
    @ManyToOne
    private RespuestaPosible respuestaSeleccionada;

    // Constructor sin parámetros
    public RespuestaDeCliente() {
    }

    // Obtención de la descripción de la respuesta posible asociada
    public String getDescripcionRta(){
        return respuestaSeleccionada.getDescripcionRta();
    }

    // Obtención del puntero a la respuesta posible
    public RespuestaPosible getRespuestaPosible() {
        return this.respuestaSeleccionada;
    }
}