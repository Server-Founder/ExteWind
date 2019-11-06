package cn.extewind.core;

import cn.extewind.core.command.AbstractCommand;
import cn.extewind.core.command.SetConfigCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * 负责处理执行时命令
 * 如
 * java -jar extewind.jar -c xxx -f xxx
 *
 * 命令要求必须空格
 */
public class RunCommandExecutor {

    private static Map<String, AbstractCommand> commands = new HashMap<>();
    static {
        registerCommands();
    }


    public void run(String[] command){
        for(int i = 0;i<command.length;i++){
            AbstractCommand cmd = commands.get(command[i]);
            if(cmd!=null){
                int len = cmd.getArgs();
                String[] args = new String[len];
                System.arraycopy(command,i,args,0,len);
                cmd.run(args);
                i = i+len;
            }else{
                return;
            }
        }
    }

    public static void registerCommands(){
        commands.put("-c",new SetConfigCommand(1));
    }

}
