package ar.edu.unlam.pb1.vivero;

public class Venta {

	private Integer id;
	private Integer unidades;
	private Planta planta;
	public Double precioUnitario; // Precio final de la planta al momento de realizar la venta
	public Double precioFinal = 0.0;

	public Venta(Integer id, Integer unidades, Planta planta, Double precioUnitario) {
		super();
		this.id = id;
		this.unidades = unidades;
		this.planta = planta;
		this.precioUnitario = precioUnitario;
		this.precioFinal = getPrecioFinal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Double getPrecioFinal() {
		return precioFinal = unidades * precioUnitario;
	}

	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}

}
