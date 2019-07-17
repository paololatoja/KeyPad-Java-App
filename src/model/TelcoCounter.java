package model;

public class TelcoCounter {
	

	//TelcoCounter class saves the value for each telco company
	
	private static int telcoSmart = 0;
	private static int telcoGlobe = 0;
	private static int telcoSun = 0;
	
	
	public int getTelcoSmart() {
		return telcoSmart;
	}

	public int getTelcoGlobe() {
		return telcoGlobe;
	}

	public int getTelcoSun() {
		return telcoSun;
	}

	
	
	public void incTelco(String Telco) {
		
		if (Telco == "SMART") {
			telcoSmart += 1;
		}
		else if (Telco == "GLOBE") {
			telcoGlobe += 1;
		}
		else if (Telco == "SUN") {
			telcoSun += 1;
		}
		else {
			System.out.println("\nERROR: No Telco Counter incremented");
		}

	}
	
}
