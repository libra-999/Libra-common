package com.common.commonutil.bean;


import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.lang.Filter;

import java.util.Set;

public class BeanScan {

    public static Set<java.lang.Class<?>> scanPackage(String packageName, Filter<java.lang.Class<?>> filterClass) {
        return ClassScanner.scanPackage(packageName, filterClass);
    }

    public static Set<java.lang.Class<?>> scanPackage(String packageName){
        return ClassScanner.scanPackage(packageName);
    }

}
