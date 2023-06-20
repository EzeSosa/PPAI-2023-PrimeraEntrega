package cu44.Modelo;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

@Entity
public class Llamada {

    // Atributos por valor de Llamada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcionOperador;
    private int duracion;
    private boolean encuestaEnviada;

    // Atributos por referencia de Llamada
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Estado estadoActual;
    @OneToMany
    private List<CambioEstado> cambioEstado;
    @OneToMany
    private List<RespuestaDeCliente> respuestasDeEncuesta;

    // Constructor con parámetros (CU #1)
    public Llamada (Cliente cliente, Estado estadoActual, LocalDateTime fechaHoraInicio){
        this.estadoActual = estadoActual;
        this.cliente = cliente;
        crearCambioEstado(estadoActual, fechaHoraInicio);
    }

    // Constructor sin parámetros
    public Llamada() {
    }

    // Creación de los cambios de estado de la llamada
    private void crearCambioEstado(Estado estado, LocalDateTime fechaHoraInicio){
        CambioEstado nuevo = new CambioEstado(fechaHoraInicio, estado);
        this.cambioEstado.add(nuevo);
    }

    // Setter del Estado actual de la llamada
    public void setEstado(Estado estadoActual){
        this.estadoActual = estadoActual;
    }

    // Comprobación de la Llamada en el periodo ingresado
    public boolean esDePeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta){
        for (CambioEstado cambio: cambioEstado){
            if (cambio.esEstadoInicial()){ // Se comprueba la fecha donde la llamada es Iniciada
                LocalDateTime fechaCambio = cambio.getFechaHoraInicio();
                return (fechaCambio.isAfter(fechaDesde) && fechaCambio.isBefore(fechaHasta));
            }
        }
        return false;
    }

    // Comprobación de si la Llamada tiene encuesta respondida
    public boolean existeEncuestaRespondida(){
        return !this.respuestasDeEncuesta.isEmpty(); // Se comprueba que el array de respuestas de cliente no sea vacío
    }

    // Obtención de la descripción de las respuestas de cliente de la llamada
    public List<String> getDescripcionRespuestasDeCliente(){
        List<String> respuestas = new ArrayList<>(); // Se obtienen las descripciones de las respuestas seleccionadas
        for (RespuestaDeCliente respuesta: respuestasDeEncuesta) {
            respuestas.add(respuesta.getDescripcionRta());
        }
        return respuestas;
    }

    // Getter del nombre del cliente asociado
    public String getNombreClienteLlamada(){
        return this.cliente.getNombre();
    }

    // Getter del nombre del estado actual
    public String getNombreEstadoActual(){
        return this.estadoActual.getNombre();
    }

    // Getter de la duración de la llamada
    public int getDuracion(){
        return this.duracion;
    }

    // Getter de las respuestas del cliente de la llamada
    public List<RespuestaDeCliente> getRespuestasDeEncuesta() {
        return this.respuestasDeEncuesta;
    }

    // Getter del ID de la llamada
    public Long getId() {
        return id;
    }

    // Getter de la descripción del operador
    public String getDescripcionOperador() {
        return descripcionOperador;
    }
}