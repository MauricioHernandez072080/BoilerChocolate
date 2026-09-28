/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import execpcion.OpercionNopermitida;

public class BoilerChocolate {
    
    private static volatile BoilerChocolate instancia;

    private EstadoBoiler estadoBoiler;
    private EstadoResistencia estadoResistencia;


    private BoilerChocolate() {
        this.estadoBoiler = EstadoBoiler.VACIO;
        this.estadoResistencia = EstadoResistencia.APAGADA;
    }

    public static BoilerChocolate getInstancia() {
        if (instancia == null) {
            synchronized (BoilerChocolate.class) {
                if (instancia == null) {
                    instancia = new BoilerChocolate();
                }
            }
        }
        return instancia;
    }

    
    public synchronized void llenar() {
        if (estadoBoiler == EstadoBoiler.VACIO && estadoResistencia == EstadoResistencia.APAGADA) {
            estadoBoiler = EstadoBoiler.LLENO;
        } else {
            throw new OpercionNopermitida(
                    "No se puede llenar: el boiler debe estar vacio y la resistencia apagada.");
        }
    }

    
    public synchronized void iniciarMezcla() {
        if (estadoBoiler == EstadoBoiler.LLENO && estadoResistencia == EstadoResistencia.APAGADA) {
            estadoResistencia = EstadoResistencia.ENCENDIDA;
        } else {
            throw new OpercionNopermitida(
                    "No se puede iniciar la mezcla: el boiler debe estar lleno y la resistencia apagada.");
        }
    }

    /**
     * Solo se vacía si no está vacío y la resistencia está encendida.
     * Al vaciarse, la resistencia se apaga y el boiler vuelve al estado inicial.
     */
    public synchronized void vaciar() {
        if (estadoBoiler == EstadoBoiler.LLENO && estadoResistencia == EstadoResistencia.ENCENDIDA) {
            estadoBoiler = EstadoBoiler.VACIO;
            estadoResistencia = EstadoResistencia.APAGADA;
        } else {
            throw new OpercionNopermitida(
                    "No se puede vaciar: el boiler debe estar lleno y la resistencia encendida.");
        }
    }

    public synchronized EstadoBoiler getEstadoBoiler() {
        return estadoBoiler;
    }

    public synchronized EstadoResistencia getEstadoResistencia() {
        return estadoResistencia;
    }

    @Override
    public synchronized String toString() {
        return "Boiler |" + estadoBoiler + ", resistencia " + estadoResistencia + "|";
    }
}