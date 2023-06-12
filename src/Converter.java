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
    public double operations(double num1, double num2, char sym1, char sym2, char sym3, int z){
        return sym1=='$'?(sym2=='+'?num1+num2:num1-num2):(sym1=='R'?(sym2=='+'?num1+num2:num1-num2):(sym2=='+'?(sym3=='$'?num1+toDollars(num2):toRubles(num1)+num2):(z==1?(sym3=='$'?num1-toDollars(num2):toRubles(num1)-num2):(sym3=='$'?toDollars(num1)-num2:num1-toRubles(num2)))));
    }
}
