package actividad06.ejercicio02;

import java.util.ArrayList;
public class Hotel {

	ArrayList<Habitacion> listaHabitaciones;

	public Hotel() {
		listaHabitaciones = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			Habitacion h = new Habitacion(i, true, 120000);
			listaHabitaciones.add(h);
		}
	}

	public Habitacion buscarHabitacionPorNumero(int numero) {
		for (Habitacion h : listaHabitaciones) {
			if (h.getNumeroHabitacion() == numero) {
				return h;
			}
		}
		return null;
	}
}

