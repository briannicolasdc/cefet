import java.io.*;

public class LerArquivo {
    public static void main(String args[]) {
        String nomeArquivo = "C:\\texto\\entrada_dados.txt";
        int contComparacao = 0, totalComparacao = 0;
        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] vetorNomes = new String[100];

            // Nesse for ele coloca cada nome em um espaço do vetor
            for (int i = 0; i < vetorNomes.length; i++) {
                vetorNomes[i] = line;
                line = br.readLine();
            }

            // Nesse for ele imprime o todo o vetor, nome por nome
            for (int i = 0; i < vetorNomes.length; i++) {
                System.out.println(vetorNomes[i]);
            }
            br.close();

            // Heap Sort
            int n = vetorNomes.length;

            // Nesse for, ele passa por todo o vetor comparando os "pais" com seus "filhos"
            for (int i = n / 2 - 1; i >= 0; i--) {
                aplicarHeap(vetorNomes, n, i);
                contComparacao++;
            }

            // Nesse for, ele passa por todo o vetor comparando os "pais" com seus "filhos"
            // de novo
            // e essa será a sída final
            for (int j = n - 1; j > 0; j--) {
                String aux = vetorNomes[0];
                vetorNomes[0] = vetorNomes[j];
                vetorNomes[j] = aux;

                aplicarHeap(vetorNomes, j, 0);
                contComparacao++;
            }

            totalComparacao = contComparacao * 2;
            System.out.println("\n\nTotal de Comparações: " + totalComparacao);
            System.out.println("\n\nOrdenado");
            for (int i = 0; i < vetorNomes.length; i++) {
                System.out.print(vetorNomes[i] + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo \"" + nomeArquivo + "\" não existe.");
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo " + nomeArquivo + ".");
        }

    }

    private static void aplicarHeap(String[] vetorNomes, int n, int i) {
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
