package actividad06.ejercicio01;

public class Principal {
    public static void main(String[] args) {
        ListaEmpleados lista = new ListaEmpleados();
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal(lista);
        miVentanaPrincipal.setVisible(true);
        miVentanaPrincipal.setResizable(false);
    }
}