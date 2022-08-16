public class Main {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();
        Employee ivanIvanov = new Employee("Иванов Иван Иванович", 1, 50000.0);
        Employee petrPetrov = new Employee("Петров Петр Петрович", 2, 65056.00);
        Employee semenSemenov = new Employee("Семёнов Семён Семёнович", 3, 77777.777);
        Employee denisDenisov = new Employee("Денисов Денис Денисович", 2, 73737.1);

        employeeBook.addNewEmployee(ivanIvanov);
        employeeBook.addNewEmployee(petrPetrov);
        employeeBook.addNewEmployee(semenSemenov);
        employeeBook.addNewEmployee(denisDenisov);

        employeeBook.printListOfEmployees();
        System.out.println(employeeBook.sumSalaryCostsPerMonth());
        System.out.println("Самый низкооплачиваемый работник: " + employeeBook.findLowestPaidEmployee().toString());
        System.out.println("Самый высокооплачиваемый работник: " + employeeBook.findHighestPaidEmployee().toString());
        System.out.println("Средняя зарплата всех работников: " + employeeBook.calculateAverageSalaries());
        employeeBook.printEmployeeNames();
        employeeBook.indexSalary(11);
        employeeBook.printListOfEmployees();
        System.out.println("Самый низкооплачиваемый работник в отделе: " + employeeBook.findLowestPaidEmployeeInDepartment(2));
        System.out.println("Самый высокооплачиваемый работник в отделе: " + employeeBook.findHighestPaidEmployeeInDepartment(2));
        System.out.println(employeeBook.sumSalariesByDepartment(2));
        System.out.println(employeeBook.calculateAverageSalariesInDepartment(2));
        employeeBook.indexSalaryInDepartment(2, -3.3);
        employeeBook.printListOfEmployeesInDepartment(2);
        employeeBook.printEmployeesWithLoverSalary(75000);
        employeeBook.printEmployeesWithHigherSalary(75000);
        System.out.println();
        employeeBook.deleteEmployee("Петров петр Петрович");
        employeeBook.printListOfEmployees();
        System.out.println();
        employeeBook.deleteEmployee(0);
        employeeBook.printListOfEmployees();
        System.out.println();
        employeeBook.changeEmployeeSalary("Денисов Денис денисович", 99000.999);
        employeeBook.changeEmployeeDepartment("денисов Денис Денисович", 3);
        employeeBook.printListOfEmployees();
        System.out.println();
        employeeBook.printEmployeeNamesByDepartment();
    }
}