package baseball.module;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class BaseBallGameComputerTest {

    @RepeatedTest(1000)
    @DisplayName("컴퓨터의 번호가 실제로 중복이 안되는지 테스트")
    public void validate_duplication_numbers() {
        // Given
        BaseBallComputer baseBallGameComputer = new BaseBallComputer();
        List<Integer> computerNumbers = baseBallGameComputer.init();

        // When
        boolean validate = BaseBallNumberValidator.validate(computerNumbers);

        // Then
        assertThat(validate).isTrue();
    }
}