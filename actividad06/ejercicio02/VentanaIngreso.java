package actividad06.ejercicio02;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class VentanaIngreso extends JFrame implements ActionListener {

    private Hotel hotel;
    private int numeroHabitacion;
    private JTextField campoFecha;
    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoDocumento;
    private JButton aceptar;
    private JButton cancelar;

    public VentanaIngreso(Hotel hotel, int numeroHabitacion) {
        this.hotel = hotel;
        this.numeroHabitacion = numeroHabitacion;
        setTitle("Ingreso");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        inicio();
    }

    private void inicio() {
        Container c = getContentPane();
        c.setLayout(new GridLayout(6, 2));

        c.add(new JLabel("Habitacion: " + numeroHabitacion));
        c.add(new JLabel(""));
        c.add(new JLabel("Fecha (aaaa-mm-dd):"));
        campoFecha = new JTextField();
        c.add(campoFecha);
        c.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        c.add(campoNombre);
        c.add(new JLabel("Apellidos:"));
        campoApellidos = new JTextField();
        c.add(campoApellidos);
        c.add(new JLabel("Doc. Identidad:"));
        campoDocumento = new JTextField();
        c.add(campoDocumento);

        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
        aceptar.addActionListener(this);
        cancelar.addActionListener(this);
        c.add(aceptar);
        c.add(cancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar) {
            Habitacion habitacion = hotel.buscarHabitacionPorNumero(numeroHabitacion);
            if (habitacion == null || !habitacion.isDisponible()) {
                JOptionPane.showMessageDialog(this, "Habitacion no disponible", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                String fechaStr = campoFecha.getText();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = formato.parse(fechaStr);
                Huesped h = new Huesped(campoNombre.getText(), campoApellidos.getText(), Integer.parseInt(campoDocumento.getText()));
                h.setFechaIngreso(formato.format(fecha));
                habitacion.setHuesped(h);
                habitacion.setDisponible(false);
                JOptionPane.showMessageDialog(this, "El huesped ha sido registrado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "La fecha no esta en el formato solicitado", "Mensaje", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de numero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == cancelar) {
            setVisible(false);
        }
    }
}
