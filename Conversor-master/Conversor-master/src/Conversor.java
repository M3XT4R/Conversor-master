
public class Conversor {

	public static void main(String[] args) {

		presentarVentanaPPal();
		Monedas peso = new Monedas("Peso Mexicano", 1, 0.060, 0.054, 0.047, 8.46, 76.30);
		Monedas dolar = new Monedas("Dolar", 16.69, 1, 0.91, 0.78, 141.14, 1273.38);
		Monedas euro = new Monedas("Euro", 18.41, 1.10, 1, 0.86, 155.76, 1404.72);
		Monedas libra = new Monedas("Libra esterlina", 21.44, 1.28, 1.16, 1, 181.31, 163606.57);
		Monedas yen = new Monedas("Yen japones", 0.12, 0.0071, 0.0064, 0.0055, 1, 9.02);
		Monedas won = new Monedas("Won sur koreano", 0.013, 0.00079, 0.00071, 0.00061, 0.11, 1);
		temperatura celsius = new temperatura("Celsius C°", 1, 0, 0);
		temperatura fahrenheit = new temperatura("Farenheith F°", 0, 1, 0);
		temperatura kelvin = new temperatura("Kelvin K°", 0, 0, 1);

	}

	private static void presentarVentanaPPal() {
		VentanaPPal ppal = new VentanaPPal();
		ppal.setVisible(true);
	}

}
