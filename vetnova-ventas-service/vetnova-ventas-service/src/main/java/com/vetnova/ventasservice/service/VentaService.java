package com.vetnova.ventasservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetnova.ventasservice.model.Venta;
import com.vetnova.ventasservice.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> obtenerVentas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta actualizarVenta(Long id, Venta ventaActualizada) {
        Optional<Venta> ventaExistente = ventaRepository.findById(id);

        if (ventaExistente.isPresent()) {
            Venta venta = ventaExistente.get();

            venta.setUsuarioId(ventaActualizada.getUsuarioId());
            venta.setFechaVenta(ventaActualizada.getFechaVenta());
            venta.setTotal(ventaActualizada.getTotal());
            venta.setMetodoPago(ventaActualizada.getMetodoPago());
            venta.setEstado(ventaActualizada.getEstado());

            return ventaRepository.save(venta);
        }

        return null;
    }

    public boolean eliminarVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}