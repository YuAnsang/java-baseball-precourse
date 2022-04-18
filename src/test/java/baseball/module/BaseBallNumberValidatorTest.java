package baseball.module;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseBallNumberValidatorTest {

    @DisplayName("List<Integer> 파라메터 validate")
    @CsvSource(value = {
            "123:true",
            "456:true",
            "789:true",
            "135:true",
            "249:true",
            "111:false",
            "122:false",
            "133:false",
            "966:false",
            "737:false",
            "069:false",
            "1234:false",
            "12345:false",
            "11111:false",
            "012:false"
    }, delimiter = ':')
    @ParameterizedTest
    public void validate_numbers(String input, boolean expected) {
        // Given
        List<Integer> numbers = new ArrayList<>();
        for (String sliced : input.split("")) {
            numbers.add(Integer.valueOf(sliced));
        }

        // When
        boolean validate = BaseBallNumberValidator.validate(numbers);

        // Then
        assertThat(validate).isEqualTo(expected);
    }

    @DisplayName("List<Integer> 파라메터 validate - Contains Negative Value")
    @CsvSource(value = {
            "-1,-2,-3:false",
            "-1,0,2:false",
            "-2,1,2:false",
            "-3,7,9:false",
            "-4,-2,-3:false",
            "-5,-4,-5:false",
            "-5,0,2:false",
    }, delimiter = ':')
    @ParameterizedTest
    public void validate_negative_numbers(String input, boolean expected) {
        // Given
        List<Integer> numbers = new ArrayList<>();
        for (String sliced : input.split(",")) {
            numbers.add(Integer.valueOf(sliced));
        }

        // When
        boolean validate = BaseBallNumberValidator.validate(numbers);

        // Then
        assertThat(validate).isEqualTo(expected);
    }

    @DisplayName("String Type의 파라메터 validate")
    @CsvSource(value = {
            "123:true",
            "456:true",
            "789:true",
            "135:true",
            "249:true",
            "111:false",
            "122:false",
            "133:false",
            "966:false",
            "737:false",
            "069:false",
            "test:false",
            "test1:false",
            "test2:false",
            "test3:false",
            "테스트:false",
            "테스트2:false",
            "1234:false",
            "2345:false",
            "5678:false",
            "123456789:false"
    }, delimiter = ':')
    @ParameterizedTest(name = "[#{index}] {0} is {1}")
    public void validate_string(String input, boolean expected) {
        // Given

        // When
        boolean validate = BaseBallNumberValidator.validate(input);

        // Then
        assertThat(validate).isEqualTo(expected);
    }

}