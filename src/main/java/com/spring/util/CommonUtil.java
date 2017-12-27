package com.spring.util;/**
 * com.spring.util
 * jacky
 * 17-12-27
 **/

import java.util.UUID;

/**
 *
 * @author jackycheng
 *
 * @date 2017-12-27-上午10:14
 *
 */

public class CommonUtil {

    /**
     * 生成唯一UUID
     * @return
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
