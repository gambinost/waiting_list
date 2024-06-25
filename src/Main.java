public class Main {
    public static void main(String[] args) {
        PatientsQueue patientsQueue = new PatientsQueue();
        // Patients taking their number in order
//        Patient.Take_A_Number(patientsQueue);
//        Patient.Take_A_Number(patientsQueue);
//        Patient.Take_A_Number(patientsQueue);
//        Patient.Take_A_Number(patientsQueue);

//        patientsQueue.PrintList();
//        System.out.println("Number of patients: " + patientsQueue.number_of_patients());
//
//        // Calling for the first patient in line (based on their order)
        patientsQueue.Calling();
        patientsQueue.Delete();
//        patientsQueue.PrintList();
//
//        patientsQueue.Calling();
//        patientsQueue.Delete();
//        patientsQueue.PrintList();
    }
}
