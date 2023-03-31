import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoPratico {
    public static void main(String[] args) {
        // write your code here
        List<String> lista = new ArrayList<String>();
        String filename = "D:\\Downloads\\entrada-100-ale.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader(fr);
            String line = in.readLine();
            while (line != null) {
                lista.add(line);
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo \"" + filename + "\" não existe.");
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo " + filename + ".");
        }

        String[] array = lista.toArray(new String[0]);

        System.out.println(" Arquivo: " + filename + "\n");

        BubbleSort ordenador = new BubbleSort();
        ShellSort shellSort = new ShellSort();
        HeapSort heapSort = new HeapSort();

        ordenador.ordena(array.clone());
        shellSort.sort(array.clone());
        heapSort.heap(array.clone());

    }
}

class Shel lSort {
    public void sort(String[] arr) {
        // só pra testar;
        // String[] arr = { "Elissa Eichmann",
        // "Meghan Johns III",
        // "Naomie Beier",
        // "Stephon Miller",
        // "Dexter Harber",
        // "Gerda Toy",
        // "Mabel Zemlak",
        // "Gage Gerhold",
        // "Berry Schaden",
        // "Roman Daniel",
        // "Lily Krajcik" };
        int counter = 0;
        int tamanho = arr.length;

        for (int gap = tamanho / 2; gap >= 1; gap /= 2) {
            for (int i = 1; i < tamanho; i++) {
                // String aux = arr[i];
                int j = i;
                while (j >= gap && compara(arr[j], arr[j - gap])) {
                    counter++;

                    String aux = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = aux;
                    j -= gap;
                }

            }

        } 
        // for (String string : arr) {
        // System.out.println(string);
        // }
        System.out.println(" Numero de comparacoes ordenando com ShellSort: " + counter + "\n");
    }

    private static boolean compara(String v, String w) {
        return v.compareTo(w) < 0;
    }

}

class BubbleSort {
    void ordena(String[] arr) {
        int total = 0;
        String temp;
        // compara os pares.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) > 0) {
                    total++;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        } 
        // for (String string : arr) {
        // System.out.println(string);  
        // }
        System.out.println(" Numero de comparacoes ordenando com BubbleSort: " + total + "\n");
        DataSave(arr);
    }
   

class HeapSort {
    void heap(String[] arr) {
        // Heap Sort
        int n = arr.length;
        int contComparacao = 0;

        // Nesse for, ele passa por todo o vetor comparando os "pais" com seus "filhos"
        for (int i = n / 2 - 1; i >= 0; i--) {
            aplicarHeap(arr, n, i);
            contComparacao++;
        }

        // Nesse for, ele passa por todo o vetor comparando os "pais" com seus "filhos"
        // de novo
        // e essa será a sída final
        for (int j = n - 1; j > 0; j--) {
            String aux = arr[0];
            arr[0] = arr[j];
            arr[j] = aux;

            aplicarHeap(arr, j, 0);
            contComparacao++;
        }

        int totalComparacao = contComparacao * 2;
        System.out.println(" Numero de comparacoes ordenando com HeapSort: " + totalComparacao + "\n");

    } 

    public static void aplicarHeap(String[] vetorNomes, int n, int i) {
        int raiz = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // Compara o vetor "pai" com seu "filho" esquerdo
        if (esquerda < n && vetorNomes[esquerda].compareTo(vetorNomes[raiz]) <= 0) {
            raiz = esquerda;
        }
        // Compara o vetor "pai" com seu "filho" direito
        if (direita < n && vetorNomes[direita].compareTo(vetorNomes[raiz]) <= 0) {
            raiz = direita;
        }

        // Faz a troca do vetor atual para raiz
        if (raiz != i) {
            String aux = vetorNomes[i];
            vetorNomes[i] = vetorNomes[raiz];
            vetorNomes[raiz] = aux;

            aplicarHeap(vetorNomes, n, raiz);
        }
        // for (String string : arr) {
        // System.out.println(string);
        // }
    }
}
