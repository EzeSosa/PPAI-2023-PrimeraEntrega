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

    // Constructor
    public Encuesta (){
    }

    // Método para obtener la descripción de la encuesta
    public String getDescripcionEncuesta(){
        return this.descripcion;
    }

    // método para verificar si la encuesta es vigente (toma como parámetro la fecha actual)
    public boolean esVigente (LocalDate fechaActual){
        return fechaActual.isBefore(fechaFinVigencia);
    }

    // método para verificar si la encuesta es la encuesta de cliente (toma las respuestas de cliente como parámetro)
    public boolean esEncuestaDeCliente (Llamada llamadaSeleccionada){
        for (Pregunta preg: pregunta) { // la encuesta le consulta a sus preguntas si tiene sus respuestas posibles
            if (preg.esEncuestaDeCliente(llamadaSeleccionada.getRespuestasDeEncuesta())) {
                return true;
            }
        }
        return false;
    }

    // método para armar la encuesta con sus preguntas
    public String armarEncuesta() {
        return "";
    }

    public List<Pregunta> getPreguntas() {
        return this.pregunta;
    }
}
