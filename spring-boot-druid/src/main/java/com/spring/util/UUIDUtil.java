package com.spring.util;

import java.util.Random;
import java.util.UUID;

/**
 *
 */
public class UUIDUtil {

    /**
     * 生成基于时间戳+5位随机数的文件名
     *
     * @return
     */
    public static String getRandomFileId() {
        Random random = new Random();
        // 获取5位随机数
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;
        return String.valueOf(System.currentTimeMillis() + rannum);
    }

    /**
     * @param
     * @return java.lang.String
     * @author chengjian
     * @description 生成32位uuid
     * @date 18-11-10:上午11:58
     */
    public static String getUUID32() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
