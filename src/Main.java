import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт\n1. Перевод валюты ($->RUB)\n2. Перевод валюты (RUB->$)\n3. Сложение\n");
        int v = scanner.nextInt();
        Converter converter = new Converter();
        switch (v){
            case 1: System.out.println("Введите сумму в $");
            System.out.println(converter.toRubles(scanner.nextInt()));
            break;

            case 2: System.out.println("Введите сумму в RUB");
            System.out.println(converter.toDollars(scanner.nextInt()));
            break;

            default: break;
        }
    }
}
