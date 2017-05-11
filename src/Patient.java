import java.awt.Color;
import java.io.File;
import java.util.Scanner;

public class Patient {
	public int eKey;
	public String name;
<<<<<<< HEAD
	public String diagnos;
	public Color emergencyCol;
	
	
	public Patient(int eKey, String diagnos, String name){
=======
	
	public Patient(int eKey, String name){
>>>>>>> origin/master
		this.name = name;
		this.eKey = eKey;
		this.diagnos = diagnos;
		
	}
	
		public String toString(){
		return name+ " " + diagnos + " " + eKey;
	}	
		public int geteKey(){
			return eKey;
		}
		
		public Color emergency(int prio){
			if(prio == 0){
				emergencyCol = new Color (0, 255, 0);
			return emergencyCol;
			}
			
			else if(prio == 1){
				emergencyCol = new Color (64, 224, 208);
			return emergencyCol;
			}
			
			else if(prio == 2){
				emergencyCol = new Color (0, 0, 255);
			return emergencyCol;
			}
			
			else
				emergencyCol = new Color (255, 0, 0);
			return emergencyCol;
			
			
		}
		
}