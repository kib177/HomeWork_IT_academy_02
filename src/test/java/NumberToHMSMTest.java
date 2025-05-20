import by.HomeWork.NumberToHMSM;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToHMSMTest {

    @Test
    @DisplayName("Тест значение shortFormat - true")
    void trueFormatTests() {
        // Проверка обычного случая
        assertEquals("02:09:49.001",
                NumberToHMSM.toHoursMinuteSecondMillisecond(7789001, true));

        // Нулевое время
        assertEquals("00:00:00.000",
                NumberToHMSM.toHoursMinuteSecondMillisecond(0, true));

        // Граничные значения
        assertEquals("00:00:01.000",
                NumberToHMSM.toHoursMinuteSecondMillisecond(1000, true));
        assertEquals("00:01:01.000",
                NumberToHMSM.toHoursMinuteSecondMillisecond(61000, true));
    }

    @Test
    @DisplayName("Тест значение shortFormat - false")
    void falseFormatTests() {
        // Проверка обычного случая
        assertEquals("2 часа 9 минут 49 секунд 1 миллисекунда",
                NumberToHMSM.toHoursMinuteSecondMillisecond(7789001, false));

        // Проверка склонений
        assertEquals("1 час 1 минута 1 секунда 1 миллисекунда",
                NumberToHMSM.toHoursMinuteSecondMillisecond(3661001, false));
        assertEquals("5 часов 0 минут 0 секунд 0 миллисекунд",
                NumberToHMSM.toHoursMinuteSecondMillisecond(18000000, false));

        // Нулевое время
        assertEquals("0 часов 0 минут 0 секунд 0 миллисекунд",
                NumberToHMSM.toHoursMinuteSecondMillisecond(0, false));
    }

    @Test
    @DisplayName("Проверяет значения, демонстрирующие некорректность текущей логики")
    void edgeCases() {
        // 59 секунд 999 мс
        assertEquals("00:00:59.999",
                NumberToHMSM.toHoursMinuteSecondMillisecond(59999, true));

        // Ровно 1 час
        assertEquals("01:00:00.000",
                NumberToHMSM.toHoursMinuteSecondMillisecond(3600000, true));
    }
}
