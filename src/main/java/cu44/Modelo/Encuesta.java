package cu44.Modelo;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Encuesta {
    // Atributos por valor de la Encuesta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private LocalDate fechaFinVigencia;

    // Atributo por referencia de la encuesta
    @OneToMany
    private List<Pregunta> pregunta;

    // Constructor sin parámetros
    public Encuesta() {
    }

    // Getter de la descripción de la encuesta
    public String getDescripcionEncuesta() {
        return this.descripcion;
    }

    // Verificación de si la encuesta es vigente
    public boolean esVigente(LocalDate fechaActual) {
        return fechaActual.isBefore(fechaFinVigencia);
    }

    // Comprobación de si la encuesta enviada corresponde a la llamada
    public boolean esEncuestaDeCliente(Llamada llamadaSeleccionada) {
        for (Pregunta preg : pregunta) { // Se consulta a cada pregunta si contiene las respuestas del Cliente
            if (preg.esEncuestaDeCliente(llamadaSeleccionada.getRespuestasDeEncuesta())) {
                return true;
            }
        }
        return false;
    }

    // Armado de la Encuesta con sus Preguntas
    public String armarEncuesta() {
        return "";
    }
}