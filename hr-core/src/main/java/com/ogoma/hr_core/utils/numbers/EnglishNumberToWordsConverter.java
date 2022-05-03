package com.ogoma.vue_starter.vue_starter.utils.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnglishNumberToWordsConverter extends GenderlessNumberToWordsConverter {
    private static final String[] UnitsMap = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TensMap = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static Map<Long, String> ordinalExceptions = new HashMap<>();

    public EnglishNumberToWordsConverter() {
        ordinalExceptions.put(1l, "first");
        ordinalExceptions.put(2l, "second");
        ordinalExceptions.put(3l, "third");
        ordinalExceptions.put(4l, "fourth");
        ordinalExceptions.put(5l, "fifth");
        ordinalExceptions.put(8l, "eighth");
        ordinalExceptions.put(9l, "ninth");
        ordinalExceptions.put(12l, "twelfth");
    }

    public  String Convert(long number) {
        return Convert(number, false);
    }

    public String ConvertToOrdinal(int number) {
        return Convert(number, true);
    }

    private String Convert(long number, boolean isOrdinal) {
        if (number == 0) {
            return GetUnitValue(0, isOrdinal);
        }

        if (number < 0) {
            return String.format("minus %s", Convert(-number));
        }

        List<String> parts = new ArrayList<String>();

        if ((number / 1000000000000000000l) > 0) {
            parts.add(String.format("%s quintillion", Convert(number / 1000000000000000000l)));
            number %= 1000000000000000000l;
        }

        if ((number / 1000000000000000l) > 0) {
            parts.add(String.format("%s quadrillion", Convert(number / 1000000000000000l)));
            number %= 1000000000000000l;
        }

        if ((number / 1000000000000l) > 0) {
            parts.add(String.format("%s trillion", Convert(number / 1000000000000l)));
            number %= 1000000000000l;
        }

        if ((number / 1000000000) > 0) {
            parts.add(String.format("%s billion", Convert(number / 1000000000)));
            number %= 1000000000;
        }

        if ((number / 1000000) > 0) {
            parts.add(String.format("%s million", Convert(number / 1000000)));
            number %= 1000000;
        }

        if ((number / 1000) > 0) {
            parts.add(String.format("%s thousand", Convert(number / 1000)));
            number %= 1000;
        }

        if ((number / 100) > 0) {
            parts.add(String.format("%s hundred", Convert(number / 100)));
            number %= 100;
        }

        if (number > 0) {
            if (parts.size() != 0) {
                parts.add("and");
            }

            if (number < 20) {
                parts.add(GetUnitValue(number, isOrdinal));
            } else {
                String lastPart = TensMap[(int) (number / 10)];
                if ((number % 10) > 0) {
                    lastPart += String.format("-%s", GetUnitValue(number % 10, isOrdinal));
                } else if (isOrdinal) {
                    lastPart = lastPart.replaceAll("[" + "y" + "]+$", "") + "ieth";
                }

                parts.add(lastPart);
            }
        } else if (isOrdinal) {
            parts.set(parts.size() - 1, "th");
        }

        String toWords = String.join(" ", parts);

        if (isOrdinal) {
            toWords = RemoveOnePrefix(toWords);
        }

        return toWords;
    }

    private static String GetUnitValue(long number, boolean isOrdinal) {
        if (isOrdinal) {
            if (ExceptionNumbersToWords(number)) {
                return number+"Missing in ordinal list";
            } else {
                return UnitsMap[(int) number] + "th";
            }
        } else {
            return UnitsMap[(int) number];
        }
    }

    private static String RemoveOnePrefix(String toWords) {
        // one hundred => hundredth
        if (toWords.indexOf("one") == 0) {
            toWords = toWords.substring(4);
        }

        return toWords;
    }

    private static boolean ExceptionNumbersToWords(long number) {
        try {
            ordinalExceptions.get(number);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}