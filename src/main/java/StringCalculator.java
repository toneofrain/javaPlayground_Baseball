import java.util.Scanner;

public class StringCalculator {
    public static boolean isOperator(String value) {
        char character = value.charAt(0);
        return character >= '*' && character <= '/';
    }

    public static int calculate(int front, int back, String operator) {
        switch (operator) {
            case "+" :
                return front + back;

            case "-" :
                return front - back;

            case "*" :
                return front * back;

            case "/" :
                return front / back;

            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String trimmed = input.substring(1, input.length() - 1);
        String[] values = trimmed.split(" ");
        scanner.close();

        int result = Integer.parseInt(values[0]);
        for (int i = 0; i < values.length; i++) {
            if (isOperator(values[i])) {
                result = calculate(result, Integer.parseInt(values[i + 1]), values[i]);
            }

        }
        System.out.print(result);
    }

}
