package mundo;

import java.io.*;
import java.util.ArrayList;

public class DiscotiendaArchivoTexto {

    private static final String ARCHIVO_TEXTO = "discotienda.txt";

    // Guardar Discotienda en un archivo de texto
    public static void guardarEnArchivoTexto(Discotienda discotienda) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TEXTO))) {
            for (Disco disco : discotienda.getDiscos()) {
                bw.write(disco.getNombre() + ";" + disco.getArtista() + ";" + disco.getAnio());
                bw.newLine();
                for (Cancion cancion : disco.getCanciones()) {
                    bw.write("-" + cancion.getNombre() + ";" + cancion.getDuracionMinutos() + ";" 
                             + cancion.getDuracionSegundos() + ";" + cancion.getGenero());
                    bw.newLine();
                }
            }
            System.out.println("Discotienda guardada correctamente en " + ARCHIVO_TEXTO);
        }
    }

    // Cargar Discotienda desde un archivo de texto
    public static Discotienda cargarDesdeArchivoTexto() throws IOException {
        File archivo = new File(ARCHIVO_TEXTO);
        if (!archivo.exists()) {
            System.out.println("No existe un archivo de texto de discotienda, se devolverá una nueva instancia.");
            return new Discotienda();
        }

        Discotienda discotienda = new Discotienda();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_TEXTO))) {
            Disco discoActual = null;
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith("-")) {
                    // Nueva entrada de disco
                    String[] partes = linea.split(";");
                    discoActual = new Disco(partes[0], partes[1], Integer.parseInt(partes[2]));
                    discotienda.getDiscos().add(discoActual);
                } else {
                    // Nueva entrada de canción
                    if (discoActual != null) {
                        String[] partes = linea.substring(1).split(";");
                        Cancion cancion = new Cancion(partes[0], Integer.parseInt(partes[1]), 
                                                      Integer.parseInt(partes[2]), partes[3]);
                        discoActual.getCanciones().add(cancion);
                    }
                }
            }
        }

        System.out.println("Discotienda cargada correctamente desde " + ARCHIVO_TEXTO);
        return discotienda;
    }
}
