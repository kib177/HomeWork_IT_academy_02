import by.HomeWork.NumberToHMSM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberToHMSMTest {

    @ParameterizedTest
    @CsvSource({
            // Короткий формат
            "0, true, '00:00:00.000'",
            "999, true, '00:00:00.999'",
            "1000, true, '00:00:01.000'",
            "59999, true, '00:00:59.999'",
            "60000, true, '00:01:00.000'",
            "3599999, true, '00:59:59.999'",
            "3600000, true, '01:00:00.000'",
            "86399999, true, '23:59:59.999'",
            "86400000, true, '24:00:00.000'",

            // Короткий формат (специфичные кейсы)
            "3661123, true, '01:01:01.123'",
            "45296789, true, '12:34:56.789'",
            "999999999, true, '277:46:39.999'",


            // Длинный формат
            "1, false, '0 часов 0 минут 0 секунд 1 миллисекунда'",
            "1000, false, '0 часов 0 минут 1 секунда 0 миллисекунд'",
            "61001, false, '0 часов 1 минута 1 секунда 1 миллисекунда'",
            "3661001, false, '1 час 1 минута 1 секунда 1 миллисекунда'",
            "7265000, false, '2 часа 1 минута 5 секунд 0 миллисекунд'",
            "18000000, false, '5 часов 0 минут 0 секунд 0 миллисекунд'",
            "78143024, false, '21 час 42 минуты 23 секунды 24 миллисекунды'",

            "59999, false, '0 часов 0 минут 59 секунд 999 миллисекунд'",
            "3600000, false, '1 час 0 минут 0 секунд 0 миллисекунд'",
            "86399999, false, '23 часа 59 минут 59 секунд 999 миллисекунд'",
            "399995050, false, '111 часов 6 минут 35 секунд 50 миллисекунд'"
    })
    void FormatParameterized(long milliseconds, boolean shortFormat, String expected) {
        NumberToHMSM numberToHMSM = new NumberToHMSM();
            assertEquals(expected, numberToHMSM.toHoursMinuteSecondMillisecond(milliseconds, shortFormat));
    }


    @Test
    @DisplayName("Максимальные значения для каждого компонента")
    void maxValues() {
        NumberToHMSM numberToHMSM = new NumberToHMSM();
        assertEquals("59:59:59.999",
                numberToHMSM.toHoursMinuteSecondMillisecond(215999999, true));
        assertEquals("59 часов 59 минут 59 секунд 999 миллисекунд",
                numberToHMSM.toHoursMinuteSecondMillisecond(215999999, false));
    }

    @Test
    @DisplayName("Обработка отрицательных значений")
    void invalidInput() {
        NumberToHMSM numberToHMSM = new NumberToHMSM();
        assertThrows(IllegalArgumentException.class,
                () -> numberToHMSM.toHoursMinuteSecondMillisecond(-1, true));
    }
}
