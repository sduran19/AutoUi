package com.edu.poli.models.enums;


import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public enum User {
    ADMINISTRADOR("administrador","idAdmin","passAdmin");

    private String name;
    private String id;
    private String password;


    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    User(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return variables.getProperty(id);
    }

    public String getPassword() {
        return variables.getProperty(password);
    }
}
