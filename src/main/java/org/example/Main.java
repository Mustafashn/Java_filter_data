package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        String inputPath = "src/main/java/org/example/Employee.csv";
        String outputPath = "src/main/java/org/example/FilteredEmployees.csv";

        List<Employee> allEmployees = dao.readFromCSV(inputPath);
        List<Employee> filteredEmployees = dao.filterByAgeAndExperience(allEmployees);

        dao.writeFilteredToCSV(filteredEmployees, outputPath);

        System.out.println("İlk dosyadaki çalışan sayısı: " + allEmployees.size());
        System.out.println("Filtrelenmiş dosyadaki çalışan sayısı: " + filteredEmployees.size());
    }
}