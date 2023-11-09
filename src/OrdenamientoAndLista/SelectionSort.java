package OrdenamientoAndLista;

import java.util.List;


public class SelectionSort {
    public void selectionSort(List<Integer> lista) {
        int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j) < lista.get(indiceMinimo)) {
                    indiceMinimo = j;
                }
            }
            
            if (indiceMinimo != i) {
                int temp = lista.get(i);
                lista.set(i, lista.get(indiceMinimo));
                lista.set(indiceMinimo, temp);
            }
        }
    }
}