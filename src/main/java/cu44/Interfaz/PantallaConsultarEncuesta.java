package cu44.Interfaz;

import cu44.Controlador.GestorConsultarEncuesta;
import cu44.Modelo.Llamada;

import org.hibernate.Session;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PantallaConsultarEncuesta extends JFrame implements ActionListener {

    // Atributos por valor de PantallaConsultarEncuesta
    private JLabel labelFechaDesde;
    private JLabel labelFechaHasta;
    private JLabel labelNombreCliente;
    private JLabel labelEstadoActual;
    private JLabel labelDuracionLlamada;
    private JLabel labelDescripcionEncuesta;

    private JPanel JPanel;

    private JScrollPane jScrollLlamadas;
    private JScrollPane jScrollPreguntas;

    private JXDatePicker dateFechaDesde;
    private JXDatePicker dateFechaHasta;

    private JTable tablaLlamadas;
    private JTable tablaPreguntasRespuestas;

    private JTextField txtEstadoActual;
    private JTextField txtDescripcionEncuesta;
    private JTextField txtNombreCliente;
    private JTextField txtDuracionLlamada;

    private JButton btnGenerarCSV;
    private JButton btnImprimir;

    // Atributos por referencia de PantallaConsultarEncuesta
    private GestorConsultarEncuesta gestorConsultarEncuesta;
    private ArrayList<Llamada> llamadasConEncuestaEnPeriodo;

    // Constructor
    public PantallaConsultarEncuesta(Session sesion) {
        gestorConsultarEncuesta = new GestorConsultarEncuesta(this, sesion); // Se asigna el gestor

        // Configuración de la Tabla de Llamadas
        jScrollLlamadas.setPreferredSize(new Dimension(400, 120));
        DefaultTableModel dtm = (DefaultTableModel) tablaLlamadas.getModel();
        dtm.addColumn("ID Llamada");
        dtm.addColumn("Descripción del Operador");

        // Configuración de la Tabla de Preguntas y Respuestas
        jScrollPreguntas.setPreferredSize(new Dimension(400, 200));
        DefaultTableModel dtm2 = (DefaultTableModel) tablaPreguntasRespuestas.getModel();
        dtm2.addColumn("Pregunta");
        dtm2.addColumn("Respuesta de Cliente");

        // ActionListener del JXDatePicker de la fecha desde
        dateFechaDesde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarSeleccionFechaInicio();
            }
        });

        // ActionListener del JXDatePicker de la fecha hasta
        dateFechaHasta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tomarSeleccionFechaFin();
            }
        });

        // ActionListener de la llamada seleccionada
        tablaLlamadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tomarSeleccionLlamada();
            }
        });
    }

    // Inicio del Caso de Uso
    public void opcionConsultarEncuesta() {
        this.habilitarVentana();
        gestorConsultarEncuesta.nuevaConsultaEncuesta();
    }

    // Habilitación de la pantalla (creación del JFrame con los elementos)
    public void habilitarVentana() {
        JFrame frame = new JFrame("Consultar Encuesta - PPAI Grupo 1");
        frame.setContentPane(JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Solicitud del periodo de la consulta. Se hacen visibles los JXDatePicker
    public void solicitarPeriodoConsulta() {
        dateFechaDesde.setVisible(true);
        dateFechaHasta.setVisible(true);
    }

    // Método para tomar la selección de la fecha desde
    public void tomarSeleccionFechaInicio() {
        gestorConsultarEncuesta.tomarPeriodoSeleccionado(dateFechaDesde.getDate(), dateFechaHasta.getDate());
    }

    // Método para tomar la selección de la fecha hasta
    public void tomarSeleccionFechaFin() {
        gestorConsultarEncuesta.tomarPeriodoSeleccionado(dateFechaDesde.getDate(), dateFechaHasta.getDate());
    }

    // Método para mostrar las llamadas en la Tabla de llamadas
    public void mostrarLlamadasConEncuestaEnPeriodo(ArrayList<Llamada> llamadasConEncuestaEnPeriodo) {
        this.llamadasConEncuestaEnPeriodo = llamadasConEncuestaEnPeriodo;
        DefaultTableModel dtm = (DefaultTableModel) tablaLlamadas.getModel();
        dtm.setRowCount(0);

        for (Llamada llamada: llamadasConEncuestaEnPeriodo) {
            dtm.addRow(new Object[] {llamada.getId(), llamada.getDescripcionOperador()});
        }
    }

    // Método para tomar la selección de la llamada
    public void tomarSeleccionLlamada() {
        gestorConsultarEncuesta.tomarLlamadaSeleccionada(llamadasConEncuestaEnPeriodo.get(tablaLlamadas.getSelectedRow()));
    }

    // Método para mostrar los datos obtenidos de la llamada, la encuesta y sus preguntas con sus respuestas
    public void mostrarDatosObtenidos(String nombreCliente, String nombreEstado, int duracion) {
        txtNombreCliente.setText(nombreCliente);
        txtEstadoActual.setText(nombreEstado);
        txtDuracionLlamada.setText(String.valueOf(duracion) + " min");
    }

    // Método para captar la funcionalidad de los botones. Inherente a ActionListener
    @Override
    public void actionPerformed(ActionEvent evt){
    }
}