package com.fravega.demo;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.fravega.demo.Controllers.SucursalController;
import com.fravega.demo.Entities.Sucursal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class NoSePuedeCrearSucursalTest {

    @Autowired
    private SucursalController controller;

    @Test
	public void noSePuedeCrearSucursal(){
		Sucursal sucursal = new Sucursal("Panamerica 2875",-32.954939,-68.858527);
		ResponseEntity<Object> savedSucursal = controller.crearSucursal(sucursal);
		assertInstanceOf(ResponseEntity.class, savedSucursal, "message");
	}
}
