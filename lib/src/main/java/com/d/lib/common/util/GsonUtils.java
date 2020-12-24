package com.d.lib.common.util;

import com.google.gson.Gson;

public final class GsonUtils {
    private GsonUtils() {
    }

    public static Gson getInstance() {
        return Singleton.gson;
    }

    private static class Singleton {
        private static Gson gson = new Gson();
    }
}
