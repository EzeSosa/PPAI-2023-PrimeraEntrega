package cu44.Modelo;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CambioEstado {
    // Atributos por valor de CambioEstado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    // Atributo por referencia de CambioEstado
    @ManyToOne
    private Estado estado;

    // Constructor sin parámetros
    public CambioEstado(){
    }

    // Verificación de si es el cambio de estado inicial (Iniciada)
    public boolean esEstadoInicial(){
        return estado.esIniciada();
    }

    // Verificación de si es el cambio de estado final
    public boolean esUltimoEstado(){
        return this.fechaHoraFin == null;
    }

    // Getter de fechaHoraInicio
    public LocalDateTime getFechaHoraInicio(){
        return this.fechaHoraInicio;
    }

    // Setter de fechaHoraFin
    public void setFechaHoraFin (LocalDateTime fechaHoraFin){
        this.fechaHoraFin = fechaHoraFin;
    }
}