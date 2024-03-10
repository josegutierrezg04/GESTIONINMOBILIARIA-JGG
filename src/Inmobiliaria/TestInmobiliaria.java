/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inmobiliaria;

import catalogo.Catalogo;
import excepciones.ViviendaException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import vivienda.Operacion;
import vivienda.Piso;
import vivienda.PisoImpl;
import vivienda.Vivienda;

/**
 *
 * @author josem
 */
public class TestInmobiliaria {

    //18.En la clase test deberás hacer un menú con las siguientes opciones:
    public static void main(String[] args) throws TestException, ViviendaException {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = new CatalogoImpl();

        int opcion;
        do {
            System.out.println("Pulse un número del 1 al 7 para realizar alguna de las siguientes opciones:");
            System.out.println("1: Añadir nuevo piso");
            System.out.println("2: Eliminar un piso");
            System.out.println("3: Mostrar piso con el menor precio por superficie");
            System.out.println("4: Rebajar pisos");
            System.out.println("5: Filtrar por precio y por superficie");
            System.out.println("6: Visualizar Catálogo");
            System.out.println("7: Salir del menú");

            opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1:
                    System.out.println("Añadir nuevo piso:");
                    agregarNuevoPiso(scanner, catalogo);
                    break;
                case 2:
                    System.out.println("Eliminar un piso:");
                    eliminarPiso(scanner, catalogo);
                    break;
                case 3:
                    System.out.println("Mostrar piso con el menor precio por superficie:");
                    mostrarPisoMasBaratoPorSuperficie(catalogo);
                    break;
                case 4:
                    System.out.println("Rebajar pisos:");
                    rebajarPisos(scanner, catalogo);
                    break;
                case 5:
                    System.out.println("Filtrar por precio y por superficie:");
                    filtrarPorPrecioYSuperficie(scanner, catalogo);
                    break;
                case 6:
                    System.out.println("Visualizar Catálogo:");
                    visualizarCatalogo(catalogo);
                    break;
                case 7:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no disponible.");
                    break;
            }
            //7: Salir del menú. El programa mostrará el menú repetidas veces hasta que se pulse esta opción. 
        } while (opcion != 7);

        scanner.close();
    }

    private static int obtenerOpcion(Scanner scanner) throws TestException {
        int opcion = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 7) {
                    entradaValida = true;
                } else {
                    throw new TestException("Opción no válida. Introduzca un número del 1 al 7:");
                }
            } catch (TestException e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
        }
        return opcion;
    }
//1: Añadir nuevo piso: para esta opción deberás pedir por terminal de manera guiada la información necesaria para crear el nuevo piso. Una vez que lo tengas deberás incluir el piso en el catálogo. Deberás informar al usuario si la operación se ha realizado con éxito o no.  A continuación se deben mostrar todos los pisos del catálogo. 

    private static void agregarNuevoPiso(Scanner scanner, Catalogo catalogo) throws ViviendaException {
        System.out.println("Ingrese la superficie del piso:");
        double superficie = scanner.nextDouble();
        System.out.println("Ingrese el precio del piso:");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese la operación del piso (alquiler, venta, alquiler con opción a venta):");
        String operacion = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese la dirección del piso:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese la planta del piso:");
        int planta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.println("Ingrese la puerta del piso:");
        char puerta = scanner.nextLine().charAt(0);

        Piso nuevoPiso = new PisoImpl(superficie, precio, Operacion.valueOf(operacion), direccion, planta, puerta);
        catalogo.agregarPiso(nuevoPiso);
        System.out.println("Nuevo piso añadido al catálogo.");
        visualizarCatalogo(catalogo);
    }
//2: Eliminar un piso:  para esta opción deberás pedir por terminal de manera guiada la información necesaria para eliminar el piso.  Deberás informar al usuario si la operación se ha realizado con éxito o no.   A continuación se deben mostrar todos los pisos del catálogo. 

    private static void eliminarPiso(Scanner scanner, Catalogo catalogo) throws ViviendaException, TestException {

        System.out.println("Ingrese la dirección del piso que desea eliminar:");
        String direccion = scanner.nextLine();

        Piso pisoAEliminar = null;
        ArrayList<Piso> pisos = catalogo.getListaPisos();
        if (pisos == null) {
            throw new TestException("No hay pisos en el catálogo.");
        }
        for (Piso piso : pisos) {
            if (piso.getDireccion().equals(direccion)) {
                pisoAEliminar = piso;
                break;
            }
        }

        if (pisoAEliminar != null) {
            catalogo.eliminarPiso(pisoAEliminar);
            System.out.println("Piso eliminado del catálogo.");
        } else {
            System.out.println("No se encontró un piso con la dirección especificada.");
        }

        visualizarCatalogo(catalogo);
    }
//3: Mostrar piso con el menor precio por superficie. Si el usuario pulsa esta opción deberás mostrar la dirección del piso más barato por superficie. 

    private static void mostrarPisoMasBaratoPorSuperficie(Catalogo catalogo) {
        String direccion = catalogo.obtenerDireccionPisoMasBaratoPorSuperficie();
        if (direccion != null) {
            System.out.println("La dirección del piso más barato por superficie es: " + direccion);
        } else {
            System.out.println("No hay pisos en el catálogo.");
        }
    }
//4: Rebajar pisos. Se deberá pedir al usuario la superficie y el porcentaje que se quieren rebajar los pisos. Se deberán rebajar los pisos y mostrar un mensaje al usuario que diga “Los pisos de superficie s se han rebajado correctamente. A continuación se deben mostrar todos los pisos del catálogo. 

    private static void rebajarPisos(Scanner scanner, Catalogo catalogo) throws ViviendaException {
        System.out.println("Ingrese la superficie de los pisos que desea rebajar:");
        double superficie = scanner.nextDouble();
        System.out.println("Ingrese el porcentaje de rebaja (%):");
        double porcentaje = scanner.nextDouble();
        catalogo.rebajarPrecioPorSuperficie(superficie, porcentaje);
        System.out.println("Los pisos de superficie " + superficie + " se han rebajado correctamente.");
        visualizarCatalogo(catalogo);
    }
//5: Filtrar por precio y por superficie. Deberás pedir al usuario el precio y la superficie por la que desea filtrar y mostrar  un Catálogo con los pisos con superficie mayor que s y precio menor que p.

    private static void filtrarPorPrecioYSuperficie(Scanner scanner, Catalogo catalogo) {
        System.out.println("Ingrese el precio para filtrar los pisos:");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese la superficie para filtrar los pisos:");
        double superficie = scanner.nextDouble();
        Catalogo catalogoFiltrado = catalogo.obtenerPisosPorPrecioYSuperficie(precio, superficie);
        System.out.println("Catálogo filtrado por precio y superficie:");
        visualizarCatalogo(catalogoFiltrado);
    }
//6: Visualizar Catálogo. Deberás mostrar el listado de pisos del catálogo. 

    private static void visualizarCatalogo(Catalogo catalogo) {
        ArrayList<Piso> pisos = catalogo.getListaPisos();
        if (pisos.isEmpty()) {
            System.out.println("No hay pisos en el catálogo.");
        } else {
            System.out.println("Catálogo de pisos:");
            for (Vivienda vivienda : pisos) {
                System.out.println(vivienda);
            }
        }
    }
}
