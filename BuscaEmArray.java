public class BuscaEmArray {
    public static void main(String[] args) {
        
        int[] array = {2, 5, 10, 8, 9, 6, 3, 1, 7, 4};
        int i = 0;
        while (i < array.length) {
            if(array[i] == 8){
                System.out.println(i);
            }
            i+=1;
        }
        
    }
}