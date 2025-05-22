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
        NumberToWeek numberToWeek = new NumberToWeek();
        System.out.println("Примеры для StringToWeek");
        System.out.println(numberToWeek.toWeek(5));    // 0 недель
        System.out.println(numberToWeek.toWeek(14));   // 2 недели
        System.out.println(numberToWeek.toWeek(177));  // 25 недель
        System.out.println(numberToWeek.toWeek(21));   // 3 недели
        System.out.println(numberToWeek.toWeek(22));   // 3 недели (22/7=3.14 → 3 недели)
        System.out.println("---------------------------");
    }

    public static void NumToWords(){
        NumberToWords numberToWords = new NumberToWords();
        System.out.println("Примеры для NumberToWords");
        System.out.println(numberToWords.toString(9999999.25));
        System.out.println(numberToWords.toString(9999999));
        System.out.println(numberToWords.toString(-578789.558999));
        System.out.println(numberToWords.toString(0.974));
        System.out.println(numberToWords.toString(666.666666666666666));
        System.out.println("---------------------------");
    }

    public static void NumToHMSM(){
        NumberToHMSM numberToHMSM = new NumberToHMSM();
        System.out.println("Примеры для NumberToHMSM");
        System.out.println(numberToHMSM.toHoursMinuteSecondMillisecond(7789001, true)); // 02:09:49.001
        System.out.println(numberToHMSM.toHoursMinuteSecondMillisecond(799990100/2, false)); // 2 часа 9 минут 49 секунд 1 миллисекунда
    }
}