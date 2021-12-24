package com.fravega.demo.Controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.fravega.demo.Daos.SucursalRepository;
import com.fravega.demo.Entities.Sucursal;
import com.fravega.demo.Exception.SucursalNotFoundException;
import com.fravega.demo.Services.SucursalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@Validated
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private SucursalService sucursalService;

    //retrieve all sucursales
    @GetMapping("/sucursales")
    public List<Sucursal> obtenerTodasLasSucursales(){
        System.out.println("Entering retrieveAllSucursales GET /sucursales");
        return sucursalRepository.findAll();
    }
    
    @GetMapping("/sucursales/{id}")
    public Optional<Sucursal> obtenerSucursal(@PathVariable("id") int id){
        System.out.println("Entering retrieveSucursal GET /sucursales({id}");

        Optional<Sucursal> sucursal = sucursalRepository.findById(id);
        if(!sucursal.isPresent()){
            throw new SucursalNotFoundException("sucursal con id - " + id + " no encontrada");
        }
        System.out.println("Exiting retrieveSucursal GET /sucursales({id}");
        return sucursal;
    }


    @GetMapping("/sucursales/{latitud}/{longitud}")
    public Sucursal obtenerSucursalCercana(@NotNull @PathVariable double latitud,@NotNull @PathVariable double longitud){
        System.out.println("Entering retrieveNearestSucursal GET /sucursales/{latitud}/{longitud}");

        Sucursal sucursalCercana = sucursalService.obtenerSucursalMasCercana(latitud, longitud);

        System.out.println("Exiting retrieveNearestSucursal GET /sucursales/{latitud}/{longitud}");

        return sucursalCercana;

    } 

    @PostMapping("/sucursales")
    public ResponseEntity<Object> crearSucursal(@RequestBody Sucursal sucursal){
        System.out.println("Entering createSucursal POST /sucursales");

        Sucursal savedSucursal = sucursalRepository.save(sucursal);

        URI path = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedSucursal.getId()).toUri();

        
        System.out.println("Exiting createSucursal POST /sucursales");

        return ResponseEntity.created(path).build();
    }
}
