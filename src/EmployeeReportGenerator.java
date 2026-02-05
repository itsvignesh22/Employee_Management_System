import java.util.*;

public class EmployeeReportGenerator { public static void generateDepartmentReport(List<Employee> employees) { Map<String, List<Employee>> map = new HashMap<>();

    for (Employee e : employees) {
        map.computeIfAbsent(e.getDepartment(), k -> new ArrayList<>()).add(e);
    }

    for (String dept : map.keySet()) {
        List<Employee> list = map.get(dept);
        double avg = list.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println(dept + ": " + list.size() + " employees, Average: ₹" + String.format("%.2f", avg));
    }
}

}
