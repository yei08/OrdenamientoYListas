package OrdenamientoAndLista;

public class Producto {
    private String codigo;
    private String nombre;
    private String marca;
    private String color;
    private double precioCompra;
    private double precioVenta;
    private double porcentajeDescuentoMaximo;
    private int unidadesEnExistencia;
    private String metricaMedida;
    private String categoria;

    public Producto(String codigo, String nombre, String marca, String color, double precioCompra, double precioVenta, double porcentajeDescuentoMaximo, int unidadesEnExistencia, String metricaMedida, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.porcentajeDescuentoMaximo = porcentajeDescuentoMaximo;
        this.unidadesEnExistencia = unidadesEnExistencia;
        this.metricaMedida = metricaMedida;
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPorcentajeDescuentoMaximo() {
        return porcentajeDescuentoMaximo;
    }

    public void setPorcentajeDescuentoMaximo(double porcentajeDescuentoMaximo) {
        this.porcentajeDescuentoMaximo = porcentajeDescuentoMaximo;
    }

    public int getUnidadesEnExistencia() {
        return unidadesEnExistencia;
    }

    public void setUnidadesEnExistencia(int unidadesEnExistencia) {
        this.unidadesEnExistencia = unidadesEnExistencia;
    }

    public String getMetricaMedida() {
        return metricaMedida;
    }

    public void setMetricaMedida(String metricaMedida) {
        this.metricaMedida = metricaMedida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void actualizarPrecioCompra(double nuevoPrecioCompra) {
        this.precioCompra = nuevoPrecioCompra;
    }

    public void actualizarPrecioVenta() {
        this.precioVenta = 0.4 * precioCompra; // Precio de venta como el 40% del precio de compra
    }

    public void actualizarPorcentajeDescuentoMaximo(double nuevoPorcentaje) {
        this.porcentajeDescuentoMaximo = nuevoPorcentaje;
    }

    public void actualizarUnidadesEnExistencia(double unidadesCompradas) {
        this.unidadesEnExistencia += unidadesCompradas;
    }

    public static void mostrarInformacionProducto(Producto producto) {
        System.out.println("Código del producto: " + producto.getCodigo());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Marca: " + producto.getMarca());
        System.out.println("Color: " + producto.getColor());
        System.out.println("Precio de compra: " + producto.getPrecioCompra());
        System.out.println("Precio de venta: " + producto.getPrecioVenta());
        System.out.println("Porcentaje máximo de descuento: " + producto.getPorcentajeDescuentoMaximo());
        System.out.println("Unidades en existencia: " + producto.getUnidadesEnExistencia());
        System.out.println("Métricas de medida: " + producto.getMetricaMedida());
        System.out.println("Categoría: " + producto.getCategoria());
        System.out.println("-----------------------------");
    }
   
    public void actualizarCantidadExistente(int cantidadVendida) {
        if (unidadesEnExistencia >= cantidadVendida) {
            unidadesEnExistencia -= cantidadVendida;
        } else {
            // Manejar caso de cantidad insuficiente
            System.out.println("No hay suficientes unidades para vender.");
        }
    }

    public void disminuirExistencias(int cantidadVendida) {
        if (cantidadVendida <= unidadesEnExistencia) {
            unidadesEnExistencia -= cantidadVendida;
        } else {
            // Manejar el caso de que la cantidad vendida sea mayor que las existencias disponibles.
            System.out.println("Error: No hay suficientes unidades en existencia para la venta.");
        }
    }
}
