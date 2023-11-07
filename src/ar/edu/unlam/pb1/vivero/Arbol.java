package ar.edu.unlam.pb1.vivero;

public class Arbol extends Planta implements Florales {

	private final double GANANCIA_ARBOL = 2.3;
	private Double estadoFloracion = 0.0;
	private Integer madurezFrutos = 0;
	private TipoDePlanta tipo;
	private Double precio = 0.0;

	public Arbol(Integer codigo, String nombre, Double precio, Integer stock) {
		super(codigo, nombre, precio, stock);
		// TODO Auto-generated constructor stub
		tipo = TipoDePlanta.ARBOL;
		this.precio = precio;
	}

	@Override
	public void florar() {
		// TODO Auto-generated method stub
		if (getEstadoFloracion() <= 100) {
			Double floracion = 20.0;
			setEstadoFloracion(estadoFloracion + floracion);
		}
	}

	@Override
	public void producirFrutos() {
		// TODO Auto-generated method stub
		if (getEstadoFloracion() > 100 && getMadurezFrutos() < 5) {
			Integer madurezDeFrutos = 1;
			setMadurezFrutos(madurezFrutos + madurezDeFrutos);
		}

	}

	public Double getEstadoFloracion() {
		return estadoFloracion;
	}

	public void setEstadoFloracion(Double estadoFloracion) {
		this.estadoFloracion = estadoFloracion;
	}

	public Integer getMadurezFrutos() {
		return madurezFrutos;
	}

	public void setMadurezFrutos(Integer madurezFrutos) {
		this.madurezFrutos = madurezFrutos;
	}

	public TipoDePlanta getTipo() {
		return tipo;
	}

	public void setTipo(TipoDePlanta tipo) {
		this.tipo = tipo;
	}

	public double getGANANCIA_ARBOL() {
		return GANANCIA_ARBOL;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	@Override
	public Double obtenerPrecio() {
		// TODO Auto-generated method stub
		Double precioArbol = getPrecio();
		precioArbol += GANANCIA_ARBOL * precio;
		
		if(getEstadoFloracion() < 33) {
			precioArbol += getPrecio() * 0.05;
		}else if(getEstadoFloracion() < 66 && getEstadoFloracion() > 34) {
			precioArbol += getPrecio() * 0.75;
		}else if(getEstadoFloracion() < 100 && getEstadoFloracion() > 66) {
			precioArbol += getPrecio() * 0.85;
		}else if(getEstadoFloracion() > 100) {
			precioArbol += ((getPrecio() * 0.85) + (getPrecio() * 0.10) + getPrecio() * 0.03);
		}
		return precioArbol;	
	}

	/**
	 * Los arboles pueden dar flores, las que posteriormente se convertiran en
	 * frutos. Las flores tienen un rango de crecimiento, siendo 0 (el valor
	 * inicial) cuando no tiene flores aun y 100 cuando ya estan aptas para dar
	 * frutos. El precio del arbol se incrementa de acuerdo al avance de la
	 * floracion: - Menos de 33% de floracion incrementa un 5% su precio. - Entre
	 * 34% y 66% incrementa un 7.5% su precio. - Mas del 66% y menos de 100%
	 * incrementa un 8.5% su precio. - Cuando el estado de floracion llega al 100%,
	 * se comienza la produccion de frutos
	 */

	/**
	 * Para poder producir frutos, el estado de floracion debe ser 100%. La
	 * produccion de frutos se mide entre 1 y 5 siendo 5 el mejor escenario. Cuando
	 * un arbol produce frutos, su precio aumenta 10% inicialmente (por tener el
	 * estado de floracion al 100%) y agrega al precio, el porcentaje de madurez.
	 * Ejemplo: precioBase = 100 + 10% (por floracion) + 3% (madurez actual de los
	 * frutos)
	 */
}
