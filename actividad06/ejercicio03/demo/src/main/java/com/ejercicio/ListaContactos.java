package com.ejercicio;

import java.util.Vector;

public class ListaContactos {

	Vector<Contacto> lista;

	public ListaContactos() {
		lista = new Vector<>();
	}

	void agregarContacto(Contacto contacto) {
		lista.add(contacto);
	}
}
