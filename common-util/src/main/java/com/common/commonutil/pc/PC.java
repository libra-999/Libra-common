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

    public static boolean isLinux() {
        Properties prt = System.getProperties();
        return prt.getProperty("os.name").toLowerCase().startsWith("linux");
    }


    // scan device that using currently
    public static boolean isPsOS() {
        return isMacOS() || isWindows() || isLinux();
    }

}
