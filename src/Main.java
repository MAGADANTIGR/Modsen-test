import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        String str;
        System.out.println("Выберите пункт\n1. Перевод валюты ($->RUB)\n2. Перевод валюты (RUB->$)\n3. Сложение\n4. Вычитание");
        switch (scanner.nextInt()){
            case 1: System.out.println("Введите сумму в $");
            str = String.format("%.2f",converter.toRubles(scanner.nextDouble()));
            System.out.print(str + "p");
            break;

            case 2: System.out.println("Введите сумму в RUB");
            str = String.format("%.2f", converter.toDollars(scanner.nextDouble()));
            System.out.print("$" + str);
            break;

            case 3: System.out.println("Выберите, что нужно сложить\n1. $ + $\n2. RUB + RUB\n3. $ + RUB");
            switch (scanner.nextInt()){
                case 1: System.out.println("Введите суммы");
                str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), '$', '+', '-', 0));
                System.out.print("$"+str);
                break;

                case 2: System.out.println("Введите суммы");
                str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'R', '+', '-', 0));
                System.out.print(str+"p");
                break;

                case 3: System.out.println("Выберите валюту, в которой нужно произвести расчет\n1. $\n2. RUB");
                if(scanner.nextInt()==1){
                    System.out.println("Введите суммы (первая сумма-$, вторая-RUB)");
                    str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'S', '+', '$', 0));
                    System.out.print("$"+str);
                } else {
                    System.out.println("Введите суммы (первая сумма-$, вторая-RUB)");
                    str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'S', '+', 'R', 0));
                    System.out.print(str+"p");
                }
                break;

                default: System.out.print("Введите верное значение");
                    break;
            }
            break;

            case 4: System.out.println("Выберите, что нужно вычесть\n1. $ - $\n2. RUB - RUB\n3. $ - RUB\n4. RUB - $");
                switch (scanner.nextInt()){
                    case 1: System.out.println("Введите суммы");
                    str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), '$', '-', '-', 0));
                    System.out.print("$"+str);
                    break;

                    case 2: System.out.println("Введите суммы");
                    str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'R', '-', '-', 0));
                    System.out.print(str+"p");
                    break;

                    case 3: System.out.println("Выберите валюту, в которой нужно произвести расчет\n1. $\n2. RUB");
                        if(scanner.nextInt()==1){
                            System.out.println("Введите суммы (первая сумма-$, вторая-RUB)");
                            str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'S', '-', '$', 1));
                            System.out.print("$"+str);
                        } else {
                            System.out.println("Введите суммы (первая сумма-$, вторая-RUB)");
                            str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'S', '-', 'R', 1));
                            System.out.print(str+"p");
                        }
                        break;

                    case 4: System.out.println("Выберите валюту, в которой нужно произвести расчет\n1. $\n2. RUB");
                        if(scanner.nextInt()==1){
                            System.out.println("Введите суммы (первая сумма-RUB, вторая-$)");
                            str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'S', '-', '$', 2));
                            System.out.print("$"+str);
                        } else {
                            System.out.println("Введите суммы (первая сумма-RUB, вторая-$)");
                            str = String.format("%.2f", converter.operations(scanner.nextDouble(), scanner.nextDouble(), 'S', '-', 'R', 2));
                            System.out.print(str+"p");
                        }
                        break;

                    default: System.out.print("Введите верное значение");
                        break;
                }
                break;

            default: System.out.print("Введите верное значение");
                break;
        }
    }
}
