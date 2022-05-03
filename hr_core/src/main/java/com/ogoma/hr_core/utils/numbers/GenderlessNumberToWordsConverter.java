package com.ogoma.hr_core.utils.numbers;

public abstract class GenderlessNumberToWordsConverter implements INumberToWordsConverter {

        /// <summary>
        /// Converts the number to string
        /// </summary>
        /// <param name="number"></param>
        /// <returns></returns>
        public abstract String  Convert(long number);

        /// <summary>
        /// Converts the number to string ignoring the provided grammatical gender
        /// </summary>
        /// <param name="number"></param>
        /// <param name="gender"></param>
        /// <returns></returns>
        public  String Convert(long number, GrammaticalGender gender)
        {
            return Convert(number);
        }

        /// <summary>
        /// Converts the number to ordinal string
        /// </summary>
        /// <param name="number"></param>
        /// <returns></returns>
        public abstract String ConvertToOrdinal(int number);

        /// <summary>
        /// Converts the number to ordinal string ignoring  the provided grammatical gender
        /// </summary>
        /// <param name="number"></param>
        /// <param name="gender"></param>
        /// <returns></returns>
        public String ConvertToOrdinal(int number, GrammaticalGender gender)
        {
            return ConvertToOrdinal(number);
        }

}
