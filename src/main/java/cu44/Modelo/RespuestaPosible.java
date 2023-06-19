package cu44.Modelo;
import javax.persistence.*;

@Entity
public class RespuestaPosible {
    // atributos por valor de la respuesta posible
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int valor;
    private String descripcion;

    // constructor de la respuesta posible
    public RespuestaPosible (int valor, String descripcion){
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public RespuestaPosible() {
    }

    // método para obtener la descripción de la respuesta posible
    public String getDescripcionRta(){
        return this.descripcion;
    }

    public int getValor() {
        return this.valor;
    }
}