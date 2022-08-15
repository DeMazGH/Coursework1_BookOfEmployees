public class Employee {
    private final String name;
    private int department;
    private double salary;
    static int count = 0;
    private final int id;

    public Employee(String name, int department, double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной!");
        }
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Неверный номер отдела, допустимое значение от 1 до 5!");
        }
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = count;
        count++;
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
