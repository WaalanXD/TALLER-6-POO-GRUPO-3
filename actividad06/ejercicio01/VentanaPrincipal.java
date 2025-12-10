package actividad06.ejercicio01;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private final ListaEmpleados lista;
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemAgregar, itemVerNomina, itemGuardarArchivo;

    public VentanaPrincipal(ListaEmpleados lista) {
        this.lista = lista;
        setTitle("Nómina");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        construirMenu();
    }

    private void construirMenu() {
        barraMenu = new JMenuBar();
        menu = new JMenu("Menú");

        itemAgregar = new JMenuItem("Agregar empleado");
        itemVerNomina = new JMenuItem("Calcular nómina");
        itemGuardarArchivo = new JMenuItem("Guardar archivo");

        itemAgregar.addActionListener(this);
        itemVerNomina.addActionListener(this);
        itemGuardarArchivo.addActionListener(this);

        menu.add(itemAgregar);
        menu.add(itemVerNomina);
        menu.add(itemGuardarArchivo);

        barraMenu.add(menu);
        setJMenuBar(barraMenu);
        getContentPane().setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == itemAgregar) {
            new VentanaAgregarEmpleado(lista).setVisible(true);
        } else if (src == itemVerNomina) {
            new VentanaNomina(lista).setVisible(true);
        } else if (src == itemGuardarArchivo) {
            guardarArchivo();
        }
    }

    private void guardarArchivo() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar nómina");
        int resp = chooser.showSaveDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                for (Empleado e : lista.obtenerLista()) {
                    pw.printf("Nombre = %s%n", e.getNombre());
                    pw.printf("Apellidos = %s%n", e.getApellidos());
                    pw.printf("Cargo = %s%n", mostrarCargo(e.getCargo()));
                    pw.printf("Género = %s%n", mostrarGenero(e.getGenero()));
                    pw.printf("Salario = $%s%n", formMonto(e.getSalarioDía()));
                    pw.printf("Días trabajados = %d%n", e.getDíasTrabajados());
                    pw.printf("Otros ingresos = $%s%n", formMonto(e.getOtrosIngresos()));
                    pw.printf("Pagos salud = $%s%n", formMonto(e.getPagosSalud()));
                    pw.printf("Aportes pensiones = $%s%n", formMonto(e.getAportePensiones()));
                    pw.println("---------");
                    pw.println();
                }
                pw.printf("Total nómina = $%s%n", String.format("%.2f", lista.totalNómina()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar archivo", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "El archivo se guardó correctamente", "Mensaje",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String formMonto(double v) {
        return String.format("%.1f", v);
    }

    private String mostrarCargo(tipoCargo c) {
        switch (c) {
            case DIRECTIVO:
                return "DIRECTIVO";
            case ESTRATEGICO:
                return "ESTRATÉGICO";
            case OPERATIVO:
            default:
                return "OPERATIVO";
        }
    }

    private String mostrarGenero(tipoGenero g) {
        switch (g) {
            case MASCULINO:
                return "MASCULINO";
            case FEMENINO:
                return "FEMENINO";
            default:
                return "OTRO";
        }
    }
}