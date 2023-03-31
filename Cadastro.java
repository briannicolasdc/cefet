
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/***
 * Classe com escutador externo
 */
public class Cadastro extends JFrame {

	//Define componentes da janela.
	private JLabel jLabelNumero;
	private JLabel jLabelNome;
	private JLabel jLabelGrupo;

	protected JTextField jtextNumero;
	protected JTextField jtextNome;
	protected JTextField jtextGrupo;

	private JButton jbuttonAnterior;
	private JButton jbuttonProximo;
	
	public Cadastro(String titulo) {
		super(titulo);

		setLayout(new FlowLayout(FlowLayout.RIGHT));

		//Inicializa componentes da janela.
		jLabelNumero = new JLabel("Número" );
		jLabelNome = new JLabel("Nome" );
		jLabelGrupo = new JLabel("Grupo");
		
		jtextNumero = new JTextField(10);
		jtextNome = new JTextField(10);
		jtextGrupo = new JTextField(10);

		jbuttonAnterior = new JButton("Anterior");
		jbuttonProximo= new JButton("Próximo");


		//Adiciona componentes na janela.
		this.add(jLabelNumero);
		this.add(jtextNumero);
		
		this.add(jLabelNome);		
		this.add(jtextNome);

		this.add(jLabelGrupo);
		this.add(jtextGrupo);
				
		this.add(jbuttonAnterior);
		this.add(jbuttonProximo);

		//Cria o escutador
		Escutador handler = new Escutador();

		//Adiciona o escutador a cada botão.
		jbuttonAnterior.addActionListener(handler);
		
		jbuttonProximo.addActionListener(handler);


		//Logica de inicialização aqui.
		// ...



	}

	private class Escutador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {			

			//Ações ao pressionarem os botões.

			if (event.getSource()==jbuttonAnterior) {
				
				jtextNome.setText("Nome Anterior");
				/// ...
				
			}else if (event.getSource()==jbuttonProximo) {
				
				jtextNome.setText("Nome Próximo");
				/// ...

			}
			
		}

	}
	
	public static void main(String[] args) {
		Cadastro cadastro = new Cadastro("Cadastro");
		cadastro.pack();
		cadastro.setSize(210,150);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.setVisible(true);
	}

}


