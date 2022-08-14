public class Main {
    public static void main(String[] args) {
        Employee[] listOfEmployees = new Employee[10];

        Employee ivanIvanov = new Employee("Иванов Иван Иванович", 1, 50000.0);
        Employee petrPetrov = new Employee("Петров Петр Петрович", 2, 65056.00);
        Employee semenSemenov = new Employee("Семёнов Семён Семёнович", 3, 77777.777);

        listOfEmployees[0] = ivanIvanov;
        listOfEmployees[1] = petrPetrov;
        listOfEmployees[2] = semenSemenov;

        Employee.getListOfEmployees(listOfEmployees);
        System.out.println(Employee.salaryCostsPerMonth(listOfEmployees));

        System.out.println("Самый низкооплачиваемый работник: " + Employee.findLowestPaidEmployee(listOfEmployees).toString());
        System.out.println("Самый высокооплачиваемый работник: " + Employee.findHighestPaidEmployee(listOfEmployees).toString());
        System.out.println("Средняя зарплата всех работников: " + Employee.calculateAverageSalaries(listOfEmployees));

        Employee.getNamesOfEmployees(listOfEmployees);
    }
}