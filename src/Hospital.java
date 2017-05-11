
public class Hospital {
	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		int xLed = 1600;
		int yLed = 800;
		StdDraw.setCanvasSize(xLed, yLed);
		Patient p1 = new Patient(0, "kalle");
		Patient p2 = new Patient(3, "karl");

		
		PatientQueue que = new PatientQueue(11);
		que.addPatient(p1);
		que.addPatient(p2);
		que.addPatient(new Patient(2,"felix"));
		que.addPatient(new Patient(2,"marcus"));
		que.addPatient(new Patient(3,"oscar"));
		que.addPatient(new Patient(2,"elias"));
		que.addPatient(new Patient(2,"inez"));
		que.addPatient(new Patient(1,"magdalena"));
		que.addPatient(new Patient(1,"daniel"));
		que.addPatient(new Patient(0,"simon"));

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
		PatientIterator[] u = new PatientIterator[4];
		
		StdDraw.show();
		for(int i = 0; i < 4; i++){
			u[i] = que.iterator();
		}
		
		for(int i = 3; i >= 0; i--){
			while(u[i].hasNext()){
				Patient tmp = u[i].next();
				if(tmp.eKey == i){
					System.out.println(tmp.toString());
				}
			}
		}
		StdDraw.clear();
		
	}
}
