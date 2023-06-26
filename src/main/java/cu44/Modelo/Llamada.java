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
    private String descripcionOperador, detalleAccionRequerida, observacionAuditor;
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

    // Constructor sin parámetros
    public Llamada() {
    }

    // Comprobación de la Llamada en el periodo ingresado
    public boolean esDePeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta){
        LocalDateTime fechaCambio = this.obtenerFechaEstadoInicial(); // Se obtiene la fecha del cambio de estado inicial
        return (fechaCambio.isAfter(fechaDesde) && fechaCambio.isBefore(fechaHasta));
    }

    // Método para obtener el estado inicial de la llamada
    private LocalDateTime obtenerFechaEstadoInicial() {
        LocalDateTime fechaEstadoInicial = null;
        for (CambioEstado cambio: cambioEstado) {
            // Se comprueba si es el estado inicial
            if (cambio.esEstadoInicial()) {
                fechaEstadoInicial = cambio.getFechaHoraInicio();
            }
        }
        return fechaEstadoInicial;
    }

    // Comprobación de si la Llamada tiene encuesta respondida
    public boolean tieneEncuestaRespondida(){
        return !this.respuestasDeEncuesta.isEmpty(); // Se comprueba que el array de respuestas de cliente no sea vacío
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

    // Obtención de la descripción de las respuestas de cliente de la llamada
    public ArrayList<String> getDescripcionRespuestasDeCliente(){
        ArrayList<String> respuestas = new ArrayList<>(); // Se obtienen las descripciones de las respuestas seleccionadas
        for (RespuestaDeCliente respuesta: respuestasDeEncuesta) {
            respuestas.add(respuesta.getDescripcionRta());
        }
        return respuestas;
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

    // Setter del estado actual de la llamada
    public void setEstadoActual(Estado estadoActual){
        this.estadoActual = estadoActual;
    }

    // Setter de la descripción del operador
    public void setDescripcionOperador(String descripcionOperador) {
        this.descripcionOperador = descripcionOperador;
    }

    // Setter de la duración de la llamada
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    // Cálculo de la duración [YA REGISTRADA EN LA BASE DE DATOS]
    public int calcularDuracion() {
        return 0;
    }
}