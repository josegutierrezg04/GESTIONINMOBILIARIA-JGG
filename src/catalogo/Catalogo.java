/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package catalogo;

import excepciones.ViviendaException;
import java.util.ArrayList;
import vivienda.Piso;

/**
 *
 * @author josem
 */
public interface Catalogo {

    ArrayList<Piso> getListaPisos();

    void setListaPisos(ArrayList<Piso> listaPisos);

    int contarPisosPorOperacion(String operacion);

    void agregarPiso(Piso nuevoPiso) throws ViviendaException;

    void eliminarPiso(Piso pisoEliminar) throws ViviendaException;

    double sumaPreciosPorPlanta(int planta);

    String direccionPisoMenorPrecioPorSuperficie() throws ViviendaException;

    Catalogo obtenerPisosPorPrecioYSuperficie(double p, double s);

    void ordenarPorSuperficie();

    boolean existePisoConPrecioMenorQue(double p);

    boolean todosPisosPorDebajoDePlanta(int p);

    void rebajarPrecioPorSuperficie(double s, double p) throws ViviendaException;

    String obtenerDireccionPisoMasBaratoPorSuperficie();
}
