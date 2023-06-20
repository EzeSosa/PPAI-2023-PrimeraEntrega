package cu44.Controlador;
import cu44.Modelo.Encuesta;
import cu44.Modelo.Llamada;
import cu44.Interfaz.PantallaConsultarEncuesta;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorConsultarEncuesta {
    // atributos por valor del gestor
    private Date fechaInicioPeriodoAConsultar;
    private Date fechaFinPeriodoAConsultar;
    private String nombreCliente, nombreEstadoActual, descripcionEncuesta, opcionGeneracionInformeSeleccionada;
    private int duracionLlamada;
    private boolean encuestaEnviada;
    private List<String> descripcionRespuestasCliente, descripcionPreguntasEncuesta, opcionesGeneracionInforme;

    // atributos por referencia del gestor
    private PantallaConsultarEncuesta pantallaConsultarEncuesta;
    private Llamada llamadaSeleccionada;
    private List<Llamada> llamadas;
    private List<Encuesta> encuestas;
    private ArrayList<Llamada> llamadasConEncuestaEnPeriodo;
    private Session sesion;

    // Constructor del Gestor
    public GestorConsultarEncuesta(PantallaConsultarEncuesta pantallaConsultarEncuesta, Session sesion) {
        this.sesion = sesion;
        this.pantallaConsultarEncuesta = pantallaConsultarEncuesta;

        // Carga de Encuestas al Gestor
        Query query = sesion.createQuery("FROM Encuesta");
        encuestas = query.getResultList();

        // Carga de Llamadas al Gestor
        query = sesion.createQuery("FROM Llamada");
        llamadas = query.getResultList();
    }

    // Inicio del CU
    public void nuevaConsultaEncuesta() {
        this.consultarPeriodoEncuestas();
    }

    // Solicitud de la Fecha Desde y de la Fecha Hasta
    public void consultarPeriodoEncuestas() {
        pantallaConsultarEncuesta.solicitarPeriodoConsulta();
    }

    // método para obtener el periodo seleccionado de la encuesta
    public void tomarPeriodoSeleccionado(Date fechaDesde, Date fechaHasta) {
        if (fechaDesde != null && fechaHasta != null) {
            this.fechaInicioPeriodoAConsultar = fechaDesde;
            this.fechaFinPeriodoAConsultar = fechaHasta;

            if (validarPeriodoIngresado()) {
                this.buscarLlamadasConEncuestaEnPeriodo();
            }
        }
    }

    // Validación del periodo ingresado (fecha desde < fecha hasta y ambas menores a la fecha actual)
    public boolean validarPeriodoIngresado() {
        return this.fechaInicioPeriodoAConsultar.before(this.fechaFinPeriodoAConsultar) &&
                this.fechaFinPeriodoAConsultar.before(new Date());
    }

    // Obtención de Llamadas con encuesta respondida en el período
    public void buscarLlamadasConEncuestaEnPeriodo() {
        llamadasConEncuestaEnPeriodo = new ArrayList<>();
        for (Llamada llamada: llamadas) {
            if (llamada.esDePeriodo(this.fechaInicioPeriodoAConsultar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                                    this.fechaFinPeriodoAConsultar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                && llamada.existeEncuestaRespondida()) {
                llamadasConEncuestaEnPeriodo.add(llamada);
            }
        }
        pantallaConsultarEncuesta.mostrarLlamadasConEncuestaEnPeriodo(llamadasConEncuestaEnPeriodo);
    }

    // método para obtener la llamada seleccionada
    public void tomarSeleccionLlamada (Llamada llamadaSeleccionada) {
        this.llamadaSeleccionada = llamadaSeleccionada;
        this.buscarDatosLlamadaSeleccionada();
        this.buscarDatosRespuestasDeCliente();
    }

    // método para obtener los datos de la llamada seleccionada
    public void buscarDatosLlamadaSeleccionada() {
        this.nombreCliente = this.llamadaSeleccionada.getNombreClienteLlamada();
        this.nombreEstadoActual = this.llamadaSeleccionada.getNombreEstadoActual();
        this.duracionLlamada = this.llamadaSeleccionada.getDuracion();
        pantallaConsultarEncuesta.mostrarDatosObtenidos(this.nombreCliente, this.nombreEstadoActual, this.duracionLlamada);
    }

    // método para obtener las descripciones de las respuestas del cliente
    public void buscarDatosRespuestasDeCliente() {
        this.descripcionRespuestasCliente = llamadaSeleccionada.getDescripcionRespuestasDeCliente();
    }

    // método para obtener la encuesta enviada al cliente y la descripción de esa encuesta con sus preguntas
    public void buscarDatosEncuestaYPreguntas() {
    }

    // método para tomar la opción de generación de informe
    public void tomarOpcionSeleccionada(String opcionSeleccionada) {
        this.opcionGeneracionInformeSeleccionada = opcionSeleccionada;
    }

    // método para generar el archivo CSV
    public void generarArchivoCSV() {
    }

    // método para finalizar el caso de uso
    public void finCU() {
        System.exit(0);
    }
}
