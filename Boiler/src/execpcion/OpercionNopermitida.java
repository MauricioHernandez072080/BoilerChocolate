/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package execpcion;

public class OpercionNopermitida extends RuntimeException {

    public OpercionNopermitida(String mensaje) {
        super(mensaje);
    }
}