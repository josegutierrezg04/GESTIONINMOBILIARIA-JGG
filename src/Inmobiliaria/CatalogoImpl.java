/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inmobiliaria;

import catalogo.Catalogo;
import excepciones.ViviendaException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import vivienda.Piso;

/**
 *
 * @author josem
 */
public class CatalogoImpl implements Catalogo {

    private ArrayList<Piso> listaPisos;

    // Constructores
    public CatalogoImpl() {
        this.listaPisos = new ArrayList<>();
    }

    private CatalogoImpl(ArrayList<Piso> pisosFiltrados) {
        this.listaPisos = pisosFiltrados;
    }

    // Getter y Setter
    public ArrayList<Piso> getListaPisos() {
        return listaPisos;
    }

    public void setListaPisos(ArrayList<Piso> listaPisos) {
        this.listaPisos = listaPisos;
    }

    // 7.Para el tipo Catálogo implemente un método para que: reciba una cadena de caracteres con “ALQUILER” o “VENTA” y devuelva el número de pisos de esa operación.
    public int contarPisosPorOperacion(String operacion) {
        int contador = 0;
        for (Piso piso : listaPisos) {
            if (piso.getOperacion().equals(operacion.toUpperCase())) {
                contador++;
            }
        }
        return contador;
    }
//8.Para el tipo Catálogo implemente un método que añada un nuevo piso al catálogo. Tenga en cuenta que no se pueden incluir dos pisos iguales en el catálogo. 

    public void agregarPiso(Piso nuevoPiso) throws ViviendaException {
        for (Piso piso : listaPisos) {
            if (piso.equals(nuevoPiso)) {
                throw new ViviendaException("El piso ya existe en el catálogo.");
            }
        }
        listaPisos.add(nuevoPiso);
        System.out.println("Nuevo piso agregado al catálogo.");
    }

//9.Para el tipo Catálogo implemente un método que elimine un piso existente del catálogo. Si el piso no se encuentra en el catálogo entonces deberá lanzar una excepción indicando esto. 
    public void eliminarPiso(Piso pisoEliminar) throws ViviendaException {
        boolean eliminado = listaPisos.remove(pisoEliminar);
        if (!eliminado) {
            throw new ViviendaException("El piso no se encuentra en el catálogo.");
        }
    }

//10.Para el tipo Catálogo implemente un método para que: reciba una planta y devuelva la suma de precios de los pisos que están en esa planta.
    public double sumaPreciosPorPlanta(int planta) {
        double sumaPrecios = 0;
        for (Piso piso : listaPisos) {
            if (piso.getPlanta() == planta) {
                sumaPrecios = sumaPrecios + piso.getPrecio();
            }
        }
        return sumaPrecios;
    }
//11.Para el tipo Catálogo implemente un método para que: devuelva la dirección del piso con el menor precio por superficie (cociente de precio por superficie).

    public String direccionPisoMenorPrecioPorSuperficie() throws ViviendaException {
        if (listaPisos.isEmpty()) {
            throw new ViviendaException("La lista de pisos está vacía");
        }

        double menorPrecio = Double.MAX_VALUE;
        String direccionPrecioPorSuperficie = null;

        for (Piso piso : listaPisos) {
            double precioPorSuperficie = piso.getPrecio() / piso.getSuperficie();
            if (precioPorSuperficie < menorPrecio) {
                menorPrecio = precioPorSuperficie;
                direccionPrecioPorSuperficie = piso.getDireccion();
            }
        }

        return direccionPrecioPorSuperficie;
    }

//12.Para el tipo Catálogo implemente un método para que: dado un precio p y una superficie s devuelve un Catálogo con los pisos con superficie mayor que s y precio menor que p.
    public Catalogo obtenerPisosPorPrecioYSuperficie(double p, double s) {
        ArrayList<Piso> pisosFiltrados = new ArrayList<>();

        for (Piso piso : listaPisos) {
            if (piso.getSuperficie() > s && piso.getPrecio() < p) {
                pisosFiltrados.add(piso);
            }
        }

        return new CatalogoImpl(pisosFiltrados);
    }

    //13.Para el tipo Catálogo implemente un método para que: Ordena el Catálogo por superficie.
    public void ordenarPorSuperficie() {
        Collections.sort(listaPisos, new Comparator<Piso>() {
            public int compare(Piso p1, Piso p2) {
                return Double.compare(p1.getSuperficie(), p2.getSuperficie());
            }
        });
    }

//14.Para el tipo Catálogo implemente un método para que: Dado un precio p devuelva si existe un piso con precio menor que p.
    public boolean existePisoConPrecioMenorQue(double p) {
        for (Piso piso : listaPisos) {
            if (piso.getPrecio() < p) {
                return true;
            }
        }
        return false;
    }

//15.Para el tipo Catálogo implemente un método para que: Dada una planta p devuelve si todos los pisos están por debajo de esa planta.
    public boolean todosPisosPorDebajoDePlanta(int p) {
        for (Piso piso : listaPisos) {
            if (piso.getPlanta() > p) {
                return false;
            }
        }
        return true;
    }

//16.Para el tipo Catálogo implemente un método para que: Dado una superficie s y un porcentaje p rebaja el precio de los pisos con superficie mayor que s un porcentaje p.
    public void rebajarPrecioPorSuperficie(double s, double p) throws ViviendaException {
        for (Piso piso : listaPisos) {
            if (piso.getSuperficie() > s) {
                double rebaja = piso.getPrecio() * (p / 100.0);
                double nuevoPrecio = piso.getPrecio() - rebaja;
                piso.setPrecio(nuevoPrecio);
            }
        }
    }

//Lo he creado porque en la opción tre me pide que nesecito filtrar los pisos
    public String obtenerDireccionPisoMasBaratoPorSuperficie() {
        if (listaPisos.isEmpty()) {
            return null;
        }

        Piso pisoMasBarato = listaPisos.get(0);
        double precioPorSuperficieMasBarato = pisoMasBarato.getPrecio() / pisoMasBarato.getSuperficie();

        for (Piso piso : listaPisos) {
            double precioPorSuperficieActual = piso.getPrecio() / piso.getSuperficie();
            if (precioPorSuperficieActual < precioPorSuperficieMasBarato) {
                pisoMasBarato = piso;
                precioPorSuperficieMasBarato = precioPorSuperficieActual;
            }
        }

        return pisoMasBarato.getDireccion();
    }
}
