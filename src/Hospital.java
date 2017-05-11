import java.awt.Color;
import java.awt.Font;

public class Hospital {
	public static void main(String[] args){
//		StdDraw.enableDoubleBuffering();
		int xLed = 1600;
		int yLed = 800;
		StdDraw.setCanvasSize(xLed, yLed);
		StdDraw.setXscale(0,xLed);
		StdDraw.setYscale(0,yLed);

		
		PatientQueue que = new PatientQueue(12);
		que.addPatient(new Patient(0, "Kalle"));
		que.addPatient(new Patient(3, "Karl"));
		que.addPatient(new Patient(2,"Felix"));
		que.addPatient(new Patient(2,"Marcus"));
		que.addPatient(new Patient(3,"Oscar"));
		que.addPatient(new Patient(2,"Elias"));
		que.addPatient(new Patient(2,"Inez"));
		que.addPatient(new Patient(1,"Magdalena"));
		que.addPatient(new Patient(1,"Daniel"));
		que.addPatient(new Patient(0,"Simon"));
		que.addPatient(new Patient(3,"Elisabeth"));

//		que.print();
//		System.out.println();
//		System.out.println("Sort:");
//		System.out.println();
//		que.sort();
//		que.print();
//		System.out.println();
//		System.out.println("Remove");
//		System.out.println();
//		System.out.println(que.pop().toString());
//		System.out.println();
//		que.print();
		PatientIterator u = que.iterator();
		
		
		
		int j = 1;
		char testa = 10;
		System.out.println("hej"+testa+"då");
		
		while(u.hasNext()){
			Patient tmp = u.next();
			StdDraw.setFont(new Font("Helvetica Bold", 1, 17));
			System.out.println(tmp.toString());
			StdDraw.setPenRadius(0.01);
			StdDraw.setPenColor(new Color(0,0,0));
			StdDraw.text((j*xLed)/(que.size()*2), 80, tmp.getDiagnos());
			StdDraw.text((j*xLed)/(que.size()*2), 100, tmp.getName());
			StdDraw.text((j*xLed)/(que.size()*2), 120, ""+tmp.geteKey());
			
			StdDraw.setPenColor(tmp.getColor());

			StdDraw.ellipse((j*xLed)/(que.size()*2), 100, 60, 40);
			j = j +2;
			
		}
	
		StdDraw.show();
		StdDraw.pause(5000);
//		StdDraw.clear();
		
	}
	
}
