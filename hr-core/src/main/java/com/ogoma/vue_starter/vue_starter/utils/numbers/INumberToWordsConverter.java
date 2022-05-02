package com.ogoma.vue_starter.vue_starter.utils.numbers;

public interface INumberToWordsConverter {


        String Convert(long number);

        String Convert(long number, GrammaticalGender gender);

        String ConvertToOrdinal(int number);


        String ConvertToOrdinal(int number, GrammaticalGender gender);
    }

