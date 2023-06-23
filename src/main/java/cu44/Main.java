package cu44;
import cu44.BBDD.ConfiguracionBBDD;
import cu44.Interfaz.PantallaConsultarEncuesta;

public class Main {
    public static void main(String[] args) {
        // Creación de la configuración de la BD
        ConfiguracionBBDD configuracionBBDD = new ConfiguracionBBDD();

        // Creación de la pantalla
        PantallaConsultarEncuesta pantallaConsultarEncuesta = new PantallaConsultarEncuesta(configuracionBBDD.configurarBBDD());
        pantallaConsultarEncuesta.opcionConsultarEncuesta();
    }
}