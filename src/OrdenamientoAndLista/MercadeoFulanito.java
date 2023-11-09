package OrdenamientoAndLista;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MercadeoFulanito {
    private MiListaPersonalizada listaProductos;

    public MercadeoFulanito(MiListaPersonalizada listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void realizarMercadeo() {
        // Paso 1: Filtrar productos con unidades de existencias mayores que 0
        List<Producto> productosFiltrados = new ArrayList<>();
        for (int i = 0; i < listaProductos.tamaño(); i++) {
            Producto producto = (Producto) listaProductos.obtener(i);
            if (producto.getUnidadesEnExistencia() > 0) {
                productosFiltrados.add(producto);
            }
        }
                    
        // Ordenar alfabéticamente los productos filtrados
        Collections.sort(productosFiltrados, (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));

        // Agrupar productos por categorías
        Map<String, List<Producto>> productosPorCategoria = new HashMap<>();
        for (Producto producto : productosFiltrados) {
            String categoria = producto.getCategoria();
            if (!productosPorCategoria.containsKey(categoria)) {
                productosPorCategoria.put(categoria, new ArrayList<>());
            }
            productosPorCategoria.get(categoria).add(producto);
        }

        // Generar un archivo con la información agrupada
        generarArchivoPublicidad(productosPorCategoria);

        // Enviar el archivo a la empresa de publicidad
        enviarArchivoPublicidad();
    }

    private void generarArchivoPublicidad(Map<String, List<Producto>> productosPorCategoria) {
        try (FileWriter writer = new FileWriter("publicidad.txt")) {
            for (Map.Entry<String, List<Producto>> entry : productosPorCategoria.entrySet()) {
                String categoria = entry.getKey();
                List<Producto> productos = entry.getValue();
                writer.write("Categoría: " + categoria + "\n");
                for (Producto producto : productos) {
                    writer.write("Producto: " + producto.getNombre() + "\n");
                    writer.write("Código: " + producto.getCodigo() + "\n");
                    writer.write("Marca: " + producto.getMarca() + "\n");
                    writer.write("Color: " + producto.getColor() + "\n");
                    writer.write("Precio de compra: " + producto.getPrecioCompra() + "\n");
                    writer.write("Precio de venta: " + producto.getPrecioVenta() + "\n");
                    writer.write("Porcentaje de descuento máximo: " + producto.getPorcentajeDescuentoMaximo() + "\n");
                    writer.write("Unidades en existencia: " + producto.getUnidadesEnExistencia() + "\n");
                    writer.write("Métrica de medida: " + producto.getMetricaMedida() + "\n");
                    writer.write("Categoría: " + producto.getCategoria() + "\n");
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarArchivoPublicidad() {
        // Simulación de envío del archivo a la empresa de publicidad
        System.out.println("Archivo de publicidad enviado a la empresa de publicidad.");
    }

    public void calcularYAplicarDescuentosSegunVentas(List<Venta> ventas) {
        Map<String, Double> ventasPorProducto = new HashMap<>();

        // Itera a través de las ventas y actualiza el mapa
        for (Venta venta : ventas) {
            String codigoProducto = venta.getCodigoProductoVendido();
            double valorVenta = venta.calcularValorTotal();

            // Si el producto ya tiene ventas registradas, suma el nuevo valor de venta
            if (ventasPorProducto.containsKey(codigoProducto)) {
                double ventasAnteriores = ventasPorProducto.get(codigoProducto);
                ventasPorProducto.put(codigoProducto, ventasAnteriores + valorVenta);
            } else {
                ventasPorProducto.put(codigoProducto, valorVenta);
            }
        }

    }

}