package actividad06.ejercicio02;

public class Principal {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal(hotel);
        miVentanaPrincipal.setVisible(true);
    }
}
