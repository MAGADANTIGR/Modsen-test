import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Converter {
    public Converter() throws IOException, ParseException {
    }
    Object o = new JSONParser().parse(new FileReader("file.json"));
    JSONObject j = (JSONObject) o;

    private double cRubles = Double.parseDouble((String) j.get("toRubles"));
    private double cDollars = Double.parseDouble((String)j.get("toDollars"));

    public double toRubles(double dollars) {
        return dollars*cRubles;
    }

    public double toDollars(double rubles) {
        return rubles*cDollars;
    }

}
