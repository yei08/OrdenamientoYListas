package OrdenamientoAndLista;

import java.util.Arrays;


public class MiListaPersonalizada {
   
    private Object[] elementos;
    private int tamaño;
    private static final int CAPACIDAD_INICIAL = 10;

    public MiListaPersonalizada() {
        elementos = new Object[CAPACIDAD_INICIAL];
        tamaño = 0;
    }

    public void agregar(Object elemento) {
        asegurarCapacidad();
        elementos[tamaño] = elemento;
        tamaño++;
    }
    
    public void eliminar(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        for (int i = indice; i < tamaño - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        elementos[tamaño - 1] = null;
        tamaño--;
    }

    public void actualizar(int indice, Object nuevoElemento) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        elementos[indice] = nuevoElemento;
    }

    public Object obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }

        return elementos[indice];
    }

    public int tamaño() {
        return tamaño;
    }

    private void asegurarCapacidad() {
        if (tamaño == elementos.length) {
            elementos = Arrays.copyOf(elementos, elementos.length * 2);
        }
   
    }
        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tamaño; i++) {
            sb.append(elementos[i]);
            if (i < tamaño - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < tamaño(); i++) {
            Cliente cliente = (Cliente) obtener(i);
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }

    public void actualizarCantidadExistentePorCodigo(String codigoProducto, int cantidadVendida) {
        for (int i = 0; i < tamaño(); i++) {
            Object elemento = obtener(i);
            if (elemento instanceof Producto) {
                Producto producto = (Producto) elemento;
                if (producto.getCodigo().equals(codigoProducto)) {
                    // Encontramos el producto, actualizamos la cantidad existente
                    producto.actualizarCantidadExistente(cantidadVendida);
                    return; // Terminamos la búsqueda
                }
            }
        }
    }

   
}