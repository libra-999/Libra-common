package com.common.commonutil.crypto;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String urlEncode(String url) {
        return URLEncoder.encode(url, StandardCharsets.UTF_8);
    }

    public static String urlDecode(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }

}
