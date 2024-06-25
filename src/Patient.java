import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient extends Person {
    int patientOrder;
    static int registrationNumber = 0;

    public Patient() {
    }

    public Patient(String name, int age) {
        super(name, age);
    }

    public Patient(int patientOrder) {
        this.patientOrder = patientOrder;
    }

    public static Patient Take_A_Number(PatientsQueue list) {
        try (Scanner in = new Scanner(System.in);
             Connection conn = DatabaseUtil.getConnection()) {
            String maxOrderQuery = "SELECT MAX(patientOrder) FROM patients";
            try (PreparedStatement maxOrderStmt = conn.prepareStatement(maxOrderQuery);
                 ResultSet resultSet = maxOrderStmt.executeQuery()) {

                int currentMaxOrder = 0;
                if (resultSet.next()) {
                    currentMaxOrder = resultSet.getInt(1);
                }

                int newPatientOrder = currentMaxOrder + 1;

                System.out.println("Enter the patient's name: ");
                String name = in.nextLine();
                System.out.println("Enter the patient's age: ");
                int age = in.nextInt();
                in.nextLine();

                Patient patient = new Patient(name, age);
                patient.patientOrder = newPatientOrder;
                list.Add(patient);
                patient.saveToDatabase();
                return patient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void saveToDatabase() {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO patients (name, patientOrder) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, this.name);
                stmt.setInt(2, this.patientOrder);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", patientOrder=" + patientOrder +
                '}';
    }
}
