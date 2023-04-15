import java.util.ArrayList;
import java.util.InputMismatchException;

public class Controlador {

    public static void main(String[] args) {

        int respuesta;
        ArrayList<Videojuegos> lista = new ArrayList<Videojuegos>();

        try {
            do{
                MetodosCRUDObjectList.showMenu();
                respuesta = MetodosCRUDObjectList.optionMenu();
                switch (respuesta){
                    case 1:
                        MetodosCRUDObjectList.addVideojuego(lista);
                        break;
                    case 2:
                        MetodosCRUDObjectList.searchVideojuego(lista);
                        break;
                    case 3:
                        MetodosCRUDObjectList.updateVideojuego(lista);
                        break;
                    case 4:
                        MetodosCRUDObjectList.deleteVideojuego(lista);
                        break;
                    case 5:
                        MetodosCRUDObjectList.outMenu();
                }
            } while (respuesta!=5);

        } catch (InputMismatchException e){
            System.out.println("ERROR --- se debe indicar un NÚMERO, letras/caracteres especiales no.");
            MetodosCRUDObjectList.outMenu();
        } catch (Exception e){
            System.out.println("ERROR --- desconocido.");
            MetodosCRUDObjectList.outMenu();
        }
    }
}


