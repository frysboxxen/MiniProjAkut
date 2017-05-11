
public class Hospital {
	public static void main(String[] args) {
//		StdDraw.enableDoubleBuffering();
		int xLed = 1600;
		int yLed = 800;
		StdDraw.setCanvasSize(xLed, yLed);
		StdDraw.setXscale(0,xLed);
		StdDraw.setYscale(0,yLed);

		
		PatientQueue que = new PatientQueue(12);
		que.addPatient(new Patient(0, "kalle"));
		que.addPatient(new Patient(3, "karl"));
		que.addPatient(new Patient(2,"felix"));
		que.addPatient(new Patient(2,"marcus"));
		que.addPatient(new Patient(3,"oscar"));
		que.addPatient(new Patient(2,"elias"));
		que.addPatient(new Patient(2,"inez"));
		que.addPatient(new Patient(1,"magdalena"));
		que.addPatient(new Patient(1,"daniel"));
		que.addPatient(new Patient(0,"simon"));
		que.addPatient(new Patient(3,"elisabeth"));

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
		
		while(u.hasNext()){
			Patient tmp = u.next();
			
			System.out.println(tmp.toString());
			StdDraw.setPenColor(tmp.getColor());
			StdDraw.setPenRadius(0.01);
			StdDraw.ellipse((j*xLed)/(que.size()*2), 100, 60, 40);
			j = j +2;
			
		}
	
		StdDraw.show();
		StdDraw.pause(5000);
//		StdDraw.clear();
		
	}
	
}
