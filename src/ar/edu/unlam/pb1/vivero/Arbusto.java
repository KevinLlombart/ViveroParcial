package ar.edu.unlam.pb1.vivero;

public class Arbusto extends Planta {

	private final double GANANCIA_ARBUSTO = 1.6;
	private Double precio;
	private TipoDePlanta tipo;

	public Arbusto(Integer codigo, String nombre, Double precio, Integer stock) {
		super(codigo, nombre, precio, stock);
		// TODO Auto-generated constructor stub
		this.precio = precio;
		tipo = TipoDePlanta.ARBUSTO;
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

	public double getGANANCIA_ARBUSTO() {
		return GANANCIA_ARBUSTO;
	}

	@Override
	public Double obtenerPrecio() {
		// TODO Auto-generated method stub
		Double precioArbusto = getPrecio();
		return precioArbusto += GANANCIA_ARBUSTO * precio;
	}

}
