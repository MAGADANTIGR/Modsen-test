import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        System.out.println("Введите выражение (разделитель целой и дробной части - точка)");
        String str=scanner.nextLine();

        if(str.substring(1).matches("\\d+(\\.)?\\d*") && str.substring(0, 1).equals("$")){
            System.out.printf("Перевод в рубли: %.2fр", converter.toRubles(Double.parseDouble(str.substring(1))));
        }
        else if(str.substring(0, str.length()-1).matches("\\d+(\\.)?\\d*") && str.substring(str.length()-1).equals("р")){
            System.out.printf("Перевод в доллары: $%.2f", converter.toDollars(Double.parseDouble(str.substring(0, str.length()-1))));
        } else if(str.matches("^(\\$)\\d+(\\.)?\\d*(\\+)\\d+(\\.)?\\d*р$")){
            System.out.printf("Результат сложения в рублях: %.2fр\n", converter.toRubles(Double.parseDouble(str.substring(1, str.indexOf("+"))))+Double.parseDouble(str.substring(str.indexOf("+")+1, str.indexOf("р"))));
            System.out.printf("Результат сложения в долларах: $%.2f\n", converter.toDollars(Double.parseDouble(str.substring(str.indexOf("+")+1, str.indexOf("р"))))+Double.parseDouble(str.substring(1, str.indexOf("+"))));
        } else if(str.matches("^\\d+(\\.)?\\d*р(\\+)(\\$)\\d+(\\.)?\\d*$")){
            System.out.printf("Результат сложения в рублях: %.2fр\n", converter.toRubles(Double.parseDouble(str.substring(str.indexOf("$")+1)))+Double.parseDouble(str.substring(0, str.indexOf("р"))));
            System.out.printf("Результат сложения в долларах: $%.2f\n", converter.toDollars(Double.parseDouble(str.substring(0, str.indexOf("р"))))+Double.parseDouble(str.substring(str.indexOf("$")+1)));
        } else if(str.matches("^\\d+(\\.)?\\d*р(\\+)\\d+(\\.)?\\d*р$")){
            System.out.printf("Результат сложения: %.2fр\n", Double.parseDouble(str.substring(0, str.indexOf("р")))+Double.parseDouble(str.substring(str.indexOf("+")+1, str.lastIndexOf("р"))));
        } else if(str.matches("^(\\$)\\d+(\\.)?\\d*(\\+)(\\$)\\d+(\\.)?\\d*$")){
            System.out.printf("Результат сложения: $%.2f\n", Double.parseDouble(str.substring(1, str.indexOf("+")))+Double.parseDouble(str.substring(str.lastIndexOf("$")+1)));
        } else if(str.matches("^(\\$)\\d+(\\.)?\\d*-(\\$)\\d+(\\.)?\\d*$")){
            System.out.printf("Результат вычитания: $%.2f\n", Double.parseDouble(str.substring(1, str.indexOf("-")))-Double.parseDouble(str.substring(str.lastIndexOf("$")+1)));
        } else if(str.matches("^\\d+(\\.)?\\d*р-\\d+(\\.)?\\d*р$")){
            System.out.printf("Результат вычитания: %.2fр\n", Double.parseDouble(str.substring(0, str.indexOf("р")))-Double.parseDouble(str.substring(str.indexOf("-")+1, str.lastIndexOf("р"))));
        } else if(str.matches("^(\\$)\\d+(\\.)?\\d*-\\d+(\\.)?\\d*р$")){
            System.out.printf("Результат вычитания в рублях: %.2fр\n", converter.toRubles(Double.parseDouble(str.substring(1, str.indexOf("-"))))-Double.parseDouble(str.substring(str.indexOf("-")+1, str.indexOf("р"))));
            System.out.printf("Результат вычитания в долларах: $%.2f\n", Double.parseDouble(str.substring(1, str.indexOf("-")))-converter.toDollars(Double.parseDouble(str.substring(str.indexOf("-")+1, str.indexOf("р")))));
        } else if(str.matches("^\\d+(\\.)?\\d*р-(\\$)\\d+(\\.)?\\d*$")){
            System.out.printf("Результат вычитания в рублях: %.2fр\n", Double.parseDouble(str.substring(0, str.indexOf("р")))-converter.toRubles(Double.parseDouble(str.substring(str.indexOf("$")+1))));
            System.out.printf("Результат вычитания в долларах: $%.2f\n", converter.toDollars(Double.parseDouble(str.substring(0, str.indexOf("р"))))-Double.parseDouble(str.substring(str.indexOf("$")+1)));
        } else {
            System.out.println("Неверный ввод данных!");
        }
    }
}
