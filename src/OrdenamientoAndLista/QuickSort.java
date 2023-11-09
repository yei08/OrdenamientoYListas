package OrdenamientoAndLista;
import java.util.List;
import java.util.ArrayList;

public class QuickSort {
    public void quickSort(List<Integer> lista) {
        if (lista.size() <= 1) {
            return;
        }
        
        List<Integer> menores = new ArrayList<>();
        List<Integer> iguales = new ArrayList<>();
        List<Integer> mayores = new ArrayList<>();
        
        int pivote = lista.get(lista.size() / 2);
        
        for (int num : lista) {
            if (num < pivote) {
                menores.add(num);
            } else if (num == pivote) {
                iguales.add(num);
            } else {
                mayores.add(num);
            }
        }
        
        quickSort(menores);
        quickSort(mayores);
        
        lista.clear();
        lista.addAll(menores);
        lista.addAll(iguales);
        lista.addAll(mayores);
    }
}