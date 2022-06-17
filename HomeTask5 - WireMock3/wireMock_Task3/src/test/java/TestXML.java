import Other.ListOfUsers;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import okhttp3.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import Other.SerializationXML;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class TestXML {

    @Rule
    public WireMockRule wm = new WireMockRule(options()
            .extensions(new ResponseTemplateTransformer(false)));

    @Test
    public void wiremock_rule_test() throws IOException {

        // Activate stub
        configureStubs();

        // Deserialization XML file
        ListOfUsers listOfUsers;
        SerializationXML xmlObject= new SerializationXML();
        listOfUsers = xmlObject.DeSerializationXML("src/Users.xml");

        int countUsers = 3;
        // Check that number of users is 3
        Assert.assertEquals(listOfUsers.users.size(),  countUsers);

        String regex = "user[0-9]*";
        Pattern pattern = Pattern.compile(regex);

        for(int currentUser = 0; currentUser < listOfUsers.users.size(); currentUser++) {
            // Check that age over 18
            Assert.assertTrue(listOfUsers.users.get(currentUser).age > 18);

            // Check that name is equal to user([0-9]*)
            Matcher matcher = pattern.matcher(listOfUsers.users.get(currentUser).name);
            Assert.assertTrue(matcher.matches());
        }

        // Post file (Users.xml) to server
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/xml");

        File file = new File("src/Users.xml");
        Request request = new Request.Builder()
                .url("http://localhost:8080/some/thing")
                .post(RequestBody.create(mediaType, file))
                .build();

        Response response = client.newCall(request).execute();

        // Print response from server
        System.out.println("Response from server: " + response.body().string());

    }

    // Stub
    private void configureStubs() {
        configureFor("localhost", 8080);
        wm.stubFor(post(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("XML file is correct!")
                        .withTransformers("response-template")));
    }
}
