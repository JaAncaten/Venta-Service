package com.vetnova.ventasservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetnova.ventasservice.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {

}