package cu44.Interfaz;
import cu44.Modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // Configuración de la Sesión

        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/gestionllamadas");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(properties);

        // Mapeo de las Clases

        configuration.addAnnotatedClass(Cliente.class);
        configuration.addAnnotatedClass(Estado.class);
        configuration.addAnnotatedClass(Llamada.class);
        configuration.addAnnotatedClass(Encuesta.class);
        configuration.addAnnotatedClass(CambioEstado.class);
        configuration.addAnnotatedClass(Pregunta.class);
        configuration.addAnnotatedClass(RespuestaPosible.class);
        configuration.addAnnotatedClass(RespuestaDeCliente.class);

        // Creación de la Sesión

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Creación de la Pantalla y el Gestor
        PantallaConsultarEncuesta pantallaConsultarEncuesta = new PantallaConsultarEncuesta(session);
        pantallaConsultarEncuesta.opcionConsultarEncuesta();
    }
}