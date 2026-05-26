package com.vetnova.ventasservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vetnova.ventasservice.model.Venta;
import com.vetnova.ventasservice.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaService.obtenerVentas();
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable Long id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @PostMapping
    public Venta guardarVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @PutMapping("/{id}")
    public Venta actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return ventaService.actualizarVenta(id, venta);
    }

    @DeleteMapping("/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        boolean eliminado = ventaService.eliminarVenta(id);

        if (eliminado) {
            return "Venta eliminada correctamente";
        }

        return "Venta no encontrada";
    }

    @PutMapping("/{id}/estado/{estado}")
    public Venta actualizarEstadoVenta(@PathVariable Long id, @PathVariable String estado) {
            return ventaService.actualizarEstadoVenta(id, estado);
    }
}