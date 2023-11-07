package ar.edu.unlam.pb1.vivero;

public class Hierba extends Planta {

	private final double gananciaHierbaMata = 1.2;
	private Double precio;
	private TipoDePlanta tipo;

	public Hierba(Integer codigo, String nombre, Double precio, Integer stock) {
		super(codigo, nombre, precio, stock);
		// TODO Auto-generated constructor stub
		tipo = TipoDePlanta.HIERBA;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public TipoDePlanta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDePlanta tipo) {
		this.tipo = tipo;
	}

	public double getGananciaHierbaMata() {
		return gananciaHierbaMata;
	}

	@Override
	public Double obtenerPrecio() {
		// TODO Auto-generated method stub
		Double precioHierba = getPrecio();
		return precioHierba += precio * gananciaHierbaMata;
	}
}
