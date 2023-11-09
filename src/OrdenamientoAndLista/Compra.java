package OrdenamientoAndLista;

public class Compra {
    private int consecutivo;
    private String fecha;
    private String proveedor;
    private String codigoProducto;
    private double precioCompra;
    private double cantidad;
    private double valorSinIVA;
    private double valorIVA;
    private double valorTotal;
    private double porcentajeDescuentoMaximo;

    public Compra(int consecutivo, String fecha, String proveedor, String codigoProducto, double precioCompra, double cantidad, double porcentajeDescuentoMaximo) {
        this.consecutivo = consecutivo;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.codigoProducto = codigoProducto;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.porcentajeDescuentoMaximo = porcentajeDescuentoMaximo; // Inicializar el porcentaje de descuento máximo
        calcularValores();
    }

    private void calcularValores() {
        valorSinIVA = precioCompra * cantidad;
        valorIVA = valorSinIVA * 0.19; // IVA del 19%
        valorTotal = valorSinIVA + valorIVA;
    }

    public MiListaPersonalizada obtenerCompraComoLista() {
        MiListaPersonalizada listaCompra = new MiListaPersonalizada();
        listaCompra.agregar(consecutivo);
        listaCompra.agregar(fecha);
        listaCompra.agregar(proveedor);
        listaCompra.agregar(codigoProducto);
        listaCompra.agregar(precioCompra);
        listaCompra.agregar(cantidad);
        listaCompra.agregar(valorSinIVA);
        listaCompra.agregar(valorIVA);
        listaCompra.agregar(valorTotal);
        return listaCompra;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getValorSinIVA() {
        return valorSinIVA;
    }

    public double getValorIVA() {
        return valorIVA;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void actualizarProductoEnLibreta(MiListaPersonalizada listaProductos) {
        // Buscar el producto por su código en la lista de productos
        for (int i = 0; i < listaProductos.tamaño(); i++) {
            Producto producto = (Producto) listaProductos.obtener(i);
            if (producto.getCodigo().equals(codigoProducto)) {
                // Actualizar la información del producto
                producto.actualizarPrecioCompra(precioCompra);
                producto.actualizarPrecioVenta();
                producto.actualizarPorcentajeDescuentoMaximo(porcentajeDescuentoMaximo);
                producto.actualizarUnidadesEnExistencia(cantidad);
               
                break; // Terminar la búsqueda después de encontrar el producto
            }
        }
    }


}
