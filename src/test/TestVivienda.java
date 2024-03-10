//11.En la clase TestVivienda se solicitan hacer las siguientes pruebas:
package test;

import Inmobiliaria.ViviendaImpl;
import excepciones.ViviendaException;
import java.util.Scanner;
import vivienda.Operacion;
import vivienda.Vivienda;

public class TestVivienda {

    public static void main(String[] args) throws ViviendaException {

        try {
//11.1.Crear una vivienda llamada v1 con los siguientes valores: 
            Vivienda v1 = new ViviendaImpl(80, 850, Operacion.ALQUILER, "Calle Gongora nº 58  - 4ºB, Cordoba");
//11.2.Cree una vivienda v2 con el constructor vacío.
            Vivienda v2 = new ViviendaImpl();
//11.3.Cree una nueva vivienda v3 con los siguientes datos:
            Vivienda v3 = new ViviendaImpl();
//11.4.Recoja por terminal la superficie, el precio y la dirección. La operación será venta. Modifique  v2 a partir de los siguientes datos recogidos por terminal. 
            Scanner venta = new Scanner(System.in);
            System.out.println("Deme la superficie de v2");
            double superficie = venta.nextDouble();
            v2.setSuperficie(superficie);
            System.out.println("Deme el precio de v2");
            double precio = venta.nextDouble();
            v2.setPrecio(precio);
            venta.nextLine();
            System.out.println("Deme dirección de v2");
            String direccion = venta.nextLine();
            v2.setDireccion(direccion);
            venta.close();
//11.5.Modifique la dirección v3 con: Plaza de las flores nº 24, Úbeda.
            v3.setDireccion("Plaza de las flores nº 24, Úbeda");
//11.6.Se ha realizado una rebaja de un 10% de v1. Muestra por pantalla el precio actual.
            System.out.println(v1.getRebajaPrecioVivienda());
//11.7.Muestre por pantalla la comisión que se lleva la inmobiliaria por v2.
            System.out.println(v2.getCantidadInmobiliariaGestion());
//11.8.Calcule y muestre por pantalla el precio por metro cuadrado de v2.
            System.out.println(v2.getPrecioMetroCuadrado());
//11.9.Muestre la localidad de v1 por pantalla. 
            System.out.println(v1.getLocalidad(v1.getDireccion()));
//11.10.Muestre por pantalla la dirección de la vivienda con mayor precio por metro cuadrado. Compare solo v2 y v3. Use el método del ejercicio 7. 
            System.out.println(v2.getDireccionViviendaMayorPrecioMetroCuadrado(v3));
//11.11.Repita el apartado anterior con v1 y v3.
            System.out.println(v1.getDireccionViviendaMayorPrecioMetroCuadrado(v3));
//11.12.Muestra por pantalla el tipo de vivienda que es v3: ¿pequeña, mediana o grande?
            System.out.println(v3.esPequena());
//11.13.Muestra por pantalla la dirección de la vivienda con mayor precio por metro cuadrado.
            System.out.println(Math.max(Math.max(v1.getPrecioMetroCuadrado(), v2.getPrecioMetroCuadrado()), v3.getPrecioMetroCuadrado()));
        } catch (ViviendaException e) {
            System.out.println(e.getMessage());
        }
    }
}
