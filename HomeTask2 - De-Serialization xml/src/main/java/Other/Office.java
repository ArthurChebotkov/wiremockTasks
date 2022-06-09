package Other;

import Employees.Employee;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

public class Office {

    public Office() {
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Employee")
    public List<Employee> employees;
    public Address address;


    public Office(List<Employee> employees, Address address) {
        this.employees = employees;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Office{" +
                "employees=" + employees +
                ", address=" + address +
                '}';
    }

}
