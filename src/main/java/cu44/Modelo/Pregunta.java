package cu44.Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pregunta {
    // atributos por valor de la pregunta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pregunta;

    // atributos por referencia de la pregunta
    @ManyToMany
    private List<RespuestaPosible> respuesta;

    // constructor de la pregunta
    public Pregunta (String pregunta, List<RespuestaPosible> respuesta){
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Pregunta() {
    }

    // metodo para obtener la descripcion de la pregunta
    public String getDescripcion(){
        return this.pregunta;
    }

    // metodo para verificar si la encuesta es la encuesta del cliente
    public boolean esEncuestaDeCliente (List<RespuestaDeCliente> respuestasCliente) {
        return this.tieneRtaPosible(respuestasCliente.get(0).getRespuestaPosible());
    }

    // método para verificar si la respuesta es una de las respuestas de la pregunta
    public boolean tieneRtaPosible (RespuestaPosible respuestaDeCliente) {
        for (RespuestaPosible respPregunta: respuesta) { // se iteran las respuestas de la pregunta
            if (respPregunta == respuestaDeCliente) { // se verifica si la respuesta es la misma que la ingresada por el cliente
                return true;
            }
        }
        return false;
    }

    // método para devolver las respuestas posibles
    public List<RespuestaPosible> getRespuesta() {
        return this.respuesta;
    }
}
