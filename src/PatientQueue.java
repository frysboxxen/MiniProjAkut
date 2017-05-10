
public class PatientQueue {
	
	private Patient[] heap;
 	private int numPatients;
	private int maxSize;
	
	public PatientQueue(int maxSize){
		this.maxSize = maxSize;
		numPatients = 0;
		heap = new Patient[maxSize];
	}
	
	
	
	public void addPatient(Patient p){
		heap[numPatients] = p;
		heapTheArray(0);
		numPatients++;
	}
	
	public void heapSort(){
		
		for(int i = numPatients; i >= 0; i--){
			Patient hurriest = pop();
			heap[i] = hurriest;
		}
	}

	private Patient pop() {
		if(numPatients != 0){
			
			Patient root = heap[0];
			heap[0] = heap[--numPatients];
			
			heapTheArray(0);
			
			return root;
		}
		return null;
	}



	private void heapTheArray(int num) {
		int largestChild;
		Patient root = heap[0];
		
		while(num < numPatients/2){
			int leftChild = num * 2 +1;
			int rightChild = leftChild + 1;
			if(rightChild < numPatients && heap[leftChild].eKey < heap[rightChild].eKey){
				largestChild = rightChild;
			} else{
				largestChild = leftChild;
			}
			if (root.eKey >= heap[largestChild].eKey){
				break;
			}

			heap[num] = heap[largestChild];
			num = largestChild;
		}

		heap[num] = root;
		
	}


	
}
