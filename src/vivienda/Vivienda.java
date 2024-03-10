package vivienda;

import excepciones.ViviendaException;

public interface Vivienda {

    double getSuperficie();

    double getPrecio();

    Operacion getOperacion();

    String getDireccion();

    void setSuperficie(double superficie);

    void setPrecio(double precio) throws ViviendaException;

    void setOperacion(Operacion operacion);

    void setDireccion(String direccion);

    double getRebajaPrecioVivienda();

    boolean esMismaOperacion(Operacion operacion);

    double getCantidadInmobiliariaGestion();

    double getPrecioMetroCuadrado();

    String getDireccionViviendaMayorPrecioMetroCuadrado(Vivienda v1);

    String esPequena();

    String getLocalidad(String array);

    double getSuperficieTotal(int[] array);
}
