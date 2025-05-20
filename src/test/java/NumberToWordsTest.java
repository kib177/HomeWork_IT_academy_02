import by.HomeWork.NumberToWords;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberToWordsTest {

    @Test
    @DisplayName("Тест для 0")
    public void testToStringIntZero() {
        assertEquals("ноль", NumberToWords.toString(0));
    }

    @Test
    @DisplayName("Тест для положительных чисел")
    public void testToStringIntPositive() {
        assertEquals("один", NumberToWords.toString(1));
        assertEquals("двадцать один", NumberToWords.toString(21));
        assertEquals("сто", NumberToWords.toString(100));
        assertEquals("двести тридцать четыре", NumberToWords.toString(234));
        assertEquals("одна тысяча", NumberToWords.toString(1000));
        assertEquals("две тысячи", NumberToWords.toString(2000));
        assertEquals("пять тысяч", NumberToWords.toString(5000));
        assertEquals("одна тысяча один", NumberToWords.toString(1001));
        assertEquals("один миллион", NumberToWords.toString(1000000));
        assertEquals("два миллиона", NumberToWords.toString(2000000));
        assertEquals("пять миллионов", NumberToWords.toString(5000000));
        assertEquals("один миллион одна тысяча", NumberToWords.toString(1001000));
        assertEquals("сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять",
                NumberToWords.toString(123456789));
    }

    @Test
    @DisplayName("Тест для отрицательных чисел")
    public void testToStringIntNegative() {
        assertEquals("минус один", NumberToWords.toString(-1));
        assertEquals("минус двадцать один", NumberToWords.toString(-21));
        assertEquals("минус сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять",
                NumberToWords.toString(-123456789));
    }

    @Test
    @DisplayName("Тест для десятичных чисел")
    public void testToStringDouble() {
        assertEquals("один целых одна сотая", NumberToWords.toString(1.01));
        assertEquals("два целых две сотых", NumberToWords.toString(2.02));
        assertEquals("пять целых пять сотых", NumberToWords.toString(5.05));
        assertEquals("десять целых десять сотых", NumberToWords.toString(10.10));
        assertEquals("сто целых двадцать одна сотая", NumberToWords.toString(100.21));
        assertEquals("минус один целых одна сотая", NumberToWords.toString(-1.01));
    }

    @Test
    @DisplayName("Тест для форм записи миллион, тысячи")
    public void testGetForm() {
        assertEquals("один миллион", NumberToWords.toString(1000000));
        assertEquals("два миллиона", NumberToWords.toString(2000000));
        assertEquals("пять миллионов", NumberToWords.toString(5000000));
        assertEquals("одна тысяча", NumberToWords.toString(1000));
        assertEquals("две тысячи", NumberToWords.toString(2000));
        assertEquals("пять тысяч", NumberToWords.toString(5000));
    }

    @Test
    @DisplayName("Тест для десятичных чисел на точность")
    public void testGetFractionalEnding() {
        assertEquals("ноль целых одна сотая", NumberToWords.toString(0.01));
        assertEquals("ноль целых две сотых", NumberToWords.toString(0.02));
        assertEquals("ноль целых пять сотых", NumberToWords.toString(0.05));
        assertEquals("ноль целых одиннадцать сотых", NumberToWords.toString(0.11));
        assertEquals("ноль целых двадцать одна сотая", NumberToWords.toString(0.21));
        assertEquals("ноль целых двадцать пять сотых", NumberToWords.toString(0.25));
    }
}
