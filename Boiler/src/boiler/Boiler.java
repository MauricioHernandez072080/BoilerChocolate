/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boiler;

import Model.BoilerChocolate;
import execpcion.OpercionNopermitida;


public class Boiler {

    public static void main(String[] args) {
        BoilerChocolate b1 = BoilerChocolate.getInstancia();
        BoilerChocolate b2 = BoilerChocolate.getInstancia();

        System.out.println("Misma instancia " + (b1 == b2));
        System.out.println("Estado inicial: " + b1);
        System.out.println();

        ejecutar("Vaciar (boiler vacio)", b1::vaciar, b1);
        ejecutar("Iniciar mezcla (boiler vacio)", b1::iniciarMezcla, b1);
        ejecutar("Llenar", b1::llenar, b1);
        ejecutar("Llenar de nuevo (ya esta lleno)", b1::llenar, b1);
        ejecutar("Iniciar mezcla (desde b2, mismo objeto)", b2::iniciarMezcla, b2);
        ejecutar("Llenar (resistencia encendida)", b1::llenar, b1);
        ejecutar("Vaciar", b1::vaciar, b1);
    }

    private static void ejecutar(String descripcion, Runnable operacion, BoilerChocolate boiler) {
        System.out.println("- " + descripcion);
        try {
            operacion.run();
            System.out.println("  OK - " + boiler);
        } catch (OpercionNopermitida e) {
            System.out.println("  RECHAZADO: " + e.getMessage());
        }
        System.out.println();
    }
    
}
