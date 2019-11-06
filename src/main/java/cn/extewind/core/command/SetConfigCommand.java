package cn.extewind.core.command;

import cn.extewind.core.LocalLib;
import cn.extewind.core.Server;
import cn.extewind.core.config.FileSystem;
import cn.extewind.core.config.YamlConfig;

import java.io.IOException;

/**
 * 文件名 和jar包一个路径
 * 配置文件的内容
 * server:
 *  name: myWind #分布式系统名称,保证链接系统中不重复
 *  friends:
 *      - 127.0.0.1:10000 #第一个链接系统
 *      - 127.0.0.1:10001 #第二个链接系统
 *  max-tasks: 100 #最大执行任务数量,ExteWind的基本工作单位是任务，任务的单位体现在工作表里
 *  min-servers: 3 #最大启动数量，开始选举和分配任务，至少为3个，否则默认不开启集群模式
 *                  #保证所有的服务器min-servers相同
 *
 */
public class SetConfigCommand extends AbstractCommand{

    public SetConfigCommand(int args) {
        super(args);
    }

    @Override
    public Object run(String[] args) {
        return FileSystem.readConfig(args[0]);
    }
}
