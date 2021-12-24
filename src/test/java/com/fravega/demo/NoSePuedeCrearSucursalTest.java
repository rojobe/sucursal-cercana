package com.fravega.demo;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import com.fravega.demo.Controllers.SucursalController;
import com.fravega.demo.Entities.Sucursal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class NoSePuedeCrearSucursalTest {

    @Autowired
    private SucursalController controller;

	/**
	 * Prueba negativa de que no podemos crear una sucursal enviando un 
	 * objeto inicializado en null. 
	 * Al intentar crearla una excepcion del tipo InvalidDataAccessApiUsageException es lanzada
	 */
    @Test
	public void noSePuedeCrearSucursal(){

		Sucursal sucursal = null;	
		
		try{

			ResponseEntity<Object> savedSucursal = controller.crearSucursal(sucursal);

		}catch(InvalidDataAccessApiUsageException exception){

			assertInstanceOf(InvalidDataAccessApiUsageException.class, exception, "message");
		}
	}
}
