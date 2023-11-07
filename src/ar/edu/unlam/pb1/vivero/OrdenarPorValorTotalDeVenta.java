package ar.edu.unlam.pb1.vivero;

import java.util.Comparator;

public class OrdenarPorValorTotalDeVenta implements Comparator<Venta>{

	@Override
	public int compare(Venta o1, Venta o2) {
		// TODO Auto-generated method stub
		return o1.getPrecioFinal().compareTo(o2.getPrecioFinal());
	}

}
