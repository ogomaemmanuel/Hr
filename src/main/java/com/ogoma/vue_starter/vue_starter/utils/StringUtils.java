package com.ogoma.vue_starter.vue_starter.utils;

import com.github.slugify.Slugify;

public class StringUtils {

    public static String slugify(String inputString) {
        Slugify slg = new Slugify();
        String slug = slg.slugify(inputString);
        return slug;
    }
}
