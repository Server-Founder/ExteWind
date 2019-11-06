package cn.extewind.core.command;

public abstract class AbstractCommand {

    private int args;

    public AbstractCommand(int args){
        this.args = args;
    }

    public abstract String run(String[] args);

    public int getArgs() {
        return args;
    }
}
