
public class temperatura {
	
	private String temperatura;
	private double equivCEL;
	private double equivFAR;
	private double equivKEL;

	public static double resultado;
	
	
	public temperatura(String temperatura, double equivCEL, double equivFAR, double equivKEL) {
		super();
		this.temperatura = temperatura;
		this.equivCEL = equivCEL;
		this.equivFAR = equivFAR;
		this.equivKEL = equivKEL;
	}
	public temperatura() {
		
	}
	public String getTemperatura() {
		return temperatura;
	}

	public double getEquivCEL() {
		return equivCEL;
	}

	public double getEquivFAR() {
		return equivFAR;
	}

	public double getEquivKEL() {
		return equivKEL;
	}

	
	public double convertirTemperatura(String temperatura0,String temperatura1,double cantidad) {
		if(temperatura0=="Celsius C°") {
			switch (temperatura1) {
			case "Celsius C°": 
				resultado= 1*cantidad;
				break;
			case "Farenheith F°":
				resultado= (cantidad*9/5)+32;
				break;
			case "Kelvin K°":
				resultado= cantidad+273.15;
				break;
			default:
				break;
			}
			}else if(temperatura0=="Farenheith F°") {
			switch (temperatura1) {
			case "Celsius C°": 
				resultado= (cantidad-32)*5/9;
				break;
			case "Farenheith F°":
				resultado= cantidad*1;
				break;
			case "Kelvin K°":
				resultado= (cantidad-32)*5/9+273.15;
				break;
			default:
				break;
			}
			}else if(temperatura0=="Kelvin K°") {
				switch (temperatura1) {
				case "Celsius C°": 
					resultado= (cantidad-273.15);
					break;
				case "Farenheith F°":
					resultado= (cantidad-273.15)*(9/5)+32;
					break;
				case "Kelvin K°":
					resultado= cantidad*1;
					break;
				default:
					break;
				}
			}
		
		return resultado;
	}
	
}
	
