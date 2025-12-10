package actividad06.ejercicio02;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class VentanaSalida extends JFrame implements ActionListener {

    private Hotel hotel;
    private int numeroHabitacion;

    private JLabel etiquetaCantidadDias;
    private JLabel etiquetaTotal;
    private JTextField campoFechaSalida;
    private JButton calcular;
    private JButton registrarSalida;

    private Habitacion habitacionOcupada;
    private int posicionHabitacion;

    public VentanaSalida(Hotel hotel, int numero) {
        this.hotel = hotel;
        this.numeroHabitacion = numero;
        setTitle("Salida huespedes");
        setSize(320, 260);
        setLocationRelativeTo(null);
        setResizable(false);
        inicio();
    }

    private void inicio() {
        Container contenedor = getContentPane();
        contenedor.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3, 3, 3, 3);
        c.fill = GridBagConstraints.HORIZONTAL;

        JLabel habitacion = new JLabel("Habitacion: " + numeroHabitacion);
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        contenedor.add(habitacion, c);

        JLabel fechaIngreso = new JLabel();
        String fecha = buscarFechaIngresoHabitacion(numeroHabitacion);
        fechaIngreso.setText("Fecha de ingreso: " + fecha);
        c.gridy = 1;
        contenedor.add(fechaIngreso, c);

        JLabel fechaSalida = new JLabel("Fecha de salida (aaaa-mm-dd):");
        c.gridy = 2; c.gridwidth = 1;
        contenedor.add(fechaSalida, c);

        campoFechaSalida = new JTextField(12);
        c.gridx = 1;
        contenedor.add(campoFechaSalida, c);

        calcular = new JButton("Calcular");
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        contenedor.add(calcular, c);
        calcular.addActionListener(this);

        etiquetaCantidadDias = new JLabel("Cantidad de dias: ");
        c.gridy = 4;
        contenedor.add(etiquetaCantidadDias, c);

        etiquetaTotal = new JLabel("Total: $");
        c.gridy = 5;
        contenedor.add(etiquetaTotal, c);

        registrarSalida = new JButton("RegistrarSalida");
        c.gridy = 6;
        contenedor.add(registrarSalida, c);
        registrarSalida.addActionListener(this);
        registrarSalida.setEnabled(false);
    }

    private String buscarFechaIngresoHabitacion(int numero) {
        for (int i = 0; i < hotel.listaHabitaciones.size(); i++) {
            Habitacion h = hotel.listaHabitaciones.get(i);
            if (h.getNumeroHabitacion() == numero) {
                habitacionOcupada = h;
                posicionHabitacion = i;
                if (h.getHuesped() != null) {
                    return h.getHuesped().getFechaIngreso();
                }
            }
        }
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            String fechaS = campoFechaSalida.getText();
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha2 = formato.parse(fechaS);
                habitacionOcupada.getHuesped().setFechaSalida(formato.format(fecha2));
                Date fecha1 = formato.parse(habitacionOcupada.getHuesped().getFechaIngreso());
                if (fecha1.compareTo(fecha2) < 0) {
                    long diff = fecha2.getTime() - fecha1.getTime();
                    int cantidad = (int) (diff / (1000 * 60 * 60 * 24));
                    etiquetaCantidadDias.setText("Cantidad de dias: " + cantidad);
                    double total = cantidad * habitacionOcupada.getPrecioDia();
                    etiquetaTotal.setText("Total: $" + total);
                    registrarSalida.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "La fecha de salida es menor que la de ingreso", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "La fecha no esta en el formato solicitado", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else if (evento.getSource() == registrarSalida) {
            habitacionOcupada.setHuesped(null);
            habitacionOcupada.setDisponible(true);
            hotel.listaHabitaciones.set(posicionHabitacion, habitacionOcupada);
            JOptionPane.showMessageDialog(this, "Se ha registrado la salida del huesped", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        }
    }
}
