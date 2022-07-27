package utilities;

public class RandomMethods {
	
	public static String getRandomEmail() {
		long numPart = (long) ( 10000000000000l * Math.random());
		return "ef_" + numPart + "@evolutionfinance.com";
	}
	
	

}
