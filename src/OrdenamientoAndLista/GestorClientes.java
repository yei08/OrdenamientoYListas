package OrdenamientoAndLista;

public class GestorClientes {
    private MiListaPersonalizada listaClientes;

    public GestorClientes() {
        this.listaClientes = new MiListaPersonalizada();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.agregar(cliente);
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < listaClientes.tamaño(); i++) {
            Cliente cliente = (Cliente) listaClientes.obtener(i);
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null; // Cliente no encontrado
    }

    public void enviarInformacionACliente(Cliente cliente, String mensaje) {
        // Simulación del envío de información al cliente
        System.out.println("Enviando información a " + cliente.getNombre() + " por correo electrónico: " + mensaje);
    }

    public void enviarInformacionAClientesVIP(String mensaje) {
        for (int i = 0; i < listaClientes.tamaño(); i++) {
            Cliente cliente = (Cliente) listaClientes.obtener(i);
            if (cliente.isEsVIP()) {
                enviarInformacionACliente(cliente, mensaje);
            }
        }
    }

    public void enviarInformacionAReferidos(String mensaje) {
        for (int i = 0; i < listaClientes.tamaño(); i++) {
            Cliente cliente = (Cliente) listaClientes.obtener(i);
            if (!cliente.isEsVIP()) {
                enviarInformacionACliente(cliente, mensaje);
            }
        }
    }
}
