package OrdenamientoAndLista;

public class ItemVenta {
    private String codigoProducto;
    private double precioVenta;
    private double cantidad;
    private double valorDescuento;

    public ItemVenta(String codigoProducto, double precioVenta, double cantidad, double valorDescuento) {
        this.codigoProducto = codigoProducto;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.valorDescuento = valorDescuento;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getValorTotal() {
        double valorSinIVA = (precioVenta - valorDescuento) * cantidad;
        double valorIVA = valorSinIVA * 0.19; // Suponiendo que el IVA es del 19%
        return valorSinIVA + valorIVA;
    }
}
