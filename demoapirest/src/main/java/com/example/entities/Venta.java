package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nombrelibro;
	private String tipolibro;// A,B y C
	private int cantidad;
	private String tipopago;// EFECTIVO - CONTADO
	private double montopago;

	public Venta() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrelibro() {
		return nombrelibro;
	}

	public void setNombrelibro(String nombrelibro) {
		this.nombrelibro = nombrelibro;
	}

	public String getTipolibro() {
		return tipolibro;
	}

	public void setTipolibro(String tipolibro) {
		this.tipolibro = tipolibro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public double getMontopago() {
		return montopago;
	}

	public void setMontopago(double montopago) {
		this.montopago = montopago;
	}

}
