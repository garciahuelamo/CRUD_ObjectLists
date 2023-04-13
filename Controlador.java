import java.util.ArrayList;

//230413 - metodos crear, modificar y buscar - HECHOS

public class Controlador {

    public static void main(String[] args) {

        int respuesta;
        String nombre;
        int codigo;
        double precio;
        ArrayList<Videojuegos> lista = new ArrayList<Videojuegos>();

        showMenu();

        try {
                respuesta = optionMenu();

                if(respuesta!=1){
                    do {
                        respuesta = Utilidades.pedirInt("ERROR. Debe añadir videojuegos primero:");
                    } while (respuesta!=1);
                }

            addVideojuego(lista);
                do{
                    respuesta = Utilidades.pedirInt("¿Quiere seguir? (1) SI / (2) NO");
                    if (respuesta == 1){
                        do{
                            respuesta = Utilidades.mostrarSubmenu("Introduzca el numero de la opcion:");
                            switch (respuesta){
                                case 2:
                                    searchVideojuego(lista);
                                    break;
                                case 3:
                                    //Método modificar
                                    updateVideojuego(lista);
                                    System.out.println(lista.toString());
                                    break;
                                case 4:
                                    //Método eliminar
                                    deleteVideojuego(lista);
                                    System.out.println(lista.toString());
                                    break;
                                case 5:
                                    //Método salir
                                    outMenu();
                            }
                        } while (respuesta!=5);
                    }
                } while (respuesta!=2);

                outMenu();

        } catch (Exception e){

        }

    }

    public static int optionMenu(){

        int respuesta;
        respuesta = Utilidades.pedirInt("Elija el numero de la opción a llevar a cabo:");

        return respuesta;
    }

    public static void showMenu(){
        System.out.println("1. Insertar");
        System.out.println("2. Buscar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Salir del programa");
    }

    public static void addVideojuego(ArrayList<Videojuegos> lista){

        String nombre;
        int codigo;
        double precio;
        int respuestaUsuario;

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
    }

    public static boolean searchVideojuego(ArrayList<Videojuegos> lista){

        boolean encontrado;
        String respuestaNombre;
        int respuestaUsuario;
        int respuestaCodigo;
        double respuestaPrecio;

        encontrado = false;

        try {
            respuestaUsuario = Utilidades.pedirInt("Buscar por: 1. NOMBRE, 2. CODIGO, 3. PRECIO");
            if (respuestaUsuario<1 || respuestaUsuario>3){
                do {
                    respuestaUsuario = Utilidades.pedirInt("Numero incorrecto. Vuelva a elegir otra opcion:");
                } while (respuestaUsuario<1 || respuestaUsuario>3);
            } else {
                switch (respuestaUsuario){
                    case 1:
                        //Buscar por nombre:
                        respuestaNombre = Utilidades.pedirString("Introduzca el nombre a buscar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getNombre().equals(respuestaNombre)){
                                encontrado = true;
                                System.out.println("Nombre buscado...ENCONTRADO");
                            }
                        }

                        if (!encontrado){
                            System.out.println("Nombre buscado...INCORRECTO");
                        }
                        break;
                    case 2:
                        //Buscar por codigo:
                        respuestaCodigo = Utilidades.pedirInt("Introduzca el codigo a buscar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getCodigo() == respuestaCodigo){
                                encontrado = true;
                                System.out.println("Codigo buscado...ENCONTRADO");
                            }
                        }

                        if (!encontrado){
                            System.out.println("Codigo buscado...INCORRECTO");
                        }
                        break;
                    case 3:
                        //Buscar por precio:
                        respuestaPrecio = Utilidades.pedirDouble("Introduzca el precio a buscar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getPrecio() == respuestaPrecio){
                                encontrado = true;
                                System.out.println("Precio buscado...ENCONTRADO");
                            }
                        }

                        if (!encontrado){
                            System.out.println("Precio buscado...INCORRECTO");
                        }
                        break;
                }
            }
        } catch (Exception e){

        }

        return encontrado;
    }

    public static boolean updateVideojuego(ArrayList<Videojuegos> lista){

        boolean encontrado;
        String respuestaNombre;
        int respuestaUsuario;
        int respuestaCodigo;
        double respuestaPrecio;

        encontrado = false;

        try {
            respuestaUsuario = Utilidades.pedirInt("Modificar por: 1. NOMBRE, 2. CODIGO, 3. PRECIO");
            if (respuestaUsuario<1 || respuestaUsuario>3){
                do {
                    respuestaUsuario = Utilidades.pedirInt("Numero incorrecto. Vuelva a elegir otra opcion:");
                } while (respuestaUsuario<1 || respuestaUsuario>3);
            } else {
                switch (respuestaUsuario){
                    case 1:
                        //Modificar por nombre:
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

                        if (!encontrado){
                            System.out.println("Nombre buscado...INCORRECTO");
                        }
                        break;
                    case 2:
                        //Modificar por codigo:
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

                        if (!encontrado){
                            System.out.println("Codigo buscado...INCORRECTO");
                        }
                        break;
                    case 3:
                        //Buscar por precio:
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

                        if (!encontrado){
                            System.out.println("Precio buscado...INCORRECTO");
                        }
                        break;
                }
            }
        } catch (Exception e){

        }

        return encontrado;
    }

    public static boolean deleteVideojuego(ArrayList<Videojuegos> lista){

        boolean encontrado;
        String respuestaNombre;
        int respuestaUsuario;
        int respuestaCodigo;
        double respuestaPrecio;

        encontrado = false;

        try {
            respuestaUsuario = Utilidades.pedirInt("Eliminar por: 1. NOMBRE, 2. CODIGO, 3. PRECIO");
            if (respuestaUsuario<1 || respuestaUsuario>3){
                do {
                    respuestaUsuario = Utilidades.pedirInt("Numero incorrecto. Vuelva a elegir otra opcion:");
                } while (respuestaUsuario<1 || respuestaUsuario>3);
            } else {
                switch (respuestaUsuario){
                    case 1:
                        //Eliminar por nombre:
                        respuestaNombre = Utilidades.pedirString("Introduzca el nombre a eliminar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getNombre().equals(respuestaNombre)){
                                encontrado = true;
                                System.out.println("Nombre buscado...ENCONTRADO");
                                //PROBLEMA PARA ENLAZAR LA ELIMINACION DE LA VARIABLE!!!!!
                                objeto.getNombre().equals(respuestaNombre);
                                lista.remove(respuestaNombre);
                                respuestaUsuario = Utilidades.pedirInt("Nombre ELIMINADO...¿quiere añadir otro? (1) SI / (2) NO:");
                                if (respuestaUsuario == 1){
                                    for (Videojuegos objetoNew : lista){
                                        respuestaNombre = Utilidades.pedirString("Nuevo nombre: ");
                                        objetoNew.setNombre(respuestaNombre);
                                    }
                                }
                            }
                        }

                        if (!encontrado){
                            System.out.println("Nombre buscado...INCORRECTO");
                        }
                        break;
                    case 2:
                        //Modificar por codigo:
                        respuestaCodigo = Utilidades.pedirInt("Introduzca el codigo a eliminar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getCodigo() == respuestaCodigo){
                                encontrado = true;
                                System.out.println("Codigo buscado...ENCONTRADO");

                            }
                        }

                        if (!encontrado){
                            System.out.println("Codigo buscado...INCORRECTO");
                        }
                        break;
                    case 3:
                        //Buscar por precio:
                        respuestaPrecio = Utilidades.pedirDouble("Introduzca el precio a eliminar: ");
                        for (Videojuegos objeto : lista){
                            if (objeto.getPrecio() == respuestaPrecio){
                                encontrado = true;
                                System.out.println("Precio buscado...ENCONTRADO");
                                lista.remove(objeto.getPrecio());
                            }
                        }

                        if (!encontrado){
                            System.out.println("Precio buscado...INCORRECTO");
                        }
                        break;
                }
            }
        } catch (Exception e){

        }

        return encontrado;
    }

    private static void outMenu(){

        System.out.println("PROGRAMA FINALIZADO.");

    }
}


