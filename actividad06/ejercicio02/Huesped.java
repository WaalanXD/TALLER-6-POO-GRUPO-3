package actividad06.ejercicio02;

public class Huesped {

    private String nombre;
    private String apellidos;
    private int documentoIdentidad;
    private String fechaIngreso;
    private String fechaSalida;

    public Huesped(String nombre, String apellidos, int documentoIdentidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int obtenerDiasAlojamiento() {
        if (fechaIngreso == null || fechaSalida == null) {
            return 0;
        }
        return 0;
    }
}
