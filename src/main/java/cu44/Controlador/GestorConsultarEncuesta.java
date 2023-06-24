package cu44.Controlador;
import cu44.Interfaz.InterfazCSV;
import cu44.Modelo.Encuesta;
import cu44.Modelo.Llamada;
import cu44.Interfaz.PantallaConsultarEncuesta;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class GestorConsultarEncuesta {

    // Atributos por valor del gestor
    private Date fechaInicioPeriodoAConsultar;
    private Date fechaFinPeriodoAConsultar;
    private String nombreCliente, nombreEstadoActual, descripcionEncuesta, opcionGeneracionInformeSeleccionada;
    private int duracionLlamada;
    private ArrayList<String> descripcionRespuestasCliente, descripcionPreguntasEncuesta;

    // Atributos por referencia del gestor
    private PantallaConsultarEncuesta pantallaConsultarEncuesta;
    private InterfazCSV interfazCSV;
    private Llamada llamadaSeleccionada;
    private List<Llamada> llamadas;
    private List<Encuesta> encuestas;
    private ArrayList<Llamada> llamadasConEncuestaEnPeriodo;
    private Session sesion;
    private Encuesta encuestaEnviada;

    // Constructor del Gestor
    public GestorConsultarEncuesta(PantallaConsultarEncuesta pantallaConsultarEncuesta, Session sesion) {
        this.sesion = sesion; // Se obtiene la sesión necesaria para obtener las Encuestas y las Llamadas
        this.pantallaConsultarEncuesta = pantallaConsultarEncuesta;
        this.interfazCSV = new InterfazCSV();
        this.cargarLlamadasYEncuestas();
    }

    // Carga de Encuestas y Llamadas al Gestor
    private void cargarLlamadasYEncuestas(){
        // Carga de Encuestas mediante una query
        Query queryConsultas = sesion.createQuery("FROM Encuesta");
        encuestas = queryConsultas.getResultList();

        // Carga de Llamadas mediante una query
        Query queryLlamadas = sesion.createQuery("FROM Llamada");
        llamadas = queryLlamadas.getResultList();
    }

    // Inicio del CU
    public void nuevaConsultaEncuesta() {
        this.consultarPeriodoEncuestas();
    }

    // Solicitud de la Fecha Desde y de la Fecha Hasta
    private void consultarPeriodoEncuestas() {
        pantallaConsultarEncuesta.solicitarPeriodoConsulta();
    }

    // Obtención del periodo seleccionado de la pantalla
    public void tomarPeriodoSeleccionado(Date fechaDesde, Date fechaHasta) {
        if (fechaDesde != null && fechaHasta != null) { // Se verifica que ambas fechas estén seleccionadas
            this.fechaInicioPeriodoAConsultar = fechaDesde;
            this.fechaFinPeriodoAConsultar = fechaHasta;

            if (validarPeriodoIngresado()) { // Se valida el periodo ingresado
                this.buscarLlamadasConEncuestaEnPeriodo();

                if (this.llamadasConEncuestaEnPeriodo.size() > 0) { // Se valida que el arreglo de llamadas con encuesta en periodo no esté vacío
                    pantallaConsultarEncuesta.mostrarLlamadasConEncuestaEnPeriodo(this.llamadasConEncuestaEnPeriodo); // Se muestran las llamadas con encuesta en periodo
                } else {
                    pantallaConsultarEncuesta.informarNoHayLlamadas(); // Flujo Alternativo
                }
            } else {
                pantallaConsultarEncuesta.informarPeriodoInvalido(); // Flujo Alternativo
            }
        }
    }

    // Validación del periodo ingresado (fecha desde menor o igual fecha hasta y ambas menores o iguales a la fecha actual)
    private boolean validarPeriodoIngresado() {
        return (this.fechaInicioPeriodoAConsultar.before(this.fechaFinPeriodoAConsultar) || this.fechaInicioPeriodoAConsultar.equals(fechaFinPeriodoAConsultar)) &&
                (this.fechaFinPeriodoAConsultar.before(new Date()) || this.fechaFinPeriodoAConsultar.equals(new Date()));
    }

    // Obtención de Llamadas con encuesta respondida en el período
    private void buscarLlamadasConEncuestaEnPeriodo() {
        llamadasConEncuestaEnPeriodo = new ArrayList<>();
        for (Llamada llamada: llamadas) { // Se itera cada llamada y a cada una se le pregunta si es de periodo y si tiene encuesta respondida
            if (llamada.esDePeriodo(this.fechaInicioPeriodoAConsultar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                                    this.fechaFinPeriodoAConsultar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(23).withMinute(59)) // Conversión de tipos de fecha
                && llamada.tieneEncuestaRespondida()) {
                llamadasConEncuestaEnPeriodo.add(llamada);
            }
        }
    }

    // Método para obtener la llamada seleccionada
    public void tomarLlamadaSeleccionada (Llamada llamadaSeleccionada) {
        this.llamadaSeleccionada = llamadaSeleccionada;
        this.buscarDatosLlamadaSeleccionada(); // Se buscan los datos de la llamada seleccionada
        this.buscarDatosRespuestasDeCliente(); // Se buscan los datos de las respuestas del cliente
        this.buscarDatosEncuestaYPreguntas(); // Se buscan las preguntas y la encuesta de la llamada
        pantallaConsultarEncuesta.mostrarDatosLlamadaYEncuesta(this.nombreCliente, this.nombreEstadoActual, this.duracionLlamada,
                                                               this.descripcionEncuesta, this.descripcionRespuestasCliente,
                                                               this.descripcionPreguntasEncuesta);
        pantallaConsultarEncuesta.solicitarOpcionVisualizacionInforme();
    }

    // Obtención de los datos de la llamada seleccionada
    private void buscarDatosLlamadaSeleccionada() {
        this.nombreCliente = this.llamadaSeleccionada.getNombreClienteLlamada();
        this.nombreEstadoActual = this.llamadaSeleccionada.getNombreEstadoActual();
        this.duracionLlamada = this.llamadaSeleccionada.getDuracion();
    }

    // Obtención de la descripción de las respuestas seleccionadas por el cliente
    private void buscarDatosRespuestasDeCliente() {
        this.descripcionRespuestasCliente = llamadaSeleccionada.getDescripcionRespuestasDeCliente();
    }

    // Método para obtener la encuesta enviada al cliente y la descripción de esa encuesta con sus preguntas
    private void buscarDatosEncuestaYPreguntas() {
        for (Encuesta encuesta: encuestas) { // Se iteran las encuestas
            if (encuesta.esEncuestaDeCliente(llamadaSeleccionada)) { // Se comprueba que una encuesta sea la encuesta de la llamada
                this.encuestaEnviada = encuesta;
                // Se obtienen los datos de la encuesta
                this.descripcionEncuesta = this.encuestaEnviada.getDescripcionEncuesta();
                this.descripcionPreguntasEncuesta = this.encuestaEnviada.armarEncuesta();
                break;
            }
        }
    }

    // Método para tomar la selección de opción del informe
    public void tomarOpcionSeleccionada(String opcionSeleccionada) {
        this.opcionGeneracionInformeSeleccionada = opcionSeleccionada;

        // Se comprueba que la opción seleccionada sea la del CSV
        if (Objects.equals(this.opcionGeneracionInformeSeleccionada, "CSV")) {
            this.generarArchivoCSV();
        } else if (Objects.equals(this.opcionGeneracionInformeSeleccionada, "Imprimir")) {
            System.out.println("Imprimiendo... \nNo apague ni desconecte el equipo");
        }
    }

    // Método para generar el archivo CSV
    private void generarArchivoCSV() {
        interfazCSV.crearArchivoCSV(this.nombreCliente, String.valueOf(this.duracionLlamada), this.nombreEstadoActual, // Se llama al método definido en la Interfaz CSV
                                    this.descripcionPreguntasEncuesta, this.descripcionRespuestasCliente);
    }

    // Método para finalizar el CU
    public void finCU() {
        System.exit(0);
    }
}