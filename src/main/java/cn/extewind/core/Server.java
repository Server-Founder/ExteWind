package cn.extewind.core;

public class Server {

    private String name;

    private String[] addresses;

    private int maxTasks;

    private int minServers;

    public Server(String name, String[] addresses, int maxTasks, int minServers) {
        this.name = name;
        this.addresses = addresses;
        this.maxTasks = maxTasks;
        this.minServers = minServers;
    }

    public String getName() {
        return name;
    }

    public int getMaxTasks() {
        return maxTasks;
    }

    public int getMinServers() {
        return minServers;
    }

    public String[] getAddresses() {
        return addresses;
    }
}
