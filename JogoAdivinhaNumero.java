import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class JogoAdivinhaNumero {

    public JogoAdivinhaNumero() {
        int palpite = 0,
                sorteado,
                tentativas = 0;
                String str;

        Scanner entrada = new Scanner(System.in);

        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(1000) + 1;
        System.out.println("Número entre 1 e 1000 sorteado!");

        do {
            System.out.printf("\n\n\n\n-----------------\n");
            System.out.println("Número de tentativas: " + tentativas);

            str = JOptionPane.showInputDialog(null, "Qual seu palpite: ",
				"Teste de Caixas de Diálogo", JOptionPane.INFORMATION_MESSAGE);
            
                palpite = Integer.parseInt(str);

            //System.out.print("Qual seu palpite: ");
            //palpite = entrada.nextInt();

            tentativas++;

            dica(palpite, sorteado, tentativas);
        } while (palpite != sorteado);
        entrada.close();
    }

    public void dica(int palpite, int numero, int tentativas) {
        if (palpite > numero) {
            //System.out.println();
            JOptionPane.showMessageDialog(null, "Seu palpite é maior que o número sorteado.",
				"Título da Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (palpite < numero) {
                //System.out.println();
                JOptionPane.showMessageDialog(null, "Seu palpite é menor que o número sorteado.",
				"Título da Mensagem", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                //System.out.println();
                JOptionPane.showMessageDialog(null, "Parabéns, você acertou! O número era " + numero + "\nVocê tentou " + tentativas + " vezes antes de acertar!",
				"Título da Mensagem", JOptionPane.INFORMATION_MESSAGE);
                //System.out.println();
            }
        }
    }

     

    public static void main(String[] args) {
        JogoAdivinhaNumero jogo = new JogoAdivinhaNumero();

    }

}

