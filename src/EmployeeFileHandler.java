import java.io.*;
import java.util.List;

public class EmployeeFileHandler {
    private static final String FILE_NAME = "employees.dat";

    public static void saveToFile(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employee data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No existing data found.");
            return null;
        }
    }

}
