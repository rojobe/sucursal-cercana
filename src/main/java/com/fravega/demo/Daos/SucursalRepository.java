package com.fravega.demo.Daos;

import com.fravega.demo.Entities.Sucursal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    
}
