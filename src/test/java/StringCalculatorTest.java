import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "111", "+", "-", "/", "-1"})
    void isOperator(String value) {
        boolean actual = StringCalculator.isOperator(value);
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void calculate() {
        int actual = StringCalculator.calculate(1, 2, "/");
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void main() {
        String input = "\"2 + 3 * 4 / 2\"";
        String trimmed = input.substring(1, input.length() - 1);
        String[] values = trimmed.split(" ");

        int result = Integer.parseInt(values[0]);
        for (int i = 0; i < values.length; i++) {
            if (StringCalculator.isOperator(values[i])) {
                result = StringCalculator.calculate(result, Integer.parseInt(values[i + 1]), values[i]);
            }

        }
        System.out.print(result);
        int actual = Integer.parseInt(outputStreamCaptor.toString());
        assertThat(actual).isEqualTo(10);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}