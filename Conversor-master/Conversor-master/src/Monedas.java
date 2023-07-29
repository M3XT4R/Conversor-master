//	MEX: peso mexicano
//	USD: dolar
//	EUR: euro
//	GBP: Libra esterlina
//	JPY: Yen japones
//	KRW: Won sul koreano
public class Monedas {

	private String nombreMoneda;
	private double equivMEX;
	private double equivUSD;
	private double equivEUR;
	private double equivGBP;
	private double equivJPY;
	private double equivKRW;
	
	public static double resultado;
	
	public Monedas(String nombreMoneda, double equivMEX, double equivUSD, double equivEUR, double equivGBP,
			double equivJPY, double equivKRW) {
		this.nombreMoneda = nombreMoneda;
		this.equivMEX = equivMEX;
		this.equivUSD = equivUSD;
		this.equivEUR = equivEUR;
		this.equivGBP = equivGBP;
		this.equivJPY = equivJPY;
		this.equivKRW = equivKRW;
	}
	public Monedas() {
		
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public double getEquivCOP() {
		return equivMEX;
	}

	public double getEquivUSD() {
		return equivUSD;
	}

	public double getEquivEUR() {
		return equivEUR;
	}

	public double getEquivGBP() {
		return equivGBP;
	}

	public double getEquivJPY() {
		return equivJPY;
	}

	public double getEquivKRW() {
		return equivKRW;
	}
	
	public double convertirMonedas(String moneda0,String moneda1,double cantidad) {
		if(moneda0=="Peso Mexicano") {
			switch (moneda1) {
			case "Peso Mexicano":
				resultado= 1*cantidad;
				break;
			case "Dolar":
				resultado= cantidad*0.060;
				break;
			case "Euro":
				resultado= cantidad*0.054;
				break;
			case "Libra esterlina":
				resultado= cantidad*0.047;
				break;
			case "Yen japones":
				resultado= cantidad*8.46;
				break;
			case "Won sur koreano":
				resultado= cantidad*76.30;
				break;
			default:
				break;
			}
	
		}else if (moneda0=="Dolar") {
			switch (moneda1) {
			case "Peso Mexicano":
				resultado= 16.69*cantidad;
				break;
			case "Dolar":
				resultado= 1*cantidad;
				break;
			case "Euro":
				resultado= cantidad*0.91;
				break;
			case "Libra esterlina":
				resultado= cantidad*0.78;
				break;
			case "Yen japones":
				resultado= cantidad*141.14;
				break;
			case "Won sur koreano":
				resultado= cantidad*1273.38;
				break;
			default:
				break;
			}
		}else if (moneda0=="Euro") {
			switch (moneda1) {
			case "Peso Mexicano":
				resultado= 18.41*cantidad;
				break;
			case "Dolar":
				resultado= cantidad*1.10;
				break;
			case "Euro":
				resultado= cantidad*1;
				break;
			case "Libra esterlina":
				resultado= cantidad*0.86;
				break;
			case "Yen japones":
				resultado= cantidad*155.76;
				break;
			case "Won sur koreano":
				resultado= cantidad*1404.72;
				break;
			default:
				break;
			}
	
		}else if (moneda0=="Libra esterlina") {
				switch (moneda1) {
				case "Peso Mexicano":
					resultado= 21.44*cantidad;
					break;
				case "Dolar":
					resultado= cantidad*1.28;
					break;
				case "Euro":
					resultado= cantidad*1.16;
					break;
				case "Libra esterlina":
					resultado= cantidad*1;
					break;
				case "Yen japones":
					resultado= cantidad*181.31;
					break;
				case "Won sur koreano":
					resultado= cantidad*163606.57;
					break;
				default:
					break;
				}
				
			
		}else if (moneda0=="Yen japones") {
			switch (moneda1) {
			case "Peso Mexicano":
				resultado= 0.12*cantidad;
				break;
			case "Dolar":
				resultado= cantidad*0.0071;
				break;
			case "Euro":
				resultado= cantidad*0.0064;
				break;
			case "Libra esterlina":
				resultado= cantidad*0.0055;
				break;
			case "Yen japones":
				resultado= cantidad*1;
				break;
			case "Won sur koreano":
				resultado= cantidad*9.02;
				break;
			default:
				break;
			}
		}else if (moneda0=="Won sur koreano") {
			switch (moneda1) {
			case "Peso Peso Mexicano":
				resultado= 0.013*cantidad;
				break;
			case "Dolar":
				resultado= cantidad*0.00079;
				break;
			case "Euro":
				resultado= cantidad*0.00071;
				break;
			case "Libra esterlina":
				resultado= cantidad*0.00061;
				break;
			case "Yen japones":
				resultado= cantidad*0.11;
				break;
			case "Won sur koreano":
				resultado= cantidad*1;
				break;
			default:
				break;
			}
	}
		return resultado;
	}
	
	
}
