package cn.extewind.core.command;

public class SetConfigCommand extends AbstractCommand{

    public SetConfigCommand(int args) {
        super(args);
    }

    @Override
    public String run(String[] args) {
        System.out.println(args.length);
        return null;
    }
}
