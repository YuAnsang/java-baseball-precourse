package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void RandomNumberInRange_오작동할경우() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(() -> run("246", "135", "1", "597", "589", "2"))
                        .isInstanceOf(RuntimeException.class),
                -1, -3, -5, -5, -8, -9
        );
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource(value = {
            "길이 테스트(4자리):1234",
            "길이 테스트(5자리):12345",
            "길이 테스트(6자리):123456",
            "길이 테스트(7자리):1234567",
            "길이 테스트(8자리):12345678",
            "길이 테스트(9자리):123456789",
            "음수 테스트:-1-2-3",
            "한글 테스트:일이삼",
            "영어 테스트:invalid",
            "영어 테스트:test",
            "영어 테스트:test2"
    }, delimiter = ':')
    void 예외_테스트(String name, String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
