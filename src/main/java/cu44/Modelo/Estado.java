package cu44.Modelo;
import javax.persistence.*;

@Entity
public class Estado {
    // Atributos por valor del Estado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    // Constructor con parámetros
    public Estado (String nombre){
        this.nombre = nombre;
    }

    // Constructor sin parámetros
    public Estado() {
    }

    // Verificación de si Estado es 'Finalizada'
    public boolean esFinalizada(){
        return "Finalizada".equals(this.nombre);
    }

    // Verificación de si Estado es 'Iniciada'
    public boolean esIniciada(){
        return "Iniciada".equals(this.nombre);
    }

    // Getter del nombre del Estado
    public String getNombre(){
        return this.nombre;
    }
}