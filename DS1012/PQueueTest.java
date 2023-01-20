package DS1012;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQueueTest {
public static void main(String[] args) {

    Comparator<Patient> myComp = new MyPatientComparator();
	PriorityQueue<Patient> patientQueue = new PriorityQueue<Patient>(10, myComp);
	
	//PriorityQueue<Patient> patientQueue = new PriorityQueue<Patient>(10, new Comparator<Patient>() {
    //    public int compare(Patient patient1, Patient patient2) {
    //        return (patient1.isEmergencyCase() == patient2.isEmergencyCase()) ? (Integer.valueOf(patient1.getId()).compareTo(patient2.getId()))
    //                                                                          : (patient1.isEmergencyCase() ? -1 : 1);
    //    }
    //});

    patientQueue.add(new Patient(1, "Patient1", false));
    patientQueue.add(new Patient(2, "Patient2", false));
    patientQueue.add(new Patient(3, "Patient3", true));
    patientQueue.add(new Patient(4, "Patient4", false));
    patientQueue.add(new Patient(5, "Patient5", true));
    

    System.out.println();
    System.out.print("Doctor's waiting for patients  : ");
    while(true) {
        Patient currentPatient = patientQueue.poll();//poll은 pop같은 기능
        if(currentPatient == null) {
            break;
        }
        
        Patient nextPatient = patientQueue.peek();
        if(nextPatient==null) {
        	System.out.println(currentPatient.getName());
        }else {
        	System.out.print(currentPatient.getName() + " <-- ");
        }
        
    }
    
}
}

class MyPatientComparator implements Comparator<Patient> 
{
        
		public int compare(Patient patient1, Patient patient2) {
            if(patient1.isEmergencyCase()==patient2.isEmergencyCase())
            {
            	if(patient1.getId()<patient2.getId()) {
            		return -1;
            	} else {
            		return 1;
            	}
            }else {
            	if(patient1.isEmergencyCase()) {
            		return -1;
            	}
            	else {
            		return 1;
            	}
            }//return은 priority를 return해주고 있음, return값이 작아야 우선처리되기 때문에 우선인 것을 -1을 return 하게 함
			
			
			//return (patient1.isEmergencyCase() == patient2.isEmergencyCase()) ? (Integer.valueOf(patient1.getId()).compareTo(patient2.getId()))
                                                                              //: (patient1.isEmergencyCase() ? -1 : 1);
        }
}

/*
class MyPatientComparator<T extends Comparable<T>> implements Comparator<T> 
{
        
		public int compare(Patient patient1, Patient patient2) {
            return (patient1.isEmergencyCase() == patient2.isEmergencyCase()) ? (Integer.valueOf(patient1.getId()).compareTo(patient2.getId()))
                                                                              : (patient1.isEmergencyCase() ? -1 : 1);
        }
}
*/