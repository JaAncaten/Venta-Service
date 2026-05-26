package com.vetnova.ventasservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetnova.ventasservice.model.DetalleVenta;
import com.vetnova.ventasservice.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> obtenerDetallesVenta() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta obtenerDetalleVentaPorId(Long id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public List<DetalleVenta> obtenerDetallesPorVentaId(Long ventaId) {
        return detalleVentaRepository.findByVentaId(ventaId);
    }

    public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta) {
        Double subtotal = detalleVenta.getCantidad() * detalleVenta.getPrecioUnitario();
        detalleVenta.setSubtotal(subtotal);

        return detalleVentaRepository.save(detalleVenta);
    }

    public DetalleVenta actualizarDetalleVenta(Long id, DetalleVenta detalleActualizado) {
        Optional<DetalleVenta> detalleExistente = detalleVentaRepository.findById(id);

        if (detalleExistente.isPresent()) {
            DetalleVenta detalle = detalleExistente.get();

            detalle.setVentaId(detalleActualizado.getVentaId());
            detalle.setProductoId(detalleActualizado.getProductoId());
            detalle.setCantidad(detalleActualizado.getCantidad());
            detalle.setPrecioUnitario(detalleActualizado.getPrecioUnitario());

            Double subtotal = detalleActualizado.getCantidad() * detalleActualizado.getPrecioUnitario();
            detalle.setSubtotal(subtotal);

            return detalleVentaRepository.save(detalle);
        }

        return null;
    }

    public boolean eliminarDetalleVenta(Long id) {
        if (detalleVentaRepository.existsById(id)) {
            detalleVentaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}