package com.fravega.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sucursal {

    @Id
    @GeneratedValue
    private Integer id;

    private String direccion;

    private double latitud;

    private double longitud;

    public Sucursal(){

    }

    public Sucursal(String direccion, double latitud, double longitud){
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;

    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Sucursal [direccion=" + direccion + "]";
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }


}
