package baseball.module;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseBallNumberValidatorTest {

    @DisplayName("List<Integer> 파라메터 validate")
    @MethodSource
    @ParameterizedTest
    public void validate_numbers(List<Integer> numbers, boolean expected) {
        // Given

        // When
        boolean validate = BaseBallNumberValidator.validate(numbers);

        // Then
        assertThat(validate).isEqualTo(expected);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> validate_numbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), true),
                Arguments.of(Arrays.asList(1, 2, 3), true),
                Arguments.of(Arrays.asList(4, 5, 6), true),
                Arguments.of(Arrays.asList(7, 8, 9), true),
                Arguments.of(Arrays.asList(1, 3, 5), true),
                Arguments.of(Arrays.asList(2, 4, 9), true),
                Arguments.of(Arrays.asList(1, 1, 1), false),
                Arguments.of(Arrays.asList(1, 2, 2), false),
                Arguments.of(Arrays.asList(1, 3, 3), false),
                Arguments.of(Arrays.asList(9, 6, 6), false),
                Arguments.of(Arrays.asList(7, 3, 7), false),
                Arguments.of(Arrays.asList(0, 6, 9), false),
                Arguments.of(Arrays.asList(1, 2, 3, 4), false),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), false),
                Arguments.of(Arrays.asList(1, 2, -1), false),
                Arguments.of(Arrays.asList(0, 1, 2), false)
                );
    }

    @DisplayName("String Type의 파라메터 validate")
    @MethodSource
    @ParameterizedTest
    public void validate_string(String input, boolean expected) {
        // Given

        // When
        boolean validate = BaseBallNumberValidator.validate(input);

        // Then
        assertThat(validate).isEqualTo(expected);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> validate_string() {
        return Stream.of(
                Arguments.of("123", true),
                Arguments.of("456", true),
                Arguments.of("789", true),
                Arguments.of("135", true),
                Arguments.of("249", true),
                Arguments.of("111", false),
                Arguments.of("122", false),
                Arguments.of("133", false),
                Arguments.of("966", false),
                Arguments.of("737", false),
                Arguments.of("069", false),
                Arguments.of("test", false),
                Arguments.of("test1", false),
                Arguments.of("test2", false),
                Arguments.of("test3", false),
                Arguments.of("테스트", false),
                Arguments.of("테스트2", false),
                Arguments.of("1234", false),
                Arguments.of("2345", false),
                Arguments.of("5678", false),
                Arguments.of("123456789", false)
        );
    }
}