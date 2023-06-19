package cu44.Modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CambioEstado {
    // atributos por valor de cambioestado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    // atributos por referencia de cambioestado
    @ManyToOne
    private Estado estado;

    // constructor de cambioestado
    public CambioEstado (LocalDateTime fechaHoraInicio, Estado estado){
        this.fechaHoraInicio = fechaHoraInicio;
        this.estado = estado;
    }

    public CambioEstado(){
    }

    // método para verificar si el cambioestado corresponde al estado inicial
    public boolean esEstadoInicial(){
        return estado.esIniciada();
    }

    // metodo para verificar si es el cambio de estado correspondiente al estado actual
    public boolean esUltimoEstado(){
        return this.fechaHoraFin == null;
    }

    // metodo para obtener la fecha y la hora de inicio de cambioestado
    public LocalDateTime getFechaHoraInicio(){
        return this.fechaHoraInicio;
    }

    // metodo para obtener el nombre del estado correspondiente al cambio
    public String getNombreEstado(){
        return estado.getNombre();
    }

    // metodo para setear la fecha de fin del cambio de estado
    public void setFechaHoraFin (LocalDateTime fechaHoraFin){
        this.fechaHoraFin = fechaHoraFin;
    }
}