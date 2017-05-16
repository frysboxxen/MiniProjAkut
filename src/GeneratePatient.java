import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeneratePatient {
	
	private static String[] list;
	private static int[] prio;
	private static String[] diagnosArr;
	private static int order;
	
/**
   GeneratePatiens class setup.
   Three arrayes, list, prio and diagnosArr, are created and filled from txt files. 
 * list[] are filled with names of potential patients and prio[] are filled with different priority ranges and diagnosArr[]
 * with 40 different diagnoses. prio[] and diagnosArr[] are connected in the sense that every element(diagnose) at each index in 
 * diagnosArr[] have it's degree of priority at the same index in prio[].
 * */
 
	GeneratePatient() {
		order = 1;
		
		/**
		 * Read and add 200 names from a file into an array. 
		*/
	
		Scanner scan;
		try {
			scan = new Scanner(new File("namn.txt"));
			list = new String[200];
			for (int i = 0; i < list.length; i++) {
				list[i] = scan.next();
				
			}
			scan.close();

			/**
			 * Read and diagnoses to diagnosArr[] and priority degree to prio[].  
			*/
			
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

	
	/**
	 * A method that creates a random patient.  
	 * @param name, patient name
	 * @param diagnos name of the diagnosis
	 * @param priority, patient priority
	 * @param indexName, index in list[]
	 * @param indexPriority, index in prio[] and diagnosArr[]
	 * @param p, the created patient.
	*/
	public Patient create() {
		String name;
		String diagnos;
		int priority;
		int indexName;
		int indexPriority;
		Patient p;

		/**
		 * The method first creates two random numbers. The first number, indexName, represent an index in the list[],
		 * the second number represent an index in both prio[] and diagnosArr[].   
		*/

		indexName = (int) (Math.random() * 199);
		indexPriority = (int) (Math.random() * 39);

		/**
		 Assign each variable to the element at the random index. 
		 Note: prio[] and diagnosArr[] share index because each diagnose are connected to a certain priority degree
		 wich can be found in prio[] at the same index as the diagnose itself in diagnosArr[].  
		*/
		name = list[indexName];
		priority = prio[indexPriority];
		diagnos = diagnosArr[indexPriority];

		/**
		The last step is to actually create the patient by calling to the Patient class constructor,
		assigning priority degree, diagosis, patient name and the patients queue number (which afterwards increses). 
		
		@return the new patient. 
		*/
		
		p = new Patient(priority, diagnos, name, order);
		order++;

		return p;
	

	}

}
