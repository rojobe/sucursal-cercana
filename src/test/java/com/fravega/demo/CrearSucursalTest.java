package com.fravega.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import com.fravega.demo.Controllers.SucursalController;
import com.fravega.demo.Entities.Sucursal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class CrearSucursalTest {

    @Autowired
    private SucursalController controller;

	/**
	 * Prueba positiva de la creación de una sucursal
	 */
    @Test
	public void createSucursal(){
		Sucursal sucursal = new Sucursal("Panamerica 2875",-32.954939,-68.858527);
		ResponseEntity<Object> savedSucursal = controller.crearSucursal(sucursal);
		assertEquals(HttpStatus.CREATED, savedSucursal.getStatusCode(), "message");
	}
}
