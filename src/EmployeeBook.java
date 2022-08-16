public class EmployeeBook {
    private final Employee[] listOfEmployees = new Employee[20];

    public void addNewEmployee(Employee newEmployee) {
        int counter = 0;
        while (counter < listOfEmployees.length) {
            if (listOfEmployees[counter] == null) {
                listOfEmployees[counter] = newEmployee;
                break;
            }
            counter++;
        }
        if (counter == listOfEmployees.length) {
            throw new RuntimeException("Список сотрудников переполнен!");
        }
    }

    public void deleteEmployee(String name) {
        int counter = 0;
        while (counter < listOfEmployees.length) {
            if (listOfEmployees[counter] != null && listOfEmployees[counter].getName().equalsIgnoreCase(name)) {
                listOfEmployees[counter] = null;
                break;
            }
            counter++;
        }
        if (counter == listOfEmployees.length) {
            throw new RuntimeException("Сотрудник не найден, проверьте правильность ввода данных!");
        }
    }

    public void deleteEmployee(int id) {
        int counter = 0;
        while (counter < listOfEmployees.length) {
            if (listOfEmployees[counter] != null && listOfEmployees[counter].getId() == id) {
                listOfEmployees[counter] = null;
                break;
            }
            counter++;
        }
        if (counter == listOfEmployees.length) {
            throw new RuntimeException("Сотрудник не найден, проверьте правильность ввода данных!");
        }
    }

    public void printListOfEmployees() {
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                System.out.println(currentEmployee);
            }
        }
    }

    public void printListOfEmployeesInDepartment(int departmentNumber) {
        System.out.printf("Данные сотрудников отдела №%s: \n", departmentNumber);
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                System.out.printf("Работник id-%s, ФИО: %s,  зарплата - %.2f руб.\n", currentEmployee.getId(), currentEmployee.getName(), currentEmployee.getSalary());
            }
        }
    }

    public void printNamesOfEmployees() {
        System.out.println("Список имён сотрудников: ");
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                System.out.println(currentEmployee.getName());
            }
        }
    }

    public void printEmployeesWithLoverSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной!");
        }
        System.out.printf("Сотрудники с зарплатой менее %s: \n", salary);
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getSalary() < salary) {
                System.out.printf("Работник id-%s, ФИО: %s,  зарплата - %.2f руб.\n", currentEmployee.getId(), currentEmployee.getName(), currentEmployee.getSalary());
            }
        }
    }

    public void printEmployeesWithHigherSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной!");
        }
        System.out.printf("Сотрудники с зарплатой более или равной %s: \n", salary);
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getSalary() > salary) {
                System.out.printf("Работник id-%s, ФИО: %s,  зарплата - %.2f руб.\n", currentEmployee.getId(), currentEmployee.getName(), currentEmployee.getSalary());
            }
        }
    }

    public double sumSalaryCostsPerMonth() {
        double allSalaries = 0.0;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                allSalaries += currentEmployee.getSalary();
            }
        }
        return RoundingDouble.roundingDoubleToHundredths(allSalaries);
    }

    public double sumSalariesByDepartment(int departmentNumber) {
        if (departmentNumber <= 0 || departmentNumber > 5) {
            throw new IllegalArgumentException("Неверный номер отдела, допустимое значение от 1 до 5!");
        }
        double allSalariesInDepartment = 0.0;
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                allSalariesInDepartment += currentEmployee.getSalary();
            }
        }
        return RoundingDouble.roundingDoubleToHundredths(allSalariesInDepartment);
    }

    public double calculateAverageSalaries() {
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

    public double calculateAverageSalariesInDepartment(int departmentNumber) {
        if (departmentNumber <= 0 || departmentNumber > 5) {
            throw new IllegalArgumentException("Неверный номер отдела, допустимое значение от 1 до 5!");
        }
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

    public void indexSalary(double indexationPercentage) {
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null) {
                double indexedSalary = currentEmployee.getSalary() + currentEmployee.getSalary() / 100 * indexationPercentage;
                currentEmployee.setSalary(RoundingDouble.roundingDoubleToHundredths(indexedSalary));
            }
        }
    }

    public void indexSalaryInDepartment(int departmentNumber, double indexationPercentage) {
        if (departmentNumber <= 0 || departmentNumber > 5) {
            throw new IllegalArgumentException("Неверный номер отдела, допустимое значение от 1 до 5!");
        }
        for (Employee currentEmployee : listOfEmployees) {
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber) {
                currentEmployee.setSalary(RoundingDouble.roundingDoubleToHundredths(currentEmployee.getSalary() + currentEmployee.getSalary() / 100 * indexationPercentage));
            }
        }
    }

    public Employee findLowestPaidEmployee() {
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

    public Employee findLowestPaidEmployeeInDepartment(int departmentNumber) {
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
            if (currentEmployee != null && currentEmployee.getDepartment() == departmentNumber && currentEmployee.getSalary() <= lowestSalaryInDepartment) {
                lowestSalaryInDepartment = currentEmployee.getSalary();
                lowestPaidEmployeeInDepartment = currentEmployee;
            }
        }
        return lowestPaidEmployeeInDepartment;
    }

    public Employee findHighestPaidEmployee() {
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

    public Employee findHighestPaidEmployeeInDepartment(int departmentNumber) {
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

    public void changeEmployeeSalary(String name, double newSalary) {
        int counter = 0;
        while (counter < listOfEmployees.length) {
            if (listOfEmployees[counter] != null && listOfEmployees[counter].getName().equalsIgnoreCase(name)) {
                listOfEmployees[counter].setSalary(RoundingDouble.roundingDoubleToHundredths(newSalary));
                break;
            }
            counter++;
        }
        if (counter == listOfEmployees.length) {
            throw new RuntimeException("Сотрудник не найден, проверьте правильность ввода данных!");
        }
    }

    public void changeEmployeeDepartment(String name, int newDepartmentNumber) {
        int counter = 0;
        while (counter < listOfEmployees.length) {
            if (listOfEmployees[counter] != null && listOfEmployees[counter].getName().equalsIgnoreCase(name)) {
                listOfEmployees[counter].setDepartment(newDepartmentNumber);
                break;
            }
            counter++;
        }
        if (counter == listOfEmployees.length) {
            throw new RuntimeException("Сотрудник не найден, проверьте правильность ввода данных!");
        }
    }
}
