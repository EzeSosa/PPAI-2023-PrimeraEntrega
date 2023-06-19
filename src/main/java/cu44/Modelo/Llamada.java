package cu44.Modelo;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

@Entity
public class Llamada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private String descripcionOperador, detalleAccionRequerida;
    private int duracion;
    private boolean encuestaEnviada;

    // atributos por referencia de la llamada
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Estado estadoActual;
    @OneToMany
    private List<CambioEstado> cambioEstado;
    @OneToMany
    private List<RespuestaDeCliente> respuestasDeEncuesta;

    // constructor (especificado en CU 1)
    public Llamada (Cliente cliente, Estado estadoActual, LocalDateTime fechaHoraInicio){
        this.estadoActual = estadoActual;
        this.cliente = cliente;
        crearCambioEstado(estadoActual, fechaHoraInicio);
    }

    public Llamada() {
    }

    // método para crear los cambios de estado de la llamada
    private void crearCambioEstado(Estado estado, LocalDateTime fechaHoraInicio){
        CambioEstado nuevo = new CambioEstado(fechaHoraInicio, estado);
        this.cambioEstado.add(nuevo);
    }

    // método para setear el estado actual de la llamada
    public void setEstado(Estado estadoActual){
        this.estadoActual = estadoActual;
    }

    // método para comprobar si la fecha de la llamada está dentro de un periodo
    public boolean esDePeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta){
        for (CambioEstado cambio: cambioEstado){
            if (cambio.esEstadoInicial()){ // se comprueba la fecha donde inició la llamada
                LocalDateTime fechaCambio = cambio.getFechaHoraInicio();
                return (fechaCambio.isAfter(fechaDesde) && fechaCambio.isBefore(fechaHasta));
            }
        }
        return false;
    }

    // método para comprobar si la llamada tiene encuesta enviada
    public boolean existeEncuestaRespondida(){
        return !this.respuestasDeEncuesta.isEmpty();
    }

    // método para obtener el nombre del cliente de la llamada
    public String getNombreClienteLlamada(){
        return this.cliente.getNombre();
    }

    // método para obtener el nombre del estado actual de la llamada
    public String getNombreEstadoActual(){
        return this.estadoActual.getNombre();
    }

    // método para obtener la duración de la llamada
    public int getDuracion(){
        return this.duracion;
    }

    // método para obtener las respuestas de cliente de la llamada
    public List<String> getDescripcionRespuestasDeCliente(){
        List<String> respuestas = new ArrayList<>(); // se obtienen las descripciones de las respuestas seleccionadas
        for (RespuestaDeCliente respuesta: respuestasDeEncuesta) {
            respuestas.add(respuesta.getDescripcionRta());
        }
        return respuestas;
    }

    // método para obtener las respuestas de la encuesta (los punteros)
    public List<RespuestaDeCliente> getRespuestasDeEncuesta() {
        return this.respuestasDeEncuesta;
    }
}
