package cn.extewind.core;

import static cn.extewind.core.LocalLib.LOCAL_PROPERTY_SERVER;

/**
 * 分布式爬虫系统的运行代码，负责启动分布式系统
 *
 */
public class ExteWind {



    public static void main(String[] args) {
        LocalSystem system = new LocalSystem();
        //执行命令获得对象
        RunCommandExecutor executor = new RunCommandExecutor();
        executor.run(args,system);
        //获得一切命令执行对象后
        Server server = system.getProperty(LOCAL_PROPERTY_SERVER,Server.class);
        
    }
}
