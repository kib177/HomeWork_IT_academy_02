package by.HomeWork;

import java.util.concurrent.TimeUnit;

public class NumberToHMSM {

    /**
     * Преобразует количество миллисекунд в форматированную строку времени.
     * Формат вывода зависит от параметра {@code shortFormat}:
     * <ul>
     *     <li>Если {@code shortFormat == true}, возвращает строку в формате {@code ЧЧ:ММ:СС.ммм}.</li>
     *     <li>Если {@code shortFormat == false}, возвращает строку с полным словесным описанием (например, "1 час 30 минут 15 секунд 500 миллисекунд").</li>
     * </ul>
     *
     * @param millis      количество миллисекунд для преобразования
     * @param shortFormat если {@code true}, возвращает сокращённый формат (ЧЧ:ММ:СС.ммм),
     *                    если {@code false} — полный словесный формат
     * @return отформатированная строка времени
     */
    public static String toHoursMinuteSecondMillisecond(long millis, boolean shortFormat) {
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        long ms = millis % 1000;

        return shortFormat
                ? String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, ms) : String.join(" ",
                format(hours, "час", "часа", "часов"),
                format(minutes, "минута", "минуты", "минут"),
                format(seconds, "секунда", "секунды", "секунд"),
                format(ms, "миллисекунда", "миллисекунды", "миллисекунд"));
    }

    /**
     * Возвращает строку с числом и правильной формой слова в зависимости от значения числа.
     * Поддерживает склонение для русского языка (1 час, 2 часа, 5 часов и т. д.).
     *
     * @param n     число, для которого нужно подобрать форму слова
     * @param forms массив из трёх форм
     * @return строка в формате "{число} {правильная_форма_слова}"
     */
    private static String format(long n, String... forms) {
        return n + " " + forms[(n % 100 >= 11 && n % 100 <= 14) ? 2 :
                new int[]{2, 0, 1, 1, 1, 2, 2, 2, 2, 2}[ (int)(n % 10)]];
    }
}
