import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ComparaOrdenacoes {
    public static void main(String args[]) throws IOException {
        String caminhoArquivo = "D:\\Downloads\\entrada-100-ale.txt";
        ControlePrograma controlePrograma = new ControlePrograma();
        controlePrograma.executaOrdenacao(caminhoArquivo);
    }

    static class ControlePrograma {
        public void executaOrdenacao(String caminho) throws IOException {
            Arquivo salvaArquivo = new Arquivo();
            BufferedReader arquivo = new Arquivo().obtemArquivo(caminho);

            // Grava todos os nomes do arquivo em uma lista
            List<String> listaNomes = new ArrayList<String>();
            String line = arquivo.readLine();
            while (line != null) {
                listaNomes.add(line);
                line = arquivo.readLine();
            }
            arquivo.close();

            // Nesse for ele coloca cada nome em cada elemento do vetor
            String[] array = listaNomes.toArray(new String[0]);

            System.out.println(" Arquivo: " + caminho + "\n");

            BubbleSort bubbleSort = new BubbleSort();
            ShellSort shellSort = new ShellSort();
            HeapSort heapSort = new HeapSort();

            bubbleSort.ordena(array.clone());
            shellSort.ordena(array);
            heapSort.ordena(array.clone());

            salvaArquivo.gravaArquivo(caminho, array);

        }

    }

    static class Arquivo {
        public BufferedReader obtemArquivo(String path) throws IOException {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            return br;
        }

        public void gravaArquivo(String path, String[] vetorOrdenado) throws IOException {
            File f = new File("SaidaTrabalho.txt");
            FileWriter fr = new FileWriter(f);
            PrintWriter out = new PrintWriter(fr);
            for (int i = 0; i < vetorOrdenado.length; i++) {
                out.println(vetorOrdenado[i]);
            }
            out.close();
        }

    }

    static class ShellSort {
        public void ordena(String[] arr) {
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
            System.out.println(" Numero de comparacoes ordenando com ShellSort: " + counter + "\n");
        }

        private static boolean compara(String v, String w) {
            return v.compareTo(w) < 0;
        }

    }

    static class BubbleSort {
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
            System.out.println(" Numero de comparacoes ordenando com BubbleSort: " + total + "\n");
        }
    }

    static class HeapSort {
        void ordena(String[] arr) {
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
        }

    }
}