package com.fravega.demo.Services;

import java.util.List;

import com.fravega.demo.Daos.SucursalRepository;
import com.fravega.demo.Entities.Sucursal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    
    public Sucursal obtenerSucursalMasCercana(double latitud ,double longitud){
        System.out.println("Entering retrieveNearesSucursal GET /sucursales/{latitud}/{longitud}");
        Sucursal nearestSucursal = new Sucursal();
        double distanceToPoint = 0;
        List<Sucursal> sucursales = sucursalRepository.findAll();

        for(Sucursal suc : sucursales){
            if(distanceToPoint == 0){
                distanceToPoint = dist(suc, latitud, longitud);
                nearestSucursal = suc;
                continue;
            }

            if(dist(suc, latitud, longitud) < distanceToPoint){
                distanceToPoint = dist(suc, latitud, longitud);
                nearestSucursal = suc;
            }
        }

       return nearestSucursal;
    }


    public double dist(Sucursal sucursal, double latitud, double longitud){

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(sucursal.getLatitud() - latitud);
        double lonDistance = Math.toRadians(sucursal.getLongitud() - longitud);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitud)) * Math.cos(Math.toRadians(sucursal.getLatitud()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = 0 - 0;// we assume we are at 0 height

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

}
