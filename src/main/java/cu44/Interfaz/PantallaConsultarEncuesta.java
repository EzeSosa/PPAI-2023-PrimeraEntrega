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

    private GestorConsultarEncuesta gestorConsultarEncuesta;
    private JLabel labelFechaDesde, labelFechaHasta;
    private JPanel JPanel;
    private JXDatePicker dateFechaDesde;
    private JXDatePicker dateFechaHasta;
    private JTable tablaLlamadas;
    private JLabel labelNombreCliente;
    private JTable tablaPreguntasRespuestas;
    private JButton btnGenerarCSV;
    private JButton btnFinCU;
    private JTextField txtEstadoActual;
    private JTextField txtDescripcionEncuesta;
    private JTextField txtNombreCliente;
    private JTextField txtDuracionLlamada;
    private JLabel labelEstadoActual;
    private JLabel labelDuracionLlamada;
    private JLabel labelDescripcionEncuesta;
    private JScrollPane jScrollLlamadas;
    private JScrollPane jScrollPreguntas;
    private JButton btnImprimir;
    private ArrayList<Llamada> llamadasConEncuestaEnPeriodo;

    // constructor de la pantalla
    public PantallaConsultarEncuesta(Session sesion) {
        gestorConsultarEncuesta = new GestorConsultarEncuesta(this, sesion);

        // Columnas de la Tabla de Llamadas
        jScrollLlamadas.setPreferredSize(new Dimension(400, 120));
        DefaultTableModel dtm = (DefaultTableModel) tablaLlamadas.getModel();
        dtm.addColumn("ID Llamada");
        dtm.addColumn("Nombre de Cliente");

        // Columnas de la Tabla de Encuestas
        jScrollPreguntas.setPreferredSize(new Dimension(400, 300));
        DefaultTableModel dtm2 = (DefaultTableModel) tablaPreguntasRespuestas.getModel();
        dtm2.addColumn("Pregunta");
        dtm2.addColumn("Respuesta de Cliente");
        dateFechaDesde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorConsultarEncuesta.tomarPeriodoSeleccionado(dateFechaDesde.getDate(), dateFechaHasta.getDate());
            }
        });
        dateFechaHasta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorConsultarEncuesta.tomarPeriodoSeleccionado(dateFechaDesde.getDate(), dateFechaHasta.getDate());
            }
        });
        tablaLlamadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tomarSeleccionLlamada(tablaLlamadas.getSelectedRow());
            }
        });
    }

    // método que inicia el caso de uso
    public void opcionConsultarEncuesta() {
        this.habilitarVentana();
        gestorConsultarEncuesta.nuevaConsultaEncuesta();
    }

    // método para solicitar los periodos de la consulta
    public void solicitarPeriodoConsulta() {
    }

    // método para habilitar la ventana de la consulta (se crea el JFrame)
    public void habilitarVentana() {
        JFrame frame = new JFrame("Consultar Encuesta - PPAI Grupo 1");
        frame.setContentPane(JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Método para mostrar las llamadas en la Tabla de llamadas
    public void mostrarLlamadasConEncuestaEnPeriodo(ArrayList<Llamada> llamadasConEncuestaEnPeriodo) {
        this.llamadasConEncuestaEnPeriodo = llamadasConEncuestaEnPeriodo;
        DefaultTableModel dtm = (DefaultTableModel) tablaLlamadas.getModel();
        dtm.setRowCount(0);

        for (Llamada llamada: llamadasConEncuestaEnPeriodo) {
            dtm.addRow(new Object[] {llamada.getId(), llamada.getNombreClienteLlamada()});
        }
    }

    public void tomarSeleccionLlamada(int indiceLlamada) {
        gestorConsultarEncuesta.tomarSeleccionLlamada(llamadasConEncuestaEnPeriodo.get(indiceLlamada));
    }

    public void mostrarDatosObtenidos(String nombreCliente, String nombreEstado, int duracion) {
        txtNombreCliente.setText(nombreCliente);
        txtEstadoActual.setText(nombreEstado);
        txtDuracionLlamada.setText(String.valueOf(duracion) + " min");
    }

    // método que capta las acciones de los botones. Es inherente a ActionListener
    @Override
    public void actionPerformed(ActionEvent evt){
    }
}
