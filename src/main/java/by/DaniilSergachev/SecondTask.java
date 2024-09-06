package by.DaniilSergachev;

import java.text.DecimalFormat;

public class SecondTask {
    private static final String[] tensNames = {
            "", " десять", " двадцать", " тридцать", " сорок", " пятьдесят", " шестьдесят", " семьдесят", " восемьдесят", " девяносто"
    };

    private static final String[] numNames = {
            "", " один", " два", " три", " четыре", " пять", " шесть", " семь", " восемь", " девять",
            " десять", " одиннадцать", " двенадцать", " тринадцать", " четырнадцать", " пятнадцать",
            " шестнадцать", " семнадцать", " восемнадцать", " девятнадцать"
    };

    private static final String[] hundredsNames = {
            "", " сто", " двести", " триста", " четыреста", " пятьсот", " шестьсот", " семьсот", " восемьсот", " девятьсот"
    };

    private static String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;
            current = tensNames[number % 10] + current;
            number /= 10;
        }
        return number == 0 ? current : hundredsNames[number] + current;
    }

    private static String convertThousands(int thousands) {
        if (thousands % 10 == 1 && thousands % 100 != 11) {
            return "одна тысяча";
        } else if (thousands % 10 == 2 && thousands % 100 != 12) {
            return "две тысячи";
        } else if (thousands % 10 >= 3 && thousands % 10 <= 4 && (thousands % 100 < 10 || thousands % 100 >= 20)) {
            return convertLessThanOneThousand(thousands) + " тысячи";
        } else {
            return convertLessThanOneThousand(thousands) + " тысяч";
        }
    }

    public static String convert(long number) {
        if (number == 0) return "ноль";

        String sNumber = new DecimalFormat("00000").format(number);
        int thousands = Integer.parseInt(sNumber.substring(0, 2));
        int hundreds = Integer.parseInt(sNumber.substring(2, 5));

        String tradThousands = thousands == 0 ? "" : convertThousands(thousands) + " ";
        String tradHundreds = convertLessThanOneThousand(hundreds);

        return (tradThousands + tradHundreds).trim().replaceAll(" +", " ");
    }

    public static String convertDouble(double number) {
        long integerPart = (long) number;
        long fractionalPart = Math.round((number - integerPart) * 100);

        String integerWords = convert(integerPart);
        String fractionalWords = convert(fractionalPart);

        return integerWords + " целых " + fractionalWords + " сотых";
    }
}
