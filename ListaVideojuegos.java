import java.util.ArrayList;

public class ListaVideojuegos {

    private int idVideojuego;
    ArrayList<Videojuegos> listaVideojuegos = new ArrayList<Videojuegos>();

    public ListaVideojuegos(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public int getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public ArrayList<Videojuegos> getListaVideojuegos() {
        return listaVideojuegos;
    }

    public void setLista(ArrayList<Videojuegos> listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;
    }

    @Override
    public String toString() {
        return "ListaVideojuegos{" +
                "idVideojuego=" + idVideojuego +
                ", lista=" + listaVideojuegos +
                '}';
    }

}
