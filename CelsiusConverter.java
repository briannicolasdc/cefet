import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CelsiusConverter extends JFrame implements ActionListener {
    int celsius;
    private JLabel jlabel;
    protected JTextField jtext;
    private JButton jbutton;

    public CelsiusConverter() {

        double fahrenheit = (celsius * 1.8) + 32;
        //setLayout(new FlowLayout());

        jlabel = new JLabel("0:");
        jtext = new JTextField("Celsius");
        jbutton = new JButton("Convert");
        jtext = new JTextField("32 fahrenheit");

        add(jlabel);
        add(jtext);
        add(jbutton);

        jtext.addActionListener((ActionListener) this);
        jbutton.addActionListener((ActionListener) this);

        @Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource()==jtext) {
			JOptionPane.showMessageDialog(this,
					"Caixa de texto: " + event.getActionCommand());	
		} else {
			
			JOptionPane.showMessageDialog(this,
					"Botão: " +this.jtext.getText());
		}		
	}

    }

    public static void main(String[] args) {
        MyJFrame my = new MyJFrame();
        my.setSize(300, 130);
        my.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
