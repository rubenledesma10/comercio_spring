
package com.example.integrador_spring.service;

import com.example.integrador_spring.dto.FechaVentasDTO;
import com.example.integrador_spring.dto.MayorVentaDTO;
import com.example.integrador_spring.dto.VentasProdDTO;
import com.example.integrador_spring.model.Venta;
import com.example.integrador_spring.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;
    
    @Override
    public void saveVenta(Venta ven) {
        ventaRepo.save(ven);
    }

    @Override
    public List<Venta> getVenta() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void editVenta(Venta curso) {
        this.saveVenta(curso);
    }

    @Override
    public VentasProdDTO productosVenta(Long codigo_venta) {
        
        VentasProdDTO prodVentDTO = new VentasProdDTO();
        Venta ventas = this.findVenta(codigo_venta);
        prodVentDTO.setCodigo_venta(ventas.getCodigo_venta());
        prodVentDTO.setListaProductosVenta(ventas.getListaProductos());
        return prodVentDTO;
    }

    @Override
    public FechaVentasDTO fechaVenta(LocalDate fecha_venta) {
        
        List<Venta> listaVentas = this.getVenta();
        FechaVentasDTO fechaVentasDTO = new FechaVentasDTO();
        double total = 0;
        Long contador = 0L;
        
        for (Venta ven : listaVentas){
            if(ven.getFecha_venta().isEqual(fecha_venta)){
                total = total + ven.getTotal();
                fechaVentasDTO.setFecha_venta(ven.getFecha_venta());
                contador++;
            } 
        }
        
        fechaVentasDTO.setSumatoria_monto(total);
        fechaVentasDTO.setTotal_ventas(contador);
        return fechaVentasDTO;
    }

    @Override
    public MayorVentaDTO getVentaMayor() {
        
        List<Venta> listaVentas = this.getVenta();
        MayorVentaDTO mayorVentaDTO = new MayorVentaDTO();
        double mayor_monto = 0;
        
        for (Venta ven : listaVentas) {
            if(ven.getTotal()>=mayor_monto){
                mayor_monto = ven.getTotal();
            }
            mayorVentaDTO.setApellido_cliente(ven.getUncliente().getApellido());
            mayorVentaDTO.setCant_productos(ven.getListaProductos().size());
            mayorVentaDTO.setCodigo_venta(ven.getCodigo_venta());
            mayorVentaDTO.setNombre_cliente(ven.getUncliente().getNombre());
            mayorVentaDTO.setTotal_venta(ven.getTotal());
        }
        
        return mayorVentaDTO;
        
        
        
        
        
    }

}
