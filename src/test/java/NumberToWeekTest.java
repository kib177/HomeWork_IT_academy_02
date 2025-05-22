import by.HomeWork.NumberToWeek;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToWeekTest {

    @ParameterizedTest
    @CsvSource({
            // проверка чисел которые возвращают слово неделя
            "1 неделя, 12",
            "1 неделя, 7",
            "1 неделя, 9",

            // числа, где возвращает недели
            "2 недели, 20",
            "3 недели, 21",
            "3 недели, 25",
            "4 недели, 30",

            //числа, где возвращает недель
            "0 недель, 0",
            "0 недель, 5",
            "0 недель, 6",
            "7 недель, 50",
            "13 недель, 91",
            "14 недель, 100",
            "114 недель, 800",
            "28571 неделя, 200000",
            "142857142 недели, 999999999"



    })
    void FormatParameterized(String week, int day) {
        NumberToWeek numberToWeek = new NumberToWeek();
        assertEquals(week, numberToWeek.toWeek(day));
    }
}


