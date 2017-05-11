
public class Hospital {
	public static void main(String[] args) {
		Patient p1 = new Patient(0, "kalle");
		Patient p2 = new Patient(3, "karl");

		
		PatientQueue kö = new PatientQueue(11);
		kö.addPatient(p1);
		kö.addPatient(p2);
		kö.addPatient(new Patient(2,"felix"));
		kö.addPatient(new Patient(2,"marcus"));
		kö.addPatient(new Patient(3,"oscar"));
		kö.addPatient(new Patient(2,"elias"));
		kö.addPatient(new Patient(2,"inez"));
		kö.addPatient(new Patient(1,"magdalena"));
		kö.addPatient(new Patient(1,"daniel"));
		kö.addPatient(new Patient(0,"simon"));

		kö.print();
		System.out.println();
		System.out.println("Sort:");
		System.out.println();
		kö.sort();
		kö.print();
		System.out.println();
		System.out.println("Remove");
		System.out.println();
		System.out.println(kö.pop().toString());
		System.out.println();
		kö.print();
		//PatientIterator u = new PatientIterator[4];
		PatientIterator b = kö.iterator();
		System.out.println("iterator print");
		while(b.hasNext()){
			System.out.println(b.next().toString());
		}
		
		
		/*for(int i = 0; i < 4; i++){
			u[i] = kö.iterator();
		}
		
		for(int i = 0; i < 4; i++){
			while(u[i].hasNext()){
				if(u[i].)
			}
		}*/
	}
}
