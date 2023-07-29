import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VentanaPPal extends JFrame {

	private JPanel contentPane;

	final VentanaMonedas vMonedas= new VentanaMonedas();
	final VentanaTemperatura vTemperatura = new VentanaTemperatura();
	
	
	public VentanaPPal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setTitle("Conversor de moneda y unidades");
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltitulo = new JLabel("Bienvenid@ al conversor de monedas y unidades");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setBounds(14, 10, 399, 19);
		lbltitulo.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lbltitulo);
		
		JLabel lbltitulo2 = new JLabel("Seleccione una opcion de conversion");
		lbltitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo2.setBounds(10, 40, 376, 14);
		contentPane.add(lbltitulo2);
		
		JComboBox combopcion = new JComboBox();
		combopcion.setModel(new DefaultComboBoxModel(new String[] {"Conversor de monedas", "Conversor de temperatura"}));
		combopcion.setToolTipText("");
		combopcion.setBounds(14, 65, 178, 22);
		contentPane.add(combopcion);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object mensaje= combopcion.getSelectedItem();
				if (mensaje=="Conversor de monedas") {
					vMonedas.setVisible(true);
					dispose();
				} else if (mensaje=="Conversor de temperatura") {
					vTemperatura.setVisible(true);
					dispose();
				}
			}
		});
		btnSeleccionar.setBounds(202, 65, 122, 23);
		contentPane.add(btnSeleccionar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(328, 65, 85, 23);
		contentPane.add(btnSalir);
	}
}
