package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Venta;
import com.example.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	
	@Override
	public Venta findById(int id) {
		// TODO Auto-generated method stub
		return ventaRepository.findOne(id);
	}

	@Override
	public void saveVenta(Venta venta) {
		// TODO Auto-generated method stub
		calcularMontopago(venta);
		ventaRepository.save(venta);
	}

	@Override
	public void updateVenta(Venta venta) {
		// TODO Auto-generated method stub
		calcularMontopago(venta);
		ventaRepository.save(venta);
	}

	@Override
	public void deleteVenta(int id) {
		// TODO Auto-generated method stub
		ventaRepository.delete(id);
	}

	@Override
	public Iterable<Venta> findAllVenta() {
		// TODO Auto-generated method stub
		return ventaRepository.findAll();
	}

	@Override
	public Iterable<Venta> findByTipolibroOrderByMontopagoAsc(String tipolibro) {
		// TODO Auto-generated method stub
		return ventaRepository.findByTipolibroOrderByMontopagoAsc(tipolibro);
	}

	@Override
	public Iterable<Venta> findByMontopago(double mp1, double mp2) {
		// TODO Auto-generated method stub
		return ventaRepository.findByMontopago(mp1, mp2);
	}
	
	
	private double calcularMontopago(Venta v){
		double montopagar=0.0;
		
		if(v.getTipolibro().equals("A")){
			montopagar=40*v.getCantidad();
		}
		
		if(v.getTipolibro().equals("B")){
			if(v.getTipopago().equals("TARJETA")){
				montopagar=(30*v.getCantidad())*1.18;
			}else{
				montopagar=30*v.getCantidad();
			}
			
		}
		
		if(v.getTipolibro().equals("C")){
			if(v.getTipopago().equals("EFECTIVO")){
				montopagar=(25*v.getCantidad())*0.50;
			}else{
				montopagar=25*v.getCantidad();
			}
			
		}
		
		v.setMontopago(montopagar);
		
		return montopagar;
	}

}
