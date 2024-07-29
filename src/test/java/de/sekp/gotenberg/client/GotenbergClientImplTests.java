package de.sekp.gotenberg.client;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import org.junit.Test;

import de.sekp.gotenberg.client.dto.GotenbergFile;
import org.junit.jupiter.api.Test;

public class GotenbergClientImplTests {
   
    final String GOTENBERG_BASEURL = "http://localhost:3000";
    final GotenbergClient gotenbergClient = new GotenbergClientImpl(GOTENBERG_BASEURL);

    @Test
    public void testConvertHtmlFile() {
        System.out.println("inside test method");
        // Load Sample File
        var input = getTestFile01();

        // Convert File
        var output = gotenbergClient.conevertHtmlFile(input);

        // Save Output
        toFile(output);
        
    }

    private GotenbergFile getTestFile01() {
        try {
            URL inputUrl = this.getClass().getResource("/samples/index.html");
            var fileData = Files.readAllBytes(Paths.get(inputUrl.toURI()));
            return new GotenbergFile(fileData, "index.html");
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void toFile(GotenbergFile output) {
        try {
         Files.write(Paths.get(output.getName()), output.getData());
            System.out.println(Paths.get(output.getName()));
            Path path = Paths.get(output.getName());
            Path absolutePath = path.toAbsolutePath();
            System.out.println(absolutePath.toString());
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}