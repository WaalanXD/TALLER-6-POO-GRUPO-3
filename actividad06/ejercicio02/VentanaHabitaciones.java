package actividad06.ejercicio02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaHabitaciones extends JFrame implements ActionListener {

    private Hotel hotel;
    private JSpinner campoNumero;
    private JButton aceptar;

    public VentanaHabitaciones(Hotel hotel) {
        this.hotel = hotel;
        setTitle("Habitaciones");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        inicio();
    }

    private void inicio() {
        Container cont = getContentPane();
        cont.setLayout(new BorderLayout());

        JPanel panelArriba = new JPanel(new GridLayout(2, 5));
        for (Habitacion h : hotel.listaHabitaciones) {
            String texto = "Habitacion " + h.getNumeroHabitacion() + "\n" + (h.isDisponible() ? "Disponible" : "No disponible");
            panelArriba.add(new JLabel("<html>" + texto.replace("\n", "<br>") + "</html>", SwingConstants.CENTER));
        }
        cont.add(panelArriba, BorderLayout.CENTER);

        JPanel panelAbajo = new JPanel();
        panelAbajo.add(new JLabel("Habitacion a reservar:"));
        campoNumero = new JSpinner(new SpinnerNumberModel(1, 1, hotel.listaHabitaciones.size(), 1));
        panelAbajo.add(campoNumero);
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        panelAbajo.add(aceptar);
        cont.add(panelAbajo, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar) {
            int numero = (Integer) campoNumero.getValue();
            VentanaIngreso vi = new VentanaIngreso(hotel, numero);
            vi.setVisible(true);
            dispose();
        }
    }
}
