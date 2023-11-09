import java.util.ArrayList;
import java.util.List;
import OrdenamientoAndLista.BubbleSort;
import OrdenamientoAndLista.Cliente;
import OrdenamientoAndLista.Compra;
import OrdenamientoAndLista.GestorClientes;
import OrdenamientoAndLista.InsertionSort;
import OrdenamientoAndLista.MercadeoFulanito;
import OrdenamientoAndLista.MiListaPersonalizada;
import OrdenamientoAndLista.Producto;
import OrdenamientoAndLista.QuickSort;
import OrdenamientoAndLista.SelectionSort;
import OrdenamientoAndLista.ShellSort;

public class Main {
    List<Producto> itemsVenta = new ArrayList<>();

    public static void main(String[] args) {

        // ordenamiento de burbuja
        System.out.println("*********Ordenamiento de burbuja*********");
        List<Integer> listaBuble = new ArrayList<>(List.of(5, 3, 1, 4, 2));

        System.out.println("Lista original: " + listaBuble);
        BubbleSort.bubbleSort(listaBuble);
        System.out.println("Lista ordenada: " + listaBuble);

        // ordenamiento rapido
        System.out.println("*************Ordenamiento rapido***************");

        List<Integer> listaQuick = new ArrayList<>(List.of(5, 3, 1, 4, 2));

        System.out.println("Lista original: " + listaQuick);

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(listaQuick);

        System.out.println("Lista ordenada: " + listaQuick);

        // ordenamiento por inserción
        System.out.println("**************Ordenamiento por insercion**************");
        List<Integer> listaInsertion = new ArrayList<>(List.of(5, 3, 1, 4, 2));

        System.out.println("Lista original: " + listaInsertion);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(listaInsertion);

        System.out.println("Lista ordenada: " + listaInsertion);

        // ordenamiento por seleccion
        System.out.println("*************Ordenamiento por seleccion***************");

        List<Integer> listaSelection = new ArrayList<>(List.of(5, 3, 1, 4, 2));

        System.out.println("Lista original: " + listaSelection);

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(listaSelection);

        System.out.println("Lista ordenada: " + listaSelection);

        // ordenamiento Shell
        System.out.println("************Ordenamiento Shell************");

        List<Integer> listaShell = new ArrayList<>(List.of(5, 3, 1, 4, 2));

        System.out.println("Lista original: " + listaShell);

        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(listaShell);

        System.out.println("Lista ordenada: " + listaShell);

        // ejemplo de utilizacion de lista personalizada

        System.out.println("*******ejemplo de utilizacion de lista personalizada********");
        System.out.println("----------------------------------------------------------");
        MiListaPersonalizada miLista = new MiListaPersonalizada();

        miLista.agregar("5");
        miLista.agregar("4");
        miLista.agregar("9");
        miLista.agregar("3");
        miLista.agregar("1");
        miLista.agregar("7");
        miLista.agregar("8");
        miLista.agregar("6");
        miLista.agregar("2");

        System.out.println("Elementos en la lista: " + miLista.tamaño());

        // miLista.eliminar(1);
        // miLista.actualizar(0, 6);

        for (int i = 0; i < miLista.tamaño(); i++) {
            System.out.println("Elemento " + i + ": " + miLista.obtener(i));
        }
        // prueba del algoritmo bubbleSort en la lista personalizada
        // Convierte tu MiListaPersonalizada a una lista de tipo List<Integer>
        List<Integer> listaConvertida = new ArrayList<>();
        for (int i = 0; i < miLista.tamaño(); i++) {
            listaConvertida.add(Integer.parseInt(miLista.obtener(i).toString()));

        }
        // Luego, ordena la lista convertida usando el algoritmo bubbleSort
        System.out.println("Lista desordenada" + listaConvertida);
        BubbleSort.bubbleSort(listaConvertida);
        System.out.println("Lista ordenada:( metodo BubbleSort) " + listaConvertida);

        // prueba del algoritmo quickSort en la lista personalizada
        System.out.println("*********************");

        // Desordena la lista
        OrdenamientoAndLista.BubbleSort.desordenar(listaConvertida);
        System.out.println("Lista desordenada" + listaConvertida);

        quickSort.quickSort(listaConvertida);
        System.out.println("Lista ordenada:(metodo QuickSort) " + listaConvertida);

        // prueba del algoritmo por inserccion
        // Desordena la lista
        System.out.println("*********************");
        OrdenamientoAndLista.BubbleSort.desordenar(listaConvertida);
        System.out.println("Lista desordenada" + listaConvertida);
        selectionSort.selectionSort(listaConvertida);
        System.out.println("Lista ordenada: (metodo insercion)" + listaConvertida);

        // empezamos con los requisitos de Fulanito*****************************

        MiListaPersonalizada listaProductos = new MiListaPersonalizada();
        MiListaPersonalizada listaCompras = new MiListaPersonalizada();
        Producto producto1 = new Producto("001", "Producto1", "Marca1", "Rojo", 10.0, 20.0, 10.0, 50, "unidad",
                "Electrónica");
        Producto producto2 = new Producto("002", "Producto2", "Marca2", "Azul", 15.0, 25.0, 15.0, 30, "unidad",
                "Ropa");

        listaProductos.agregar(producto1);
        listaProductos.agregar(producto2);
        // Mostrar la lista de productos
        System.out.println("Lista de productos:");
        for (int i = 0; i < listaProductos.tamaño(); i++) {
            Producto producto = (Producto) listaProductos.obtener(i);
            System.out.println("Codigo: " + producto.getCodigo() +
                    ", Nombre: " + (producto).getNombre() +
                    ", Precio de compra: " + producto.getPrecioCompra() +
                    ", Precio de venta: " + producto.getPrecioVenta());

        }
        // .......Las compras de Fulanito

        Compra compra1 = new Compra(1, "2023-11-01", "Proveedor1", "001", 10.0, 5.0, 0);
        Compra compra2 = new Compra(2, "2023-11-02", "Proveedor2", "002", 15.0, 3.0, 0);

        listaCompras.agregar(compra1.obtenerCompraComoLista());
        listaCompras.agregar(compra2.obtenerCompraComoLista());

        // Mostrar la lista de compras
        for (int i = 0; i < listaCompras.tamaño(); i++) {
            MiListaPersonalizada compraLista = (MiListaPersonalizada) listaCompras.obtener(i);

            System.out.println("Compra " + (i + 1) + ":");
            System.out.println("Consecutivo: " + compraLista.obtener(0));
            System.out.println("Fecha: " + compraLista.obtener(1));
            System.out.println("Proveedor: " + compraLista.obtener(2));
            System.out.println("Código del producto: " + compraLista.obtener(3));
            System.out.println("Precio de compra: " + compraLista.obtener(4));
            System.out.println("Cantidad: " + compraLista.obtener(5));
            System.out.println("Valor Sin IVA: " + compraLista.obtener(6));
            System.out.println("Valor del IVA: " + compraLista.obtener(7));
            System.out.println("Valor Total: " + compraLista.obtener(8));

            System.out.println("-----------------------------");
        }
        // guardar en archivo la info relacionada con el mercadeo de fulanito

        Producto producto3 = new Producto("003", "celular", "Marca3", "Rojo", 500000.0, 700000.0, 10.0, 50,
                "unidad",
                "Electrónica");
        Producto producto4 = new Producto("004", "sueter", "Marca4", "Azul", 50000.0, 60000.0, 15.0, 30,
                "unidad",
                "Ropa");
        Producto producto5 = new Producto("005", "tablet", "Marca5", "verde", 200000.0, 300000.0, 10.0, 50,
                "unidad",
                "Electrónica");
        Producto producto6 = new Producto("006", "pantalon", "Marca6", "morado", 30000.0, 50000.0, 15.0, 30,
                "unidad",
                "Ropa");
        listaProductos.agregar(producto3);
        listaProductos.agregar(producto4);
        listaProductos.agregar(producto5);
        listaProductos.agregar(producto6);

        MercadeoFulanito fulanito = new MercadeoFulanito(listaProductos);

        // ejemplo de como usar el gestor de clientes

        GestorClientes gestorClientes = new GestorClientes();

        // Agregar clientes a la lista
        Cliente cliente1 = new Cliente("123456789", "Juan", "Pérez", "Gómez", "Masculino", "1990-05-15",
                "1234567890",
                "juan@example.com", "Calle 123", true);
        Cliente cliente2 = new Cliente("987654321", "María", "López", "Sánchez", "Femenino", "1985-12-20",
                "9876543210",
                "maria@example.com", "Avenida 456", false);

        gestorClientes.agregarCliente(cliente1);
        gestorClientes.agregarCliente(cliente2);

        // Buscar un cliente por cédula
        String cedulaBuscada = "123456789";
        Cliente clienteEncontrado = gestorClientes.buscarClientePorCedula(cedulaBuscada);

        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNombre());
        } else {
            System.out.println("Cliente no encontrado.");
        }

        // Enviar información a clientes VIP
        String mensajeVIP = "¡Oferta especial para clientes VIP!";
        gestorClientes.enviarInformacionAClientesVIP(mensajeVIP);

        // Enviar información a referidos
        String mensajeReferidos = "¡Descubre nuestros productos!";
        gestorClientes.enviarInformacionAReferidos(mensajeReferidos);
        // Agregar productos a la lista
        Producto producto7 = new Producto("0045", "drone", "Marca1", "Rojo", 10.0, 20.0, 10.0, 50, "unidad",
                "Electrónica");
        Producto producto8 = new Producto("0033", "zandalias", "Marca2", "Azul", 15.0, 25.0, 15.0, 30, "unidad",
                "Ropa");

        listaProductos.agregar(producto7);
        listaProductos.agregar(producto8);

        String codigoProductoVendido = "006";
        int cantidadVendida = 5;

        listaProductos.actualizarCantidadExistentePorCodigo(codigoProductoVendido, cantidadVendida);
        fulanito.realizarMercadeo();

    }
}