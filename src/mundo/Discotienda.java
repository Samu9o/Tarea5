package mundo;

import java.io.Serializable;
import java.util.ArrayList;

public class Discotienda implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Disco> discos;

    public Discotienda() {
        discos = new ArrayList<>();
    }

    public ArrayList<Disco> getDiscos() { return discos; }
    public void setDiscos(ArrayList<Disco> discos) { this.discos = discos; }
}
