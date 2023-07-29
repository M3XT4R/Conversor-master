import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	private static void presentarVentanaPPal() {
		VentanaPPal ppal = new VentanaPPal();
		ppal.setVisible(true);
	}
	public VentanaTemperatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setTitle("Conversor de Temperatura");
		setResizable(false);
		temperatura temperatura=new temperatura();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Te encuentras en el conversor de temperatura");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
		lblTitulo.setBounds(10, 11, 320, 25);
		contentPane.add(lblTitulo);
		
		JLabel lblTemperatura1 = new JLabel("Temperatura 1");
		lblTemperatura1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTemperatura1.setBounds(20, 47, 126, 25);
		contentPane.add(lblTemperatura1);
		
		JComboBox Cbxtemperatura0 = new JComboBox();
		Cbxtemperatura0.setModel(new DefaultComboBoxModel(new String[] {"Celsius C°", "Farenheith F°", "Kelvin K°"}));
		Cbxtemperatura0.setBounds(10, 83, 116, 22);
		contentPane.add(Cbxtemperatura0);
		
		JComboBox Cbxtemperatura1 = new JComboBox();
		Cbxtemperatura1.setModel(new DefaultComboBoxModel(new String[] {"Celsius C°", "Farenheith F°", "Kelvin K°"}));
		Cbxtemperatura1.setBounds(10, 152, 126, 22);
		contentPane.add(Cbxtemperatura1);
		
		JLabel lblTemperatura2 = new JLabel("Temperatura 2");
		lblTemperatura2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTemperatura2.setBounds(20, 116, 138, 25);
		contentPane.add(lblTemperatura2);
		
		JLabel lblCantidadAConvertir = new JLabel("Cantidad a convertir");
		lblCantidadAConvertir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadAConvertir.setBounds(186, 47, 138, 25);
		contentPane.add(lblCantidadAConvertir);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingrese solo Numeros");
				}
				
				 int key = e.getKeyChar();
				    boolean numeros = key >= 46 && key <= 57 ;
				    if (!numeros)
				    {
				        e.consume();
				    }
				    if (textField.getText().trim().length() == 10) {
				        e.consume();
				    }
				    
				    if(!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.') {
				    	e.consume();
				    }
				    if(e.getKeyChar()=='.'&& textField.getText().contains(".")) {
				    	e.consume();
				    }
			}
		});
		textField.setColumns(10);
		textField.setBounds(186, 84, 118, 20);
		contentPane.add(textField);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temperatura0=Cbxtemperatura0.getSelectedItem().toString();
				String temperatura1=Cbxtemperatura1.getSelectedItem().toString();
				Valida();
				double conversion= temperatura.convertirTemperatura(temperatura0, temperatura1, capturarTemperatura());
				JOptionPane.showMessageDialog(null, "la conversion de "+capturarTemperatura() +" "+ temperatura0 + " a "+ temperatura1 + " es equivalente a "+ conversion +" " + temperatura1);
				 int input= JOptionPane.showConfirmDialog(null, "Desea ir al menu ppal");
				 if (input==0) {
					 presentarVentanaPPal();
					 dispose();
				 }else if(input==1) {
					 JOptionPane.showMessageDialog(null, "Continua convirtiendo temperatura");
				 }else {
					 JOptionPane.showMessageDialog(null, "Muchas gracias por usar el conversor");
					 System.exit(0);
				 }
			}
		});
		btnConvertir.setBounds(186, 118, 118, 25);
		contentPane.add(btnConvertir);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(186, 151, 118, 25);
		contentPane.add(btnSalir);
	}
	boolean Valida(){
	    if(textField.getText().equals("")){
	        javax.swing.JOptionPane.showMessageDialog(this, "Llene todos los campos");
	        return false;
	    } 
	        return true;
	}
	
	public double capturarTemperatura() {
		double temp=Double.parseDouble(textField.getText());
		if(Valida()) {
			return temp;
		}else {
			temp=0.0;
			return temp;
		}	
	}
}
