package com.fravega.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fravega.demo.Controllers.SucursalController;
import com.fravega.demo.Entities.Sucursal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObtenerSucursalCercanaTest {

    @Autowired
    private SucursalController controller;

    @Test
    public void obtenerSucursalMasCercana(){

        Sucursal sucursalCercana = controller.obtenerSucursalCercana(-32.890399, -68.839576);

        assertEquals(1001, sucursalCercana.getId());        

    }
}
