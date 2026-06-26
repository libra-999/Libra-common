package com.common.commonutil.bean;

import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bean extends BeanUtil {

    private static final Logger logger = LoggerFactory.getLogger(Bean.class);

    public static void copyBeanProp(Object defaultObject, Object targetObject) {
        try {
            copyProperties(defaultObject, targetObject);
        } catch (Exception e) {
            logger.error("==> msg: {}", e.getMessage());
            e.printStackTrace();
        }
    }

}
