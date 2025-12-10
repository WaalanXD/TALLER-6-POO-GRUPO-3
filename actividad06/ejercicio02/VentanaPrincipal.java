package actividad06.ejercicio02;

import java.awt.event.*;
import javax.swing.*;
public class VentanaPrincipal extends JFrame implements ActionListener {

    private Hotel hotel;
    private JMenuItem consultarHabitaciones;
    private JMenuItem salidaHuespedes;

    public VentanaPrincipal(Hotel hotel) {
        this.hotel = hotel;
        setTitle("Hotel");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        consultarHabitaciones = new JMenuItem("Consultar habitaciones");
        salidaHuespedes = new JMenuItem("Salida de huespedes");
        consultarHabitaciones.addActionListener(this);
        salidaHuespedes.addActionListener(this);
        menu.add(consultarHabitaciones);
        menu.add(salidaHuespedes);
        barra.add(menu);
        setJMenuBar(barra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == consultarHabitaciones) {
            VentanaHabitaciones vh = new VentanaHabitaciones(hotel);
            vh.setVisible(true);
        } else if (e.getSource() == salidaHuespedes) {
            String input = JOptionPane.showInputDialog(this, "Ingrese numero de habitacion");
            if (input != null && !input.isEmpty()) {
                try {
                    int numero = Integer.parseInt(input);
                    VentanaSalida vs = new VentanaSalida(hotel, numero);
                    vs.setVisible(true);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Numero no valido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
