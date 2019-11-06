package cn.extewind.core;

public class LocalLib {


    private static String local;
    static {
        String file = LocalLib.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        local = file.substring(0,file.lastIndexOf("/")+1);

    }
    public static String getLocalFile(String name){
        return local+name;
    }

}
