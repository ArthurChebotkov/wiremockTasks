package Users;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "user")

public class User {

    public User() {
    }
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
