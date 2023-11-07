package ar.edu.unlam.pb1.vivero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

public class TestVivero {

//	1 test para el metodo agregarPlanta() que arroje la excepcion de validacion
//	 * - 1 test para el metodo venderPlanta() que arroje una excepcion a eleccion -
//	 * 1 test para el metodo
//	 * obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta() - 1 test
//	 * para el metodo obtenerReporteDePlantasAgrupadasPorTipo() - 1 test para el
//	 * metodo obtenerTodasLasPlantasFlorales() - 1 test para el metodo
//	 * obtenerPrecio() de la clase Planta - 1 test para el metodo obtenerPrecio() de
//	 * alguna clase que implemente la interfaz Florales en estado de floracion - 1
//	 * test para el metodo obtenerPrecio() de alguna clase que implemente la
//	 * interfaz Florales en estado de produccion

	@Test
	public void QueSePuedaAgregarPlanta() throws PlantaDuplicadaException {
		Vivero vivero = new Vivero("vivero");
		Planta planta = new Arbusto(1, "sakura", 120.50, 3);

		assertNotNull(vivero.agregarPlanta(planta));
	}

	@Test(expected = ProdutoSinStockException.class)
	public void QueNoSePuedaVenderPlantaSiNoHayStock()
			throws PlantaDuplicadaException, PlantaInexistenteException, ProdutoSinStockException {
		Vivero vivero = new Vivero("vivero");
		Planta planta = new Arbusto(1, "sakura", 120.50, 3);

		vivero.agregarPlanta(planta);
		vivero.venderPlanta(1, 4);

	}

	@Test
	public void obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta()
			throws PlantaDuplicadaException, PlantaInexistenteException, ProdutoSinStockException {
		Vivero vivero = new Vivero("vivero");
		Planta planta1 = new Arbol(1, "sakura", 120.00, 3);
		Planta planta2 = new Arbol(2, "sakura", 120.00, 3);
		Planta planta3 = new Arbol(3, "sakura", 120.00, 3);

		vivero.agregarPlanta(planta1);
		vivero.agregarPlanta(planta2);
		vivero.agregarPlanta(planta3);

		vivero.venderPlanta(1, 1);
		vivero.venderPlanta(2, 2);
		vivero.venderPlanta(3, 3);

		TreeSet<Venta> arboles = vivero.obtenerTodasLasVentasDeArbolesOrdenadosPorElValorTotalDeLaVenta();

		Integer firts = arboles.first().getPlanta().getCodigo();
		Integer last = arboles.last().getPlanta().getCodigo();

		assertEquals((Integer) 1, firts);
		assertEquals((Integer) 3, last);

	}

	@Test
	public void obtenerReporteDePlantasAgrupadasPorTipo()
			throws PlantaDuplicadaException, PlantaInexistenteException, ProdutoSinStockException {
		Vivero vivero = new Vivero("vivero");
		Planta planta1 = new Arbol(1, "sakura", 120.50, 3);
		Planta planta2 = new Arbusto(2, "sakura", 150.50, 3);
		Planta planta3 = new Hierba(3, "sakura", 180.00, 3);

		vivero.agregarPlanta(planta1);
		vivero.agregarPlanta(planta2);
		vivero.agregarPlanta(planta3);

		Map<String, Planta> plantasAgrupadas = vivero.obtenerReporteDePlantasAgrupadasPorTipo();

		for (Map.Entry<String, Planta> entry : plantasAgrupadas.entrySet()) {
			String key = entry.getKey();
			Planta val = entry.getValue();
			if (entry.getKey().equals("Hierba")) {
				assertEquals(val.getCodigo(), planta3.getCodigo());
			} else if (entry.getKey().equals("Arbusto")) {
				assertEquals(val.getCodigo(), planta2.getCodigo());

			} else if (entry.getKey().equals("Arbol")) {
				assertEquals(val.getCodigo(), planta1.getCodigo());
			}

		}
	}

	@Test
	public void obtenerReporteDePlantasFlorales()
			throws PlantaDuplicadaException, PlantaInexistenteException, ProdutoSinStockException {
		
		Vivero vivero = new Vivero("vivero");
		Planta planta1 = new Arbol(1, "sakura", 120.50, 3);
		Planta planta2 = new Arbusto(2, "sakura", 150.50, 3);
		Planta planta3 = new Hierba(3, "sakura", 180.00, 3);
		Planta planta4 = new Arbol(4, "sakura", 180.00, 3);

		vivero.agregarPlanta(planta1);
		vivero.agregarPlanta(planta2);
		vivero.agregarPlanta(planta3);
		vivero.agregarPlanta(planta4);
		
		List<Florales> listaFlorales = vivero.obtenerTodasLasPlantasFlorales();
		
		Integer vo = ((Arbol)listaFlorales.get(0)).getCodigo();
		Integer vo2 = ((Arbol)listaFlorales.get(1)).getCodigo();
		
		assertEquals((Integer)1, vo);
		assertEquals((Integer)4, vo2);
		

	}
}
