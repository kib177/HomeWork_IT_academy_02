package by.HomeWork;

/**
 * @author Kirill Brigi
 */
public class Main {
    public static void main(String[] args) {

        StrToWeek();
        NumToWords();
        NumToHMSM();
    }

    public static void StrToWeek(){
        System.out.println("Примеры для StringToWeek");
        System.out.println(NumberToWeek.toWeek(5));    // 0 недель
        System.out.println(NumberToWeek.toWeek(14));   // 2 недели
        System.out.println(NumberToWeek.toWeek(177));  // 25 недель
        System.out.println(NumberToWeek.toWeek(21));   // 3 недели
        System.out.println(NumberToWeek.toWeek(22));   // 3 недели (22/7=3.14 → 3 недели)
        System.out.println("---------------------------");
    }

    public static void NumToWords(){
        System.out.println("Примеры для NumberToWords");
        System.out.println(NumberToWords.toString(9999999.25));
        System.out.println(NumberToWords.toString(9999999));
        System.out.println(NumberToWords.toString(-578789.558999));
        System.out.println(NumberToWords.toString(0.974));
        System.out.println(NumberToWords.toString(666.666666666666666));
        System.out.println("---------------------------");
    }

    public static void NumToHMSM(){
        System.out.println("Примеры для NumberToHMSM");
        System.out.println(NumberToHMSM.toHoursMinuteSecondMillisecond(7789001, true)); // 02:09:49.001
        System.out.println(NumberToHMSM.toHoursMinuteSecondMillisecond(7789001, false)); // 2 часа 9 минут 49 секунд 1 миллисекунда
    }
}