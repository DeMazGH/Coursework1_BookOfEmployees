public class Employee {
    private final String name;
    private int department;
    private double salary;
    static int count = 0;
    private final int id;

    public Employee(String name, int department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = count;
        count++;
    }

    public static void getListOfEmployees(Employee[] listOfEmployees) {
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                System.out.println(currentEmployee);
            }
        }
    }

    public static double salaryCostsPerMonth(Employee[] listOfEmployees) {
        double allSalaries = 0.0;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                allSalaries += currentEmployee.getSalary();
            }
        }
        return DoubleRounding.roundingDoubleToHundredths(allSalaries);
    }

    public static Employee findLowestPaidEmployee(Employee[] listOfEmployees) {
        double lowestSalary = 0;
        Employee lowestPaidEmployee = null;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                lowestSalary = currentEmployee.getSalary();
            }
        }
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getSalary() < lowestSalary) {
                lowestSalary = currentEmployee.getSalary();
                lowestPaidEmployee = currentEmployee;
            }
        }
        return lowestPaidEmployee;
    }

    @Override
    public String toString() {
        return String.format("Работник id-%s, ФИО: %s, отдел №%s, зарплата - %.2f руб.", id, name, department, salary);
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
