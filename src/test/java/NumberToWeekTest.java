import by.HomeWork.NumberToWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToWeekTest {

    @Test
    @DisplayName(" Проверяет числа 10-19, где метод возвращает 'неделя'")
    public void testDays10to19() {
        assertEquals("неделя", NumberToWeek.toWeek(12));
        assertEquals("неделя", NumberToWeek.toWeek(7));
        assertEquals("неделя", NumberToWeek.toWeek(9));
    }

    @Test
    @DisplayName("Проверяет диапазон 20-49, где ожидается 'недели'")
    public void testDays20to49() {
        assertEquals("недели", NumberToWeek.toWeek(20));
        assertEquals("недели", NumberToWeek.toWeek(21));
        assertEquals("недели", NumberToWeek.toWeek(25));
        assertEquals("недели", NumberToWeek.toWeek(30));
    }

    @Test
    @DisplayName("Проверяет, где ожидается 'недель'")
    public void test1050AndAbove() {
        assertEquals("недель", NumberToWeek.toWeek(0));
        assertEquals("недель", NumberToWeek.toWeek(5));
        assertEquals("недель", NumberToWeek.toWeek(6));
        assertEquals("недель", NumberToWeek.toWeek(50));
        assertEquals("недель", NumberToWeek.toWeek(99));
        assertEquals("недель", NumberToWeek.toWeek(100));
    }

    @Test
    @DisplayName("Проверяет значения, демонстрирующие некорректность текущей логики")
    public void testLogics() {
        assertEquals("неделя", NumberToWeek.toWeek(7));   // 7 дней = 1 неделя, но тест на текущую логику
        assertEquals("недели", NumberToWeek.toWeek(14));  // 14 дней = 2 недели, но тест на текущую логику
    }

}
