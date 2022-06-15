package Other;

import Users.User;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class ListOfUsers {

    public ListOfUsers() {
    }
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "user")
    public List<User> users;


    public ListOfUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }

}
