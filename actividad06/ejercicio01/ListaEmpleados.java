package actividad06.ejercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaEmpleados {
    private final List<Empleado> empleados;

    public ListaEmpleados() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        if (e == null) {
            throw new IllegalArgumentException("Empleado nulo");
        }
        empleados.add(e);
    }

    public String[][] obtenerMatriz() {
        String[][] datos = new String[empleados.size()][3];
        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);
            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidos();
            datos[i][2] = String.format("%.2f", e.calcularNómina());
        }
        return datos;
    }

    public double totalNómina() {
        double total = 0.0;
        for (Empleado e : empleados) {
            total += e.calcularNómina();
        }
        return total;
    }

    public List<Empleado> obtenerLista() {
        return Collections.unmodifiableList(empleados);
    }
}