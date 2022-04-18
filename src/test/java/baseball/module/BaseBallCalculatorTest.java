package baseball.module;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBallCalculatorTest {

    @DisplayName("야구 계산기가 정확하게 동작하는지 테스트 한다.")
    @MethodSource
    @ParameterizedTest
    public void test_calculator(List<Integer> answer, String input, int expectedStrike, int expectedBall) {
        // Given
        BaseBallCalculator calculator = new BaseBallCalculator(answer);

        // When
        calculator.calculate(input);

        // Then
        assertThat(calculator.getStrike()).isEqualTo(expectedStrike);
        assertThat(calculator.getBall()).isEqualTo(expectedBall);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> test_calculator() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), "231", 0, 3),
                Arguments.of(Arrays.asList(1, 2, 3), "789", 0, 0),
                Arguments.of(Arrays.asList(1, 2, 3), "321", 1, 2),
                Arguments.of(Arrays.asList(1, 2, 3), "123", 3, 0),
                Arguments.of(Arrays.asList(3, 6, 9), "974", 0, 1),
                Arguments.of(Arrays.asList(3, 6, 9), "693", 0, 3),
                Arguments.of(Arrays.asList(3, 6, 9), "169", 2, 0),
                Arguments.of(Arrays.asList(3, 6, 9), "269", 2, 0),
                Arguments.of(Arrays.asList(3, 6, 9), "469", 2, 0),
                Arguments.of(Arrays.asList(3, 6, 9), "639", 1, 2),
                Arguments.of(Arrays.asList(3, 6, 9), "936", 0, 3),
                Arguments.of(Arrays.asList(3, 6, 9), "369", 3, 0),
                Arguments.of(Arrays.asList(7, 2, 8), "724", 2, 0),
                Arguments.of(Arrays.asList(7, 2, 8), "427", 1, 1),
                Arguments.of(Arrays.asList(7, 2, 8), "723", 2, 0),
                Arguments.of(Arrays.asList(7, 2, 8), "728", 3, 0)
        );
    }

}