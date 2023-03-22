import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> filteredEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    public double getAverageSalary() {
        if (employees.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }

    public Employee getEmployeeWithMaxSalary() {
        if (employees.isEmpty()) {
            return null;
        }
        Employee maxEmployee = employees.get(0);
        for (int i = 1; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getSalary() > maxEmployee.getSalary()) {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    public List<Employee> getEmployeesByAge(int age) {
        List<Employee> filteredEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            if (employee.getBirthDate().getYear() <= (LocalDate.now().getYear() - age)) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }

    public void giveRaise(double percentage) {
        for (Employee employee : employees) {
            double newSalary = employee.getSalary() * (1 + percentage / 100);
            employee.setSalary(newSalary);
        }
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
