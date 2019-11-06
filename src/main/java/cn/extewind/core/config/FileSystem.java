package cn.extewind.core.config;

import cn.extewind.core.LocalLib;
import cn.extewind.core.Server;

import java.io.IOException;

/**
 * 管理文件系统
 * 分布式配置文件 extewind.yml
 * 启动时
 * sh extewind.sh -c extewind.yml
 */
public class FileSystem {



    public static Server readConfig(String arg){
        Server server = null;
        String name;
        String[] friends;
        int maxTasks;
        int minServers;
        try{
            String arg0 = LocalLib.getLocalFile(arg);
            YamlConfig config = new YamlConfig(arg0);
            name = config.get("server.name").toString();
            Object[] frs = config.getArray("server.friends");
            friends = new String[frs.length];
            for(int i = 0;i<frs.length;i++){
                friends[i] = frs[i].toString();
            }
            maxTasks = config.getInt("server.max-tasks");
            minServers = config.getInt("server.min-servers");
            server = new Server(name,friends,maxTasks,minServers);
        }catch (IOException e){
            e.printStackTrace();
        }
        return server;
    }
}
