package Tasks;

import Employees.Employee;
import Other.Address;
import Other.Office;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Create Office and de-serialization
public class Task2 {
    public static void main(String[] args) throws IOException {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Max", "Volkov",
                "Sergeevisch", 27, true);
        Employee employee2 = new Employee("Mike", "Taison",
                "Sergeevisch", 22, false);

        employees.add(employee1);
        employees.add(employee2);

        Address address = new Address("Russia","Novosibirsk",
                "South street", 40, 3, 41);

        Office office = new Office(employees, address);

        System.out.println(office.toString());

        FileWriter fileWriter = new FileWriter("src/office.xml");
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(fileWriter, office);
        FileReader fileReader = new FileReader("src/office.xml");
        office = objectMapper.readValue(fileReader, Office.class);
        System.out.println(office.toString());
    }
}
