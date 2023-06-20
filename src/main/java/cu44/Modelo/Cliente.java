package cu44.Modelo;
import javax.persistence.*;

@Entity
public class Cliente {
    // Atributos por valor de Cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dni, nroCelular;
    private String nombreCompleto;

    // Constructor con parámetros
    public Cliente (int dni, int nroCelular, String nombreCompleto) {
        this.dni = dni;
        this.nroCelular = nroCelular;
        this.nombreCompleto = nombreCompleto;
    }

    // Constructor sin parámetros
    public Cliente() {
    }

    // Getter del nombre del cliente
    public String getNombre(){
        return this.nombreCompleto;
    }
}