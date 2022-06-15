package wireMockTasks;

import java.io.IOException;

import Other.ListOfUsers;

import java.io.FileReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class Task3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new XmlMapper();
        ListOfUsers listOfUsers;

        FileReader fileReader = new FileReader("src/Users.xml");
        listOfUsers = objectMapper.readValue(fileReader, ListOfUsers.class);
        System.out.println(listOfUsers.toString());

        // Проверяем, что пользователей 3
        Assert.assertEquals(listOfUsers.users.size(),  3);

        String regex = "user[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        boolean boolAge;

        for(int currentUser = 0; currentUser < listOfUsers.users.size(); currentUser++) {
            // Проверяем, что возраст > 18
            boolAge = listOfUsers.users.get(currentUser).age > 18;
            Assert.assertEquals(boolAge,  true);

            // Проверяем, что имя удовлетворяет выражению user([0-9]*)
            Matcher matcher = pattern.matcher(listOfUsers.users.get(currentUser).name);
            Assert.assertEquals(matcher.matches(),  true);
        }

        // Если все ок, то запускаем сервер
        WireMockServer wireMockServer = new WireMockServer();
        wireMockServer.start();

        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Body is correct!")));
        }
}