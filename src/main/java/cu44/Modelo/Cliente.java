package cu44.Modelo;
import javax.persistence.*;

@Entity
public class Cliente {
    // atributos por valor del cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dni, nroCelular;
    private String nombreCompleto;

    // constructor del cliente
    public Cliente (int dni, int nroCelular, String nombreCompleto) {
        this.dni = dni;
        this.nroCelular = nroCelular;
        this.nombreCompleto = nombreCompleto;
    }

    public Cliente() {
    }

    // método para obtener el nombre del cliente
    public String getNombre(){
        return this.nombreCompleto;
    }
}
