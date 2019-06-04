package com.price.doc.dto;

import java.util.Map;

public class Httpz extends HttpFacade {

    private static String encoding = "utf-8";
    private static int readTimeout = 18000;
    private static int sendTimeout = 18000;

    public Httpz(String encoding, int readTimeout, int sendTimeout) {
        this.encoding = encoding;
        this.readTimeout = readTimeout;
        this.sendTimeout = sendTimeout;
    }

    public Httpz() {
    }

    public static String post(String url, Map params) throws Exception {
        HttpFacade hf = null;
        if (isHttps(url)) {
            hf = new HttpsHandler();
        } else {
            hf = new HttpHandler();
        }
        hf.setDefaultCharset(encoding);
        hf.setDEFAULT_CONNECT_TIMEOUT(sendTimeout);
        hf.setDEFAULT_READ_TIMEOUT(readTimeout);

        return hf.post(url, params);
    }

    public static String get(String url) throws Exception {
        HttpFacade hf = null;
        if (isHttps(url)) {
            hf = new HttpsHandler();
        } else {
            hf = new HttpHandler();
        }
        hf.setDefaultCharset(encoding);
        hf.setDEFAULT_CONNECT_TIMEOUT(sendTimeout);
        hf.setDEFAULT_READ_TIMEOUT(readTimeout);

        return hf.get(url);
    }


    /**
     * 是否为https地址
     *
     * @param url
     * @return
     */
    private static boolean isHttps(String url) {
        return url.startsWith("https") || url.startsWith("HTTPS");
    }

}
