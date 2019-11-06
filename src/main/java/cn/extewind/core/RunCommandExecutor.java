package cn.extewind.core;

import cn.extewind.core.command.AbstractCommand;
import cn.extewind.core.command.SetConfigCommand;
import org.apache.log4j.Logger;

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

    private Logger logger = Logger.getLogger(RunCommandExecutor.class);

    private static Map<String, AbstractCommand> commands = new HashMap<>();
    static {
        registerCommands();
    }

    public static void main(String[] args) {
        RunCommandExecutor executor = new RunCommandExecutor();
        executor.run(new String[]{"-c","config.yml"});
    }

    public void run(String[] command){
        for(int i = 0;i<command.length;i++){
            AbstractCommand cmd = commands.get(command[i]);
            if(cmd!=null){
                int len = cmd.getArgs();
                String[] args = new String[len];
                System.arraycopy(command,i+1,args,0,len);
                String target = cmd.run(args);
                logger.info("["+cmd.getClass().getSimpleName()+"]"+(target==null?"":target));
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
