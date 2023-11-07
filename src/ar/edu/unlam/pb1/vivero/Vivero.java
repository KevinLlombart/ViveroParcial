package ar.edu.unlam.pb1.vivero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Vivero {

	/**
	 * Se deberan realizar los siguientes tests
	 * 
	 * - 1 test para el metodo agregarPlanta() que arroje la excepcion de validacion
	 * - 1 test para el metodo venderPlanta() que arroje una excepcion a eleccion -
	 * 1 test para el metodo
	 * obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta() - 1 test
	 * para el metodo obtenerReporteDePlantasAgrupadasPorTipo() - 1 test para el
	 * metodo obtenerTodasLasPlantasFlorales() - 1 test para el metodo
	 * obtenerPrecio() de la clase Planta - 1 test para el metodo obtenerPrecio() de
	 * alguna clase que implemente la interfaz Florales en estado de floracion - 1
	 * test para el metodo obtenerPrecio() de alguna clase que implemente la
	 * interfaz Florales en estado de produccion
	 */

	private String nombre;

	// No se pueden registrar plantas duplicadas. 2 plantas son iguales cuando tiene
	// el mismo Id
	private Set<Planta> plantas;
	private List<Venta> ventas;

	public Vivero(String nombre) {
		this.nombre = nombre;
		this.plantas = new HashSet<>();
		this.ventas = new ArrayList<>();
	}

	// No puede haber 2 plantas con el mismo Id , Si se duplica lanza una Exception
	// Planta Duplicada Exception
	public Boolean agregarPlanta(Planta planta) throws PlantaDuplicadaException {
		if (plantas.add(planta)) {
			return true;
		}
		throw new PlantaDuplicadaException();
	}

	/*
	 * Registra una venta y descuenta del stock de la planta la cantidad deseada. Si
	 * no se encuentra la planta lanza una exception Planta Inexistente. Si no hay
	 * Stock Lanza Una Exception ProdutoSinStockException
	 */

	public Planta buscarPlanta(Integer codigo) {
		Planta plantaBuscada = null;
		for (Planta planta : plantas) {
			if (planta.getCodigo().equals(codigo)) {
				plantaBuscada = planta;
			}
		}
		return plantaBuscada;
	}

	public Boolean seEncuentraPlanta(Integer codigo) throws PlantaInexistenteException {
		Planta plantaBuscada = buscarPlanta(codigo);
		if (plantaBuscada != null) {
			return true;
		}
		throw new PlantaInexistenteException();
	}

	public Boolean hayStock(Integer codigo, Integer cantidadAVender) throws ProdutoSinStockException {
		Planta plantaBuscada = buscarPlanta(codigo);
		if (cantidadAVender <= plantaBuscada.getStock()) {
			return true;
		}
		throw new ProdutoSinStockException();

	}

	public Integer idIncremetalDeVentas() {
		Integer id = 0;
		return id = id + 1;
	}

	public void venderPlanta(Integer codigoPlanta, Integer cantidadAVender)
			throws PlantaInexistenteException, ProdutoSinStockException {
		Planta plantaBuscada = buscarPlanta(codigoPlanta);
		if (seEncuentraPlanta(codigoPlanta) && hayStock(codigoPlanta, cantidadAVender)) {
			ventas.add(
					new Venta(idIncremetalDeVentas(), cantidadAVender, plantaBuscada, plantaBuscada.obtenerPrecio()));
					plantaBuscada.setStock(plantaBuscada.getStock() - cantidadAVender);
		}
	}

	/*
	 * Obtener un listado de todos los arboles vendidos ordenados por el total de
	 * venta (Cantidad * precioDeLaPlanta)
	 * 
	 */
	public TreeSet<Venta> obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta() {

		TreeSet<Venta> arbolesOrdenadosPorVenta = new TreeSet<>(new OrdenarPorValorTotalDeVenta());

		for (Venta venta : ventas) {
			if (venta.getPlanta() instanceof Florales) {
				arbolesOrdenadosPorVenta.add(venta);
			}
		}

		return arbolesOrdenadosPorVenta;
	}

	/*
	 * Obtener Un reporte de las plantas vendidas agrupados por tipo Plantas
	 * 
	 * 
	 * Ejemplo: para una key "arbol", debemos completar las plantas de este tipo
	 * 
	 */

	public Map<String, Planta> obtenerReporteDePlantasAgrupadasPorTipo() {

		Map<String, Planta> plantasAgrupadas = new HashMap<String, Planta>();

		for (Map.Entry<String, Planta> entry : plantasAgrupadas.entrySet()) {
			String key = entry.getKey();
			Planta val = entry.getValue();
			if (entry.getValue().getTipo().equals(TipoDePlanta.ARBUSTO)) {
				plantasAgrupadas.put("Arbusto", val);
			} else if (entry.getValue().getTipo().equals(TipoDePlanta.ARBOL)) {
				plantasAgrupadas.put("Arbol", val);
			} else if (entry.getValue().getTipo().equals(TipoDePlanta.HIERBA)) {
				plantasAgrupadas.put("Hierba", val);
			}

		}
		return plantasAgrupadas;
	}

	/**
	 * Obtener una lista de plantas que implementen la interfaz correspondiente
	 */
	public List<Florales> obtenerTodasLasPlantasFlorales() {

		List<Florales> listaFlorales = new ArrayList<>();

		for (Planta florales : plantas) {
			if (florales instanceof Florales) {
				listaFlorales.add((Florales) florales);
			}
		}
		return listaFlorales;
	}
}
