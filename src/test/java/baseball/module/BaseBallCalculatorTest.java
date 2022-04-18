package baseball.module;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallCalculatorTest {

    @DisplayName("야구 계산기가 정확하게 동작하는지 테스트 한다.")
    @CsvSource(value = {
            "123:231:0:3",
            "123:789:0:0",
            "123:321:1:2",
            "123:123:3:0",
            "369:974:0:1",
            "369:169:2:0",
            "369:269:2:0",
            "369:469:2:0",
            "369:639:1:2",
            "369:936:0:3",
            "369:369:3:0",
            "728:724:2:0",
            "728:427:1:1",
            "728:723:2:0",
            "728:728:3:0",
    }, delimiter = ':')
    @ParameterizedTest(name = "[#{index}] answer : {0}, input : {1}, strike : {2}, ball : {3}")
    public void test_calculator(String answer, String input, int expectedStrike, int expectedBall) {
        // Given
        List<Integer> answerList = new ArrayList<>();
        for (String sliced : answer.split("")) {
            answerList.add(Integer.valueOf(sliced));
        }
        BaseBallCalculator calculator = new BaseBallCalculator(answerList);

        // When
        calculator.calculate(input);

        // Then
        assertThat(calculator.getStrike()).isEqualTo(expectedStrike);
        assertThat(calculator.getBall()).isEqualTo(expectedBall);
    }

    @DisplayName("clear 메서드 동작 테스트")
    @Test
    public void test_clear() {
        // Given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        BaseBallCalculator calculator = new BaseBallCalculator(numbers);

        // When
        calculator.calculate("132");

        // Then
        assertThat(calculator.getStrike()).isNotZero();
        assertThat(calculator.getBall()).isNotZero();

        // When
        calculator.clear();

        // Then
        assertThat(calculator.getStrike()).isZero();
        assertThat(calculator.getBall()).isZero();
    }
}