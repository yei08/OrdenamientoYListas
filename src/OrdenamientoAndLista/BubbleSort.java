package OrdenamientoAndLista;
import java.util.List;
public class BubbleSort {
    public static void bubbleSort(List<Integer> lista) {
        int n = lista.size();
        boolean intercambiado;
        
        do {
            intercambiado = false;
            
            for (int i = 1; i < n; i++) {
                if (lista.get(i - 1) > lista.get(i)) {
                    int temp = lista.get(i - 1);
                    lista.set(i - 1, lista.get(i));
                    lista.set(i, temp);
                    intercambiado = true;
                }
            }
        } while (intercambiado);
    }
    public static void desordenar(List<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n; i++) {
            int indiceAleatorio = (int) (Math.random() * n);
            int temp = lista.get(i);
            lista.set(i, lista.get(indiceAleatorio));
            lista.set(indiceAleatorio, temp);
        }
    }
}