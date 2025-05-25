package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> readFromCSV(String filePath) {
        List<Employee> employeeList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);

                String education = row[0];
                int joiningYear = Integer.parseInt(row[1]);
                String city = row[2];
                int paymentTier = Integer.parseInt(row[3]);
                int age = Integer.parseInt(row[4]);
                String gender = row[5];
                String everBenched = row[6];
                int experience = Integer.parseInt(row[7]);
                int leaveOrNot = Integer.parseInt(row[8]);

                Employee emp = new Employee(education, joiningYear, city, paymentTier, age,
                        gender, everBenched, experience, leaveOrNot);
                employeeList.add(emp);
            }
        } catch (IOException | CsvException e) {
            System.out.println("CSV dosyası okunamadı: " + e.getMessage());
        }

        return employeeList;
    }

    public void writeFilteredToCSV(List<Employee> employees, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{
                    "Education", "JoiningYear", "City", "PaymentTier", "Age",
                    "Gender", "EverBenched", "ExperienceInCurrentDomain", "LeaveOrNot"
            });

            for (Employee e : employees) {
                writer.writeNext(new String[]{
                        e.getEducation(),
                        String.valueOf(e.getJoiningYear()),
                        e.getCity(),
                        String.valueOf(e.getPaymentTier()),
                        String.valueOf(e.getAge()),
                        e.getGender(),
                        e.getEverBenched(),
                        String.valueOf(e.getExperienceInCurrentDomain()),
                        String.valueOf(e.getLeaveOrNot())
                });
            }
        } catch (IOException e) {
            System.out.println("CSV output yazma hatası: " + e.getMessage());
        }
    }

    public List<Employee> filterByAgeAndExperience(List<Employee> employees) {
        List<Employee> filtered = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getAge() > 32 && e.getExperienceInCurrentDomain() > 2) {
                filtered.add(e);
            }
        }
        return filtered;
    }

    public void printEmployees(List<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }


}
