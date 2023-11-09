package OrdenamientoAndLista;
import java.util.List;

public class BalanceFinanciero {
    public static double calcularTotalInvertido(List<Compra> compras) {
        double totalInvertido = 0;
        for (Compra compra : compras) {
            totalInvertido += compra.getValorTotal();
        }
        return totalInvertido;
    }

    public static double calcularTotalRecuperado(List<Venta> ventas) {
        double totalRecuperado = 0;
        for (Venta venta : ventas) {
            if ("éxito".equals(venta.getEstado())) {
                totalRecuperado += venta.calcularValorTotal();
            }
        }
        return totalRecuperado;
    }

    public static double calcularTotalGanancias(List<Venta> ventas, List<Compra> compras) {
        double totalGanancias = calcularTotalRecuperado(ventas) - calcularTotalInvertido(compras);
        return totalGanancias;
    }

    public static double calcularTotalDescuentos(List<Cliente> clientes) {
        double totalDescuentos = 0;
        for (Cliente cliente : clientes) {
            double totalCompras = cliente.calcularTotalCompras();
            if (totalCompras > 0) {
                if (totalCompras > 500) {
                    totalDescuentos += totalCompras * 0.1; // 10% de descuento
                } else if (totalCompras > 300) {
                    totalDescuentos += totalCompras * 0.15; // 15% de descuento
                } else {
                    totalDescuentos += totalCompras * 0.25; // 25% de descuento
                }
            }
        }
        return totalDescuentos;
    }

    public static double calcularTotalIVA(List<Venta> ventas) {
        double totalIVA = 0;
        for (Venta venta : ventas) {
            if ("éxito".equals(venta.getEstado())) {
                totalIVA += venta.calcularTotalIVA();
            }
        }
        return totalIVA;
    }

   
}
