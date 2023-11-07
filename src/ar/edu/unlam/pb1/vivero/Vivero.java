package ar.edu.unlam.pb1.vivero;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Vivero {
	
	/**
	 * Se deberan realizar los siguientes tests
	 * 
	 * - 1 test para el metodo agregarPlanta() que arroje la excepcion de validacion
	 * - 1 test para el metodo venderPlanta() que arroje una excepcion a eleccion
	 * - 1 test para el metodo obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta()
	 * - 1 test para el metodo obtenerReporteDePlantasAgrupadasPorTipo()
	 * - 1 test para el metodo obtenerTodasLasPlantasFlorales()
	 * - 1 test para el metodo obtenerPrecio() de la clase Planta 
	 * - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la interfaz Florales en estado de floracion
	 * - 1 test para el metodo obtenerPrecio() de alguna clase que implemente la interfaz Florales en estado de produccion
	 * */

	private String nombre;

	// No se pueden registrar plantas duplicadas. 2 plantas son iguales cuando tiene
	// el mismo Id
	private _____<Planta> plantas;
	private List<Planta> ventas;

	public Vivero(String nombre) {
	}

	// No puede haber 2 plantas con el mismo Id , Si se duplica lanza una Exception
	// Planta Duplicada Exception
	public Boolean agregarPlanta(Planta planta) {
		return false;
	}

	/*
	 * Registra una venta y descuenta del stock de la planta la cantidad deseada. Si no se encuentra la planta lanza
	 * una exception Planta Inexistente. Si no hay Stock Lanza Una Exception
	 * ProdutoSinStockException
	 */
	public void venderPlanta(Integer codigoPlanta, Integer cantidadAVender) {
	}

	/*
	 * Obtener un listado de todos los arboles vendidos ordenados por el total de
	 * venta (Cantidad * precioDeLaPlanta)
	 * 
	 */
	public ______ obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta() {

		return null;
	}

	/*
	 * Obtener Un reporte de las plantas vendidas agrupados por tipo Plantas
	 * 
	 * 
	 * Ejemplo: para una key "arbol", debemos completar las plantas de este tipo
	 * 
	 */

	public Map<String, ______> obtenerReporteDePlantasAgrupadasPorTipo() {
		return null;
	}

	/**
	 * Obtener una lista de plantas que implementen la interfaz correspondiente
	 * */
	public List<Florales> obtenerTodasLasPlantasFlorales() {
	}
}
