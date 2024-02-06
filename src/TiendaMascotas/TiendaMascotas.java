package TiendaMascotas;

import java.util.Scanner;

public class TiendaMascotas {
    Mascota[] inventario;
    int cantidadMascotas;

    //inventario
    public TiendaMascotas() {

        inventario = new Mascota[100];
        cantidadMascotas = 0;
    }

    public Object[] getInventario() {
        return inventario;
    }

    public void AgregarMascota() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de la mascota: ");
        String nombreMascota = sc.nextLine();


        Scanner scDos = new Scanner(System.in);
        System.out.println("Introduce su edad: ");
        int edadMascota = scDos.nextInt();


        Scanner scTres = new Scanner(System.in);
        System.out.println("Introduce el tipo de mascota: ");
        String tipoMascota = scTres.nextLine();

        // creamos el objeto nuevo mascota
        inventario[cantidadMascotas] = new Mascota(nombreMascota, edadMascota, tipoMascota);
        cantidadMascotas++;
        {
            System.out.println("Agregaste a " + nombreMascota + " al sistema");

        }
    }

    public void venderMascota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué mascota vas a vender?");
        String vendeMascota = sc.nextLine();

        for (int i = 0; i < cantidadMascotas; i++) {
            System.out.println(inventario[i].getNombre());
        }

        for (int i = 0; i < cantidadMascotas; i++) {
            if (inventario[i].getNombre() == vendeMascota) {
                inventario[i] = null;
                System.out.println("Se eliminó a " + inventario[i].getNombre() + " del inventario");
                for (int j = i; j < cantidadMascotas; j++) {
                    inventario[j] = inventario[j + 1];
                }
            }
            cantidadMascotas--;
            return;
        }
    }


    public void mostarInventario() {
        for (int j = 0; j < cantidadMascotas; j++) {
            System.out.println("Quedan " + cantidadMascotas + " mascotas");
            System.out.println("Nombre: " + inventario[j].getNombre());
            System.out.println("Edad: " + inventario[j].getEdad());
            System.out.println("Tipo " + inventario[j].getTipo());

            if (cantidadMascotas == 0) {
                System.out.println("No quedan mascotas");
            }
        }
    }
    public static void main (String[]args){
        TiendaMascotas tiendaMascotas = new TiendaMascotas();
        int salir = 2;
        while (salir > 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca una opción: \n1: Agregar Mascota \n2: Vender una Mascota \n3: Comprobar inventario");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    tiendaMascotas.AgregarMascota();
                    break;
                case 2:
                    tiendaMascotas.venderMascota();
                    break;
                case 3:
                    tiendaMascotas.mostarInventario();
                    break;
            }
            Scanner scBucle = new Scanner(System.in);
            System.out.println("¿Quieres seguir editando? \n Introduzca 1 para salir \n introduzca 2 para continuar.");
            salir = scBucle.nextInt();
        }
    }
}







