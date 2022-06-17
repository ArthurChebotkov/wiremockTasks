package Other;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.IOException;

public class SerializationXML {

    public SerializationXML() {
    }

    public ListOfUsers DeSerializationXML(String path) throws IOException {
        ObjectMapper objectMapper = new XmlMapper();
        ListOfUsers listOfUsers;

        FileReader fileReader = new FileReader(path);
        listOfUsers = objectMapper.readValue(fileReader, ListOfUsers.class);
        System.out.println("Deserialization XML file: " + listOfUsers.toString());

        return listOfUsers;

    }


}
