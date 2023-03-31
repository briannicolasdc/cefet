package java.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TrabalhoPratico{
    public static void main(String[] args) {
        // write your code here

        List<String> lista = new ArrayList<String>();
        String filename = "C:\\Users\\brian\\Documents\\code\\java\\sortingAlgorithms\\entrada-100-ale.txt";
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
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);

    }
}

class ShellSort {
    public void sort(String[] arr) {
        // String[] arr = { "Elissa Eichmann",
        //         "Meghan Johns III",
        //         "Naomie Beier",
        //         "Stephon Miller",
        //         "Dexter Harber",
        //         "Gerda Toy",
        //         "Mabel Zemlak",
        //         "Gage Gerhold",
        //         "Berry Schaden",
        //         "Roman Daniel",
        //         "Lily Krajcik" };
        int counter = 0;
        int tamanho = arr.length;

        for (int gap = tamanho / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < tamanho; i++) {
                String aux = arr[i];

                int j;
                for (j = i; j >= gap && compara(arr[j], arr[j - gap]); j -= gap) {
                    counter++;
                    arr[j] = arr[j - gap];
                }
                arr[j] = aux;
            }
        }
        for (String string : arr) {
             System.out.println(string);
        }
        System.out.println(" Comparacoes:" + counter);
    }

     private static boolean compara(String v, String w) {
          return v.compareTo(w) < 0;
     }
    
    
    // private static boolean comparaString(Comparable v, Comparable w) {
    //     return v.compareTo(w) < 0;
    // }

}