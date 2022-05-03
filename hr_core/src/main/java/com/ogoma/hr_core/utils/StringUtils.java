package com.ogoma.hr_core.utils;

import com.github.slugify.Slugify;

public class StringUtils {

    public static String slugify(String inputString) {
        Slugify slg = new Slugify();
        String slug = slg.slugify(inputString.toLowerCase());
        return slug;
    }
}
