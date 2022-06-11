package com.jeff.utils;

/**
 * @ProjectName: joyy-backend
 * @Package: com.jeff.utils
 * @ClassName: CloseUtil
 * @Description: [用于关闭各种连接，缺啥补啥]
 * @Author: [clh]
 * @Date: 2022/6/11 14:48
 **/
import java.io.Closeable;

public class CloseUtil {

    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                // 静默关闭
            }
        }
    }

    public static void close(AutoCloseable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                // 静默关闭
            }
        }
    }
}

