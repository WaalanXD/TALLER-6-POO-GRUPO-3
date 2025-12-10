package actividad06.ejercicio01;

public class Empleado {
    private String nombre;
private String apellidos;
private double salarioDía; 
private double otrosIngresos;
private double pagosSalud; 
private double aportePensiones;

private int díasTrabajados;
private tipoCargo cargo;
private tipoGenero genero;

public Empleado(String nombre, String apellidos, double salarioDía, double otrosIngresos,
        double pagosSalud, double aportePensiones, int díasTrabajados, tipoCargo cargo, tipoGenero genero) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.salarioDía = salarioDía;
    this.otrosIngresos = otrosIngresos;
    this.pagosSalud = pagosSalud;
    this.aportePensiones = aportePensiones;
    this.díasTrabajados = díasTrabajados;
    this.cargo = cargo;
    this.genero = genero;
}

public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getApellidos() {
    return apellidos;
}
public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
}
public double getSalarioDía() {
    return salarioDía;
}
public void setSalarioDía(double salarioDía) {
    this.salarioDía = salarioDía;
}
public double getOtrosIngresos() {
    return otrosIngresos;
}
public void setOtrosIngresos(double otrosIngresos) {
    this.otrosIngresos = otrosIngresos;
}
public double getPagosSalud() {
    return pagosSalud;
}
public void setPagosSalud(double pagosSalud) {
    this.pagosSalud = pagosSalud;
}
public double getAportePensiones() {
    return aportePensiones;
}
public void setAportePensiones(double aportePensiones) {
    this.aportePensiones = aportePensiones;
}
public int getDíasTrabajados() {
    return díasTrabajados;
}
public void setDíasTrabajados(int díasTrabajados) {
    this.díasTrabajados = díasTrabajados;
}
public tipoCargo getCargo() {
    return cargo;
}
public void setCargo(tipoCargo cargo) {
    this.cargo = cargo;
}
public tipoGenero getGenero() {
    return genero;
}
public void setGenero(tipoGenero genero) {
    this.genero = genero;
}

public double calcularNómina() {
return ((salarioDía * díasTrabajados) + otrosIngresos -
pagosSalud - aportePensiones);
}

}