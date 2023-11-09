package OrdenamientoAndLista;
import java.util.List;


public class ShellSort {
    public void shellSort(List<Integer> lista) {
        int n = lista.size();
        
        for (int brecha = n / 2; brecha > 0; brecha /= 2) {
            for (int i = brecha; i < n; i++) {
                int temp = lista.get(i);
                int j;
                
                for (j = i; j >= brecha && lista.get(j - brecha) > temp; j -= brecha) {
                    lista.set(j, lista.get(j - brecha));
                }
                
                lista.set(j, temp);
            }
        }
    }
}