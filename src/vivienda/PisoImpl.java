/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vivienda;

import Inmobiliaria.ViviendaImpl;
import excepciones.ViviendaException;

/**
 *
 * @author josem
 */
public class PisoImpl extends ViviendaImpl implements Piso, Vivienda, Comparable<Vivienda> {

    private int planta;
    private char puerta;

    /**
     *
     * @return
     */
    @Override
    public int getPlanta() {
        return planta;
    }

    /**
     *
     * @return
     */
    @Override
    public char getPuerta() {
        return puerta;
    }
// 6.SEGUNDA ENTREGA: Implemente para el tipo Piso un constructor que reciba un argumento para cada atributo.

    public PisoImpl(double superficie, double precio, Operacion operacion, String direccion, int planta, char puerta) throws ViviendaException {
        super(superficie, precio, operacion, direccion);
        this.planta = planta;
        this.puerta = puerta;
    }

    // 4.SEGUNDA ENTREGA: Repite la misma operación para el tipo Piso. Dos pisos son iguales entre sí si tiene la misma dirección, misma planta y la misma puerta.
    @Override
    public boolean equals(Object o) {
        boolean r = false;
        if (o instanceof Piso) {
            Piso v = (Piso) o;
            r = super.equals(v) && this.planta == v.getPlanta() && this.puerta == v.getPuerta();
        }
        return r;
    }

    public int compare(Piso p1, Piso p2) {
        int n;
        n = p1.getDireccion().compareTo(p2.getDireccion());
        if (n == 0) {
            n = Integer.compare(p1.getPlanta(), p2.getPlanta());
        }
        if (n == 0) {
            n = Character.compare(p1.getPuerta(), p2.getPuerta());
        }
        return n;
    }
}
