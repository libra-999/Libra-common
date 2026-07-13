package com.common.commonutil.pc;

import java.util.Properties;

public class PC {

    public static boolean isMacOS() {
        Properties prt = System.getProperties();
        return prt.getProperty("os.name").toLowerCase().startsWith("mac");
    }

    public static boolean isWindows() {
        Properties prt = System.getProperties();
        return prt.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    // scan device that using currently , if linux OS so device is DEV or PROD
    public static boolean isPsOS() {
        return isMacOS() || isWindows();
    }

}
