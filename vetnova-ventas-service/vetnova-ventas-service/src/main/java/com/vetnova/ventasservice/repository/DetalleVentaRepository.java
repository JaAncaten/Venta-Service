package com.vetnova.ventasservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetnova.ventasservice.model.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    List<DetalleVenta> findByVentaId(Long ventaId);

}