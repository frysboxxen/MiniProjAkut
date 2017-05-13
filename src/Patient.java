import java.awt.Color;

public class Patient implements Comparable<Patient>{
	public int eKey;
	public String name;
	public int order;
	public String diagnos;
	public Color emergencyCol;
	
	/**
	 * Constructor for a patient. 
	 * @param eKey patient priority
	 * @param diagnos name of the disease 
	 * @param name of the patient
	 * @param order in which the patient arrived
	 */
	public Patient(int eKey, String diagnos, String name, int order) {
		this.order = order;
		this.name = name;
		this.eKey = eKey;
		this.diagnos = diagnos;

	}
	
	/**
	 * Secondary constructor which initiate order to 0.
	 * @param eKey patient priority
	 * @param name of the patient
	 * @param diagnos name of the disease
	 */
	public Patient(int eKey, String name, String diagnos) {

		this.name = name;
		this.eKey = eKey;
		this.diagnos = diagnos;
		this.order = 0;
	}
	
	/**
	 * @return a string representation of the patient. 
	 */
	public String toString() {
		String temp = name + " " + diagnos + " " + eKey + " " + order; 
		return temp;
	}
	
	/**
	 * 
	 * @return the priority on the patient
	 */
	public int geteKey() {
		return eKey;
	}
	
	/**
	 * 
	 * @return The name of the patient
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * 
	 * @return the name of the disease on the patient
	 */
	public String getDiagnos() {
		return diagnos;
	}
	
	/**
	 * Priority 0 = Green, Priority 1 = Turquoise, Priority 2 = Blue, Priority 3 = Red.  
	 * @return the color the patient has according to the priority
	 */
	public Color getColor() {
		if (eKey == 0) {
			emergencyCol = new Color(0, 255, 0);
			return emergencyCol;
		}

		else if (eKey == 1) {
			emergencyCol = new Color(64, 224, 208);
			return emergencyCol;
		}

		else if (eKey == 2) {
			emergencyCol = new Color(0, 0, 255);
			return emergencyCol;
		}

		else {
			emergencyCol = new Color(255, 0, 0);
			return emergencyCol;
		}

	}
	
	@Override
	/**Compares patients based on priority and the order
	 * @param is another patient to be compared
	 * @return (Priority * 100000 - order) - (paramPriority * 100000 - paramOrder)
	 */
	public int compareTo(Patient o) {
		return ((this.eKey * 100000) - this.order) - ((o.eKey * 100000) - o.order);
	}

}