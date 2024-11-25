package mundo;

import java.io.Serializable;

public class Cancion implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int duracionMinutos;
    private int duracionSegundos;
    private String genero;

    public Cancion(String nombre, int duracionMinutos, int duracionSegundos, String genero) {
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
        this.duracionSegundos = duracionSegundos;
        this.genero = genero;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }

    public int getDuracionSegundos() { return duracionSegundos; }
    public void setDuracionSegundos(int duracionSegundos) { this.duracionSegundos = duracionSegundos; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
}
