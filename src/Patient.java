import java.awt.Color;


public class Patient {
	public int eKey;
	public String name;

	public String diagnos;
	public Color emergencyCol;

	public Patient(int eKey, String diagnos, String name) {

		this.name = name;
		this.eKey = eKey;
		this.diagnos = diagnos;

	}
	public Patient(int eKey,  String name) {

		this.name = name;
		this.eKey = eKey;

	}

	public String toString() {
		return name + " " + diagnos + " " + eKey;
	}

	public int geteKey() {
		return eKey;
	}

	public String getDiagnos() {
		return diagnos;
	}

	public Color emergency(int prio) {
		if (prio == 0) {
			emergencyCol = new Color(0, 255, 0);
			return emergencyCol;
		}

		else if (prio == 1) {
			emergencyCol = new Color(64, 224, 208);
			return emergencyCol;
		}

		else if (prio == 2) {
			emergencyCol = new Color(0, 0, 255);
			return emergencyCol;
		}

		else
			emergencyCol = new Color(255, 0, 0);
		return emergencyCol;

	}

}