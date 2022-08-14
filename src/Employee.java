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

    public static void getListOfEmployees(Employee[] listOfEmployees) {
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                System.out.println(currentEmployee);
            }
        }
    }

    public static double sumSalaryCostsPerMonth(Employee[] listOfEmployees) {
        double allSalaries = 0.0;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                allSalaries += currentEmployee.getSalary();
            }
        }
        return RoundingDouble.roundingDoubleToHundredths(allSalaries);
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
            if (currentEmployee != null && currentEmployee.getSalary() <= lowestSalary) {
                lowestSalary = currentEmployee.getSalary();
                lowestPaidEmployee = currentEmployee;
            }
        }
        return lowestPaidEmployee;
    }

    public static Employee findHighestPaidEmployee(Employee[] listOfEmployees) {
        double highestSalary = 0;
        Employee highestPaidEmloyee = null;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getSalary() > highestSalary) {
                highestSalary = currentEmployee.getSalary();
                highestPaidEmloyee = currentEmployee;
            }
        }
        return highestPaidEmloyee;
    }

    public static double calculateAverageSalaries(Employee[] listOfEmployees) {
        double allSalaries = 0.0;
        int currentNumberOfEmployees = 0;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                allSalaries += currentEmployee.getSalary();
                currentNumberOfEmployees++;
            }
        }
        double averageSalaries = allSalaries / currentNumberOfEmployees;
        return RoundingDouble.roundingDoubleToHundredths(averageSalaries);
    }

    public static void getNamesOfEmployees(Employee[] listOfEmployees) {
        System.out.println("Список имён сотрудников: ");
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                System.out.println(currentEmployee.getName());
            }
        }
    }

    public static void indexSalary(Employee[] listOfEmploees, double indexationPercentage) {
        for (Employee currentEmployee : listOfEmploees) {
            if (currentEmployee != null) {
                currentEmployee.setSalary(RoundingDouble.roundingDoubleToHundredths(currentEmployee.getSalary() + currentEmployee.getSalary() / 100 * indexationPercentage));
            }
        }
    }

    public static Employee findLowestPaidEmployeeInDepartment(Employee[] listOfEmployees, int departmentNumber) {
        if (departmentNumber <= 0 || departmentNumber > 5) {
            throw new IllegalArgumentException("Неверный номер отдела, допустимое значение от 1 до 5!");
        }
        double lowestSalaryInDepartment = 0;
        Employee lowestPaidEmployeeInDepartment = null;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                lowestSalaryInDepartment = currentEmployee.getSalary();
            }
        }
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber && currentEmployee.getSalary() <= lowestSalaryInDepartment ) {
                lowestSalaryInDepartment = currentEmployee.getSalary();
                lowestPaidEmployeeInDepartment = currentEmployee;
            }
        }
        return lowestPaidEmployeeInDepartment;
    }

    public static Employee findHighestPaidEmployeeInDepartment(Employee[] listOfEmployees, int departmentNumber) {
        if (departmentNumber <= 0 || departmentNumber > 5) {
            throw new IllegalArgumentException("Неверный номер отдела, допустимое значение от 1 до 5!");
        }
        double highestSalaryInDepartment = 0;
        Employee highestPaidEmloyeeInDepartment = null;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getSalary() > highestSalaryInDepartment && currentEmployee.getDepartment() == departmentNumber) {
                highestSalaryInDepartment = currentEmployee.getSalary();
                highestPaidEmloyeeInDepartment = currentEmployee;
            }
        }
        return highestPaidEmloyeeInDepartment;
    }

    public static double sumSalariesByDepartment(Employee[] listOfEmployees, int departmentNumber) {
        double allSalariesInDepartment = 0.0;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                allSalariesInDepartment += currentEmployee.getSalary();
            }
        }
        return RoundingDouble.roundingDoubleToHundredths(allSalariesInDepartment);
    }

    public static double calculateAverageSalariesInDepartment(Employee[] listOfEmployees, int departmentNumber) {
        double allSalariesInDepartment = 0.0;
        int currentNumberOfEmployees = 0;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                allSalariesInDepartment += currentEmployee.getSalary();
                currentNumberOfEmployees++;
            }
        }
        double averageSalaries = allSalariesInDepartment / currentNumberOfEmployees;
        return RoundingDouble.roundingDoubleToHundredths(averageSalaries);
    }

    public static void indexSalaryInDepartment(Employee[] listOfEmploees, int departmentNumber, double indexationPercentage) {
        for (Employee currentEmployee : listOfEmploees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                currentEmployee.setSalary(RoundingDouble.roundingDoubleToHundredths(currentEmployee.getSalary() + currentEmployee.getSalary() / 100 * indexationPercentage));
            }
        }
    }

    public static void printListOfEmployeesInDepartment(Employee[] listOfEmployees, int departmentNumber) {
        System.out.printf("Данные сотрудников отдела №%s: \n", departmentNumber);
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                System.out.printf("Работник id-%s, ФИО: %s,  зарплата - %.2f руб.\n", currentEmployee.getId(), currentEmployee.getName(), currentEmployee.getSalary());
            }
        }
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
