package com.example.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("ressource")
public class Ressource extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet haset = new HashSet<Class<?>>();
        haset.add(BanqueWebService.class);
        return haset;
    }
}
