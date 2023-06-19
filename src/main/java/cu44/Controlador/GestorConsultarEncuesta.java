package cu44.Controlador;
import cu44.Modelo.Encuesta;
import cu44.Modelo.Llamada;
import cu44.Interfaz.PantallaConsultarEncuesta;

import java.time.LocalDateTime;
import java.util.List;

public class GestorConsultarEncuesta {
    // atributos por valor del gestor
    private LocalDateTime fechaInicioPeriodoAConsultar;
    private LocalDateTime fechaFinPeriodoAConsultar;
    private String nombreCliente, nombreEstadoActual, descripcionEncuesta, opcionGeneracionInformeSeleccionada;
    private int duracionLlamada;
    private List<String> descripcionRespuestasCliente, descripcionPreguntasEncuesta, opcionesGeneracionInforme;

    // atributos por referencia del gestor
    private PantallaConsultarEncuesta pantallaConsultarEncuesta;
    private Llamada llamadaSeleccionada;
    private List<Llamada> llamadasConEncuestaEnPeriodo;
    private Encuesta encuestaEnviada;

    // constructor del gestor
    public GestorConsultarEncuesta(PantallaConsultarEncuesta pantallaConsultarEncuesta) {
        this.pantallaConsultarEncuesta = pantallaConsultarEncuesta;
    }

    // método para iniciar el caso de uso
    public void nuevaConsultaEncuesta() {
        this.consultarPeriodoEncuestas();
    }

    // método para solicitar el periodo de la consulta de encuesta (fecha desde y fecha hasta)
    public void consultarPeriodoEncuestas() {
        pantallaConsultarEncuesta.solicitarPeriodoConsulta();
    }

    // método para obtener el periodo seleccionado de la encuesta
    public void tomarPeriodoSeleccionado(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        this.fechaInicioPeriodoAConsultar = fechaDesde;
        this.fechaFinPeriodoAConsultar = fechaHasta;
    }

    // método para validar el periodo ingresado (se valida que la fecha desde sea menor a la fecha hasta)
    public boolean validarPeriodoIngresado() {
        return this.fechaInicioPeriodoAConsultar.isBefore(this.fechaFinPeriodoAConsultar);
    }

    // método para buscar las llamadas con encuesta respondida en el periodo
    public void buscarLlamadaConEncuestaEnPeriodo() {
    }

    // método para obtener la llamada seleccionada
    public void tomarSeleccionLlamada (Llamada llamadaSeleccionada) {
        this.llamadaSeleccionada = llamadaSeleccionada;
    }

    // método para obtener los datos de la llamada seleccionada
    public void buscarDatosLlamadaSeleccionada() {
        this.nombreCliente = this.llamadaSeleccionada.getNombreClienteLlamada();
        this.nombreEstadoActual = this.llamadaSeleccionada.getNombreEstadoActual();
        this.duracionLlamada = this.llamadaSeleccionada.getDuracion();
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
