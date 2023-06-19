package cu44.Modelo;
import javax.persistence.*;

@Entity
public class Estado {
    // atributo por valor del estado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // constructor
    public Estado (String nombre){
        this.nombre = nombre;
    }

    public Estado() {
    }

    // método para verificar si el estado es estado final
    public boolean esFinalizada(){
        return "Finalizada".equals(this.nombre);
    }

    // método para verificar si el estado es estado inicial
    public boolean esIniciada(){
        return "Iniciada".equals(this.nombre);
    }

    // método para obtener el nombre del estado
    public String getNombre(){
        return this.nombre;
    }
}