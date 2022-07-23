/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieut
 */
public class Vehicle {
    private String idRandomVehicle;
    private String tour;
    private String transport;
    private int capacity;
    public Vehicle(String idRandomVehicle, String tour, String transport, int capacity) {
        this.idRandomVehicle = idRandomVehicle;
        this.tour = tour;
        this.transport = transport;
        this.capacity = capacity;
    }

    public Vehicle() {
    }

    public String getIdRandomVehicle() {
        return idRandomVehicle;
    }

    public void setIdRandomVehicle(String idRandomVehicle) {
        this.idRandomVehicle = idRandomVehicle;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

   
    
}
