package com.ogoma.hr_core.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

public class BaseUrlUtil {
    public static UriComponentsBuilder getBaseUrlBuilder(HttpServletRequest httpServletRequest) {
        UriComponentsBuilder uriComponentsBuilder =
                ServletUriComponentsBuilder.fromContextPath(httpServletRequest).path("/");
        return uriComponentsBuilder;
    }
}
