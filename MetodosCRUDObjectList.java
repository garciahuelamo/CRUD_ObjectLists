import java.util.ArrayList;
import java.util.InputMismatchException;

public class MetodosCRUDObjectList {

    /**
     * Method for adding names, codes and prices of videogames.
     *   Use toString() method to see the overview of videogames.
     * @author Angela_Garcia
     * @param lista is a video-game arraylist.
     */

    public static void addVideojuego(ArrayList<Videojuegos> lista){

        String nombre;
        int codigo;
        double precio;
        int respuestaUsuario;

        try{
            respuestaUsuario = Utilidades.pedirInt("Introduzca el número de videojuegos que desea ingresar:");

            for(int i=0; i<respuestaUsuario; i++){
                nombre = Utilidades.pedirString("Nombre: " + i);
                codigo = Utilidades.pedirInt("Codigo: " + i);
                precio = Utilidades.pedirDouble("Precio: " + i);

                Videojuegos objeto = new Videojuegos(nombre,codigo,precio);
                lista.add(objeto);
            }

            System.out.println("Los videojuegos almacenados son los siguientes: ");
            System.out.println(lista.toString());
        } catch (InputMismatchException e){
            System.out.println("ERROR --- se debe indicar un NÚMERO, letras/caracteres especiales no.");
            outMenu();
        } catch (Exception e){
            System.out.println("ERROR --- desconocido.");
            outMenu();
        }
    }

    /**
     * Method for searching names, codes and prices of videogames.
     *   Use toString() method to see the overview of videogames.
     *   Use isEmpty() method to know if the Arraylist has any videogame.
     * @author Angela_Garcia
     * @param lista is a video-game arraylist.
     */

    public static boolean searchVideojuego(ArrayList<Videojuegos> lista){

        /*If the arraylist has objects stored in it, we'll search by name, code or price.
          If the arraylist is empty it will be redirected back to the addVideojuego method.*/

        boolean encontrado;
        String respuestaNombre;
        int respuestaUsuario;
        int respuestaCodigo;
        double respuestaPrecio;

        encontrado = false;

        try {
            if (lista.isEmpty()) {
                System.out.println("Introduzca primero datos: ");
                addVideojuego(lista);
            }

            respuestaUsuario = Utilidades.pedirInt("Buscar por: 1. NOMBRE, 2. CODIGO, 3. PRECIO");
            if (respuestaUsuario < 1 || respuestaUsuario > 3) {
                do {
                    respuestaUsuario = Utilidades.pedirInt("Numero incorrecto. Vuelva a elegir otra opcion:");
                } while (respuestaUsuario < 1 || respuestaUsuario > 3);
            } else {
                switch (respuestaUsuario) {
                    case 1:
                        respuestaNombre = Utilidades.pedirString("Introduzca el nombre a buscar: ");
                        for (Videojuegos objeto : lista) {
                            if (objeto.getNombre().equals(respuestaNombre)) {
                                encontrado = true;
                                System.out.println("Nombre buscado...ENCONTRADO");
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Nombre buscado...INCORRECTO");
                        }
                        break;
                    case 2:
                        respuestaCodigo = Utilidades.pedirInt("Introduzca el codigo a buscar: ");
                        for (Videojuegos objeto : lista) {
                            if (objeto.getCodigo() == respuestaCodigo) {
                                encontrado = true;
                                System.out.println("Codigo buscado...ENCONTRADO");
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Codigo buscado...INCORRECTO");
                        }
                        break;
                    case 3:
                        respuestaPrecio = Utilidades.pedirDouble("Introduzca el precio a buscar: ");
                        for (Videojuegos objeto : lista) {
                            if (objeto.getPrecio() == respuestaPrecio) {
                                encontrado = true;
                                System.out.println("Precio buscado...ENCONTRADO");
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Precio buscado...INCORRECTO");
                        }
                        break;
                }
            }
        } catch (InputMismatchException e){
            System.out.println("ERROR --- se debe indicar un NÚMERO, letras/caracteres especiales no.");
            outMenu();
        } catch (Exception e){
            System.out.println("ERROR --- desconocido.");
            outMenu();
        }

        return encontrado;
    }

    /**
     * Method for searching names, codes and prices of videogames.
     *   Use toString() method to see the overview of videogames.
     *   Use isEmpty() method to know if the Arraylist has any videogame.
     * @author Angela_Garcia
     * @param lista is a video-game arraylist.
     */

    public static boolean updateVideojuego(ArrayList<Videojuegos> lista){

        /*If the arraylist has objects stored in it, we'll update by name, code or price.
          If the arraylist is empty it will be redirected back to the addVideojuego method.*/

        boolean encontrado;
        String respuestaNombre;
        int respuestaUsuario;
        int respuestaCodigo;
        double respuestaPrecio;

        encontrado = false;

        try {
            if(lista.isEmpty()){
                System.out.println("Introduzca primero datos:");
                addVideojuego(lista);
            }
            respuestaUsuario = Utilidades.pedirInt("Modificar por: 1. NOMBRE, 2. CODIGO, 3. PRECIO");
            if (respuestaUsuario<1 || respuestaUsuario>3){
                do {
                    respuestaUsuario = Utilidades.pedirInt("Numero incorrecto. Vuelva a elegir otra opcion:");
                } while (respuestaUsuario<1 || respuestaUsuario>3);
            } else {
                switch (respuestaUsuario){
                    case 1:
                        respuestaNombre = Utilidades.pedirString("Introduzca el nombre a modificar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getNombre().equals(respuestaNombre)){
                                encontrado = true;
                                System.out.println("Nombre buscado...ENCONTRADO");
                                respuestaNombre = Utilidades.pedirString("Introduzca el nuevo nombre:");
                                objeto.setNombre(respuestaNombre);
                                System.out.println("Nombre modificado a: " + objeto.getNombre());
                            }
                        }

                        System.out.println(lista.toString());

                        if (!encontrado){
                            System.out.println("Nombre buscado...INCORRECTO");
                        }
                        break;
                    case 2:
                        respuestaCodigo = Utilidades.pedirInt("Introduzca el codigo a buscar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getCodigo() == respuestaCodigo){
                                encontrado = true;
                                System.out.println("Codigo buscado...ENCONTRADO");
                                respuestaCodigo = Utilidades.pedirInt("Introduzca el nuevo codigo:");
                                objeto.setCodigo(respuestaCodigo);
                                System.out.println("Codigo modificado a: " + objeto.getCodigo());
                            }
                        }

                        System.out.println(lista.toString());

                        if (!encontrado){
                            System.out.println("Codigo buscado...INCORRECTO");
                        }
                        break;
                    case 3:
                        respuestaPrecio = Utilidades.pedirDouble("Introduzca el precio a buscar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getPrecio() == respuestaPrecio){
                                encontrado = true;
                                System.out.println("Precio buscado...ENCONTRADO");
                                respuestaPrecio = Utilidades.pedirDouble("Introduzca el nuevo precio:");
                                objeto.setPrecio(respuestaPrecio);
                                System.out.println("Precio modificado a: " + objeto.getPrecio());
                            }
                        }

                        System.out.println(lista.toString());

                        if (!encontrado){
                            System.out.println("Precio buscado...INCORRECTO");
                        }
                        break;
                }
            }
        } catch (InputMismatchException e){
            System.out.println("ERROR --- se debe indicar un NÚMERO, letras/caracteres especiales no.");
            outMenu();
        } catch (Exception e){
            System.out.println("ERROR --- desconocido.");
            outMenu();
        }

        return encontrado;
    }

    /**
     * Method for searching names, codes and prices of videogames.
     *   Use toString() method to see the overview of videogames.
     *   Use isEmpty() method to know if the Arraylist has any videogame.
     *   Use remove() method to delete any videogame.
     * @author Angela_Garcia
     * @param lista is a video-game arraylist.
     */

    public static boolean deleteVideojuego(ArrayList<Videojuegos> lista){

        /*If the arraylist has objects stored in it, we'll delete by name, code or price.
          If the arraylist is empty it will be redirected back to the addVideojuego method.*/

        boolean encontrado;
        int respuestaUsuario;
        String respuestaNombre;
        int respuestaCodigo;
        double respuestaPrecio;

        encontrado = false;

        try {
            if(lista.isEmpty()){
                System.out.println("Introduzca primero datos:");
                addVideojuego(lista);
            }
            respuestaUsuario = Utilidades.pedirInt("Eliminar por: (1) NOMBRE, (2) CODIGO, (3) PRECIO: ");
            switch (respuestaUsuario){
                case 1:
                    respuestaNombre = Utilidades.pedirString("Buscar por nombre del videojuego: ");
                    for (Videojuegos v1 : lista){
                        if (v1.getNombre().equals(respuestaNombre)){
                            lista.remove(v1);
                            System.out.println("Videojuego buscado...ELIMINADO");
                            respuestaUsuario = Utilidades.pedirInt("(1) Añadir nuevo videojuego,  (2) Seguir: ");
                            if(respuestaUsuario == 1){
                                addVideojuego(lista);
                            } else {
                                System.out.println(lista.toString());
                            }
                        }
                    }
                    break;
                case 2:
                    respuestaCodigo = Utilidades.pedirInt("Buscar por códgo del videojuego: ");
                    for (Videojuegos v1 : lista){
                        if (v1.getCodigo() == respuestaCodigo){
                            lista.remove(v1);
                            System.out.println("Videojuego buscado...ELIMINADO");
                            respuestaUsuario = Utilidades.pedirInt("(1) Añadir nuevo videojuego,  (2) Seguir: ");
                            if(respuestaUsuario == 1){
                                addVideojuego(lista);
                            } else {
                                System.out.println(lista.toString());
                            }
                        }
                    }
                    break;
                case 3:
                    respuestaPrecio = Utilidades.pedirDouble("Buscar por precio del videojuego: ");
                    for (Videojuegos v1 : lista){
                        if (v1.getPrecio() == respuestaPrecio){
                            lista.remove(v1);
                            System.out.println("Videojuego buscado...ELIMINADO");
                            respuestaUsuario = Utilidades.pedirInt("(1) Añadir nuevo videojuego,  (2) Seguir: ");
                            if(respuestaUsuario == 1){
                                addVideojuego(lista);
                            } else {
                                System.out.println(lista.toString());
                            }
                        }
                    }
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("ERROR --- se debe indicar un NÚMERO, letras/caracteres especiales no.");
            outMenu();
        } catch (Exception e){
            System.out.println("ERROR --- desconocido.");
            outMenu();
        }

        return encontrado;
    }

    /**
     * Method to exit of the program.
     * @author Angela_Garcia
     */
    public static void outMenu(){

        System.out.println("PROGRAMA FINALIZADO.");

    }

    /**
     * Method to show-menu.
     * @author Angela_Garcia
     */
    public static void showMenu(){
        System.out.println("1. Insertar");
        System.out.println("2. Buscar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Salir del programa");
    }

    /**
     * Method to choose the option.
     * @author Angela_Garcia
     */
    public static int optionMenu(){

        int respuesta;

        do{
            respuesta = Utilidades.pedirInt("Elija el numero de la opción a llevar a cabo:");
        } while (respuesta<1 || respuesta>5);

        return respuesta;
    }
}
