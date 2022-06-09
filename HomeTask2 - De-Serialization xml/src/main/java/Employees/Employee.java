package Employees;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Employee")

public class Employee {

    public Employee() {
    }
    public static int count;
    public int id;
    public String name;
    public String surname;
    public String patronymic;
    public int age;
    public boolean workExperience;

    public Employee(String name, String surname, String patronymic, int age, boolean workExperience) {
        count++;
        this.id = count;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.workExperience = workExperience;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", workExperience=" + workExperience +
                '}';
    }

}
