import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaMonedas extends JFrame {

	private JPanel contentPane;
	public static JTextField txtcantidad;

	private static void presentarVentanaPPal() {
		VentanaPPal ppal = new VentanaPPal();
		ppal.setVisible(true);
	}
	public VentanaMonedas() {
		
		setBackground(new Color(0, 64, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 226);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setTitle("Conversor de monedas");
		setResizable(false);
		Monedas monedas= new Monedas();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitulo = new JLabel("Te encuentras en el conversor de monedas");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
		lbltitulo.setBounds(10, 18, 304, 19);
		contentPane.add(lbltitulo);
		
		JLabel lblMoneda1 = new JLabel("Moneda que posees");
		lblMoneda1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMoneda1.setBounds(10, 48, 138, 25);
		contentPane.add(lblMoneda1);
		
		JLabel lblMoneda2 = new JLabel("Moneda a convertir");
		lblMoneda2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMoneda2.setBounds(10, 115, 138, 25);
		contentPane.add(lblMoneda2);
		
		JComboBox Cbxmoneda1 = new JComboBox();
		Cbxmoneda1.setModel(new DefaultComboBoxModel(new String[] {"Peso Mexicano", "Dolar", "Euro", "Libra esterlina", "Yen japones", "Won sur koreano"}));
		Cbxmoneda1.setBounds(10, 151, 126, 22);
		contentPane.add(Cbxmoneda1);
		
		JComboBox Cbxmoneda0 = new JComboBox();
		Cbxmoneda0.setModel(new DefaultComboBoxModel(new String[] {"Peso Mexicano", "Dolar", "Euro", "Libra esterlina", "Yen japones", "Won sur koreano"}));
		Cbxmoneda0.setBounds(10, 84, 126, 22);
		contentPane.add(Cbxmoneda0);
	
		
		JLabel lblCantidadAConvertir = new JLabel("Cantidad a convertir");
		lblCantidadAConvertir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadAConvertir.setBounds(188, 48, 138, 25);
		contentPane.add(lblCantidadAConvertir);
		
		
		
//		VALIDACION DE ERRORES EN TXTFIELD***********************
		txtcantidad = new JTextField();
		txtcantidad.addKeyListener(new KeyAdapter() {
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
				    if (txtcantidad.getText().trim().length() == 10) {
				        e.consume();
				    }
				    
				    if(!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.') {
				    	e.consume();
				    }
				    if(e.getKeyChar()=='.'&& txtcantidad.getText().contains(".")) {
				    	e.consume();
				    }
				    
			}
		});
	
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				String moneda0=Cbxmoneda0.getSelectedItem().toString();
				String moneda1=Cbxmoneda1.getSelectedItem().toString();
				Valida();
				double conversion= monedas.convertirMonedas(moneda0, moneda1, capturarMoneda());
				JOptionPane.showMessageDialog(null, "la conversion de "+capturarMoneda() +" "+ moneda0 + " a "+ moneda1 + " es equivalente a "+ conversion +" " + moneda1);
				 int input= JOptionPane.showConfirmDialog(null, "Desea ir al menu ppal");
				 if (input==0) {
					 presentarVentanaPPal();
					 dispose();
				 }else if(input==1) {
					 JOptionPane.showMessageDialog(null, "Continua convirtiendo monedas");
				 }else {
					 JOptionPane.showMessageDialog(null, "Muchas gracias por usar el conversor");
					 System.exit(0);
				 }
			}
		});
		btnConvertir.setBounds(188, 117, 118, 25);
		contentPane.add(btnConvertir);
		
		txtcantidad.setBounds(188, 85, 118, 20);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(188, 151, 118, 25);
		contentPane.add(btnSalir);
	}
	
	boolean Valida(){
	    if(txtcantidad.getText().equals("")){
	        javax.swing.JOptionPane.showMessageDialog(this, "Llene todos los campos");
	        return false;
	    } 
	        return true;
	}
	public double capturarMoneda() {
		double moneda=Double.parseDouble(txtcantidad.getText());
		if(Valida()) {
			return moneda;
		}else {
			moneda=0.0;
			return moneda;
		}	
	}
}
