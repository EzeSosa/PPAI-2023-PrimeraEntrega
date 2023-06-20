package cu44.Modelo;
import javax.persistence.*;

@Entity
public class RespuestaPosible {
    // Atributos por valor de RespuestaPosible
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int valor;
    private String descripcion;

    // Constructor con parámetros
    public RespuestaPosible (int valor, String descripcion){
        this.valor = valor;
        this.descripcion = descripcion;
    }

    // Constructor sin parámetros
    public RespuestaPosible() {
    }

    // Getter de la descripción de la respuesta
    public String getDescripcionRta(){
        return this.descripcion;
    }

    // Getter del valor de la respuesta
    public int getValor() {
        return this.valor;
    }
}