package OrdenamientoAndLista;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String genero;
    private String fechaNacimiento;
    private String numeroTelefonico;
    private String email;
    private String direccion;
    private boolean esVIP;
    private List<Venta> ventasRealizadas;
        
    public Cliente(String cedula, String nombre, String apellido1, String apellido2, String genero,
            String fechaNacimiento,
            String numeroTelefonico, String email, String direccion, boolean esVIP) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
        this.direccion = direccion;
        this.esVIP = esVIP;
        this.ventasRealizadas = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Venta> getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(List<Venta> ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public boolean isEsVIP() {
        return esVIP;
    }

    public void setEsVIP(boolean esVIP) {
        this.esVIP = esVIP;
    }

    public void registrarVenta(Venta venta) {
        ventasRealizadas.add(venta);
    }

    public double calcularTotalCompras() {
        double totalCompras = 0;
        for (Venta venta : ventasRealizadas) {
            // Sumar el valor total de cada venta
            totalCompras += venta.calcularValorTotal();
        }
        return totalCompras;
    }

    public void informarDescuento(double porcentajeDescuento) {
        // implementando la lógica para informar al cliente sobre el descuento
        if (porcentajeDescuento == 10) {
            System.out.println("Cliente " + nombre + " tiene un 10% de descuento en su próxima compra.");
        } else if (porcentajeDescuento == 15) {
            System.out.println("Cliente " + nombre + " tiene un 15% de descuento en su próxima compra.");
        } else if (porcentajeDescuento == 25) {
            System.out.println("Cliente " + nombre + " tiene un 25% de descuento en su primera compra.");
        }
    }

    public String getNombre() {
        return null;
    }
}
