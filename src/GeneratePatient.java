import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeneratePatient {
	private static String[] list;
	private static int[] prio;
	private static String[] diagnosArr;
	private static int order;

	GeneratePatient() {
		order = 1;
		// l�s in och l�gg 200 namn i en array.
		Scanner scan;
		try {
			scan = new Scanner(new File("namn.txt"));
			list = new String[200];
			for (int i = 0; i < list.length; i++) {
				list[i] = scan.next();
				
			}
			scan.close();

			// l�ser in diagnos samt prioritet till varsin array.
			// Index f�r diagnosen �r samma index i prio.
			Scanner scanDiag = new Scanner(new File("diagnos.txt"));
			diagnosArr = new String[40];
			prio = new int[40];

			for (int j = 0; j < diagnosArr.length; j++) {
				prio[j] = scanDiag.nextInt();
				diagnosArr[j] = scanDiag.next();

			}
			scanDiag.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Patient create() {
		String name;
		String diagnos;
		int priority;
		int indexName;
		int indexPriority;
		Patient p;

		// Slumpa namn och diagnos/prioritet

		indexName = (int) (Math.random() * 199);
		indexPriority = (int) (Math.random() * 39);

		name = list[indexName];
		priority = prio[indexPriority];
		diagnos = diagnosArr[indexPriority];

		p = new Patient(priority, diagnos, name, order);
		order++;

		return p;

	}

}
