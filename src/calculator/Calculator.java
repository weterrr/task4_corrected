package calculator;

import java.util.Scanner;
import operation.Addition;
import operation.Subtraction;
import operation.Multiplication;
import operation.Division;

public class Calculator extends UserInteraction{
    double first;
    double second;
    String operation;
    public Calculator() {
    }
    public void runCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        first = scanDouble(scanner);
        System.out.println("Введите второе число");
        second = scanDouble(scanner);
        operation = scanOperation(scanner);
        scanner.close();
        if (operation == null)
            return;
        apply();
    }

    public void apply() {
        double result = 0;
        if (checkOperation.isAddition(operation))
            result = new Addition(first, second, operation).apply();
        else if (checkOperation.isSubtraction(operation))
            result = new Subtraction(first, second, operation).apply();
        else if (checkOperation.isMultiplication(operation))
            result = new Multiplication(first, second, operation).apply();
        else if (checkOperation.isDivision(operation)) {
            Division division = new Division(first, second, operation);
            if (division.isCorrectOperation())
                result = new Division(first, second, operation).apply();
            else {
                System.out.println("Деление на ноль, не надо так!");
                return;
            }
        }
        System.out.printf("Результат = %.4f", result);
    }
}