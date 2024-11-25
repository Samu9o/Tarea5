package mundo;

import java.io.*;

public class DiscoTiendaPersistencia {

    private static final String ARCHIVO_BINARIO = "discotienda.dat";

    // Guardar el objeto Discotienda en un archivo binario
    public static void guardarDiscotienda(Discotienda discotienda) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_BINARIO))) {
            oos.writeObject(discotienda);
            System.out.println("Discotienda guardada correctamente en " + ARCHIVO_BINARIO);
        }
    }

    // Cargar el objeto Discotienda desde un archivo binario
    public static Discotienda cargarDiscotienda() throws IOException, ClassNotFoundException {
        File archivo = new File(ARCHIVO_BINARIO);
        if (!archivo.exists()) {
            System.out.println("No existe un archivo de discotienda, se devolverá una nueva instancia.");
            return new Discotienda();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_BINARIO))) {
            System.out.println("Discotienda cargada correctamente desde " + ARCHIVO_BINARIO);
            return (Discotienda) ois.readObject();
        }
    }
}
