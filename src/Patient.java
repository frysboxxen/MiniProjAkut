public class Patient {
	public int eKey;
	public String name;
	
	public Patient(int eKey, String name){
		this.name = name;
		this.eKey = eKey;
	}
	
	public String toString(){
		return name+" " + eKey;
	}	
}