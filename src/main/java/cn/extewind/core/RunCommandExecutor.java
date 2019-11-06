package cn.extewind.core;

import cn.extewind.core.command.AbstractCommand;
import cn.extewind.core.command.SetConfigCommand;
import cn.extewind.core.handler.Handler;
import cn.extewind.core.handler.SetConfigHandler;
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

    private static Map<Class, Handler> handlerMap = new HashMap<>();

    private static Map<String, AbstractCommand> commands = new HashMap<>();
    static {
        registerCommands();
        registerHandlers();
    }

    public static void main(String[] args) {
        RunCommandExecutor executor = new RunCommandExecutor();
        executor.run(new String[]{"-c","config.yml"},new LocalSystem());
    }

    public void run(String[] command,LocalSystem system){
        for(int i = 0;i<command.length;i++){
            AbstractCommand cmd = commands.get(command[i]);
            if(cmd!=null){
                int len = cmd.getArgs();
                String[] args = new String[len];
                System.arraycopy(command,i+1,args,0,len);
                Object target = cmd.run(args);
                logger.info("["+cmd.getClass().getSimpleName()+"]"+(target==null?"":target.getClass().equals(String.class)?target:target.getClass().getSimpleName()+" inited"));
                handlerMap.get(cmd.getClass()).handle(target,system);
                i = i+len;
            }else{
                return;
            }
        }
    }

    public static void registerCommands(){
        commands.put("-c",new SetConfigCommand(1));
    }

    public static void registerHandlers(){
        handlerMap.put(SetConfigCommand.class, new SetConfigHandler());
    }
}
