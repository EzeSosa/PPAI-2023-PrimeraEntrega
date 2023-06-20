package cu44.Modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pregunta {
    // Atributos por valor de Pregunta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pregunta;

    // Atributos por referencia de Pregunta
    @ManyToMany
    private List<RespuestaPosible> respuesta;

    // Constructor con parámetros
    public Pregunta (String pregunta, List<RespuestaPosible> respuesta){
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    // Constructor sin parámetros
    public Pregunta() {
    }

    // Getter de la descripción de la pregunta
    public String getDescripcion(){
        return this.pregunta;
    }

    // Comprobación de si la encuesta enviada corresponde a la llamada
    public boolean esEncuestaDeCliente (List<RespuestaDeCliente> respuestasCliente) {
        return this.tieneRtaPosible(respuestasCliente.get(0).getRespuestaPosible()); // Se comprueba si la pregunta tiene la respuesta posible
    }

    // Comprobación de si la pregunta tiene la respuesta posible
    private boolean tieneRtaPosible (RespuestaPosible respuestaDeCliente) {
        for (RespuestaPosible respPregunta: respuesta) { // Se iteran todas las respuestas de la pregunta
            if (respPregunta == respuestaDeCliente) { // Se comprueba si la respuesta es la misma que la ingresada por el cliente
                return true;
            }
        }
        return false;
    }
}