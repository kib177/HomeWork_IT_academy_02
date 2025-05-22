package by.HomeWork;

public class NumberToWords {
    // Массивы слов для единиц, десятков, сотен и т.д.
    private static final String[] UNITS = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String[] UNITSFEM = {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String[] TEENS = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] TENS = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[][] FORMS = {
            {"миллионов", "миллион", "миллиона"},
            {"тысяч", "тысяча", "тысячи"}
    };

    /**
     * Преобразует целое число в его текстовое представление на русском языке.
     *
     * @param number целое число для преобразования (диапазон от -999,999,999 до 999,999,999)
     * @return строку с текстовым представлением числа
     * @throws NumberFormatException если число выходит за допустимый диапазон
     */
    public String toString(int number) {
        if (number == 0) return "ноль";

        boolean minus = number < 0;
        int n = Math.abs(number);

        if (String.valueOf(n).length() > 9) {
            throw new NumberFormatException("Ввели значение выходящее за пределы -999999999 до 999999999");
        }

        String resultConvert = "";
        if (minus) resultConvert = "минус ";

        int millionNumber = n / 1000000;
        int thousandNumber = (n % 1000000) / 1000;
        int hundredsNumber = n % 1000;

        if (millionNumber > 0) {
            resultConvert += ConvertThree(millionNumber, true) + " "
                + GetForm(millionNumber, 0) + " ";
        }
        if (thousandNumber > 0) {
            resultConvert += ConvertThree(thousandNumber, false) + " "
                + GetForm(thousandNumber, 1) + " ";
        }
        if (hundredsNumber > 0) {
            resultConvert += ConvertThree(hundredsNumber, true);
        }

        return resultConvert.trim();
    }

    /**
     * Преобразует дробное число в его текстовое представление на русском языке.
     * Дробная часть преобразуется до сотых (2 знака после запятой).
     *
     * @param number дробное число для преобразования
     * @return строку с текстовым представлением числа
     * @throws NumberFormatException если дробная часть равна 0 или возникает ошибка округления
     */
    public String toString(double number) {
        StringBuilder result = new StringBuilder(toString((int)number));

        int fraction = (int)(((Math.abs(number) % 1)+0.001) * 100); // 0.001 для сокрытия не точности округления double временное, исправить!!!

        if (fraction == 0) {
            throw new NumberFormatException("Возможная ошибка округления или в дробной части отсутствуют цифры");// она есть) не точность округления
        } else {
            result.append(" целых ");
            result.append(ConvertThree(fraction, false));
            result.append(" ").append(getFractionalEnding(fraction));
        }

        return result.toString();

    }

    /**
     * Вспомогательный метод для преобразования трехзначного числа в текст.
     *
     * @param numConvert трехзначное число для преобразования
     * @param State флаг, указывающий на род числительного (true - мужской, false - женский)
     * @return текстовое представление трехзначного числа
     */
    private String ConvertThree(int numConvert, boolean State) {
        String resultConvertThree = "";

        if (numConvert / 100 > 0) {
            resultConvertThree = HUNDREDS[numConvert / 100] + " ";
        }

        int number = numConvert % 100;
        if (number >= 20) {
            resultConvertThree += TENS[number / 10] + " ";
            if (number % 10 > 0){
                resultConvertThree += (State ? UNITS[number % 10] : UNITSFEM[number % 10]) + " ";
            }
        } else if (number >= 10) {
            resultConvertThree += TEENS[number - 10] + " ";
        } else if (number > 0) {
              resultConvertThree += (State ? UNITS[number] : UNITSFEM[number]) + " ";
          }

        return resultConvertThree.trim();
    }

    /**
     * Вспомогательный метод для получения правильной формы слова (род, число).
     *
     * @param numConvert число для определения формы
     * @param formType тип формы (0 - миллионы, 1 - тысячи)
     * @return правильную форму слова
     */
    private String GetForm(int numConvert, int formType) {
        if ((numConvert % 100) >= 11 && (numConvert % 100) <= 19) return FORMS[formType][0];
        if (numConvert % 10 == 1) return FORMS[formType][1];
        if (numConvert % 10 >= 2 && numConvert % 10 <= 4) return FORMS[formType][2];

        return FORMS[formType][0];
    }

    /**
     * Вспомогательный метод для получения правильного окончания дробной части.
     *
     * @param num число для определения окончания
     * @return правильное окончание для дробной части
     */
    private String getFractionalEnding(int num) {
        return (num % 100 >= 11 && num % 100 <= 14) || num % 10 != 1 ? "сотых" : "сотая";
    }
}
