import java.util.Iterator;

public class PatientQueue {

	private Patient[] heap;
	private int numPatients;
	private int maxSize;

	public PatientQueue(int maxSize) {
		this.maxSize = maxSize;
		numPatients = 0;
		heap = new Patient[maxSize];
	}

	public void addPatient(Patient p) {
		heap[numPatients] = p;
		// heapTheArray(0);
		numPatients++;
	}
	public PatientQueue copy(){
		PatientQueue temp = new PatientQueue(numPatients);
			for(int i = 0; i<numPatients;i++){
				temp.addPatient(heap[i]);
			}
		return temp;	
	}

	public void heapSort() {

		for (int i = numPatients; i >= 0; i--) {
			Patient hurriest = pop();
			heap[i] = hurriest;
		}
	}

	public Patient pop() {
		if (numPatients != 0) {

			Patient root = heap[0];
			heap[0] = heap[--numPatients];

			heapTheArray(0);

			return root;
		}
		return null;
	}

	public void heapTheArray(int num) {
		int largestChild;
		Patient root = heap[num];

		while (num < numPatients / 2) {
			int leftChild = num * 2 + 1;
			int rightChild = leftChild + 1;

			if (rightChild < numPatients && heap[leftChild].eKey < heap[rightChild].eKey) {
				largestChild = rightChild;
			} else {
				largestChild = leftChild;
			}
			if (root.eKey >= heap[largestChild].eKey) {
				break;
			}

			heap[num] = heap[largestChild];
			num = largestChild;
		}

		heap[num] = root;

	}

	public void sort() {
		for (int i = maxSize / 2 - 1; i >= 0; i--) {
			heapTheArray(i);
		}
	}

	public void print() {
		for (int i = 0; i < numPatients; i++) {
			System.out.println(heap[i].toString());
		}
	}

	public int size() {
		return numPatients;
	}

	public Patient[] toArray() {
		return heap;
	}

	public PatientIterator iterator() {
		return new PatientIterator(this);
	}

}

class PatientIterator implements Iterator<Patient> {
	PatientQueue que;

	public PatientIterator(PatientQueue que) {
		this.que = que.copy();
		this.que.sort();
	}

	public boolean hasNext() {
		
		return que.size() != 0;
	}

	public Patient next() {
		
			return que.pop();
		
	}
	
	public void remove(){
		// Not in use;
	}

}
