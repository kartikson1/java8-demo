import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employees.stream() // Stream API
                .filter(e -> e.getDepartment().equals(department))
                .toList();
    }

    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary) // Method reference
                .average()
                .orElse(0); // Optional
    }

    public Employee getEmployeeWithMaxSalary() {
        return employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
    }

    public List<Employee> getEmployeesByAge(int age) {
        LocalDate today = LocalDate.now(); // New Date API
        LocalDate birthDate = today.minusYears(age);

        return employees.stream()
                .filter(e -> e.getBirthDate().isBefore(birthDate)) // Lambda expression
                .toList();
    }

    public void giveRaise(double percentage) {
        employees.forEach(e -> e.setSalary(e.getSalary() * (1 + percentage / 100)));
    }
}

class Employee {
    private String name;
    private String department;
    private LocalDate birthDate;
    private double salary;

    public Employee(String name, String department, LocalDate birthDate, double salary) {
        this.name = name;
        this.department = department;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
