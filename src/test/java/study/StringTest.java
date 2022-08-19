package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split1() {
        String[] actual = "2 + 3 * 4 / 1".split(" ");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(2,5);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("인덱스를 초과하는 값을 넣었을 떄 예외")
    void charAt() {
        String str = "abc";
        int index = 3;
        assertThatThrownBy(() -> str.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("인덱스를 초과하는 값을 넣었을 떄 예외2")
    void charAt2() {
        String str = "abc";
        int index = 3;

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(index))
                .withMessageContaining("d", index);
    }
}
