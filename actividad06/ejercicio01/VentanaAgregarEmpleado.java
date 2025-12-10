package actividad06.ejercicio01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaAgregarEmpleado extends JFrame implements ActionListener {
    private Container contenedor;
    private final ListaEmpleados lista;

    private JLabel nombre, apellidos, cargo, genero, salarioDia, numeroDias,
            otrosIngresos, aportesSalud, pensiones;
    private JTextField campoNombre, campoApellidos, campoSalarioDia,
            campoOtrosIngresos, campoAportesSalud, campoPensiones;
    private JComboBox<String> campoCargo;
    private JSpinner campoNumeroDias;
    private SpinnerNumberModel modeloSpinner;
    private ButtonGroup grupoGenero;
    private JRadioButton masculino, femenino;
    private JButton agregar, limpiar;

    public VentanaAgregarEmpleado(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Agregar Empleado");
        setSize(360, 440);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nombre = new JLabel("Nombre:");
        nombre.setBounds(20, 20, 100, 23);
        campoNombre = new JTextField();
        campoNombre.setBounds(160, 20, 160, 23);

        apellidos = new JLabel("Apellidos:");
        apellidos.setBounds(20, 50, 100, 23);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(160, 50, 160, 23);

        cargo = new JLabel("Cargo:");
        cargo.setBounds(20, 80, 100, 23);
        campoCargo = new JComboBox<>();
        campoCargo.addItem("Directivo");
        campoCargo.addItem("Estratégico");
        campoCargo.addItem("Operativo");
        campoCargo.setBounds(160, 80, 160, 23);

        genero = new JLabel("Género:");
        genero.setBounds(20, 110, 100, 23);
        grupoGenero = new ButtonGroup();
        masculino = new JRadioButton("Masculino", true);
        masculino.setBounds(160, 110, 100, 23);
        femenino = new JRadioButton("Femenino");
        femenino.setBounds(260, 110, 90, 23);
        grupoGenero.add(masculino);
        grupoGenero.add(femenino);

        salarioDia = new JLabel("Salario por día:");
        salarioDia.setBounds(20, 140, 130, 23);
        campoSalarioDia = new JTextField();
        campoSalarioDia.setBounds(160, 140, 160, 23);

        numeroDias = new JLabel("Días trabajados al mes:");
        numeroDias.setBounds(20, 170, 160, 23);
        modeloSpinner = new SpinnerNumberModel();
        modeloSpinner.setMinimum(1);
        modeloSpinner.setMaximum(31);
        modeloSpinner.setValue(30);
        campoNumeroDias = new JSpinner(modeloSpinner);
        campoNumeroDias.setBounds(160, 170, 160, 23);

        otrosIngresos = new JLabel("Otros ingresos:");
        otrosIngresos.setBounds(20, 200, 130, 23);
        campoOtrosIngresos = new JTextField();
        campoOtrosIngresos.setBounds(160, 200, 160, 23);

        aportesSalud = new JLabel("Pagos por salud:");
        aportesSalud.setBounds(20, 230, 130, 23);
        campoAportesSalud = new JTextField();
        campoAportesSalud.setBounds(160, 230, 160, 23);

        pensiones = new JLabel("Aportes pensiones:");
        pensiones.setBounds(20, 260, 130, 23);
        campoPensiones = new JTextField();
        campoPensiones.setBounds(160, 260, 160, 23);

        agregar = new JButton("Agregar");
        agregar.setBounds(20, 320, 100, 23);
        agregar.addActionListener(this);

        limpiar = new JButton("Borrar");
        limpiar.setBounds(130, 320, 100, 23);
        limpiar.addActionListener(this);


        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(cargo);
        contenedor.add(campoCargo);
        contenedor.add(genero);
        contenedor.add(masculino);
        contenedor.add(femenino);
        contenedor.add(salarioDia);
        contenedor.add(campoSalarioDia);
        contenedor.add(numeroDias);
        contenedor.add(campoNumeroDias);
        contenedor.add(otrosIngresos);
        contenedor.add(campoOtrosIngresos);
        contenedor.add(aportesSalud);
        contenedor.add(campoAportesSalud);
        contenedor.add(pensiones);
        contenedor.add(campoPensiones);
        contenedor.add(agregar);
        contenedor.add(limpiar);
    }

    private void limpiarCampos() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoSalarioDia.setText("");
        campoNumeroDias.setValue(30);
        campoOtrosIngresos.setText("");
        campoAportesSalud.setText("");
        campoPensiones.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == agregar) {
            añadirEmpleado();
        } else if (src == limpiar) {
            limpiarCampos();
        }
    }

    private void añadirEmpleado() {
        try {
            String v1 = campoNombre.getText();
            String v2 = campoApellidos.getText();
            double v3 = Double.parseDouble(campoSalarioDia.getText());
            int v4 = (Integer) campoNumeroDias.getValue();
            double v5 = Double.parseDouble(campoOtrosIngresos.getText());
            double v6 = Double.parseDouble(campoAportesSalud.getText());
            double v7 = Double.parseDouble(campoPensiones.getText());

            String seleccionado = (String) campoCargo.getSelectedItem();
            tipoCargo cargoSel;
            if ("Directivo".equals(seleccionado)) {
                cargoSel = tipoCargo.DIRECTIVO;
            } else if ("Estratégico".equals(seleccionado)) {
                cargoSel = tipoCargo.ESTRATEGICO;
            } else {
                cargoSel = tipoCargo.OPERATIVO;
            }

            tipoGenero generoSel = masculino.isSelected() ? tipoGenero.MASCULINO : tipoGenero.FEMENINO;

            Empleado emp = new Empleado(v1, v2, v3, v5, v6, v7, v4, cargoSel, generoSel);
            lista.agregarEmpleado(emp);
            JOptionPane.showMessageDialog(this, "El empleado ha sido agregado", "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}