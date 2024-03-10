/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

// 5.SEGUNDA ENTREGA: Una vivienda no puede tener un precio negativo. Cree una excepción verificada que muestre un mensaje por pantalla que indique que el precio no puede ser negativo. Lance la excepción en el constructor con un método estático. 
/**
 *
 * @author josem
 */
public class ViviendaException extends Exception {

    public ViviendaException(String e) {
        super(e);
    }
}
