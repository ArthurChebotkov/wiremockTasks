package Tasks;

import Employees.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


// Create Employee and de-serialization
public class Task1 {
    public static void main(String[] args) throws IOException {

        Employee employee = new Employee("Max", "Volkov",
                "Sergeevisch", 27, true);

        System.out.println(employee.toString());

        FileWriter fileWriter = new FileWriter("src/employee.xml");
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(fileWriter, employee);

        FileReader fileReader = new FileReader("src/employee.xml");
        employee = objectMapper.readValue(fileReader, Employee.class);
        System.out.println(employee.toString());

    }

}
