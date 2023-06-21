package cu44.Interfaz;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InterfazCSV {
    private String nombreArchivo;

    public void crearArchivoCSV(String nombreCliente, String duracion, String estadoActual, ArrayList<String> preguntas, ArrayList<String> respuestasDeCliente) {
        nombreArchivo = "datos.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Encabezado de los datos de la llamada
            writer.write("Nombre del Cliente,Duracion,Estado Actual");

            writer.newLine();
            writer.write(nombreCliente + "," + duracion + "," + estadoActual); // Se cargan los datos de la llamada
            writer.newLine();

            // Encabezado de las preguntas y las respuestas
            writer.write("Pregunta,Respuesta de Cliente");

            writer.newLine();
            for (int i = 0; i < preguntas.size(); i++) {
                writer.write (preguntas.get(i) + "," + respuestasDeCliente.get(i)); // Se carga cada pregunta con su respuesta
                writer.newLine();
            }

            // Abriendo el archivo automáticamente
            File csvFile = new File(nombreArchivo);
            if (csvFile.exists() && csvFile.isFile()) {
                Desktop.getDesktop().open(csvFile);
            }

        } catch (IOException e) {
            System.out.println("ERROR" + e.getMessage());
        }
    }
}