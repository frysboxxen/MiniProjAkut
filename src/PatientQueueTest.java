import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PatientQueueTest {
	PatientQueue test1;
	PatientQueue test2;
	PatientQueue test3;
	int size;
	
	
	@Before
	public void setUp() throws Exception {
		size = 1000;
		test1 = new PatientQueue(size);
		test2 = new PatientQueue(4);
		
	}

	@Test
	public void sizeTest() {
		for(int i = 0; i<1000;i++){
			test1.addPatient(new Patient(3, "Kalle","ovetande",i));
		}
		assertEquals("test to see if size is correct after adding patients",1000,test1.size()); 
	}
	
	@Test
	public void popTest(){
		Patient pat1 = new Patient(1,"Adam","Törstig",1);
		Patient pat2 = new Patient(2,"Sara","Solbränd",2);
		Patient pat3 = new Patient(3,"Kalle","Bakfull",3);
		Patient pat4 = new Patient(2,"Gunnar","Skoskav",4);
		
		test2.addPatient(pat1);
		test2.addPatient(pat2);
		test2.addPatient(pat3);
		test2.addPatient(pat4);
		assertEquals("check to see if the highest priority is poped",pat3.toString(), test2.pop().toString());
		assertEquals("check to see if the highest priority is poped",pat2.toString(), test2.pop().toString());
		assertEquals("check to see if the highest priority is poped",pat4.toString(), test2.pop().toString());
		assertEquals("check to see if the highest priority is poped",pat1.toString(), test2.pop().toString());
		assertEquals("check to see if size is 0 after poping all items in queue",0, test2.size());
		
	}
	
	@Test
	public void copyTest(){
		Patient pat1 = new Patient(1,"Adam","Törstig",1);
		Patient pat2 = new Patient(2,"Sara","Solbränd",2);
		Patient pat3 = new Patient(3,"Kalle","Bakfull",3);
		Patient pat4 = new Patient(2,"Gunnar","Skoskav",4);
		
		test2.addPatient(pat1);
		test2.addPatient(pat2);
		test2.addPatient(pat3);
		test2.addPatient(pat4);
		
		test3 = test2.copy();
		assertEquals("check to see if size are equal after copying", test3.size(), test2.size());
		
		assertEquals("check to see if the highest priority is poped", test3.pop().toString(), test2.pop().toString());
		assertEquals("check to see if the highest priority is poped", test3.pop().toString(), test2.pop().toString());
		assertEquals("check to see if the highest priority is poped", test3.pop().toString(), test2.pop().toString());
		assertEquals("check to see if the highest priority is poped", test3.pop().toString(), test2.pop().toString());
		assertEquals("check to see if size is equal after poping all items in queue", test3.size(), test2.size());
	}
	
	@Test
	public void iteratorTest(){
		Patient pat1 = new Patient(1,"Adam","Törstig",1);
		Patient pat2 = new Patient(2,"Sara","Solbränd",2);
		Patient pat3 = new Patient(3,"Kalle","Bakfull",3);
		Patient pat4 = new Patient(2,"Gunnar","Skoskav",4);
		
		test2.addPatient(pat1);
		test2.addPatient(pat2);
		test2.addPatient(pat3);
		test2.addPatient(pat4);
		
		PatientIterator itr = test2.iterator();
		assertEquals("check to see if has next returns true when tere are items in list", true, itr.hasNext());
		
		while(itr.hasNext()){
			assertEquals("check to see if the highest priority is returned from the iteraror.next().",itr.next().toString(), test2.pop().toString());
		}
		assertEquals("check to see if hasNext returns false when queue is empty", false, itr.hasNext());
	}

}





























