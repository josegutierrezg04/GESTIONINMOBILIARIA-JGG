//1.Crear la clase y la interfaz con sus métodos observables y modificables
package Inmobiliaria;

import excepciones.ViviendaException;
import vivienda.Operacion;
import vivienda.Vivienda;

public class ViviendaImpl implements Vivienda {

    final static double REBAJA_VIVIENDA = 0.1;
    protected double superficie;
    protected double precio;
    protected Operacion operacion;
    protected String direccion;

    /**
     * Obtiene la superficie.
     *
     * @return Superficie.
     */
    public double getSuperficie() {
        return this.superficie;
    }

    /**
     * Obtiene el precio.
     *
     * @return Precio.
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Obtiene la Operacion.
     *
     * @return Operacion.
     */
    public Operacion getOperacion() {
        return this.operacion;
    }

    /**
     * Obtiene la Dirección.
     *
     * @return Dirección.
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Establece la Superficie.
     */
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    /**
     * Establece la Precio.
     */
    public void setPrecio(double precio) throws ViviendaException {
        if (precio < 0) {
            throw new ViviendaException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    /**
     * Establece la Operacion.
     */
    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    /**
     * Establece la Direccion.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
//2.Crear tres constructores:
//2.1.Uno que reciba los valores de todos los atributos por parámetro.

    public ViviendaImpl(double superficie, double precio, Operacion operacion, String direccion) throws ViviendaException {
        this.superficie = superficie;
        if (precio < 0) {
            throw new ViviendaException("El precio no puede ser negativo");
        }
        this.precio = precio;
        this.operacion = operacion;
        this.direccion = direccion;
    }
//2.2.Uno que reciba únicamente la dirección y el resto los inicialice al valor establecido por defecto:

    public ViviendaImpl(String direccion) {
        this.superficie = 90.0;
        this.precio = 150000;
        this.operacion = operacion.VENTA;
        this.direccion = direccion;
    }
//2.3.Uno que no reciba ningún valor por parámetro e inicialice al valor nulo todos los atributos. El valor por defecto de operación es venta.

    public ViviendaImpl() {
        this.superficie = 90.0;
        this.precio = 150000;
        this.operacion = operacion.VENTA;
        this.direccion = "";
    }

//3.Crear un método que rebaje el precio de la vivienda a un 10%. El valor de rebaja debe ser creado en una constante.
    /**
     * Rebaja el precio de la vivienda a un 10%.
     *
     * @return Precio Rebajado de la vivienda.
     */
    public double getRebajaPrecioVivienda() {
        double precioRebaja = this.precio * REBAJA_VIVIENDA;
        return this.precio - precioRebaja;
    }
//4.Crear el método toString que muestre la información de la Vivienda en el siguiente formato:

    /**
     * Crea una cadena.
     *
     * @return Cadena de datos.
     */
    public String toString() {
        return "Dirección:" + this.direccion + "- precio=" + this.precio + " - superficie=" + this.superficie + "- operación=" + this.operacion;
    }
//5.Cree un método que dada una operación, alquiler, venta o alquiler con opción a compra, devuelva si la vivienda es de esa operación.

    /**
     * Compara dos tipo operaciones.
     *
     * @return Si la vivienda es de esa operación o no.
     */
    public boolean esMismaOperacion(Operacion operacion) {
        return this.operacion == operacion;
    }
    //6.Crear un método que devuelva la cantidad que se lleva la inmobiliaria por la gestión. En el caso de las viviendas en alquiler se lleva un 8% del precio, en el caso de las viviendas en venta se lleva un 14% y en el alquiler con opción a compra un 11%.

    /**
     * Calcula la cantidad que se lleva la inmobiliaria por la gestión según el
     * tipo de operación que sea.
     *
     * @return Cantidad que se lleva la inmobiliaria.
     */
    public double getCantidadInmobiliariaGestion() {
        double cantidad = 0;
        switch (this.operacion) {
            case ALQUILER:
                cantidad = this.precio * 0.08;
                break;
            case VENTA:
                cantidad = this.precio * 0.14;
                break;
            case ALQUILER_OPCION_VENTA:
                cantidad = this.precio * 0.11;
                break;
        }
        return cantidad;
    }
//7.Crear un método que dado otra Vivienda y sí únicamente la operación en ambas en la misma, es decir, ambas están en Venta o en alquiler nos devuelva la dirección de la vivienda con mayor precio por metro cuadrado. En el caso de que las viviendas  no tengan la misma operación  devuelva “Las viviendas no tienen la misma dirección”. Para ello, necesitará crear un método que calcule el precio por metro cuadrado. 

    /**
     * Calcula el precio por metro cuadrado.
     *
     * @return Precio por metro cuadrado.
     */
    public double getPrecioMetroCuadrado() {
        return this.precio / this.superficie;
    }

    /**
     * Calcula la dirección de la vivienda con con mayor precio por metro
     * cuadrado sí únicamente la operación en ambas en la misma .
     *
     * @return Dirección de la vivienda con con mayor precio por metro cuadrado.
     */
    public String getDireccionViviendaMayorPrecioMetroCuadrado(Vivienda v1) {
        String direc = "";
        if (this.getOperacion() == v1.getOperacion()) {
            if (this.getPrecioMetroCuadrado() > v1.getPrecioMetroCuadrado()) {
                direc = this.getDireccion();
            } else if (this.getPrecioMetroCuadrado() < v1.getPrecioMetroCuadrado()) {
                direc = v1.getDireccion();
            }
        } else {
            direc = "Las viviendas no tienen la misma dirección";
        }
        return direc;
    }
//8.Cree un método que devuelva un String que diga si la vivienda es pequeña, mediana o grande. 

    /**
     * Calcula del tamaño de la vivienda.
     *
     * @return Tamaño de la vivienda.
     */
    public String esPequena() {
        String tamano = "";
        if (this.superficie < 70) {
            tamano = "Vivienda pequeña";
        } else if (this.superficie >= 70 && this.superficie <= 95) {
            tamano = "Vivienda mediana";
        } else if (this.superficie > 95) {
            tamano = "Vivienda grande";
        }
        return tamano;
    }
//9.Cree un método que devuelva la localidad en la que se encuentra la vivienda. El formato de la dirección siempre se escribirá así: 

    /**
     * Calcula la localidad en la que se encuentra la vivienda dado un String.
     *
     * @return Localidad en la que se encuentra la vivienda.
     */
    public String getLocalidad(String array) {
        String localidad = "";
        String[] direccion = array.split(",");
        localidad = direccion[1];
        return localidad;
    }
//10.Cree un método que dado un array con las superficies de cada una de las estancias de la vivienda te calcule la superficie total y modifique la superficie.

    /**
     * Calcula la superficie total y modifica la superficie dado un array con
     * las superficies de cada una de las estancias de la vivienda.
     *
     * @return Superficie total.
     */
    public double getSuperficieTotal(int[] array) {
        double total = 0;
        double sum = 0;
        for (int elements : array) {
            sum = sum + elements;
        }
        sum = total;
        return total;
    }
// 3.SEGUNDA ENTREGA:Implemente en Vivienda el método equals y el compareTo. Dos viviendas son iguales si tienen la misma dirección.Se ordenan por dirección. 

    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Vivienda) {
            Vivienda v = (Vivienda) o;
            r = this.getDireccion().equals(v.getDireccion());
        }
        return r;
    }

    public int compareTo(Vivienda v) {
        return this.direccion.compareTo(v.getDireccion());
    }

}
