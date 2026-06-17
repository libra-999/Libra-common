package org.project.commons.utils.pc;

import java.util.Properties;

public class CommonUtil {

    // os.name = mean all os such window,mac or linux
    // then we need to convert to lowercase , for safety when get os because it some os show capital or lower
    public static boolean isMacOS(){
        Properties pro = System.getProperties();
        return pro.getProperty("os.name").toLowerCase().startsWith("mac");
    }
    public static boolean isWindowOS(){
        Properties pro = System.getProperties();
        return pro.getProperty("os.name").toLowerCase().startsWith("win");
    }
    public static boolean isLinuxOS() {
        Properties pro = System.getProperties();
        return pro.getProperty("os.name").toLowerCase().contains("nux");
    }

    // test product in local
    public static boolean isPcOS(){
        return isMacOS() || isWindowOS() || isLinuxOS();
    }

}
