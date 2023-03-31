import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Trabalho {

    public static void main(String[] args) {
    
        BubbleSort ordenador = new BubbleSort();
        //String[] arr = { "Izabela Rodrigues", "Amanda Ferreira", "Sabrine", "Augusto" };
        List<String> lista = new ArrayList<String>();
        String filename = "D:\\Downloads\\entrada-10000-ale.txt";
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
        ordenador.ordena(array);
        
        // int n = arr.length;
        // sortStrings(arr);
       
    }

}

// static int MAX = 100;
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
        System.out.println("Strings ordenadas: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
            System.out.println();
        }
        System.out.println(" Numero de Comparacoes:" + total+"\n");
    }

}
