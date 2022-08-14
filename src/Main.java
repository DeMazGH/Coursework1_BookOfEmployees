public class Main {
    public static void main(String[] args) {
        Employee[] listOfEmployees = new Employee[10];

        Employee ivanIvanov = new Employee("Иванов Иван Иванович", 1, 50000.0);
        Employee petrPetrov = new Employee("Петров Петр Петрович", 2, 65056.00);
        Employee semenSemenov = new Employee("Семёнов Семён Семёнович", 3, 77777.777);
        Employee denisDenisov = new Employee("Денисов Денис Денисович", 2, 73737.1);

        listOfEmployees[0] = ivanIvanov;
        listOfEmployees[1] = petrPetrov;
        listOfEmployees[2] = semenSemenov;
        listOfEmployees[3] = denisDenisov;

        Employee.printListOfEmployees(listOfEmployees);
        System.out.println(Employee.sumSalaryCostsPerMonth(listOfEmployees));

        System.out.println("Самый низкооплачиваемый работник: " + Employee.findLowestPaidEmployee(listOfEmployees).toString());
        System.out.println("Самый высокооплачиваемый работник: " + Employee.findHighestPaidEmployee(listOfEmployees).toString());
        System.out.println("Средняя зарплата всех работников: " + Employee.calculateAverageSalaries(listOfEmployees));

        Employee.printNamesOfEmployees(listOfEmployees);

        Employee.indexSalary(listOfEmployees, 11);
        Employee.printListOfEmployees(listOfEmployees);

        System.out.println("Самый низкооплачиваемый работник в отделе: " + Employee.findLowestPaidEmployeeInDepartment(listOfEmployees, 2));
        System.out.println("Самый высокооплачиваемый работник в отделе: " + Employee.findHighestPaidEmployeeInDepartment(listOfEmployees, 2));
        System.out.println(Employee.sumSalariesByDepartment(listOfEmployees, 2));
        System.out.println(Employee.calculateAverageSalariesInDepartment(listOfEmployees, 2));
        Employee.indexSalaryInDepartment(listOfEmployees, 2, 3.3);
        Employee.printListOfEmployeesInDepartment(listOfEmployees, 2);

        Employee.printEmployeesWithLoverSalary(listOfEmployees, 75000);
        Employee.printEmployeesWithHigherSalary(listOfEmployees, 75000);


    }
}