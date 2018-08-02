import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AngleCalculatingTest {
    AngleCalculate calculator;

    @BeforeEach
    void init() {
        calculator = new AngleCalculating();
    }

    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(11, 20, 140),
                Arguments.of(3, 30, 75),
                Arguments.of(11, 59, 6),
                Arguments.of(23, 0, 30)
        );
    }

    @ParameterizedTest
    @MethodSource("sumProvider")
    void sum(int hours, int minutes, int result) {
        assertEquals(result, calculator.calculating(hours, minutes));
    }
}