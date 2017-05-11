import java.io.File;
import java.util.Scanner;

public class generatePatient {
	public String[] list;
	public int[] prio;
	public int[] diagnosArr;
	
	generatePatient(){
		
	}
	
	
	public static void main(String[] args) {
		create();
	}
	
	

	public static Patient create() {
		String name;
		String diagnos;
		int priority;
		int indexName;
		int indexPriority;

		Patient p;
		try {
			// läs in och lägg 200 namn i en array.
			Scanner scan = new Scanner(new File("namn.txt"));
			String[] list = new String[200];
			for (int i = 0; i < list.length; i++) {
				list[i] = scan.nextLine();
			}
			scan.close();

			// läser in diagnos samt prioritet till varsin array.
			// Index för diagnosen är samma index i prio.
			Scanner scanDiag = new Scanner(new File("diagnos.txt"));
			String[] diagnosArr = new String[40];
			int[] prio = new int[40];

			for (int j = 0; j < diagnosArr.length; j++) {
				prio[j] = scanDiag.nextInt();
				diagnosArr[j] = scanDiag.next();

			}
			scanDiag.close();

			// Slumpa namn och diagnos/prioritet

			indexName = (int) (Math.random() * 200);
			indexPriority = (int) (Math.random() * 40);

			name = list[indexName];
			priority = prio[indexPriority];
			diagnos = diagnosArr[indexPriority];

			p = new Patient(priority, diagnos, name);

			return p;
		}

		catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
