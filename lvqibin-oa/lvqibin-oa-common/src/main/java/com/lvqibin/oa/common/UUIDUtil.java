package com.lvqibin.oa.common;

import java.util.UUID;

public class UUIDUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-" , "");
    }
}
