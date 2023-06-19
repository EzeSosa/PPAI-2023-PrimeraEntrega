package cu44.Interfaz;

import cu44.Modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        PantallaConsultarEncuesta pantallaConsultarEncuesta = new PantallaConsultarEncuesta();
        pantallaConsultarEncuesta.opcionConsultarEncuesta();

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

        configuration.addAnnotatedClass(Cliente.class); // BIEN MAPEADA
        configuration.addAnnotatedClass(Estado.class); // BIEN MAPEADA
        configuration.addAnnotatedClass(Llamada.class); // BIEN MAPEADA
        configuration.addAnnotatedClass(Encuesta.class); // BIEN MAPEADA
        configuration.addAnnotatedClass(CambioEstado.class);
        configuration.addAnnotatedClass(Pregunta.class); // BIEN MAPEADA
        configuration.addAnnotatedClass(RespuestaPosible.class);
        configuration.addAnnotatedClass(RespuestaDeCliente.class);

        // Creación de la Sesión

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("FROM Llamada", Llamada.class);
        List<Llamada> llamadas = query.getResultList();

        for (Llamada call: llamadas) {
            System.out.println("Duración:" + call.getDuracion() + "Nombre Cliente: " + call.getNombreClienteLlamada());
            for (RespuestaDeCliente resp: call.getRespuestasDeEncuesta()){
                System.out.println(resp.getDescripcionRta());
            }
        }

        session.close();
    }
}