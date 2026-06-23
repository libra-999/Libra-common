package com.common.commonall;

import cn.hutool.core.lang.ConsoleTable;
import com.common.commonutil.bean.BeanScan;

import java.util.Set;

public class Common {
    public Common() {}

    public static void getAllCommons(){
        final Set<java.lang.Class<?>> allCommons = BeanScan.scanPackage("com.common");
        ConsoleTable table = ConsoleTable.create().addHeader("Libra Class", "Libra Package" );
        for (java.lang.Class<?> clazz : allCommons){
            table.addBody(clazz.getSimpleName(), clazz.getPackageName().toLowerCase());
        }
        table.print();
    }
}
