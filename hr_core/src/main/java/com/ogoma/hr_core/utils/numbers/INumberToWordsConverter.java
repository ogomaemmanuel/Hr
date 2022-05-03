package com.ogoma.hr_core.utils.numbers;

public interface INumberToWordsConverter {


        String Convert(long number);

        String Convert(long number, GrammaticalGender gender);

        String ConvertToOrdinal(int number);


        String ConvertToOrdinal(int number, GrammaticalGender gender);
    }

