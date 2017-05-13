import java.util.Iterator;

public class PatientQueue {

	private Patient[] heap;
	private int numPatients;
	private int maxSize;
	
	/**
	 * Constructor for PatientQueue
	 * @param maxSize is used to tell the queue how many spaces it should have.
	 */
	public PatientQueue(int maxSize) {
		this.maxSize = maxSize;
		numPatients = 0;
		heap = new Patient[maxSize];
	}
	
	/**
	 * Adds a patient based on priority and order. Keeps queue sorted.
	 * @param p is a patient to be added to the queue.
	 */
	public void addPatient(Patient p) {
		heap[numPatients] = p;
		sort();
		numPatients++;
	}

	/**
	 * Copies the patient queue.
	 * @return a copy of the PatientQueue
	 */
	public PatientQueue copy() {
		PatientQueue temp = new PatientQueue(numPatients);
		for (int i = 0; i < numPatients; i++) {
			temp.addPatient(heap[i]);
		}
		return temp;
	}

	/**
	 * Removes the highest priority Patient from the queue.
	 * @return The Patient with the highest priority and lowest orderNumber
	 */
	public Patient pop() {
		if (numPatients != 0) {

			Patient root = heap[0];
			heap[0] = heap[--numPatients];

			heapTheArray(0);

			return root;
		}
		return null;
	}

	/**
	 * Private help method to order the queue based on compareTo. The highest priority patient is first
	 * in the queue.
	 * @param num is the location in the array to start comparing
	 */
	private void heapTheArray(int num) {
		int largestChild;
		Patient root = heap[num];

		while (num < numPatients / 2) {
			int leftChild = num * 2 + 1;
			int rightChild = leftChild + 1;
			
			if (rightChild < numPatients && heap[leftChild].compareTo(heap[rightChild]) < 0) {
				largestChild = rightChild;
			} else {
				largestChild = leftChild;
			}

			if (root.compareTo(heap[largestChild]) > 0) {
				break;
			}

			heap[num] = heap[largestChild];
			num = largestChild;
		}

		heap[num] = root;

	}

	/**
	 * A method to sort the queue based on compareTo, highest priority is first in the queue.
	 */
	public void sort() {
		for (int i = maxSize / 2 - 1; i >= 0; i--) {
			heapTheArray(i);
		}
	}

	/**
	 * 
	 * @return the number of patients in queue.
	 */
	public int size() {
		return numPatients;
	}

	/**
	 * Creates a PatientIterator that traverses the queue in order of priority and order. 
	 * @return a patientIterator
	 */
	public PatientIterator iterator() {
		return new PatientIterator(this);
	}
	
	/**
	 *  Changes the priority of a patient.
	 * @param s is the name of the patient that is going to change.
	 * @param k is the new priority, must be between 0 ant 3.
	 */
	public boolean changePrio(String s, int k) {
		if (k >= 0 && k <= 3) {
			for (int i = 0; i < numPatients; i++) {
				if (heap[i].getName().equals(s)) {
					heap[i].eKey = k;
					sort();
					return true;
				}
			}
		}
		return false;
	}

}


class PatientIterator implements Iterator<Patient> {
	PatientQueue que;

	/**
	 * Constructor for PatientIterator
	 * @param que is the PatientQueue to create an Iterator from. 
	 */
	public PatientIterator(PatientQueue que) {
		this.que = que.copy();
		this.que.sort();
	}

	/**
	 * Checks is the size of que is not equal to 0. 
	 * @return true if iterator has not gone through the PatientQueue.
	 */
	public boolean hasNext() {

		return que.size() != 0;
	}

	/**
	 * @return next Patient based on order of compareTo. 
	 */
	public Patient next() {

		return que.pop();

	}

	/**
	 * Unimplemented method.
	 */
	public void remove() {
		// Not in use;
	}

}
