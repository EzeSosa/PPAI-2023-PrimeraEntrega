package cu44.Modelo;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RespuestaDeCliente {
    // atributos por valor de respuestadecliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RespuestaPosible respuestaSeleccionada;

    private LocalDate fechaEncuesta;

    // constructor de respuestadecliente
    public RespuestaDeCliente(RespuestaPosible respuestaSeleccionada){
        this.respuestaSeleccionada = respuestaSeleccionada;
    }

    public RespuestaDeCliente() {
    }

    // método para obtener la descripción de la respuesta seleccionada
    public String getDescripcionRta(){
        return respuestaSeleccionada.getDescripcionRta();
    }

    // método para obtener la respuesta posible
    public RespuestaPosible getRespuestaPosible() {
        return this.respuestaSeleccionada;
    }
}
