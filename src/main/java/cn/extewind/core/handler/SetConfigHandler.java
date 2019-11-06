package cn.extewind.core.handler;

import cn.extewind.core.LocalSystem;

import static cn.extewind.core.LocalLib.LOCAL_PROPERTY_SERVER;

public class SetConfigHandler implements Handler {


    @Override
    public void handle(Object obj, LocalSystem system) {
        system.setProperty(LOCAL_PROPERTY_SERVER,obj);
    }
}
