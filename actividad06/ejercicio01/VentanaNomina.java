package actividad06.ejercicio01;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaNomina extends JFrame {
    private Container contenedor;
    private final ListaEmpleados lista;
    private JLabel empleados, nomina;
    private JTable tabla;

    public VentanaNomina(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Nómina de Empleados");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        empleados = new JLabel("Lista de empleados:");
        empleados.setBounds(20, 20, 135, 23);

        String[][] datos = lista.obtenerMatriz();
        String[] titulos = {"NOMBRE", "APELLIDOS", "SUELDO"};
        DefaultTableModel model = new DefaultTableModel(datos, titulos);
        tabla = new JTable(model);
        tabla.setBounds(20, 50, 310, 100);

        nomina = new JLabel();
        nomina.setText(String.format("Total nómina mensual = $ %.2f", lista.totalNómina()));
        nomina.setBounds(20, 160, 250, 23);

        contenedor.add(empleados);
        contenedor.add(tabla);
        contenedor.add(nomina);
    }
}