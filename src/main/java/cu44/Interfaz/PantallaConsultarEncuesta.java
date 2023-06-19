package cu44.Interfaz;
import cu44.Controlador.GestorConsultarEncuesta;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

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

    // constructor de la pantalla
    public PantallaConsultarEncuesta() {
        gestorConsultarEncuesta = new GestorConsultarEncuesta(this);
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
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel dtm = (DefaultTableModel) tablaLlamadas.getModel();
        dtm.addColumn("ID Llamada");
        dtm.addColumn("Descripción Operador");

        dtm.addRow(new Object[]{"A", "B"});
        dtm.addRow(new Object[]{"A", "B"});
        dtm.addRow(new Object[]{"A", "B"});
        dtm.addRow(new Object[]{"A", "B"});
        dtm.addRow(new Object[]{"A", "B"});

    }

    // método que capta las acciones de los botones. Es inherente a ActionListener
    @Override
    public void actionPerformed(ActionEvent evt){
    }
}
