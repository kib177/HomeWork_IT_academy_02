import by.HomeWork.NumberToWords;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberToWordsTest {

    @Test
    @DisplayName("Тест для 0")
    public void testToStringIntZero() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("ноль", numberToWords.toString(0));
    }

    @Test
    @DisplayName("Тест для десятичных чисел")
    public void testToStringDouble() {
            NumberToWords numberToWords = new NumberToWords();
            assertEquals("один целых одна сотая", numberToWords.toString(1.01));
            assertEquals("два целых две сотых", numberToWords.toString(2.02));
            assertEquals("пять целых пять сотых", numberToWords.toString(5.05));
            assertEquals("десять целых десять сотых", numberToWords.toString(10.10));
            assertEquals("сто целых двадцать одна сотая", numberToWords.toString(100.21));
            assertEquals("минус один целых одна сотая", numberToWords.toString(-1.01));
            assertEquals("ноль целых пятнадцать сотых", numberToWords.toString(0.15));
            assertEquals("девятьсот девяносто девять целых девяносто девять сотых", numberToWords.toString(999.99));
    }

    @Test
    @DisplayName("Тест для десятичных чисел на точность")
    public void testGetFractionalEnding() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("ноль целых одна сотая", numberToWords.toString(0.01));
        assertEquals("ноль целых две сотых", numberToWords.toString(0.02));
        assertEquals("ноль целых пять сотых", numberToWords.toString(0.05));
        assertEquals("ноль целых одиннадцать сотых", numberToWords.toString(0.11));
        assertEquals("ноль целых двадцать одна сотая", numberToWords.toString(0.21));
        assertEquals("ноль целых двадцать пять сотых", numberToWords.toString(0.25));
    }

    @ParameterizedTest
    @CsvSource({

            // Положительные числа
            "один, 1",
            "двадцать один, 21",
            "сто, 100",
            "двести тридцать четыре, 234",
            "одна тысяча, 1000",
            "две тысячи, 2000",
            "пять тысяч, 5000",
            "одна тысяча один, 1001",

            "сто тысяч, 100000",
            "триста тысяч, 300000",

            "один миллион, 1000000",
            "два миллиона, 2000000",
            "пять миллионов, 5000000",
            "один миллион одна тысяча, 1001000",
            "двенадцать миллионов, 12000000",

    })
    void FormatParameterized(String expected, int number) {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals(expected, numberToWords.toString(number));
    }

    @Test
    public void testTeens() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("одиннадцать", numberToWords.toString(11));
        assertEquals("девятнадцать", numberToWords.toString(19));
    }

    @Test
    public void testTens() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("десять", numberToWords.toString(10));
        assertEquals("двадцать", numberToWords.toString(20));
        assertEquals("девяносто", numberToWords.toString(90));
    }

    @Test
    public void testHundreds() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("сто", numberToWords.toString(100));
        assertEquals("двести", numberToWords.toString(200));
        assertEquals("девятьсот девяносто девять", numberToWords.toString(999));
    }

    @Test
    public void testThousands() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("одна тысяча", numberToWords.toString(1000));
        assertEquals("две тысячи", numberToWords.toString(2000));
        assertEquals("девять тысяч девятьсот девяносто девять", numberToWords.toString(9999));
        assertEquals("одна тысяча один", numberToWords.toString(1001));
        assertEquals("две тысячи триста сорок пять", numberToWords.toString(2345));
    }

    @Test
    public void testMillions() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("один миллион", numberToWords.toString(1_000_000));
        assertEquals("два миллиона", numberToWords.toString(2_000_000));
        assertEquals("пять миллионов", numberToWords.toString(5_000_000));
        assertEquals("один миллион одна тысяча", numberToWords.toString(1_001_000));
        assertEquals("девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять",
                numberToWords.toString(9_999_999));
    }

    @Test
    public void testLargeNumbers() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять",
                numberToWords.toString(123_456_789));
        assertEquals("девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять",
                numberToWords.toString(999_999_999));
    }

    // Тесты для отрицательных чисел
    @Test
    public void testNegativeNumbers() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("минус один", numberToWords.toString(-1));
        assertEquals("минус двести тридцать четыре", numberToWords.toString(-234));
        assertEquals("минус сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять",
                numberToWords.toString(-123_456_789));
    }

    @Test
    @DisplayName("Проверка исключений")
    void invalidInput() {
        NumberToWords numberToWords = new NumberToWords();
        assertThrows(IllegalArgumentException.class,
                () -> numberToWords.toString(0000.000));
        assertThrows(IllegalArgumentException.class,
                () -> numberToWords.toString(1000000001));
        assertThrows(IllegalArgumentException.class,
                () -> numberToWords.toString(-1000000001));
    }
}
