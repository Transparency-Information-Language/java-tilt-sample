import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;

public class Tests {

    @Test
    public void showHowToUseTilt() {
        System.out.println("--- Welcome to tilt ---");

        /*
            Generate new Tilt instance from scratch
         */
        Tilt tilt = new Tilt();

        Controller controller = new Controller();
        controller.setName("Example Company SE");
        tilt.setController(controller);

        System.out.println(tilt.toString());


        String DOCUMENT_URL = "https://raw.githubusercontent.com/Transparency-Information-Language/schema/master/tilt.json";

        /*
            Validation Example
         */
        TiltValidator.validateDocumentFromUrl(DOCUMENT_URL);


        /*
            Load tilt instance from json and modify properties
         */
        try {
            String instance = IOUtils.toString(URI.create(DOCUMENT_URL), "utf8");

            System.out.println(instance.indexOf("meta"));

            Tilt t = Converter.fromJsonString(instance);
            System.out.println(t.getMeta().getHash());
            t.getMeta().setHash("42");

            System.out.println(Converter.toJsonString(t));

            System.out.println(t.getMeta().toString());
            System.out.println(t.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
