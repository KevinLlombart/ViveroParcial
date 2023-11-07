package ar.edu.unlam.pb1.vivero;

import java.util.Objects;

public abstract class Planta {

	private Integer codigo;
	private String nombre;
	private Integer stock;
	private Double precioBase;
	private TipoDePlanta tipo;

	public Planta(Integer codigo, String nombre, Double precio, Integer stock) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.stock = stock;
		this.precioBase = precio;
		this.tipo = getTipo();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/*
	 * Cada Planta tiene un valor denominadado ganancia y este se debe multiplicar
	 * por el precio base para el calculo del precio final. Considerar ademas la/s
	 * interfaces aplicadas a cada tipo de planta, las cuales modifican el precio
	 * final de la planta
	 */

	public abstract Double obtenerPrecio();

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	public TipoDePlanta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDePlanta tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
