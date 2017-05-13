import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Hospital {

	static GeneratePatient pg = new GeneratePatient();
	static PatientQueue que;
	static int queMax;
	static int xLed = 1600;
	static int yLed = 800;
	static double drPrecent = 60;
	static double patPrecent = 60;
	static Scanner scan;
	
	/**
	 * setUp()
	 * Help method to set up StdDraw for ER mode.
	 * 
	 */
	public static void setup(){
		scan = new Scanner(System.in);
		StdDraw.setCanvasSize(xLed, yLed);
		StdDraw.setXscale(0, xLed);
		StdDraw.setYscale(0, yLed);
		StdDraw.setFont(new Font("Helvetica Bold", 1, 17));
		StdDraw.setPenRadius(0.01);
		StdDraw.enableDoubleBuffering();
	}

	public static void main(String[] args) {
		queMax = 8; // Max number of patients in ER.
		que = new PatientQueue(queMax); // Initiate PatientQueue to contain a maximum of queMax.
		setup();
		
		int i = 0; // Iterations
		Patient patientReception = reception(); // Initiate pat variable and maybe start with patient in graphical reception.
		
		// Main loop
		while (true) {
			if(StdDraw.isKeyPressed(KeyEvent.VK_C)){
				StdDraw.setPenColor(StdDraw.BOOK_RED);
				StdDraw.filledSquare(xLed/2, yLed/2, 50);
				StdDraw.show();
				System.out.println("Skriv namnet på patienten du vill ändra "
						+ "prioritet på, \nföljt av enter, sedan dess nya prioritet");
				System.out.println(que.changePrio(scan.next(), scan.nextInt()));
				StdDraw.pause(4000);
			}
			while(StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
				StdDraw.setPenColor(StdDraw.BOOK_RED);
				StdDraw.filledSquare(xLed/2, yLed/2, 50);
				StdDraw.show();
				StdDraw.pause(100);
			}
			StdDraw.clear(StdDraw.GRAY);
			
			// Check if there is a patient in reception and if the waiting room has space.
			if (patientReception != null && que.size() < queMax){
				que.addPatient(patientReception); // Add reception patient to queue.
				que.sort();
				patientReception = null; // Reset patient in reception after it has been added to the patient queue.
			}
			patientReception = reception(); // Possibly create a new patient in reception.
			patientLoad(i); // Decide the patient load.
			drawAlways(i); // Create background stuff.
			
			doctor(); // Cure patient
			int j = 1; // Used to create spacing in queue when drawn.
			PatientIterator itr = que.iterator();
			// Draw all patients in queue.
			while (itr.hasNext()) {
				draw(itr.next(), j); // Help method to draw patient.
				j = j + 2;
			}
			
			StdDraw.show();
			StdDraw.pause(2000);
			i++;
		}
	}

	/**
	 * Method create a new patient with GeneratePatient class. 
	 * Creates based on percent decided by patietLoad(), and only adds if there's space in queue.
	 * @return created patient (if created) else null
	 */
	public static Patient generatePatient() {
		if (Math.random() * 100 < patPrecent && que.size() < queMax) {
			Patient inReception = pg.create();
			return inReception;
		}
		return null;
	}
	
	/**
	 * Method to draw the patient in the reception and only drawn if created
	 * @return returns a patient if a patient was created by generatePatient() else null
	 * 
	 */
	public static Patient reception(){
		Patient in = generatePatient();
		if(in != null){
			StdDraw.setPenColor(new Color(0, 0, 0));
			StdDraw.text(3*(xLed/4), yLed/2+20, "" + in.geteKey());
			StdDraw.text(3*(xLed/4), yLed/2, in.getName());
			StdDraw.text(3*(xLed/4), yLed/2-20, in.getDiagnos());
			
			//for rectangle
			StdDraw.setPenColor(in.getColor());
			StdDraw.rectangle(3*(xLed/4), yLed/2, 100, 40);
			return in;
		}
		return null;
	}
	
	/**
	 * Changes the patient load based on the iteration based on i modulus 30 
	 * @param i used to get a different load structure to the ER
	 */
	public static void patientLoad(int i){
		int load = i % 30;
		if(load >= 0 && load <= 10){
			patPrecent = 60;
		} 
		else if(load > 10 && load <= 20){
			patPrecent = 70;
		}
		else if(load > 20 && load <= 30){
			patPrecent = 80;
		}
	}
	
	static Patient fika = new Patient(3,"Fika","", 0); // used to hold a patient at the doctor.
	
	/**
	 * this method is used to remove patients from the queue and draw them at the doctor.
	 * changes how fast the doctor is working based on doctorEff()
	 */
	public static void doctor(){
		doctorEff();
		
		if(Math.random() * 100 < drPrecent && que.size()>0){
			fika = que.pop();
		}
		doctorDraw(fika);
	}
	
	/**
	 * This is a help method to draw patients at the doctor. 
	 * @param p is a patient that is going to be drawn at the doctor.
	 */
	public static void doctorDraw(Patient p){
		
		StdDraw.setPenColor(new Color(0, 0, 0));
		StdDraw.text((xLed/4), yLed/2+20, "" + p.geteKey());
		StdDraw.text((xLed/4), yLed/2, p.getName());
		StdDraw.text((xLed/4), yLed/2-20, p.getDiagnos());
		
		//for rectangle
		StdDraw.setPenColor(p.getColor());
		StdDraw.rectangle((xLed/4), yLed/2, 100, 40);
		
	}
	
	/**
	 * This method is used to determine how fast the doctor is working. This is based on the number of 
	 * people in the queue.
	 */
	public static void doctorEff(){
		int size = que.size();
		if(size >= 0 && size <= 3){
			drPrecent = 50;
		}
		else if (size >= 4 && size < 7){
			drPrecent = 70;
		}
		else if (size >= 7){
			drPrecent = 90;
		}
		
	}
	
	/**
	 * This is a help method to draw patients in the queue.
	 * @param p is a patient to be drawn in the queue.
	 * @param j is used to space out the graphical patients according to the window size.
	 */
	public static void draw(Patient p,int j){
		// for rectangle
		StdDraw.setPenColor(p.getColor());
		StdDraw.rectangle((j * xLed) / (que.size() * 2), 100, 100, 40);
		
		// For text
		StdDraw.setPenColor(new Color(0, 0, 0));
		StdDraw.text((j * xLed) / (que.size() * 2), 80, p.getDiagnos());
		StdDraw.text((j * xLed) / (que.size() * 2), 100, p.getName());
		StdDraw.text((j * xLed) / (que.size() * 2), 120, "" + p.geteKey());
		
	
	}
	
	/**
	 * This method is a help method to draw background elements.
	 * @param iteration is counting how many times the main loop has ran. 
	 */
	public static void drawAlways(int iteration){
		// this is for the cross.
		StdDraw.setPenColor(new Color(255,51,51));
		StdDraw.filledRectangle(xLed / 2, 9*(yLed / 12), xLed/18, yLed/40);
		StdDraw.filledRectangle(xLed / 2, 9*(yLed / 12), yLed/40, xLed/18);
		
		// Writes all the background text and chooses font, color and size accordingly.
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setFont(new Font("Helvetica Bold", 1, 40));
		StdDraw.text(xLed / 2, (27*yLed)/30, "Frysboxxens Akutmottagning");
		StdDraw.setFont(new Font("Helvetica Bold", 1, 17));
		StdDraw.text(5*xLed / 6, (31*yLed)/32, "Dr Procent: " + drPrecent +"%    Patient Procent: " + 
								patPrecent +"%    Itteration: " + iteration);
		StdDraw.text((xLed/4), yLed/2+70, "Nu Behandlas:");
		StdDraw.text(3*(xLed/4), yLed/2+70, "I Receptionen:");
		StdDraw.text((xLed/14), yLed/5, "Kö till doktorn:");
	}

}
