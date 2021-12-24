package com.fravega.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import com.fravega.demo.Controllers.SucursalController;
import com.fravega.demo.Entities.Sucursal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuscarTodasLasSucursalesTest {
    
	@Test
	void contextLoads() {	}

    @Autowired
    private SucursalController controller;

	/**
	 * Prueba positiva de la búsqueda de todas las sucursales que se esperan obtene
	 */
	@Test
	public void sizeOfList(){
		List<Sucursal> sucursales = controller.obtenerTodasLasSucursales();
		assertEquals(3, sucursales.size());		
	}

}
