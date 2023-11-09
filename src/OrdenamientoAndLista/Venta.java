package OrdenamientoAndLista;

import java.util.ArrayList;
import java.util.List;
public class Venta {
    private int consecutivo;
    private String fecha;
    private String cedulaCliente;
    private String medioDePago;
    private String modalidad;
    private List<ItemVenta> itemsVenta;
    private String estado; // Puede ser "éxito", "cancelada" u otro estado
    private String motivoCancelacion; // Atributo para almacenar el motivo de cancelación
    private List<Cliente> listaClientes; // Definir la lista de clientes
    private List<Compra> listaCompras; // Definir la lista de compras
    private int consecutivoCompra = 1; // Atributo para el consecutivo de la compra (inicializado en 1)
    private String fechaCompra; // Fecha de la compra (ajusta la fecha según tus necesidades)
    private String proveedor; // Proveedor de la compra
    private double precioCompra; // Precio de compra (ajusta el precio según tus necesidades)
    private double cantidadCompra; // Cantidad de compra (ajusta la cantidad según tus necesidades)
    private double descuento; // Descuento (ajusta el descuento según tus necesidades)
    
    public Venta(int consecutivo, String fecha, String cedulaCliente, String medioDePago, String modalidad,
            List<ItemVenta> itemsVenta, String fechaCompra, String proveedor, double precioCompra, double cantidadCompra, double descuento) {
        this.consecutivo = consecutivo;
        this.fecha = fecha;
        this.cedulaCliente = cedulaCliente;
        this.medioDePago = medioDePago;
        this.modalidad = modalidad;
        this.itemsVenta = itemsVenta;
        this.estado = "pendiente";
        this.fechaCompra = fechaCompra;
        this.proveedor = proveedor;
        this.precioCompra = precioCompra;
        this.cantidadCompra = cantidadCompra;
        this.descuento = descuento;
        this.itemsVenta = new ArrayList<>();
    }

    public Venta(int consecutivo2, String fecha2, String cedulaCliente2, String medioDePago2,
            String codigoProductoVendido, String string, String codigoProductoVendido2, String codigoProductoVendido3,
            double precioCompra2, double cantidadCompra2, double descuento2) {
    }

    public Venta() {
    }

    private List<Producto> revisarExistenciaBaja(MiListaPersonalizada listaProductos) {
        List<Producto> productosExistenciaBaja = new ArrayList<>();
        for (int i = 0; i < listaProductos.tamaño(); i++) {
            Producto producto = (Producto) listaProductos.obtener(i);
            if (producto.getUnidadesEnExistencia() < 5) {
                productosExistenciaBaja.add(producto);
            }
        }
        return productosExistenciaBaja;
    }
    
    public void abastecerInventario(MiListaPersonalizada listaProductos) {
        List<Producto> productosExistenciaBaja = revisarExistenciaBaja(listaProductos);

        for (Producto producto : productosExistenciaBaja) {
            // Simulación de compra para abastecer el inventario
            Compra compra = new Compra(
                consecutivoCompra, 
                fechaCompra, 
                proveedor, 
                producto.getCodigo(), 
                precioCompra, 
                cantidadCompra, 
                descuento 
            );
            listaCompras.add(compra); // Agregar la compra a la lista de compras
            consecutivoCompra++;

            // Actualizar la información del producto en la lista de productos
            producto.actualizarPrecioCompra(precioCompra);
            producto.actualizarPrecioVenta();
            producto.actualizarPorcentajeDescuentoMaximo(descuento);
            producto.actualizarUnidadesEnExistencia(cantidadCompra);
        }
    }
    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public List<ItemVenta> getItemsVenta() {
        return itemsVenta;
    }

    public void setItemsVenta(List<ItemVenta> itemsVenta) {
        this.itemsVenta = itemsVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public int getConsecutivoCompra() {
        return consecutivoCompra;
    }

    public void setConsecutivoCompra(int consecutivoCompra) {
        this.consecutivoCompra = consecutivoCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(double cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (ItemVenta item : itemsVenta) {
            valorTotal += item.getValorTotal();
        }
        return valorTotal;
    }

    // Método para cambiar el estado a "éxito" con un motivo
    public void cambiarEstadoExito() {
        estado = "éxito";
    }

    // Método para cambiar el estado a "cancelada" con un motivo
    public void cambiarEstadoCancelada(String motivo) {
        estado = "cancelada";
        this.motivoCancelacion = motivo;
    }

    public Cliente buscarClientePorCedula(String cedula) {
        // Implementa la lógica para buscar un cliente por cédula en la lista 
      
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }

    public void registrarVenta(String cedulaCliente) {
        // Verificar si el cliente es VIP
        Cliente cliente = buscarClientePorCedula(cedulaCliente);
        if (cliente != null && !cliente.isEsVIP()) {
            // Cambiar el estado del cliente a VIP
            cliente.setEsVIP(true);
        }
    }
    
    public void motivarClientesDescuento(List<Cliente> listaClientes) {
        // Calcular el promedio de compras de todos los clientes
        double sumaCompras = 0;
        int totalClientes = listaClientes.size();
        for (Cliente cliente : listaClientes) {
            sumaCompras += cliente.calcularTotalCompras();
        }
        double promedioCompras = sumaCompras / totalClientes;

        // Recorrer la lista de clientes y determinar el descuento para cada uno
        for (Cliente cliente : listaClientes) {
            double totalComprasCliente = cliente.calcularTotalCompras();

            if (totalComprasCliente > promedioCompras) {
                // Cliente con más compras que el promedio
                cliente.informarDescuento(10); // 10% de descuento
            } else if (totalComprasCliente < promedioCompras) {
                // Cliente con menos compras que el promedio
                cliente.informarDescuento(15); // 15% de descuento
            } else {
             
                // Cliente que no ha comprado o tiene compras iguales al promedio
                cliente.informarDescuento(25); // 25% de descuento en la primera compra
            }
        }
    }

    public double calcularTotalIVA() {
        double totalIVA = 0;
        for (ItemVenta item : itemsVenta) {
            double valorTotalItem = item.getValorTotal();
            totalIVA += valorTotalItem * 0.19; // Suponiendo que el IVA es del 19%
        }
        return totalIVA;
    }
    
    public void agregarItemVenta(ItemVenta item) {
        if (itemsVenta == null) {
            itemsVenta = new ArrayList<>();
        }
        itemsVenta.add(item);
    }

    public String getCodigoProductoVendido() {
        return null;
    }
    public void imprimirDetallesVenta() {
        System.out.println("ID: " + consecutivo);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cedulaCliente);
        System.out.println("Código del producto vendido: " + getCodigoProductoVendido());
        System.out.println("Valor Sin IVA: " + calcularValorTotal());
        System.out.println("Valor del IVA: " + calcularTotalIVA());
        System.out.println("Valor Total: " + (calcularValorTotal() + calcularTotalIVA()));
    }
    
}
