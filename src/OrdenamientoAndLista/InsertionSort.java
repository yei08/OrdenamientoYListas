package OrdenamientoAndLista;
import java.util.List;

public class InsertionSort {
    public void insertionSort(List<Integer> lista) {
        int n = lista.size();
        
        for (int i = 1; i < n; i++) {
            int clave = lista.get(i);
            int j = i - 1;
            
            while (j >= 0 && lista.get(j) > clave) {
                lista.set(j + 1, lista.get(j));
                j--;
            }
            
            lista.set(j + 1, clave);
        }
    }
}