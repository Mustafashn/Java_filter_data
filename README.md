# Employee CSV Filter Application

This Java application reads employee data from a CSV file, filters it based on specific conditions, and writes the filtered data to a new CSV file.

## 📋 Project Overview

The application performs the following steps:

1. Reads employee records from a `CSV` file (`Employee.csv`).
2. Filters employees who:
   - Are **older than 32**
   - Have **more than 2 years of experience** in their current domain.
3. Writes the filtered records to a new CSV file (`FilteredEmployees.csv`).
4. Prints the row count of both the original and filtered files to the console.

## 🔧 Technologies Used

- Java 19
- Maven
- [OpenCSV](http://opencsv.sourceforge.net/) for CSV parsing
- IntelliJ IDEA
