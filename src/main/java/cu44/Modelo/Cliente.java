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

    // Constructor sin parámetros
    public Cliente() {
    }

    // Método para verificar si se trata del cliente (comparación de punteros)
    public boolean esCliente(Cliente cliente) {
        return this == cliente;
    }

    // Getter del nombre del cliente
    public String getNombre(){
        return this.nombreCompleto;
    }
}