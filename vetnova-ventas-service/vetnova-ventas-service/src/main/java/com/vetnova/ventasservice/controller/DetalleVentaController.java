package com.vetnova.ventasservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vetnova.ventasservice.model.DetalleVenta;
import com.vetnova.ventasservice.service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> obtenerDetallesVenta() {
        return detalleVentaService.obtenerDetallesVenta();
    }

    @GetMapping("/{id}")
    public DetalleVenta obtenerDetalleVentaPorId(@PathVariable Long id) {
        return detalleVentaService.obtenerDetalleVentaPorId(id);
    }

    @GetMapping("/venta/{ventaId}")
    public List<DetalleVenta> obtenerDetallesPorVentaId(@PathVariable Long ventaId) {
        return detalleVentaService.obtenerDetallesPorVentaId(ventaId);
    }

    @PostMapping
    public DetalleVenta guardarDetalleVenta(@RequestBody DetalleVenta detalleVenta,
                                        @RequestHeader("Authorization") String token) {
         return detalleVentaService.guardarDetalleVenta(detalleVenta, token);
}

    @PutMapping("/{id}")
    public DetalleVenta actualizarDetalleVenta(@PathVariable Long id,
                                               @RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.actualizarDetalleVenta(id, detalleVenta);
    }

    @DeleteMapping("/{id}")
    public String eliminarDetalleVenta(@PathVariable Long id) {
        boolean eliminado = detalleVentaService.eliminarDetalleVenta(id);

        if (eliminado) {
            return "Detalle de venta eliminado correctamente";
        }

        return "Detalle de venta no encontrado";
    }
}