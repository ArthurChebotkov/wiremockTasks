package Tasks;

import Employees.Employee;
import Other.Address;
import Other.Office;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// Create List of Office and de-serialization
public class Task3 {
    public static void main(String[] args) throws IOException {

        final int numberOfOffices = 100;
        final int numberOfEmployees = 10;

        String[] countries = {"USA","Canada","France"};
        String[] cities = {"Paris", "Tokyo","London"};
        String[] streets = {"Baker", "Liberty"};
        final int houses = 100;
        final int floors = 15;
        final int flats = 200;

        String[] names = {"Max", "Mike", "John"};
        String[] surnames = {"Smith","Plank","Huston"};
        String[] patronymics = {"Ivanivich", "Petrovich", "Sergeevich"};
        final int ages = 70;

        Random random = new Random();

        List<Office> offices = new ArrayList<>();

        for(int currentNumberOfOffice = 0; currentNumberOfOffice < numberOfOffices; currentNumberOfOffice++) {
            int randomIndexForCountry = random.nextInt(countries.length);
            int randomIndexForCity = random.nextInt(cities.length);
            int randomIndexForStreet = random.nextInt(streets.length);
            int randomHouse = random.nextInt(houses);
            int randomFloor = random.nextInt(floors);
            int randomFlat = random.nextInt(flats);
            Address address = new Address(
                    countries[randomIndexForCountry],
                    cities[randomIndexForCity],
                    streets[randomIndexForStreet],
                    randomHouse,
                    randomFloor,
                    randomFlat
            );

            List<Employee> employees = new ArrayList<>();
            for(int currentNumberOfEmployee = 0; currentNumberOfEmployee < numberOfEmployees; currentNumberOfEmployee++) {
                int randomIndexForName = random.nextInt(names.length);
                int randomIndexForSurname = random.nextInt(surnames.length);
                int randomIndexForPatronymic = random.nextInt(patronymics.length);
                int randomAge = random.nextInt(ages);
                Employee employee = new Employee(
                        names[randomIndexForName],
                        surnames[randomIndexForSurname],
                        patronymics[randomIndexForPatronymic],
                        randomAge,random.nextBoolean());
                employees.add(employee);
            }

            Office office = new Office(employees,address);
            offices.add(office);
        }


        System.out.println(offices.toString());
        System.out.println("------------------------------");

        FileWriter fileWriter = new FileWriter("src/offices.xml");
        ObjectMapper objectMapper = new XmlMapper();
        objectMapper.writeValue(fileWriter, offices);

        FileReader fileReader = new FileReader("src/offices.xml");
        List<Office> officesOut = objectMapper.readValue(fileReader, new TypeReference<List<Office>>() {});
        System.out.println(offices.toString());
    }
}
