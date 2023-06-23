package cu44.Modelo;
import javax.persistence.*;

@Entity
public class RespuestaPosible {
    // Atributos por valor de RespuestaPosible
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private int valor;

    // Constructor sin parámetros
    public RespuestaPosible() {
    }

    // Getter de la descripción de la respuesta
    public String getDescripcionRta(){
        return this.descripcion;
    }
}